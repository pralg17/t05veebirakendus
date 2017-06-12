<?php
require("header.php");
  if (isset($_SESSION["login_user"])){

  } else {
    session_destroy();
    header("location: index.php");
    exit();
  }

  if ($_GET["logout"]) {
    session_destroy();
    header("location: index.php");
  }
 ?>
<!doctype html>
 <html>
 <link rel="stylesheet" href="style.css">

 <div class="titlebar">Minu kena veebileht | <a href="?logout=true" class="clear">Logi välja</a></div>
 <body>
   <div class="limitwidth">
     <h1>Tore elu!</h1>
     <h2>Päeva küsimus: kas Su elu on tore?</h2>
     <div id="answer">
       <a href="#" class="jsButton" onClick="life(false)">Jah, on küll!</a>
       <a href="#" class="jsButton" onClick="life(true)">Ei, ikka väga ei ole.</a>
     </div>
     <div id="statistic" style="display: none">
       <h1><span id="percentage"></span>% inimestest ütlesid, et nende elu on ilus.</h1>
     </div>
   </div>
 </body>
 <script src="life.js"></script>
 </html>
