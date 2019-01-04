package controller;

import domains.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequest=request.getParameter("pageRequest");
        UserService userService=new UserService();

        //login page
        if(pageRequest.equalsIgnoreCase("loginpage")){
            //link to login
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        //login
        if(pageRequest.equalsIgnoreCase("login")){
            String email=request.getParameter("email");
            String password=request.getParameter("password");

            User user=userService.loginUser(email, password);
            if(user!=null){
                //Home
                HttpSession session=request.getSession(false);
                session.setAttribute("user", user);
                redirectToHome(request, response, "Login Successful!!");
            } else {
                //if login fails
                redirectToIndex(request, response, "Credential not matched!");
            }

        }

        //home page
        if(pageRequest.equalsIgnoreCase("home")){
            HttpSession session=request.getSession(false);
            if(session.getAttribute("user")!=null) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
                requestDispatcher.forward(request, response);
            } else {
                redirectToIndex(request, response, "");
            }
        }

        //user register page
        if(pageRequest.equalsIgnoreCase("registerpage")){
            //link to register page
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("localhost:8080/#register");
            requestDispatcher.forward(request, response);
        }

        //register user
        if(pageRequest.equalsIgnoreCase("registeruser")){
            //gets user credential for registration
            userService.registerUser(userService.getUser(request));
            redirectToHome(request, response, "Signed up and login successfully");
        }

        //logout
        if(pageRequest.equalsIgnoreCase("logout")){
            //for logout

            HttpSession session=request.getSession(false);
            session.invalidate();
            request.setAttribute("logoutMessage", "Successfully logged out!!");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        //for user list
        if (pageRequest.equalsIgnoreCase("userList")) {
            //get all user from utils
            HttpSession session=request.getSession(false);
            if(session.getAttribute("user")!=null) {
                User user=(User)session.getAttribute("user");
                if(user.getRole().equalsIgnoreCase("admin")) {
                    redirectToList(request, response, "");
                } else{
                    redirectToHome(request, response, "");
                }
            } else {
                redirectToIndex(request, response,"Please! Login first.");
            }
        }

        //for delete user
        if(pageRequest.equalsIgnoreCase("deleteUser")){
            HttpSession session=request.getSession(false);
            User user=(User)session.getAttribute("user");
            if(user!=null) {
                if (user.getRole().equalsIgnoreCase("admin")) {
                    User user1 = userService.selectUser(Integer.parseInt(request.getParameter("id")));
                    userService.deleteUser(Integer.parseInt(request.getParameter("id")));
                    String message = "User " + user1.getName() + " removed.";
                    redirectToList(request, response, message);
                } else {
                    redirectToList(request, response, "");
                }
            } else {
                redirectToIndex(request, response, "Please! Login first.");
            }
        }

        //update user page
        if(pageRequest.equalsIgnoreCase("updateUserPage")){
            HttpSession session=request.getSession(false);
            if(session.getAttribute("user")!=null) {
                User user = userService.selectUser(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("user", user);

                RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/edit.jsp");
                requestDispatcher.forward(request,response);
            } else {
                redirectToIndex(request, response, "Please! Login first.");
            }
        }

        //for update user information
        if(pageRequest.equalsIgnoreCase("updateUser")){
            HttpSession session=request.getSession(false);
            if(session.getAttribute("user")!=null) {
                User user;
                userService.updateUser(user = userService.getUser(request), Integer.parseInt(request.getParameter("id")));
                String message = "User " + user.getName() + " updated.";
                redirectToList(request, response, message);
            } else {
                redirectToIndex(request, response, "Please! Login first.");
            }
        }
    }

    private void redirectToHome(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {

        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        //get all user from utils
        List<User> userList = new UserService().userList();
        request.setAttribute("userList", userList);
        request.setAttribute("message",message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
