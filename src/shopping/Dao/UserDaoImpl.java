package shopping.Dao;

import shopping.Utils.DBUtils;
import shopping.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static shopping.Utils.DBUtils.getConn;


public class UserDaoImpl implements UserDao{


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    /**
     * 确认是否有此用户
     *
     * @param
     * @return
     */
    public int UserConfirm(User use) {
        try {
            conn = getConn();
            String sql = "select * from `user` where u_password = ? and u_username = ? and is_delete = 0";
            List useList = new ArrayList<>();
            if (use != null) {
                if (!"".equals(use.getPassword()) && use.getPassword() != null) {
                    useList.add(use.getPassword());
                }
                if (!"".equals(use.getUsername()) && use.getUsername() != null) {
                    useList.add(use.getUsername());
                }
            }

            //获取编译语句
            pstmt = conn.prepareStatement(sql);

            if (useList != null && useList.size() > 0) {
                for (int i = 0; i < useList.size(); i++) {
                    pstmt.setObject(i + 1, useList.get(i));
                }
            }
            rs = pstmt.executeQuery();
            if (rs.next()) {
                DBUtils.getClose(conn,pstmt,rs);
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.getClose(conn,pstmt,rs);
        return 0;
    }

    /**
     *  添加用户
     * @param user
     * @return 大于0  添加成功
     *          小于0  添加失败
     */
    public int insertUser(User user) {
        conn = getConn();
        StringBuffer sf = new StringBuffer();
        sf.append("INSERT INTO `user` (u_username,u_password,u_sex,u_hobbies,u_phone,u_email,u_address,is_delete) VALUES(?,?,?,?,?,?,?,0)");

        ///将占位符内容传入数组
        ArrayList list = new ArrayList();
                list.add(user.getUsername());
                list.add(user.getPassword());
                list.add(user.getSex());
                list.add(user.getHobbies());
                list.add(user.getPhone());
                list.add(user.getEmail());
                list.add(user.getAddrs());
        int row = DBUtils.executeUpdate(sf.toString(),list);
        DBUtils.getClose(conn,pstmt,rs);
        return row;
    }

    /**
     *  删除用户
     * @param u
     * @return
     */
    @Override
    public int deleteUser(String[] u) {
        conn = DBUtils.getConn();
        StringBuffer sql = new StringBuffer("UPDATE goods SET flag = 1 WHERE id in(");
        ArrayList list = new ArrayList();
        if(u != null && u.length > 0){
            for(int i = 0;i < u.length;i++){
                if(i == u.length-1){
                    sql.append("?)");
                }else{
                    sql.append("?,");
                }
                list.add(u[i]);
            }
        }
        int row = DBUtils.executeUpdate(sql.toString(),list);
        DBUtils.getClose(conn,pstmt,rs);
        return row;
    }


}
