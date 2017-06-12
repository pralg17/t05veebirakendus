<?php
require("header.php");
$classStrings = " hidden";
if($_SERVER["REQUEST_METHOD"] == "POST") {
  $userName = mysqli_real_escape_string($db,$_POST['username']);
  $userPass = mysqli_real_escape_string($db,$_POST['password']);

  $sql = "SELECT id FROM users WHERE username = '$userName' and password = '$userPass'";
  $result = mysqli_query($db,$sql);
  $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
  $active = $row['active'];

  $count = mysqli_num_rows($result);

  if($count == 1) {
     $_SESSION['login_user'] =  $userName;
     header("location: home.php");
  }else {
     $classStrings = "";
  }
}


 ?>
<!doctype html>
<html>
<link rel="stylesheet" href="style.css">
<div class="limitwidth">
  <h1>Logi sisse</h1>
  <form method="post">
    <label>Kasutajanimi:</label>
    <input type="text" name="username">
    <br>
    <label>Parool:</label>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Logi sisse">
  </form>
  <div class="error<?=$classStrings?>">Teie kasutaja andmed ei ole korrektsed.</div>
  <br>
  <a href="register.php">Registreerumiseks vajutage siia.</a>
</div>


</html>
