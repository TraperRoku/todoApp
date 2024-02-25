
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigator.jspf" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Todos Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #444;
            color: #fff;
        }

        table.table {
            background-color: #fff;
        }
        table.table th {
            color: #000;
        }
        table.table td {
            color: #000;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Y O U R || T O D O S</h1>

    <table class="table rounded-3">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.descr}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td> <a href="deleteTodo?id=${todo.id}" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</a>   </td>
                <td> <a href="updateTodo?id=${todo.id}" class="btn btn-primary"><i class="fas fa-edit"></i> Update</a>   </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="addTodo" class="btn btn-success"><i class="fas fa-plus"></i> Add Todo</a>

</div>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>
