<?php
require_once "db.php";
$error_message = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {

  $email = $_POST['email'] ?? '';            //die frage zeichnen bedutet  wenn es leer ist dann '' ;

  $userPassword = $_POST['password'] ?? '';

  if (!empty($email) && !empty($userPassword)) {
    $normalizedEmail = strtolower(trim($email));  //egal ob die klein oder groß gischriben
    // $hashedPassword = password_hash($userPassword, PASSWORD_DEFAULT);

    $user = checkLogin($normalizedEmail, $userPassword); // fetch will return false if no row found

    // print_r($user);
    if ($user !== false) {
      // ✅ معلومات الدخول صحيحة → الانتقال إلى لوحة التحكم
      // يمكنك تخزين معلومات الجلسة هنا إن أردت
      session_start();

       $_SESSION['user_name'] = $user['Username'];
      //  $_SESSION['user_ID'] = $user['ID'];
      header("Location: dashboard.php");
      // exit();  مهم جدًا بعد التوجيه
    } else {
      $error_message = "Falsche Benutzername oder Password Bitte Versuchen Sie es noch mal ";
    }
  }
 //wenn alles richtig ist dann gehe zum Daschbord else "der username oder password falsch"
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>login</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="C:\xampp\htdocs\php2\php-2-Munir2029\stylesheet.css">
</head>

<body>
  <div class="container">


    <h1>login</h1>
    <br>
    <form class="row g-3" method="POST" action="">
      <div class="col-3">
        <label for="staticEmail2" class="visually-hidden">Email</label>
        <input type="email" name="email" id="staticEmail2" placeholder="email@example.com">
      </div>
      <div class="col-3">
        <label for="inputPassword2" class="visually-hidden">Password</label>
        <input type="password" name="password" class="form-control" id="inputPassword2" placeholder="Password">
      </div>
      <div class="col-auto">
        <button type="submit" class="btn btn-primary mb-3">Confirm identity</button>
      </div>
    </form>
    <p class="error"><?= $error_message;?></p>
    <br>

    <p>haben Sie noch kein konto </p> <a
      href="http://localhost/php2/php-2-Munir2029/Registrierung%E2%80%AF.php">Registrieren</a>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

     <script src="index.js"></script>

</body>

</html>