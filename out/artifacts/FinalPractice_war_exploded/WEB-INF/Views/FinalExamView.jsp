<%--
  Created by IntelliJ IDEA.
  User: roout
  Date: 2021-08-10
  Time: 8:52 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Final Exam</title>
</head>
<body>
<h1>Rafael Olivares - 300300098</h1>
<h1 id="mes">${messages}</h1>
<form method="POST">
    <fieldset class="form-group">
        <label for="custno">Cust No:</label>
        <input type="text" name="custno" class="form-control" id="custno" value="${custno}">
    </fieldset>
    <fieldset class="form-group">
        <label for="custname">Name:</label>
        <input type="text" name="custname" class="form-control" id="custname" value="${custname}">
    </fieldset>
    <fieldset class="form-group">
        <label for="cdep">Discount:</label>
        <input type="number" name="cdep" class="form-control" id="cdep" value="${cdep}">
    </fieldset>
    <fieldset class="form-group">
        <label for="nyears">Year:</label>
        <input type="number" name="nyears" class="form-control" id="nyears" value="${nyears}">
    </fieldset>
    <fieldset class="form-group">
        <label for="savingType">Job:</label>
        <select name="savingType" id="savingType">
            <c:forEach items="${types}" var="type">
                <option value="${type}">${type}</option>
            </c:forEach>
        </select>
    </fieldset>
    <input class="btn btn-success" type="submit" value="${edit == true ? "Edit":"Submit"}" />
</form>

<h1>List of employees</h1>
<a class="btn btn-success" href="add">Add new</a>
<table class="table">
    <tr>
        <th>Customer Number</th>
        <th>Customer Name</th>
        <th>Customer Deposit</th>
        <th>Number of years</th>
        <th>Saving type</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${savings}" var="saving">
        <tr>
            <td>${saving.getCustno()}</td>
            <td>${saving.getCustname()}</td>
            <td>${saving.getCdep()}</td>
            <td>${saving.getNyears()}</td>
            <td>${saving.getSavtype()}</td>
            <td><a class="btn btn-primary" href="add?id=${saving.getCustno()}">Edit</a></td>
            <td><a class="btn btn-secondary" href="delete?id=${saving.getCustno()}">Delete</a></td>
            <td><a class="btn btn-success" href="add?id=${saving.getCustno()}">Project Investment</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
