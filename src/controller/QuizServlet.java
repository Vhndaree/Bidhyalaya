package controller;

import domains.QuestionCategory;
import service.QuestionCategoryService;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRequest=request.getParameter("pageRequest");

        //choose preference for game
        if(pageRequest.equalsIgnoreCase("selectquiz")){
            List<QuestionCategory> questionCategories=new QuestionCategoryService().getQuestionCategoryList();
            request.setAttribute("questionCategories", questionCategories);
            request.getRequestDispatcher("quiz/selectquiz.jsp").forward(request,response);
        }

        //Enter to the game
        if(pageRequest.equalsIgnoreCase("startquiz")){
            request.setAttribute("questionList", new QuizService().getQuestionList(request));
            request.getRequestDispatcher("quiz/playquiz.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
