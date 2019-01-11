<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/9/19
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>Question List</title>
<link rel="stylesheet" href="/css/stickybar.css">
</head>
</body>

<%@include file="/include/navbar.jsp"%>

<div class="page-background">

    <div class="container">
        <div class="mt-5">
            <form method="post" action="quiz" >
                <div class="form-group bg-light card-body mt-5">
                    <label class="font-weight-bold">${question.question}</label><span class="float-right text-primary">Category: ${question.category}<br>Difficulty: ${question.difficultyLevel}</span><br>
                    <div class="col-md-4"><input type="radio" name="${question.id}" value="${question.option1}"> ${question.option1} </div>
                    <div class="col-md-4"><input type="radio" name="${question.id}" value="${question.option2}"> ${question.option2} </div>
                    <div class="col-md-4"><input type="radio" name="${question.id}" value="${question.option3}"> ${question.option3} </div>
                    <div class="col-md-4"><input type="radio" name="${question.id}" value="${question.option4}"> ${question.option4} </div>
                </div>
                <div class=" text-center">
                    <input class="btn btn-primary float-right" type="submit" value="NEXT" title="NEXT">
                </div>
                <%--Hidden field for Login--%>
                <input type="hidden" name="pageRequest" value="startquiz">
                <input type="hidden" name="id" value="${question.id}">
            </form>
        </div>
    </div>
</div>
</body>
</html>



