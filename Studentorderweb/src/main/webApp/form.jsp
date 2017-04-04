<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Forma</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="mystyles.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
</head>
    <body>
    <header class="mainImage ">
     <div class="container-fluid" >
        <div class="row ">
            <div class="top-line">

            <div class="col-md-12 welcome">Запольните форму</div>

            </div>
        </div>
        <div class="row" >
<div class="placeHolderForForm">
            <div class="col-md-2 ">

            </div>

                <div class="col-md-8 ">
                <form class="form-horizontal placeHolderForForm" id="formF" method="POST" action="saveForm">

                  <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">MODEL</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputEmail3" placeholder="MODEL" name="model" value="${car.model}">
                    </div>
                  </div>

                    <div class="form-group">
                                       <label for="inputEmail3" class="col-sm-2 control-label">COLOR</label>
                                       <div class="col-sm-10">
                                         <input type="text" class="form-control" id="inputEmail3" placeholder="COLOR" name="color" value="${car.color}">
                                       </div>
                                     </div>
                   <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">TYPE</label>
                                      <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputEmail3" placeholder="MODEL" name="type" value="${car.type}">
                                      </div>
                                    </div>
                    <div class="form-group">
                                       <label for="inputEmail3" class="col-sm-2 control-label">PRICE</label>
                                       <div class="col-sm-10">
                                         <input type="text" class="form-control" id="inputEmail3" placeholder="PRICE" name="price" value="${car.price}">
                                       </div>
                                     </div>
                   <div class="form-group">
                                                          <label for="inputEmail3" class="col-sm-2 control-label">YEAR</label>
                                                          <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputEmail3" placeholder="YEAR" name="year" value="${car.yearOfProduction}">
                                                          </div>
                                                        </div>

                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default" name="submit">ADD CAR</button>
                    </div>
                  </div>
                </form>


                </div>
                <div class="col-md-2 ">


                </div>
                </div>
        </div>
    </div>
  </header>



    </body>

</html>