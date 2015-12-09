<%--
  Created by IntelliJ IDEA.
  Date: 11.11.2015
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery-2.1.4.js"></script>

</head>
<body>

<div class="container">
    <div class="row">

    </div>
    <div class="row">
        <div class="col-lg-offset-4 col-lg-5">
            <form id="profile" class="form-horizontal">
                <div class="form-group">
                    <label for="login" class="control-label col-md-2">Login</label>

                    <div class="col-md-10">
                        <input value="<c:out value="${user.login}"/>" readonly="readonly" name="login" class="form-control allowEdit" id="login"  type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="country" class="control-label col-md-2">Country</label>

                    <div class="col-md-10">
                        <input value="<c:out value="${user.country}"/>" readonly="readonly" name="country" class="form-control allowEdit" id="country" type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="control-label col-md-2">Email</label>

                    <div class="col-md-10">
                        <input value="<c:out value="${user.email}"/>" readonly="readonly" name="email" class="form-control allowEdit" id="email" type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="bd" class="control-label col-md-2">Birth Date</label>

                    <div class="col-md-10">
                        <input readonly="readonly" name="birthDate" value="${user.birthDate}" class="form-control allowEdit" id="bd" type="text" />
                    </div>
                </div>
                <div hidden class="form-group" id="cancel">
                    <div class="col-md-5">
                        <button id="cancelBtn" type="button" class="btn btn-default">Cancel</button>
                    </div>
                </div>
                <div hidden id="save" class="form-group">
                    <div class="col-md-5">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    $(function(){
        $(".allowEdit").click(function(){
            $('input:text').removeAttr("readonly");
            $('#save').show();
            $('#cancel').show();
        });
        $("#cancelBtn").click(function(){
            $('input:text').attr("readonly", "readonly");
            $('#save').hide();
            $('#cancel').hide();
        });

        $("#profile").submit(function (e) {
            e.preventDefault();
            $("#profile").serialize()
            console.log(1122);
            $.ajax('/profile?update', $.param(
                $("#profile").serialize()
            ), function (resp) {
                console.log("=================");
                console.log(resp);
            })
        })
    })


</script>

</body>
</html>
