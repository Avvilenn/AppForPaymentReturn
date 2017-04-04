
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Persons</title>
    <link rel="shortcut icon" href="images/lotus.ico" type="image/x-icon">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="mystyles.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
</head>
    <body>
    <header >
     <div class="container-fluid" >
        <div class="row ">
            <div class="top-line">

            <div class="col-md-12 welcome">ALL REGISTERED USERS IN SYSTEM</div>

            </div>
        </div>
        <div class="row">
         <div class="mylinks">
          <div class="col-md-4"></div>
          <div class="col-md-4">

          </div>
          <div class="col-md-4"></div>
        </div>
        </div>
        <div class="row" >
<div class="placeHolderForForm">
            <div class="col-md-2 ">

            </div>

                <div class="col-md-8 ">
                <div class="placeHolderForForm">
                <table class="table table-hover" id="tableId">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Email</th>
                                    <th>Password</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="person" items="${Persons}" varStatus="status">

                                    <c:url var="deleteUrl" value="deletePerson">
                                        <c:param name="personId" value="${person.personId}"/>
                                    </c:url>


                                        <td>${person.personId}</td>
                                        <td>${person.email}</td>
                                        <td>${person.password}</td>

                                        <td><a href="${deleteUrl}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>





                </div>
                <div class="col-md-2 ">


                </div>
                </div>
        </div>
    </div>
  </header>



    </body>

</html>
