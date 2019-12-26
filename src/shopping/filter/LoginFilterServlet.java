package shopping.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilterServlet implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();


        // 以下路径可直接通过
        if ("/login.jsp".equals(requestURI) || "/loginServlet".equals(requestURI) || "/register.jsp".equals(requestURI)
                || "/registerServlet".equals(requestURI) || "/checkCodeServlet".equals(requestURI)) {
            chain.doFilter(req, resp);

        } else {
            // 判断是否有存入的用户名来判断能否免登录
            String noFreeUsername = (String) session.getAttribute("noFreeUsername");
            String name = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    name = c.getName();
                    // 如果找到存入的用户名，就直接跳出循环
                    if (name.equals(request.getContextPath() + "username")) {
                        req.setAttribute("noFreeUsername",c.getValue());
                        break;
                    }
                }
            }
            // 不免登陆时
            if (noFreeUsername != null && !"".equals(noFreeUsername) || (request.getContextPath() + "username").equals(name)) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("login.jsp");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
