package controller;

import domains.QuestionCategory;
import service.QuestionCategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionCategoryServlet")
public class QuestionCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequest=request.getParameter("pageRequest");

        //redirect to add category form
        if(pageRequest.equalsIgnoreCase("listQuestionCategory")){
            redirectToCategoryList(request, response);
        }

        //Add category
        if(pageRequest.equalsIgnoreCase("addQuestionCategory")){
            new QuestionCategoryService().addQuestionCategory(request);
            request.setAttribute("message", "Category added");
            redirectToCategoryList(request, response);
        }

        //delete category
        if(pageRequest.equalsIgnoreCase("deleteQuestionCategory")){
            new QuestionCategoryService().deleteQuestionCategory(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("message", "Category removed");
            redirectToCategoryList(request, response);
        }

    }

    private void redirectToCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<QuestionCategory> questionCategoryList = new QuestionCategoryService().getQuestionCategoryList();
        request.setAttribute("questionCategoryList", questionCategoryList);
        request.getRequestDispatcher("questioncategory/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
