package shopping.servlet;

import shopping.Dao.UserDaoImpl;
import shopping.Utils.StringUtil;
import shopping.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User();
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");

//        user.setUsername(req.getParameter("username"));
//        user.setPassword(password);
//        user.setSex(req.getParameter("sex"));
//        user.setHobbies(StringUtil.printStr(req.getParameterValues("hobbys")));
//        user.setPhone(req.getParameter("phone"));
//        user.setEmail(req.getParameter("email"));
//        user.setAddrs(req.getParameter("addrs"));
//        int row = 0;
//        String errMsg = "";
//
//        try {
//            //判断数值是否合法
//            if (!StringUtil.isNotNull(user.getUsername())) {
//                throw new RuntimeException("用户名不能为空");
//            }
//            if (!StringUtil.isNotNull(user.getPassword())){
//                throw new RuntimeException("密码不能为空");
//            }
//            if (!StringUtil.isNotNull(user.getEmail())){
//                throw new RuntimeException("邮箱不能为空");
//            }
//            if (!StringUtil.isNotNull(user.getHobbies())){
//                throw new RuntimeException("请选择爱好");
//            }
//            if (!StringUtil.isNotNull(user.getPhone())){
//                throw new RuntimeException("手机不能为空");
//            }
//            if (!StringUtil.isNotNull(user.getAddrs())){
//                throw new RuntimeException("地址不能为空");
//            }
//            if(!password.equals(password1)){
//                throw new RuntimeException("密码验证不匹配");
//            }
//
//
//            //数据都合法后
//            UserDaoImpl userDao = new UserDaoImpl();
//            row = userDao.insertUser(user);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            errMsg = e.getMessage();
//        }
//        PrintWriter out = resp.getWriter();
//
//        //判断是否成功创建用户
//        if(row > 0){
//            //创建成功
//            out.println("<script type='text/javascript'>alert('注册成功');location.href='login.jsp'</script>");
//        }else{
//            //创建失败
//            out.println("<script type='text/javascript'>alert('注册失败:"+errMsg+"');history.back()</script>");
//        }
//        out.flush();
    }
}
