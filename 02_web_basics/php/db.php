<?php

$dsn = 'mysql:host=localhost;dbname=company_db';     //  data source Name

$username = "root";
$password = "";
$dbConnect = null;

function connectToDb()
{
    global $username, $password, $dsn, $dbConnect;
    try {
        $dbConnect = new PDO($dsn, $username, $password); //PDO ist zu contacten oder new conect zu starten

    } catch (PDOException $e) {
        echo 'Failed: ' . $e->getMessage();
    }


    return $dbConnect;
}

function registerUser($name, $email, $pwd){
    $dbConnect = connectToDb();
    $hashedPassword = password_hash($pwd, PASSWORD_DEFAULT);   //hasch metode um passwort zu versclüseeln

    $query = "INSERT INTO users (Username, Email, Pw)VALUES(:name, :email, :userPassword)";  //wieso schribt mann nicht hashedPassword staat userPassword?

    try{
        $stmt = $dbConnect->prepare($query);     // Die Methode prepare() bereitet eine SQL-Anweisung zur sicheren und effizienten Ausführung vor.
        $stmt->execute([  //
            ':name' => $name,
            ':email' => $email,
            ':userPassword' => $hashedPassword
        ]);
        return "";
    }catch (Exception $e){
        return $e->getMessage();
    }
}

function checkLogin($email, $pwd){
    $dbConnect = connectToDb();
    $query = "SELECT * FROM users WHERE Email=:email LIMIT 1";
    $stmt = $dbConnect->prepare($query);
    $stmt->execute([
      ':email' => $email
    ]);

    $user = $stmt->fetch(PDO::FETCH_ASSOC); 
    if ($stmt->rowCount()===1){
        if (password_verify($pwd, $user["Pw"])){
            return $user;
        }
    }
    return false;
}


function addNewCustamer($companyName, $companyPhone, $companyAdress, $createdBy)
{
    if (!empty($companyName) && !empty($companyPhone) && !empty($companyAdress)) {

        // $createdBy = $_SESSION['user_name'] ?? '';
        global $createdBy;
        $dbConnect = connectToDb();
        
        $query = "INSERT INTO customers(company_name, contact_person_phone, Adresse, created_by)VALUES(:companyName, :companyPhone, :companyAdress, :createdBy)";

        $stmt = $dbConnect->prepare($query);     // Die Methode prepare() bereitet eine SQL-Anweisung zur sicheren und effizienten Ausführung vor.
        $stmt->execute([  //
            ':companyName' => $companyName,
            ':companyPhone' => $companyPhone,
            ':companyAdress' => $companyAdress,
            ':createdBy' => $createdBy
        ]);

    }
     else {
        echo "was machst du bitte";
    }
    

};


// function lösche($companyId,$createdBy){
   
//  $dbConnect = connectToDb();
// $query="DELETE FROM customers WHERE company_id = :companyId AND created_by= :createdBy";
// $stmt=$dbConnect->prepare($query);
// }



// function refreshAllUsers()

//     {

//         // $createdBy = $_SESSION['user_name'] ?? '';
       
//         $dbConnect = connectToDb();
        
//         $query = "SELECT * FROM customers";

//         $stmt = $dbConnect->prepare($query);     // Die Methode prepare() bereitet eine SQL-Anweisung zur sicheren und effizienten Ausführung vor.
//         $stmt->execute();
//         $customers=$stmt->fetchAll();

//   foreach($customers as $customer);

// };


 


























?>