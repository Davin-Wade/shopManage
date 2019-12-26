package shopping.servlet;

import org.junit.Test;
import shopping.Dao.UserDao;
import shopping.Dao.UserDaoImpl;
import shopping.Utils.StringUtil;
import shopping.entity.User;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int row = 0;
        String errMsg = "";
        loginsServlet(req, resp, row, errMsg);
    }

    /**
     * 登录验证
     *
     * @param req
     * @param resp
     * @param row
     * @param errMsg
     * @throws IOException
     */
    private void loginsServlet(HttpServletRequest req, HttpServletResponse resp, int row, String errMsg) throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");

        User use = new User();
        use.setUsername(req.getParameter("username"));
        use.setPassword(req.getParameter("password"));
        String code = req.getParameter("checkCode");

        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");


        try {
            //判断数据是否合法
            if(!checkCode_session.equals(code)){
               throw new RuntimeException("验证码错误");
            }
            if (!StringUtil.isNotNull(use.getUsername()) && !StringUtil.isNotNull(use.getPassword())) {
                throw new RuntimeException("用户名和密码不能为空");
            }
            if (!StringUtil.isNotNull(use.getUsername())) {
                throw new RuntimeException("用户名不能为空");
            }
            if (!StringUtil.isNotNull(use.getPassword())) {
                throw new RuntimeException("密码不能为空");
            }

            //获取响应流
            UserDaoImpl uDao = new UserDaoImpl();
            row = uDao.UserConfirm(use);

        } catch (RuntimeException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }



        PrintWriter out = resp.getWriter();
        // 登录判断数据是否合法
        if (row > 0) {
            String freeLogin = req.getParameter("freeLogin");// 获取是否免登录
            String remUser = req.getParameter("remember");// 获取是否记住密码
            session.setAttribute("noFreeUsername",use.getUsername());
            if(freeLogin != null){
                Cookie cookie = new Cookie(req.getContextPath()+"username",use.getUsername());
                cookie.setMaxAge(60*60*24*7);// 七天免登录
                resp.addCookie(cookie);
            }
//            if(remUser != null){
//                Cookie cookie = new Cookie("pass",use.getPassword());
//                Cookie cookie1 = new Cookie("user",use.getUsername());
//                cookie.setMaxAge(60*60*24*7);//
//                session.setAttribute("noFreePwd",use.getPassword());
//            }
            resp.sendRedirect("goodsServlet");
        } else {
            out.println("<script type='text/javascript'> alert('登陆失败:" + errMsg + "');history.back();</script>");
        }
    }


}



