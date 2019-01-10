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

</head>
</body>

<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="mt-5">
                <form method="post" action="startquiz" >
                    <c:set var="count" value="0" scope="page"/>
                    <c:forEach items="${questionList}" var="questionList">
                        <div class="form-group bg-light card-body mt-5">
                            <label class="font-weight-bold"><c:set var="count" value="${count+1}" scope="page"/>${count}. ${questionList.question}</label><span class="float-right text-primary">Category: ${questionList.category}<br>Difficulty: ${questionList.difficultyLevel}</span><br>
                            <div class="col-md-4"><input type="radio"  name="answer" value="${questionList.option1}"> ${questionList.option1} </div>
                            <div class="col-md-4"><input type="radio" name="answer" value="${questionList.option2}"> ${questionList.option2} </div>
                            <div class="col-md-4"><input type="radio" name=answer" value="${questionList.option3}"> ${questionList.option3}</div>
                            <div class="col-md-4"><input type="radio" name=answer" value="${questionList.option4}"> ${questionList.option4}</div>
                        </div>
                    </c:forEach>

                    <div class=" text-center">
                        <input class="btn btn-primary" type="submit" value="FINISH" title="FINISH">
                    </div>
                    <%--Hidden field for Login--%>
                    <input type="hidden" name="pageRequest" value="playquiz">
                </form>
        </div>
    </div>
</div>
</body>
</html>



