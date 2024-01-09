<%--
  Created by IntelliJ IDEA.
  User: buidu
  Date: 9/1/2024
  Time: 6:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>

<body>
<header>
    <div class="alert bg-dark" style="color: white;" role="alert">
        @White2077 - Bui Hoang Dung Spring MVC CRUD with JSP
    </div>
</header>
<h3>EMPLOYEE LIST:</h3>
<div class="container">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary mb-3 bg-secondary" data-bs-toggle="modal"
            data-bs-target="#employeeModal">
        Add new
    </button>
    <div class="modal fade" id="employeeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add new employee</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="" method="post">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="emName" class="form-label">Name:</label>
                            <input type="text"  class="form-control" id="emName" placeholder="Full name">
                        </div>
                        <div class="mb-3">
                            <label for="DOB" class="form-label">DOB:</label>
                            <input type="date" class="form-control" id="DOB">
                        </div>
                        <div class="mb-3">
                            <label for="department" class="form-label">Department:</label>
                            <select class="form-select form-select" id="department" aria-label=".form-select-sm example">
                                <option value="1" selected>One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div class="mb-3 d-flex">
                            <div class="form-check me-2">
                                <input class="form-check-input" type="radio" name="Male"
                                       id="rdoMale" checked>
                                <label class="form-check-label" for="rdoMale">
                                    Male
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="Female"
                                       id="rdoFemale" >
                                <label class="form-check-label" for="rdoFemale">
                                    Female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>EM.ID</th>
            <th>Employee name</th>
            <th>Gender</th>
            <th>DOB</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${listEmployee}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.employeeName}</td>
                <td>
                    <c:if test="${employee.gender}">
                        Male
                    </c:if>
                    <c:if test="${not employee.gender}">
                        Female
                    </c:if>
                </td>
                <td>${employee.dob}</td>
                <td>${employee.department.departmentName}</td>
                <td><a href="">Edit</a></td>
                <td><a href="">Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>
