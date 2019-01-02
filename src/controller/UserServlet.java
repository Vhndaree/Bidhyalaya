package controller;

import domains.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequest=request.getParameter("pageRequest");
        UserService userService=new UserService();

        if(pageRequest.equalsIgnoreCase("login")){
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            if(userService.loginUser(email, password)!=null){
                //Home
                request.setAttribute("message","Login Successful!!");
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
                requestDispatcher.forward(request, response);
            } else {
                //if login fails
                request.setAttribute("message","Credential not matched!!");
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }

        }

        if(pageRequest.equalsIgnoreCase("home")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);
        }

        if(pageRequest.equalsIgnoreCase("registeruser")){
            //gets user credential for registration
            userService.registerUser(userService.getUser(request));
            request.setAttribute("message", "You are signed up and logged in successfully!!");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);
        }

        if(pageRequest.equalsIgnoreCase("registerpage")){
            //link to register page
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("localhost:8080/#register");
            requestDispatcher.forward(request, response);
        }


        if(pageRequest.equalsIgnoreCase("loginpage")){
            //link to login
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if(pageRequest.equalsIgnoreCase("logout")){
            //for logout
            request.setAttribute("logoutMessage", "Successfully logged out!!");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (pageRequest.equalsIgnoreCase("userList")) {
            //get all user from utils

            redirectToList(request, response, "");
        }

        //for delete user
        if(pageRequest.equalsIgnoreCase("deleteUser")){
            User user = userService.selectUser(Integer.parseInt(request.getParameter("id")));
            userService.deleteUser(Integer.parseInt(request.getParameter("id")));
            String message ="User "+user.getName()+" removed.";
            redirectToList(request, response, message);

        }

        //update user page
        if(pageRequest.equalsIgnoreCase("updateUserPage")){
            User user=userService.selectUser(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("user",user);

            RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/edit.jsp");
            requestDispatcher.forward(request,response);
        }

        //for update user information
        if(pageRequest.equalsIgnoreCase("updateUser")){

            User user;
            userService.updateUser(user=userService.getUser(request),Integer.parseInt(request.getParameter("id")));
            String message="User "+user.getName()+" updated.";
            redirectToList(request,response, message);
        }
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
