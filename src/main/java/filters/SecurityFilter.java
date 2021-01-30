package filters;

import login.elements.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/dashboard.jsp")


public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                System.out.println(user.getName());
                chain.doFilter(req, resp);
            } else {
                System.out.println("user is null");
                req.getRequestDispatcher("signIn.html").forward(request, response);
            }
        } else {
            System.out.println("no session");
            req.getRequestDispatcher("signIn.html").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
