<?php

require_once "db.php";


session_start();

if (isset($_SESSION['user_name'])) {
    $welcomeMessage = "Supr willkommen in Daschbord, " . $_SESSION['user_name'];
    $createdBy = $_SESSION['user_name'] ?? '';
} else {
    echo "Bitte melden Sie sich an.";
}


if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST['runFunction'])) {
    global $createdBy;
    addNewCustamer($_POST['PostCompanyName'] ?? '', $_POST['PostContactPersonPhone'] ?? '', $_POST['PostAddress'] ?? '', $createdBy);
    
}



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheet.css">
    <title>dashboard</title>
</head>

<body>


    <!-- <h1>Supr willkommen in daschbord </h1> -->
    <div class="container">

        <h2 class="welcomeMessage"><?php if ($welcomeMessage)
            echo $welcomeMessage; ?></h2>



        <button class="btn btn-primary createANewCustomerButton" type="button" data-bs-toggle="collapse"
            data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            Create a new customer +
        </button>


        <div class="collapse" id="collapseExample">

            <div class="card card-body">
                <div class="card" style="width: 18rem;">
                    <div class="card-header">
                        Featured
                    </div>
                    <form action="" method="post">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <input type="text" class="form-control" name="PostCompanyName"
                                    placeholder="Enter Company name">
                            </li>
                            <li class="list-group-item">
                                <input type="text" class="form-control" name="PostContactPersonPhone"
                                    placeholder="Enter  Contact Person, Phone">
                            </li>
                            <li class="list-group-item">
                                <input type="text" class="form-control" name="PostAddress" placeholder="Enter Address ">
                            </li>
                        </ul>
                        <button type="submit" id="createCustomerBtn" class="btn btn-success"
                            name="runFunction">Create</button>
                    </form>
                </div>
            </div>
        </div>


     









        <div class="container text-center">

            <div class="row ">
                <div class="col-12 AllCostumers">AllCostumers</div>

            </div>
            <div class="row CompanyDetails">
                <div class="col-1 companyId">Id</div>
                <div class="col-1 CompanyName">Name</div>
                <div class="col-2 contactPersonPhone">phone</div>
                <div class="col-2 Adresse">Adresse</div>
                <div class="col-1 createdBy">C_by</div>
                <div class="col-1 createdAt">C_at</div>
                <div class="col-1 editedaAt">ed_at</div>
                <div class="col-3 bearbeiten">berbeiten</div>
            </div>
            <div id="allCompaniesContainer" class="companyRowsDetails">
                <!-- سيتم تعبئة الشركات هنا -->
            </div>

             <!-- <div  class="col bearbeitenButtons">
                    <button type="button " class="btn btn-success buttonbearabeiten">bearabeiten</button>
                    <button type="button " class="btn btn-danger buttonLöschen">Löschen</button>
                    
                </div>  -->

        </div>
        <a class="btn btn-primary backButton" href="http://localhost/php2/php-2-Munir2029/login.php"
            role="button">Back</a>

    </div>

    </div>
<button id="akt">aktuliesern</button>

    </div>

<script>
  const currentUser = "<?php echo $_SESSION['user_name']; ?>";
</script>

    <script src="index.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


</body>

</html>