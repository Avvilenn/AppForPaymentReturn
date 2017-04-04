<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Все заявки студентов</title>
    <link rel="shortcut icon" href="images/lotus.ico" type="image/x-icon">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="mystyles.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
</head>
    <body>


     <div class="container-fluid" >
        <div class="row ">
            <div class="top-line">

            <div class="col-md-12 welcome">LIST OF CARS</div>

            </div>
        </div>
        <div class="row">
         <div class="mylinks">
          <div class="col-md-4"></div>
          <div class="col-md-4">
           <div >



                      </div>
                      <hr>
                      <hr>

                       <div class>


                                            </div>
                     <hr>
                     <hr>
          </div>
          <div class="col-md-4"></div>
        </div>
        </div>
        <div class="row" >
<div class="placeHolderForForm">
            <div class="col-md-2 ">

            </div>

                <div class="col-md-9 ">
                <div class="placeHolderForForm">
                 <table class="table table-hover" id="tableId">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Husbant</th>
                                    <th>Wife</th>
                                    <th>GRN answer</th>
                                    <th>ZAGS answer</th>
                                    <th>Check if student </th>
                                    <th>Delete</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="order" items="${ORDERS}" varStatus="status">

                                    <c:url var="deleteUrl" value="deleteOrder">
                                        <c:param name="OrderId" value="${order.id}"/>
                                    </c:url>
                                        <td>${order.id}</td>
                                        <td>${order.husband.surName}</td>
                                        <td>${order.wife.surName}</td>
                                        <td>${order.grnAnswer}</td>
                                        <td>${order.zagsAnswer}</td>
                                        <td>${order.studentAnswer}</td>
                                        <td><a href="${deleteUrl}">Delete</a></td>
                                  </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>

                </div>
                <div class="col-md-1 ">
                </div>
                </div>
        </div>
    </div>




    </body>

</html>
