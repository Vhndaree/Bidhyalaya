<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/2/19
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 12/27/18
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>Question</title>

<%--Jstl core group tags--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="card mt-5">
            <div class=" bg-danger">${message}</div>
            <div class="card-body">
                <div class="card-title">Update Question</div>
                <form method="post" action="updatequestion" class="login-form card-body">
                    <input type="hidden" name="id" value="${question.id}">
                    <div class="form-group">
                        <label>Question</label> <textarea rows="5" name="question" class="form-control" autofocus>${question.question}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" name="category">
                            <option value="general" ${question.category == 'general'?'selected':''}>General</option>
                            <option value="computer" ${question.category == 'computer'?'selected':''}>Computer</option>
                            <option value="science" ${question.category == 'science'?'selected':''}>Science</option>
                            <option value="geography" ${question.category == 'geography'?'selected':''}>Geography</option>
                            <option value="sports" ${question.category == 'sports'?'selected':''}>Sports</option>
                            <option value="art and literature" ${question.category == 'art and literature'?'selected':''}>Art & Literature</option>
                            <option value="history"${question.category == 'history'?'selected':''}>History</option>
                            <option value="current affairs" ${question.category == 'current affairs'?'selected':''}>Current affairs</option>
                            <option value="IQ" ${question.category == 'IQ'?'selected':''}>IQ</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Difficulty Level</label>
                        <div >
                            <input type="radio"  name="difficulty" value="beginner" ${question.difficultyLevel=='beginner'?'checked':''}> Beginner <br>
                            <input type="radio" name="difficulty" value="intermediate" ${question.difficultyLevel=='intermediate'?'checked':''}> Intermediate <br>
                            <input type="radio" name="difficulty" value="expert" ${question.difficultyLevel=='expert'?'checked':''}> Expert
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Option 1</label> <textarea rows="1" name="option1" class="form-control" autofocus>${question.option1}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 2</label> <textarea rows="1" name="option2" class="form-control" autofocus>${question.option2}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 3</label> <textarea rows="1" name="option3" class="form-control" autofocus>${question.option3}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 4</label> <textarea rows="1" name="option4" class="form-control" autofocus>${question.option4}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Correct answer</label> <textarea rows="1" name="correctanswer" class="form-control" autofocus>${question.correctAnswer}</textarea>
                    </div>

                    <div class="form-group">
                        <input class="btn btn-danger float-right" type="submit" value="Update Question" title="UPDATE">
                    </div>
                    <%--Hidden field for Login--%>
                    <input type="hidden" name="pageRequest" value="updateQuestion">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
