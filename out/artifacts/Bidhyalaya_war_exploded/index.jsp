<%--
  Created by IntelliJ IDEA.
  User: vhndaree
  Date: 12/27/18
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
    <title>Index</title>

    <%--Bootstrap CDN--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!--jQuery CDN-->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


    <%--login and registration forms--%>
    <link rel="stylesheet" href="css/login.css">

    <script>
     $( function() {
         $( "#tabs" ).tabs();
     } );
    </script>
</head>
<body>
    <section class="login-block">
        <div class="container">
            <div class="row">
                <div class="card col-md-4" id="tabs">
                    <ul class="nav nav-tabs justify-content-center mt-2">
                        <li><a class="nav-link active" href="#login">Login</a></li>
                        <li><a class="nav-link active" href="#register">Register</a></li>
                    </ul>

                    <div id="login">
                        <form method="post" action="login" class="login-form card-body">
                            <div class="form-group">
                                <div class=" bg-danger">${message}</div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="email" placeholder="Email Address">

                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password" name="password">
                            </div>


                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input">
                                    <small>Remember Me</small>
                                </label>
                                <button type="submit" class="btn btn-login float-right">Login</button>
                            </div>
                            <%--Hidden field for Login--%>
                            <input type="hidden" name="pageRequest" value="login">
                        </form>
                        <div class="copy-text bg-info"><span class="text-light">${logoutMessage}</span></div>
                    </div>

                    <div id="register">
                            <form method="post" action="register" class="login-form card-body">
                                <div class="form-group">
                                    <input type="text" name="username" class="form-control" placeholder="Full Name" autofocus>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="email" class="form-control" placeholder="Email Address" autofocus>
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="confirmPassword" class="form-control" placeholder="Re-enter password" autofocus>
                                </div>

                                <div class="form-group">
                                    <input class="btn btn-login float-right" type="submit" value="Register" class="login-button">
                                </div>
                                <%--Hidden field for Login--%>
                                <input type="hidden" name="pageRequest" value="registeruser">
                            </form>
                            <div class="copy-text justify-content-center">Already have an account <a href="login?pageRequest=loginpage">Login</a></div>
                        </div>
                </div>

                <div class="col-md-8 banner-sec">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <div class="banner-text">
                                        <h2>This is text for carousel.</h2>
                                        <p>...</p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg" alt="First slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <div class="banner-text">
                                        <h2>This is text for carousel.</h2>
                                        <p>...</p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg" alt="First slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <div class="banner-text">
                                        <h2>This is text for carousel.</h2>
                                        <p>...</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>