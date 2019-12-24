package shopping.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginOffServlet")
public class LoginOffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("noFreeUsername");
        Cookie cookie = new Cookie(req.getContextPath()+"username","out");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
