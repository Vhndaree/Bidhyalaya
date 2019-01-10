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


</head>
<body>

<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="card mt-5">
            <div class=" bg-danger">${message}</div>
            <div class="card-body">
                <div class="card-title">Add Question</div>
                <form method="post" action="addquestion" class="login-form card-body">
                    <div class="form-group">
                        <label>Question</label> <textarea rows="5" name="question" class="form-control" autofocus></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" name="category">
                            <option value="default">--select--</option>
                            <c:forEach items="${questionCategories}" var="questionCategories">
                                <option value="${questionCategories.category}">${questionCategories.category}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Difficulty Level</label>
                        <div >
                            <input type="radio"  name="difficulty" value="beginner"> Beginner <br>
                            <input type="radio" name="difficulty" value="intermediate"> Intermediate <br>
                            <input type="radio" name="difficulty" value="expert"> Expert
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Option 1</label> <textarea rows="1" name="option1" class="form-control" autofocus></textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 2</label> <textarea rows="1" name="option2" class="form-control" autofocus></textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 3</label> <textarea rows="1" name="option3" class="form-control" autofocus></textarea>
                    </div>
                    <div class="form-group">
                        <label>Option 4</label> <textarea rows="1" name="option4" class="form-control" autofocus></textarea>
                    </div>
                    <div class="form-group">
                        <label>Correct answer</label>
                        <select name="correctanswer" class="form-control" autofocus>
                            <option value="option1">Option 1</option>
                            <option value="option2">Option 2</option>
                            <option value="option3">Option 3</option>
                            <option value="option4">Option 4</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <input class="btn btn-danger float-right" type="submit" value="Add Question" title="ADD QUESTION">
                    </div>
                    <%--Hidden field for Login--%>
                    <input type="hidden" name="pageRequest" value="addQuestion">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
