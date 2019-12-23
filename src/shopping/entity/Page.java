package shopping.entity;

import java.util.List;

/**
 *  Page类
 *  存储分页信息
 */
public class Page {
    private int nowPage;// 当前页
    private int homePage = 1;// 首页
    private int endPage;// 尾页
    private int dateSize;// 数据条数
    private int totlePage;// 总页数
    private List<Object> list;// 得到数据后存放的list集合

    @Override
    public String toString() {
        return "Page{" +
                "nowPage=" + nowPage +
                ", homePage=" + homePage +
                ", endPage=" + endPage +
                ", dateSize=" + dateSize +
                ", totlePage=" + totlePage +
                ", list=" + list +
                '}';
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getHomePage() {
        return homePage;
    }

    public void setHomePage(int homePage) {
        this.homePage = homePage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getDateSize() {
        return dateSize;
    }

    public void setDateSize(int dateSize) {
        this.dateSize = dateSize;
    }

    public int getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(int totlePage) {
        this.totlePage = totlePage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Page() {
    }

    public Page(int nowPage, int homePage, int endPage, int dateSize, int totlePage, List<Object> list) {
        this.nowPage = nowPage;
        this.homePage = homePage;
        this.endPage = endPage;
        this.dateSize = dateSize;
        this.totlePage = totlePage;
        this.list = list;
    }
}
