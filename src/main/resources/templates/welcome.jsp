<%@include file="include.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px;
        }
        .navbar.navbar-inverse {
            border: none;
        }
        .navbar .navbar-brand {
            padding-top: 0px;
        }
        .navbar .navbar-brand img {
            height: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">QuestBook project</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/welcome">Home</a>
                        </li>
                        <li>
                            <a href="/admin/getAll">QuestBook List</a>
                        </li>
                        <li>
                            <a href="/myQuestBooks">My QuestBook</a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li c:if="${authorization.expression('!isAuthenticated()')}">
                        <li>
                            <a href="/signin">
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;Sign in
                            </a>
                        </li>
                        <li c:if="${authorization.expression('isAuthenticated()')}">
                        <li>
                            <a href="/logout" onclick="$('#logoutForm').submit();">
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;Logout
                            </a>
                            <form style="visibility: hidden" id="logoutForm" method="post" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </ul>

                </div>
            </div>
        </div>



        <%--<form id="logoutForm" method="POST" action="${contextPath}/logout">--%>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--</form>--%>

        <%--<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>--%>
    </c:if>
</div>
<script src="${contextPath}/static/js/jquery.js"></script>
<script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>