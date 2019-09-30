<?php
include "sessao.php";
include "../coneccao.php";
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Comboio | NUP</title>
        <!-- Favicon-->
        <link rel="icon" href="logo.ico" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- Morris Chart Css-->
        <link href="plugins/morrisjs/morris.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />
    </head>

    <body class="theme-blue">
        <!-- Page Loader -->
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="preloader">
                    <div class="spinner-layer pl-blue">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>
                <p>Por favor aguarde...</p>
            </div>
        </div>
        <!-- #END# Page Loader -->
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Top Bar -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="index.php">NUP | Número Único Portuário</a>
                </div>
            </div>
        </nav>
        <!-- #Top Bar -->
        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <div class="user-info">
                    <div class="info-container">
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">CB<?php echo $_SESSION["codigo"]; ?></div>
                        <div class="btn-group user-helper-dropdown">
                            <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="pages/forms/perfil.php">Editar Info</a></li>
                                <li role="seperator" class="divider"></li>
                                <li><a href="../logout.php">Sair</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #User Info -->
                <!-- Menu -->
                <div class="menu">
                    <ul class="list">
                        <li class="header">MENU</li>
                        <li class="active">
                            <a href="index.php">
                                <span>Inicio</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/forms/chegada.php">
                                <span>Marcar Chegada</span>
                            </a>
                        </li>
                        <li>
                            <a href="pages/forms/partida.php">
                                <span>Partida</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Navio</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/tables/nvdisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="pages/tables/nvchegada.php">Previsao de Chegada</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- #Menu -->
                <!-- Footer -->
                <?php
                include "../footer.php";
                ?>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
        </section>

        <section class="content">
            <div class="container-fluid">

                <!-- Widgets -->
                <div class="row clearfix">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="info-box bg-red hover-expand-effect">
                            <div class="icon">
                                <i class="material-icons">equalizer</i>
                            </div>
                            <div class="content">
                                <div class="text">Total a Pagar (USD)</div>
                                <?php
                                $sql = "SELECT (preco) FROM comboio WHERE nup='$_SESSION[codigo]';";
                                $result = mysqli_query($connect, $sql);
                                $row = mysqli_fetch_array($result);
                                $preco = $row['preco'];

                                ?>
                                <div class="number count-to" data-from="0" data-to="<?php echo $preco; ?>" data-speed="1000" data-fresh-interval="20"></div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Widgets -->

                <div class="row clearfix">
                    <!-- Task Info -->
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="card">
                            <div class="header">
                                <h2>Navio</h2>
                            </div>
                            <div class="body">
                                <div class="table-responsive">
                                    <table class="table table-hover dashboard-task-infos">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Matricula</th>
                                                <th>Nome</th>
                                                <th>Tipo de Embarcacao</th>
                                                <th>Pais de Origem</th>
                                                <th>Situacao</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <?php
                                            $sql2 = "SELECT * FROM navio WHERE chegada!='NULL';";
                                            $result2 = mysqli_query($connect, $sql2);
                                            while ($row2 = mysqli_fetch_assoc($result2)) {
                                                if ($row2["chegada"] <= $data) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo "NV" . $row2["nup"]; ?></th>
                                                        <td><?php echo $row2["matricula"]; ?></td>
                                                        <td><?php echo $row2["nome"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["pais"]; ?></td>
                                                        <td><span class="label bg-blue">No Porto</span></td>
                                                    </tr>
                                                    <?php
                                                } else
                                                if ($row2["chegada"] > $data) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo "NV" . $row2["nup"]; ?></th>
                                                        <td><?php echo $row2["matricula"]; ?></td>
                                                        <td><?php echo $row2["nome"]; ?></td>
                                                        <td><?php echo $row2["tipo"] . " T"; ?></td>
                                                        <td><?php echo $row2["pais"]; ?></td>
                                                        <td><span class="label bg-orange">A Caminho</span></td>
                                                    </tr>
                                                    <?php
                                                }
                                            }
                                            mysqli_close($connect);
                                            ?>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- #END# Task Info -->
                </div>
            </div>
        </section>

        <!-- Jquery Core Js -->
        <script src="plugins/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="plugins/bootstrap/js/bootstrap.js"></script>

        <!-- Select Plugin Js -->
        <script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>

        <!-- Slimscroll Plugin Js -->
        <script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="plugins/node-waves/waves.js"></script>

        <!-- Jquery CountTo Plugin Js -->
        <script src="plugins/jquery-countto/jquery.countTo.js"></script>

        <!-- Morris Plugin Js -->
        <script src="plugins/raphael/raphael.min.js"></script>
        <script src="plugins/morrisjs/morris.js"></script>

        <!-- ChartJs -->
        <script src="plugins/chartjs/Chart.bundle.js"></script>

        <!-- Flot Charts Plugin Js -->
        <script src="plugins/flot-charts/jquery.flot.js"></script>
        <script src="plugins/flot-charts/jquery.flot.resize.js"></script>
        <script src="plugins/flot-charts/jquery.flot.pie.js"></script>
        <script src="plugins/flot-charts/jquery.flot.categories.js"></script>
        <script src="plugins/flot-charts/jquery.flot.time.js"></script>

        <!-- Sparkline Chart Plugin Js -->
        <script src="plugins/jquery-sparkline/jquery.sparkline.js"></script>

        <!-- Custom Js -->
        <script src="js/admin.js"></script>
        <script src="js/pages/index.js"></script>

        <!-- Demo Js -->
        <script src="js/demo.js"></script>
    </body>

</html>