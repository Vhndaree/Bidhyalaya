package controller;

import domains.Question;
import domains.User;
import service.QuestionService;
import sun.security.x509.RDN;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRequest=request.getParameter("pageRequest");
        QuestionService questionService=new QuestionService();

        HttpSession session=request.getSession(false);
        if(session.getAttribute("user")!=null) {

            User user=(User)session.getAttribute("user");
            if(user.getRole().equalsIgnoreCase("admin")) {
                //redirect to add question page
                if (pageRequest.equalsIgnoreCase("addQuestionPage")) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/create.jsp");
                    requestDispatcher.forward(request, response);
                }

                //Add questions
                if (pageRequest.equalsIgnoreCase("addQuestion")) {
                    questionService.addQuestion(questionService.getQuestion(request));
                    request.setAttribute("message", "Question added successfully.");

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/create.jsp");
                    requestDispatcher.forward(request, response);
                }

                //List all questions
                if (pageRequest.equalsIgnoreCase("listQuestion")) {
                    redirectToList(request, response, "");
                }

                //Delete question
                if (pageRequest.equalsIgnoreCase("deleteQuestion")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    questionService.deleteQuestion(id);

                    redirectToList(request, response, "Question deleted.");
                }

                //redirect to edit page
                if (pageRequest.equalsIgnoreCase("updateQuestionPage")) {
                    Question question = questionService.selectQuestion(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("question", question);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/edit.jsp");
                    requestDispatcher.forward(request, response);
                }

                //edit question
                if (pageRequest.equalsIgnoreCase("updateQuestion")) {
                    questionService.updateQuestion(questionService.getQuestion(request), Integer.parseInt(request.getParameter("id")));

                    String message = "Question updated.";
                    redirectToList(request, response, message);
                }
            } else {
                redirectToHome(request, response,"");
            }
        } else {
            redirectToIndex(request, response, "Please! Login first.");
        }
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException{
        request.setAttribute("message", message);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        List<Question> questionList=new QuestionService().getQuestionList();
        request.setAttribute("questionList", questionList);
        request.setAttribute("message", message);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("question/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void redirectToHome(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException{
        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
