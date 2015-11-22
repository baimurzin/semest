<%--
  Created by IntelliJ IDEA.
  Date: 12.11.2015
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Space research</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery-2.1.4.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="form-inline">
            <form>
                <input class="form-control" type="text" id="query" name="query"/>
            </form>
        </div>
    </div>
    <div class="row">

        <table id="resultTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Date</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>

<script>
    $(function () {
        $('#query').on('input', function (e) {
            var val = $('#query').val();
            $.post('/research', $.param({query: val}), function (resp) {
                var content = '';
                $.each(resp, function (i, item) {
                    content += '<tr>';
                    content += '<td>' + item.date + '</td>';
                    content += '<td>' + item.eventName + '</td>';
                    content += '</tr>';
                });
                $('#resultTable').find('tbody').html(content);
            })
        })
    })
</script>
</body>
</html>
