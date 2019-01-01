<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 12/27/18
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-xl bg-dark">
    <ul class="navbar-nav w-100">
        <li class="nav-item">
            <a class="nav-link text-light"  href="home?pageRequest=home"><i class="fa fa-home" ></i></a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-light" href="#">Courses</a>
        </li>

        <li class="nav-item">
            <a class="nav-link text-light" href="#">upcoming intakes</a>
        </li>

        <li class="nav-item">
            <a class="nav-link text-light" href="#">Admission</a>
        </li>

        <%--for user list--%>
        <li class="nav-item">
            <a class="nav-link text-light" href="listUser?pageRequest=userlist">Users</a>
        </li>

    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link text-light" href="logout?pageRequest=logout">Logout</a>
        </li>
    </ul>
</nav>