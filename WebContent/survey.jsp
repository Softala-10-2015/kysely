<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/kisutopi.ico">

    <title>Kysely</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="survey.jsp">Softala</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="survey.jsp">Home</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Valita opelle</a></li>
                <li><a href="#">Valita rehtorille</a></li>
                <li><a href="#">Soita poliisille</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Missä Auringon Pizza Kebab?</li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <!-- Begin page content -->
	<div class="container">
    <div class="container">
      <div class="page-header">
        <h1>Iso kysely</h1>
      </div>

<form class="well" method="post" action="email">
  <h3>Kurssin tiedot</h3>
  <!--  optionit jsp loopilla? --> 
  <div class="form-group">
  <label for="course-opt">Kurssitunnus:</label>
  <select class="form-control" id="course-opt">
  <option>Valitse</option>
  <option>SWE12345</option>
  <option>BUS54321</option>
 </select>
</div>
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon1"></span>
  <input type="text" class="form-control" placeholder="Kurssin nimi" aria-describedby="basic-addon1">
</div>
<br/>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"></span>
  <input type="text" class="form-control" placeholder="Opettajan nimi" aria-describedby="basic-addon1">
</div>
<!--  optionit jsp loopilla? --> 
  <div class="form-group">
  <label for="class-year">Vuosikurssi:</label>
  <select class="form-control" id="class-year">
  <option>2012</option>
  <option>2013</option>
  <option>2014</option>
  <option>2015</option>
 </select>
</div>
<div class="container"> 

<label for="input_message">Toteutus:</label><br>
<div class="btn-group" data-toggle="buttons">

  <label class="btn btn-primary active">
    <input type="radio" name="options" id="option1" autocomplete="off" checked>Kevät 
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" id="option2" autocomplete="off">Syksy 
  </label>
</div>
</div>
</form>

	  
	  <form action="email" method="post">
<div class="well">
<h3>Hyvinvointikysely</h3>
<br>

<!-- Tekstikenttä -->
<div class="form-group">
<div class="input-group">
<label for="input_message">Ole hyvä ja kerro, miltä sinusta nyt tuntuu:</label>
<input type="text" name="input_message" id="input_message" class="form-control" rows="5" required autofocus>
<input type="hidden" name="receiver" value="softala2015@gmail.com">
</div>
</div>

</div>

	

<div class="well">	
<br>
<label for="input_message">Ole hyvä ja kerro, miltä sinusta nyt tuntuu hymynaamoilla:</label><br>
<div class="btn-group" data-toggle="buttons">

  <label class="btn btn-primary">
    <input type="radio" name="options" id="option1" autocomplete="off">  <img src="img/hymy.png" alt="Smiley face"> 
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" id="option2" autocomplete="off"> <img src="img/perus.png" alt="medium"> 
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" id="option3" autocomplete="off"> <img src="img/suru.png" alt="sad face"> 
  </label>
</div>
</div>

<div class="well">
<br>
<label for="input_message">Mitkä kaikki näistä feelsseistä sulla on nyt? </label><br>
<div class="btn-group" data-toggle="buttons">
  <label class="btn btn-primary">
    <input type="checkbox" autocomplete="off"> Feels good man
  </label>
  <label class="btn btn-primary">
    <input type="checkbox" autocomplete="off"> Semi
  </label>
  <label class="btn btn-primary">
    <input type="checkbox" autocomplete="off"> Harmittaa
  </label>
</div>

	</div>

<div class="container">
<button class="btn btn-primary" type="submit" value="Send" >Submit</button>
<br><br>
</div>
</form>
    <footer class="footer">
      <div class="container">
        <p class="text-muted">Copiright Make 2015</p>
      </div>
    </footer>

</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/angular.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
