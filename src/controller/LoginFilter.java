package controller;

import domains.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session=request.getSession(false);

        String pageRequest=request.getParameter("pageRequest");

        if(pageRequest == null) {
            pageRequest = "NA";
        }
        String landingURI = request.getContextPath() + "/";
        if((session==null || session.getAttribute("user")==null)&&!pageRequest.equalsIgnoreCase("login") && !pageRequest.equalsIgnoreCase("logout") && !pageRequest.equalsIgnoreCase("registeruser")){
            if(request.getRequestURI().equals(landingURI)) {
                req.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Please Login first.");
                req.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
