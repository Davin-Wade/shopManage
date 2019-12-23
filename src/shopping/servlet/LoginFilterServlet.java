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

        if("/login.jsp".equals(requestURI) || "/loginServlet".equals(requestURI) || "/register.jsp".equals(requestURI)
                || "/registerServlet".equals(requestURI) || "/checkCodeServlet".equals(requestURI)){
            chain.doFilter(req, resp);

        }else{
            String username = (String)session.getAttribute("username");
//            String noFreeUsername = (String)session.getAttribute("noFreeUsername");
            if(username != null && !"".equals(username)){ /*|| noFreeUsername != null && !"".equals(noFreeUsername)*/
                chain.doFilter(req,resp);
            }else{
//                response.getWriter().println("<script type='text/javascript'> alert('您尚未登录！');location.href='login.jsp'</script>");
                response.sendRedirect("login.jsp");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
