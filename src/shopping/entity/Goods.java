package shopping.entity;

/*goodsInfo_namevarchar(20) NULL
goodsInfo_picvarchar(255) NULL
goodsInfo_priceint(11) NULL
goodsInfo_descriptionvarchar(255) NULL
goods_stockint(11) NULL
flagvarchar(10) NULL
createdvarchar(20) NULL
created_datedate NULL*/

import java.util.Arrays;

/**
 * flag:
 *      1：激活
 *      2：禁用
 */
public class Goods {
    private String name;
    private String pic;
    private double price;
    private String desc;
    private int stock;
    private int isDel;
    private int id;
    private int[] idAll;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", stock=" + stock +
                ", isDel=" + isDel +
                ", id=" + id +
                ", idAll=" + Arrays.toString(idAll) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getIdAll() {
        return idAll;
    }

    public void setIdAll(int[] idAll) {
        this.idAll = idAll;
    }

    public Goods() {
    }

    public Goods(String name, String pic, double price, String desc, int stock, int isDel, int id, int[] idAll) {
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
        this.isDel = isDel;
        this.id = id;
        this.idAll = idAll;
    }
}
