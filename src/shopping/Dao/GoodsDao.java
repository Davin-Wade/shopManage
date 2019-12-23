package shopping.Dao;

import shopping.entity.Goods;

import java.util.List;


public interface GoodsDao {

    /**
     *
     * @param gd
     * @return
     */
    int insertGoods(Goods gd);
    List<Goods> selectGoods(Goods gd);
    int deleteGoods(String[] gd);
    int updateGoods(Goods gd);
}
