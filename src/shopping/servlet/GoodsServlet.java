package shopping.servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import shopping.Dao.GoodsDaoImpl;
import shopping.Utils.StringUtil;
import shopping.entity.Goods;
import shopping.entity.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet("/goodsServlet")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String opr = req.getParameter("opr");


        if ("del".equals(opr)) {
            del(req, resp);
        } else if ("add".equals(opr)) {
            add(req, resp);
        } else if ("getGoods".equals(opr)) {
            getGoods(req, resp);
        } else if ("update".equals(opr)) {
            update(req, resp);
        } else {
            list(req, resp);
        }


    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int row = 0;
        String errMsg = null;
        try {
            Goods gd = new Goods();
            gd.setId(StringUtil.String2int(req.getParameter("ids"), 0));
            gd.setName(req.getParameter("names"));
            gd.setPic(req.getParameter("pic"));
            gd.setPrice(StringUtil.String2int(req.getParameter("price"), 0));
            gd.setDesc(req.getParameter("desc"));
            gd.setStock(StringUtil.String2int(req.getParameter("stock"), 0));

            //判断接收的数据是否合法
            if (!StringUtil.isNotNull(gd.getName())) {
                throw new RuntimeException("商品名称不能为空");
            }
//            if (!StringUtil.isNotNull(gd.getPic())) {
//                throw new RuntimeException("商品照片不能为空");
//            }
            if (gd.getPrice() <= 0) {
                throw new RuntimeException("商品价格不能为空");
            }
            if (!StringUtil.isNotNull(gd.getDesc())) {
                throw new RuntimeException("商品描述不能为空");
            }
            if (gd.getStock() <= 0) {
                throw new RuntimeException("商品库存不能为空");
            }

            GoodsDaoImpl gDao = new GoodsDaoImpl();
            row = gDao.updateGoods(gd);
        } catch (RuntimeException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        if (row > 0) {
            resp.getWriter().println("<script type='text/javascript'> alert('修改成功！');location.href='goodsServlet';</script>");
        } else {
            resp.getWriter().println("<script type='text/javascript'> alert('修改失败:" + errMsg + "！');history.back();;</script>");
        }
    }

    private void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods gd = new Goods();
        gd.setId(StringUtil.String2int(req.getParameter("checks"), 0));
        GoodsDaoImpl gDao = new GoodsDaoImpl();
        List<Goods> goods = gDao.selectGoods(gd);
        req.setAttribute("gd", goods);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    /**
     * 列表显示
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Goods gd = new Goods();
        gd.setName(req.getParameter("nameSearch"));

        Page pg = new Page();
        pg.setNowPage(StringUtil.String2int(req.getParameter("page"),0));

        GoodsDaoImpl gdDao = new GoodsDaoImpl();
        Page page = gdDao.getPageObject(gd, pg);
        List<Object> list = gdDao.pageList(gd,page);
        if (list != null && list.size() > 0) {
            req.setAttribute("list", list);
            req.setAttribute("page",page);
            req.getRequestDispatcher("goodsShow.jsp").forward(req, resp);

        } else {
            resp.getWriter().println("<script type='text/javascript'> alert('无此商品');location.href='goodsServlet';</script>");
        }

    }

    /**
     * 逻辑删除
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void del(HttpServletRequest req, HttpServletResponse resp) {
        int row = 0;
        String[] checkall = req.getParameterValues("checks");
        GoodsDaoImpl stuDao = new GoodsDaoImpl();
        row = stuDao.deleteGoods(checkall);
        if (row > 0) {
            try {
                resp.sendRedirect("goodsServlet");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                resp.getWriter().println("<script type='text/javascript'> alert('删除失败！');location.href='goodsServlet';</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        // 创建实例类存储前端数据
        Goods gd = new Goods();
        System.out.println(req.getParameter("names"));
        gd.setName(req.getParameter("names"));
        gd.setPrice(StringUtil.String2int(req.getParameter("price"), 0));
        gd.setPic(req.getParameter("pic"));
        gd.setDesc(req.getParameter("desc"));
        gd.setStock(StringUtil.String2int(req.getParameter("stock"), 0));

        *//**
         *  判断空条件
         *//*

        GoodsDaoImpl stuDao = new GoodsDaoImpl();
        int b = stuDao.insertGoods(gd);

        // 判断添加是否成功
        if (b > 0) {
            resp.getWriter().println("<script type='text/javascript'> alert('添加成功!');location.href='goodsServlet';</script>");
        } else {
            resp.getWriter().println("<script type='text/javascript'> alert('添加失败！');location.href='add.jsp';</script>");

        }*/
        String errMsg;
        int row;
        try {
            boolean ismultipart = ServletFileUpload.isMultipartContent(req);
            Goods gd = new Goods();
            GoodsDaoImpl gdDao = new GoodsDaoImpl();
            String fileName = "";
            PrintWriter out = resp.getWriter();

            if (ismultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                List<FileItem> fileItemList = upload.parseRequest(req);

                if (fileItemList != null && fileItemList.size() > 0) {
                    for (FileItem item : fileItemList) {
                        if (item.isFormField()) {
                            if ("names".equals(item.getFieldName())) {
                                String name = item.getString("utf-8");
                                gd.setName(name);
                                if (!StringUtil.isNotNull(gd.getName())) {
                                    out.println("<script>alert('商品名字不能为空');history.back();</script>");
                                    return;
                                }

                            }
                            if ("price".equals(item.getFieldName())) {
                                String price = item.getString();
                                gd.setPrice(StringUtil.String2int(price, 0));
                                if (gd.getPrice() <= 0) {
                                    out.println("<script>alert('商品价格不能为空');history.back();</script>");
                                    return;
                                }
                            }
                            if ("desc".equals(item.getFieldName())) {
                                String desc = item.getString("utf-8");
                                gd.setDesc(desc);
                                if (!StringUtil.isNotNull(gd.getDesc())) {
                                    out.println("<script>alert('商品描述不能为空');history.back();</script>");
                                    return;
                                }

                            }
                            if ("stock".equals(item.getFieldName())) {
                                String stock = item.getString();
                                gd.setStock(StringUtil.String2int(stock, 0));
                                if (gd.getStock() <= 0) {
                                    out.println("<script>alert('商品库存不能为空');history.back();</script>");
                                    return;
                                }
                            }
                        } else {
                            if (item.getName() != null && !"".equals(item.getName())) {
                                String parentPath = req.getServletContext().getRealPath("/upload");
                                File parentFile = new File(parentPath);
                                if (!parentFile.exists()) parentFile.mkdirs();

                                File newFile = new File(parentFile, item.getName());
                                InputStream inputStream = item.getInputStream();
                                OutputStream outputStream = new FileOutputStream(newFile);
                                IOUtils.copy(inputStream, outputStream);


                                fileName = item.getName();

                                if (fileName != null) {
                                    String path1 = "upload/" + fileName;
                                    System.out.println(path1);
                                    gd.setPic(path1);
                                }
                            }
                        }
                    }
                }
                row = gdDao.insertGoods(gd);
                if (row > 0) {
                    //修改成功，跳回查询页面
                    out.println("<script type='text/javascript'>alert('添加成功');location.href='goodsServlet';</script>");
                } else {
                    //修改失败，跳回修改页面
                    out.println("<script type='text/javascript'>alert('添加失败');history.back();</script>");
                }
                return;
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }




}
