<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/10/19
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>Result</title>
<link rel="stylesheet" href="/css/stickybar.css">
</head>
<body>
<%@include file="/include/navbar.jsp"%>
<div class="page-background">
    <div class="container">
        <div class="table-responsive mt-3">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th class="col-md-6">Question</th>
                    <th class="col-md-3">Correct Answer</th>
                    <th class="col-md-3">Your Answer</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${quizResultList}" var="quizResult">
                    <tr class="${quizResult.correctAnswer==quizResult.usersAnswer?'table-success':'table-danger'}">
                        <td class="col-md-6">${quizResult.question}</td>
                        <td class="col-md-3">${quizResult.correctAnswer}</td>
                        <td class="col-md-3">${quizResult.usersAnswer}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </table>





        <div class="jumbotron">
            <div class="text-center">
                <h1>Result text here...</h1>
                <p>Some text that represents result...</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>


