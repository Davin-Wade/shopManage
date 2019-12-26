package shopping.Dao;

import shopping.Utils.DBUtils;
import shopping.entity.Goods;
import shopping.entity.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int updateGoods(Goods gd) {
        conn = DBUtils.getConn();
        String sql = "UPDATE goods SET g_goods_name = ?,g_goods_pic = ?,g_goods_price = ?,g_goods_description = ?,g_goods_stock = ? WHERE g_id = ?";

        ArrayList gdList = new ArrayList();
        gdList.add(gd.getName());
        gdList.add(gd.getPic());
        gdList.add(gd.getPrice());
        gdList.add(gd.getDesc());
        gdList.add(gd.getStock());
        gdList.add(gd.getId());

        int row = DBUtils.executeUpdate(sql,gdList);
        DBUtils.getClose(conn,pstmt,rs);
        return row;
    }

    /**
     * 添加数据
     *
     * @param
     * @return true  插入成功
     * false  插入失败
     */
    @Override
    public int insertGoods(Goods gd) {
        conn = DBUtils.getConn();
        String sql = "INSERT INTO goods (g_goods_name,g_goods_pic,g_goods_price,g_goods_description,g_goods_stock,is_delete)VALUES(?,?,?,?,?,?)";
        ArrayList list = new ArrayList();
        if (gd != null) {
            list.add(gd.getName());
            list.add(gd.getPic());
            list.add(gd.getPrice());
            list.add(gd.getDesc());
            list.add(gd.getStock());
            list.add(0);
        }
        int row = DBUtils.executeUpdate(sql, list);
        DBUtils.getClose(conn, pstmt, rs);
        return row;
    }

    /**
     * 逻辑删除数据
     *
     * @param gd
     * @return 大于0 删除成功
     * 不大于0 删除失败
     */
    @Override
    public int deleteGoods(String[] gd) {
        conn = DBUtils.getConn();
        StringBuffer sql = new StringBuffer("UPDATE goods SET is_delete = 1 WHERE g_id in(");
        ArrayList list = new ArrayList();
        if (gd != null && gd.length > 0) {
            for (int i = 0; i < gd.length; i++) {
                if (i == gd.length - 1) {
                    sql.append("?)");
                } else {
                    sql.append("?,");
                }
                list.add(gd[i]);
            }
        }
        int row = DBUtils.executeUpdate(sql.toString(), list);
        DBUtils.getClose(conn, pstmt, rs);
        return row;
    }

    /**
     * 遍历信息
     *
     * @param
     * @return 将list集合返回
     */
    @Override
    public List<Goods> selectGoods(Goods gd) {
        List<Goods> list = new ArrayList<>();

        try {
            conn = DBUtils.getConn();
            ArrayList stuList = new ArrayList<Goods>();
            StringBuffer buf = new StringBuffer("SELECT *FROM goods WHERE is_delete = 0");


            if (gd.getName() != null && !"".equals(gd.getName())) {
                buf.append(" and g_goods_name like ?");
                stuList.add("%" + gd.getName() + "%");
            }

            if (gd.getId() > 0) {
                buf.append(" and g_id = ?");
                stuList.add(gd.getId());
            }

            // 获取SQL执行对象
            pstmt = conn.prepareStatement(buf.toString());

            if (stuList != null && stuList.size() > 0) {
                for (int i = 0; i < stuList.size(); i++) {
                    pstmt.setObject(i + 1, stuList.get(i));
                }
            }

            // 获取执行结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods gdList = new Goods();
                gdList.setId(rs.getInt("g_id"));
                gdList.setName(rs.getString("g_goods_name"));
                gdList.setPic(rs.getString("g_goods_pic"));
                gdList.setPrice(rs.getDouble("g_goods_price"));
                gdList.setDesc(rs.getString("g_goods_description"));
                gdList.setStock(rs.getInt("g_goods_stock"));
                gdList.setIsDel(rs.getInt("is_delete"));
                list.add(gdList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.getClose(conn, pstmt, rs);
        return list;
    }

    /**
     *  分页后的遍历信息
     * @param gd
     * @param pg
     * @return
     */
    public List<Object> pageList(Goods gd, Page pg) {
        List<Object> pageList = new ArrayList<>();
        getPageObject(gd, getPageObject(gd,pg));

        if(selectGoods(gd) != null && selectGoods(gd).size() > 0) {
            for (int i = (pg.getNowPage() * pg.getDateSize()); i < (pg.getNowPage() + 1) * pg.getDateSize() && i < selectGoods(gd).size(); i++) {
                // 将当前页面的数据传给pageList
                pageList.add(selectGoods(gd).get(i));// selectStu是查询出来的所有数据，用get(i)方式来获取第i条数据
            }
        }
        return pageList;
    }

    /**
     *  获取经判断后的分页对象
     * @param gd 商品对象
     * @param pg 分页对象
     * @return
     */
    public Page getPageObject(Goods gd, Page pg) {
        int pageNum = 0;
        // 设置一页数据条数
        pg.setDateSize(5);
        // 设置总页数
        int remainder = (selectGoods(gd).size()) % pg.getDateSize();// 求总页数的余数
        int num = (selectGoods(gd).size()) / pg.getDateSize();// 总页数
        if(remainder == 0){
            pg.setTotlePage(num);
        }else{
            pg.setTotlePage(num+1);
        }
        // 如果 收到的页码 大于 0 的话
        if(pg.getNowPage() >= 0){
            // 将 收到的页码 赋给 当前页码
            pageNum = pg.getNowPage();
            // 如果 收到的页码 大于
            if(pageNum >= (pg.getTotlePage())){
                pageNum = pg.getNowPage() - 1;
            }
        }
        // 设置最终当前页
        pg.setNowPage(pageNum);

        // 返回处理后的对象
        return pg;
    }
}
