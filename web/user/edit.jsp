<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 12/27/18
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/html/head.jsp"%>
<title>Edit User</title>


    </head>
    <body>

        <%@include file="/include/navbar.jsp"%>
        <div class="page-background">
            <div class="container">
                <div class="card mt-5">
                    <div class="card-body">
                        <div class="card-title">Edit user</div>
                        <form method="post" action="updateuser" class="login-form card-body">
                            <input type="hidden" name="id" value="${user.id}">
                            <div class="form-group">
                                <label>Name</label> <input type="text" name="username" class="form-control" value="${user.name}" placeholder="Full Name" autofocus>
                            </div>
                            <div class="form-group">
                                <label>Email</label> <input type="text" name="email" class="form-control" value="${user.email}" placeholder="Email Address" autofocus>
                            </div>
                            <div class="form-group">
                                <label>Password</label> <input type="text" name="password" class="form-control" value="${user.password}" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label>Confirm password</label> <input type="password" name="confirmPassword" class="form-control" placeholder="Re-enter password" autofocus>
                            </div>
                            <div class="form-group">
                                <label>Role</label> <input type="text" name="role" class="form-control" value="${user.role}" placeholder="Role" autofocus>
                            </div>

                            <div class="form-group">
                                <input class="btn btn-danger float-right" type="submit" value="Update">
                            </div>
                            <%--Hidden field for Login--%>
                            <input type="hidden" name="pageRequest" value="updateUser">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
