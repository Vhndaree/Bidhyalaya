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

<%--Jstl core group tags--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

</head>
</body>

<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="bg-danger mt-5">${message}</div>

        <div class="table-responsive mt-3">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Question</th>
                    <th>Category</th>
                    <th>Difficulty</th>
                    <th>Answer</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${questionList}" var="question">
                    <tr>
                        <td class="col-md-6">${question.question}</td>
                        <td class="col-md-1">${question.category}</td>
                        <td class="col-md-1">${question.difficultyLevel}</td>
                        <td class="col-md-2">${question.correctAnswer}</td>
                        <td class="col-md-2">
                            <a href="updatequestion?pageRequest=updateQuestionPage&id=${question.id}" title="EDIT" class="btn btn-outline-primary d-block d-sm-inline mr-2"><i class="fa fa-pencil"></i></a>
                            <a href="deletequestion?pageRequest=deleteQuestion&id=${question.id}" title="DELETE" class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </table>
    </div>
</div>
</body>
</html>

