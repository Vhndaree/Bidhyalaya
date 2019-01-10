<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/9/19
  Time: 11:29 AM
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
                <form method="post" action="questioncategory" class="login-form card-body">

                    <div class="form-group">
                        <label>Category</label> <input type="text" name="category" class="form-control" autofocus>
                    </div>

                    <div class="form-group">
                        <input class="btn btn-danger float-right" type="submit" value="Add" title="ADD CATEGORY">
                    </div>
                    <%--Hidden field for Login--%>
                    <input type="hidden" name="pageRequest" value="addQuestionCategory">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
