<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Forma</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="mystyles.css" rel="stylesheet">
     <script>
             $(function(){
               $('#add-text-field').click(function(){
                 $('#text-fields').append('<input type="text" name="textfield[]" class="form-control">');
               });
             });

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="js/bootstrap.min.js"></script>
</head>
    <body>

<form class="form-horizontal" method="POST" action="saveForm">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="Email" name="email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">husband_surName</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="husband_surName" name="husband_surName">
    </div>
  </div>
   <div class="form-group">
      <label for="inputEmail3" class="col-sm-2 control-label">husband_givenName</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputEmail3" placeholder="husband_givenName" name="husband_givenName">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword3" class="col-sm-2 control-label">husband_patronymic</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputPassword3" placeholder="husband_patronymic" name="husband_patronymic">
      </div>
    </div>
     <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">husband_dateOfBirth</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="inputEmail3" placeholder="husband_dateOfBirth" name="husband_dateOfBirth">
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">husband_passportSeria</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="inputPassword3" placeholder="husband_passportSeria" name="husband_passportSeria">
        </div>
      </div>
       <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">husband_passportNumber</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="husband_passportNumber" name="husband_passportNumber">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">husband_passportDateIssue</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputPassword3" placeholder="husband_passportDateIssue" name="husband_passportDateIssue">
          </div>
        </div>
    <div class="form-group">
       <label for="inputEmail3" class="col-sm-2 control-label">husband_passportDateExpire</label>
       <div class="col-sm-10">
         <input type="text" class="form-control" id="inputEmail3" placeholder="husband_passportDateExpire" name="husband_passportDateExpire">
       </div>
     </div>
     <div class="form-group">
       <label for="inputPassword3" class="col-sm-2 control-label">wife_surName</label>
       <div class="col-sm-10">
         <input type="text" class="form-control" id="inputPassword3" placeholder="wife_surName" name="wife_surName">
       </div>
     </div>

    <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">wife_givenName</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputPassword3" placeholder="wife_givenName" name="wife_givenName">
          </div>
        </div>
         <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">wife_patronymic</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputEmail3" placeholder="wife_patronymic" name="wife_patronymic">
            </div>
          </div>
          <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">wife_dateOfBirth</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputPassword3" placeholder="wife_dateOfBirth" name="wife_dateOfBirth">
            </div>
          </div>
           <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">wife_passportSeria</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" placeholder="wife_passportSeria" name="wife_passportSeria">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">wife_passportNumber</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" placeholder="wife_passportNumber" name="wife_passportNumber">
              </div>
            </div>
        <div class="form-group">
           <label for="inputEmail3" class="col-sm-2 control-label">wife_passportDateIssue</label>
           <div class="col-sm-10">
             <input type="text" class="form-control" id="inputEmail3" placeholder="wife_passportDateIssue" name="wife_passportDateIssue">
           </div>
         </div>
         <div class="form-group">
           <label for="inputPassword3" class="col-sm-2 control-label">wife_passportDateExpire</label>
           <div class="col-sm-10">
             <input type="text" class="form-control" id="inputPassword3" placeholder="wife_passportDateExpire" name="wife_passportDateExpire">
           </div>
         </div>
         <hr>


         <div id="text-fields">

            <div class="form-group">
                       <label for="inputPassword3" class="col-sm-2 control-label">child surName</label>
                       <div class="col-sm-10">
                         <input type="text" class="form-control" id="inputPassword3" placeholder="surName" name="surName">
                       </div>
                     </div>
         <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">child givenName</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputPassword3" placeholder="givenName" name="givenName">
                    </div>
                  </div>
        <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">child patronymic</label>
                   <div class="col-sm-10">
                     <input type="text" class="form-control" id="inputPassword3" placeholder="patronymic" name="patronymic">
                   </div>
                 </div>
         <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">child dateOfBirth</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputPassword3" placeholder="dateOfBirth" name="dateOfBirth">
                    </div>
                  </div>
        <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">child birthDocument</label>
                   <div class="col-sm-10">
                     <input type="text" class="form-control" id="inputPassword3" placeholder="birthDocument" name="birthDocument">
                   </div>
                 </div>
         </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">SAVE AND SEND FOR CHECKING</button>
    </div>
  </div>
</form>
    </body>

</html>