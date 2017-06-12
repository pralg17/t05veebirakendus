<?php
require("header.php");
$classStrings = " hidden";
if($_SERVER["REQUEST_METHOD"] == "POST") {
  $userName = mysqli_real_escape_string($db,$_POST['username']);
  $userPass = mysqli_real_escape_string($db,$_POST['password']);
  $sql = "INSERT INTO users(username, password) VALUES ('$userName', '$userPass')";
  $result = mysqli_query($db,$sql);
  if ($result) {
    $classStrings="success";
    $Message = "Teie kasutaja on salvestatud. Minge tagasi eelmisele lehele, et sisse logida.";
  } else {
    $classStrings = "error";
    $Message = "Midagi läks valesti. Proovige hiljem uuesti.";
  }

}


 ?>
<!doctype html>
<html>
<link rel="stylesheet" href="style.css">
<div class="limitwidth">
  <h1>Registreeri</h1>
  <form method="post">
    <label>Kasutajanimi:</label>
    <input type="text" name="username">
    <br>
    <label>Parool:</label>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Loo kasutaja">
  </form>
  <div class="<?=$classStrings?>"><?=$Message?></div>
  <br>
  <a href="index.php">Sisselogimiseks liikuge tagasi eelmisele lehele.</a>
</div>

</html>
