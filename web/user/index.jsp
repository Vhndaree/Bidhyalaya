<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 12/27/18
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>User List</title>

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
                            <th>Name</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Option</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                                <td>${user.name}</td>
                                <td>${user.email}</td>
                                <td>${user.role}</td>
                                <td>
                                    <a href="updateuser?pageRequest=updateUserPage&id=${user.id}" title="EDIT" class="btn btn-outline-primary d-block d-sm-inline mr-2"><i class="fa fa-pencil"></i></a>
                                    <a href="deleteuser?pageRequest=deleteUser&id=${user.id}" title="DELETE" class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
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
