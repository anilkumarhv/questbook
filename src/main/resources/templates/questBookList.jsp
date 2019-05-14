<%@include file="include.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <div class="col-lg-8 col-md-7 col-sm-6">
        <h1>My QuestBooks</h1>

        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Status</th>
                <th>Approve</th>
                <th>Reject</th>
                <th>UserName</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <c:forEach var="book" items="${questBooks}">
                    <td><c:out value="${book.id}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td><c:out value="${book.status}"/></td>
                    <td><a href="/questbook/${book.id}/approve" >Approve</a></td>
                    <td><a href="/questbook/${book.id}/reject" >Reject</a></td>
                    <td><c:out value="${book.user.username}"/></td>
                </c:forEach>
            </tr>

            </tbody>
        </table>
    </div>

</div>

<script src="${contextPath}/static/js/jquery.js"></script>
<script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>