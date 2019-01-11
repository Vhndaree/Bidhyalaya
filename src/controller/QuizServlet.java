package controller;

import domains.Question;
import domains.QuestionCategory;
import domains.QuizResult;
import service.QuestionCategoryService;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
            Question question=new QuizService().getQuestion(request);

            List<QuizResult> quizResultList=new ArrayList<>();
            HttpSession session=request.getSession(false);
            if(!request.getParameter("id").equalsIgnoreCase("0")){
                QuizResult quizResult=new QuizService().getQuizPlayResult(request);

                if(session.getAttribute("quizResultList")==null) {
                    quizResultList.add(quizResult);
                } else {
                    quizResultList=(List<QuizResult>)session.getAttribute("quizResultList");
                    quizResultList.add(quizResult);
                }
                session.setAttribute("quizResultList", quizResultList);

            }

            if(question!=null) {
                request.setAttribute("question", question);
                request.getRequestDispatcher("quiz/playquiz.jsp").forward(request, response);
            }
            else {
                pageRequest="resultQuiz";
            }
        }

        //for result display
        if(pageRequest.equalsIgnoreCase("resultQuiz")){
            HttpSession session=request.getSession(false);
            request.setAttribute("quizResultList", session.getAttribute("quizResultList"));
            session.removeAttribute("quizResultList");
            request.getRequestDispatcher("quiz/resultquiz.jsp").forward(request, response );
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
