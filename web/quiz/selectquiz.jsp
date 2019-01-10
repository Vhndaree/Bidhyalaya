<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/9/19
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/2/19
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>Question List</title>

</head>
</body>

<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="card mt-5">
            <div class="card-body">
                <form method="post" action="startquiz" class="login-form card-body">
                    <div class="form-group">
                        <label>Select Category</label>
                        <div class="form-control">
                            <c:forEach items="${questionCategories}" var="questionCategory">
                                <span class="col-md-4 ">${questionCategory.category} <input type="checkbox" name="category" value="${questionCategory.category}"></span>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Difficulty Level</label>
                        <div class="form-control">
                            <span class="col-md-4"><input type="radio"  name="difficulty" value="beginner"> Beginner</span>
                            <span class="col-md-4"><input type="radio" name="difficulty" value="intermediate"> Intermediate</span>
                            <span class="col-md-4"><input type="radio" name="difficulty" value="expert"> Expert</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Number of Questions</label> <input type="number" min="1" value="1" name="questionnumber" class="form-control" autofocus>
                    </div>

                    <div class="form-group">
                        <input class="btn btn-danger float-right" type="submit" value="START" title="START QUIZ">
                    </div>
                    <%--Hidden field for Login--%>
                    <input type="hidden" name="pageRequest" value="startquiz">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>


