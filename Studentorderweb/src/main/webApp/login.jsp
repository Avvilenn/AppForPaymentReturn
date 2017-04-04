<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>LOGIN</title>
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

            <div class="col-md-12 welcome">LOGIN</div>

            </div>
        </div>
        <div class="row" >
<div class="placeHolderForForm">
            <div class="col-md-2 ">

            </div>

                <div class="col-md-8 ">
                <form class="form-horizontal placeHolderForForm" id="formF" method="POST" action="${pageContext.request.contextPath}/LLogin">
                  <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputEmail3" placeholder="Email" name="login">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> Remember me
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default" name="submit">Sign in</button>
                    </div>
                  </div>
                </form>


                </div>
                <div class="col-md-2 ">


                </div>
                </div>
        </div>
    </div>




    </body>

</html>