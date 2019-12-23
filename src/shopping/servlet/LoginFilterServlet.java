package shopping.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilterServlet implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        resp.setContentType("text/html;charset=utf-8");

        // 以下路径可直接通过
        if("/login.jsp".equals(requestURI) || "/loginServlet".equals(requestURI) || "/register.jsp".equals(requestURI)
                || "/registerServlet".equals(requestURI) || "/checkCodeServlet".equals(requestURI)){
            chain.doFilter(req, resp);

        }else{
            String username = (String)session.getAttribute("username");
            if(username != null && !"".equals(username)){
                chain.doFilter(req,resp);
            }else{
                response.sendRedirect("login.jsp");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
