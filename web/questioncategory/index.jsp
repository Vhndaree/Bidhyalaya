<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 1/9/19
  Time: 10:24 AM
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
        <div class="mt-5">
            <form method="post" action="listquestioncategory">
                <div class="form-group">
                    <span>
                        <label class="col-md-3">Category</label> <input type="text" name="category" autofocus>
                        <input class="btn btn-danger ml-2" type="submit" value="Add" title="ADD CATEGORY">
                    </span>
                    <span class="text-danger ml-5">${message}</span>
                </div>
                <%--Hidden field for Login--%>
                <input type="hidden" name="pageRequest" value="addQuestionCategory">
            </form>
        </div>

        <div class="table-responsive mt-2">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Question Category</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${questionCategoryList}" var="questionCategory">
                    <tr>
                        <td class="col-md-2">${questionCategory.category}</td>
                        <td class="col-md-2">
                            <a href="updatequestioncategory?pageRequest=updateQuestionPage&id=${questionCategory.id}" title="EDIT" class="btn btn-outline-primary d-block d-sm-inline mr-2"><i class="fa fa-pencil"></i></a>
                            <a href="listquestioncategory?pageRequest=deleteQuestionCategory&id=${questionCategory.id}" title="DELETE" class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
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


