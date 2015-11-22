<%--
  Created by IntelliJ IDEA.
  Date: 10.11.2015
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-offset-4 col-lg-3 has-error">
            <h3 class="alert-danger">
                <c:if test="${not empty error}">
                    <c:out value="${error}"/>
                </c:if>
                <h4><a class="alert-link" href="/login">Go to Login page</a> </h4>

            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-4 col-lg-5">
            <form action="register" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="login" class="control-label col-md-2">Login</label>

                    <div class="col-md-10">
                        <input name="login" class="form-control" id="login" placeholder="Login" type="text" required/>
                    </div>
                </div>


                <div class="form-group">
                    <label for="email" class="control-label col-md-2">Email</label>
                    <div class="col-md-10">
                        <input name="email" class="form-control" id="email" placeholder="Email" type="email" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="birthDate" class="control-label col-md-2">Birth Date</label>
                    <div class="col-md-10">
                        <input name="birthDate" class="form-control" id="birthDate" type="date" placeholder="date"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="control-label col-md-2">Password</label>

                    <div class="col-md-10">
                        <input name="password" class="form-control" id="password" placeholder="Password" type="password"
                               required/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Register</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
