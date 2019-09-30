<?php
include "sessao.php";
include "../coneccao.php";
$data = date("Y-m-d");
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Autoridade Portuaria | NUP</title>
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

                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">AT<?php echo $_SESSION["codigo"]; ?></div>
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
                            <a href="pages/forms/noticia.php">
                                <span>Noticia</span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Responsavel</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/forms/verificar.php">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="pages/tables/responsavel.php">Visualizar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Mercadoria</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/tables/mercadoriacaminho.php">A Caminho</a>
                                </li>
                                <li>
                                    <a href="pages/tables/mercadoriaatracado.php">No Navio Atracado</a>
                                </li>
                                <li>
                                    <a href="pages/tables/mercadoriaarmazem.php">No Armazem</a>
                                </li>
                                <li>
                                    <a href="pages/tables/mercadoriadespachada.php">Despachada</a>
                                </li>
                                <li>
                                    <a href="pages/tables/mercadoriaapreendida.php">Apreendida</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Navio</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/tables/naviodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="pages/tables/navioprevisao.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="pages/tables/navio.php">Todos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Comboio</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/tables/comboiodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="pages/tables/comboiochegada.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="pages/tables/comboio.php">Todos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Camiao</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="pages/tables/camiaodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="pages/tables/camiaochegada.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="pages/tables/camiao.php">Todos</a>
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
                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                        <div class="info-box bg-green hover-expand-effect">
                            <div class="icon">
                                <i class="material-icons">playlist_add_check</i>
                            </div>
                            <div class="content">
                                <div class="text">Mercadoria No Armazem</div>
                                <?php
                                $sqlmd = "SELECT COUNT(*) AS total FROM mercadoria WHERE disponivel='2' ;";
                                $resultmd = mysqli_query($connect, $sqlmd);
                                $valormd = mysqli_fetch_assoc($resultmd);
                                $nummd = $valormd['total'];
                                ?>
                                <div class="number count-to" data-from="0" data-to="<?php echo $nummd; ?>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                        <div class="info-box bg-cyan hover-expand-effect">
                            <div class="icon">
                                <i class="material-icons">shopping_cart</i>
                            </div>
                            <div class="content">
                                <div class="text">Mercadoria Por Descarregar</div>
                                <?php
                                $sqlm = "SELECT COUNT(*) AS total FROM mercadoria WHERE disponivel='1';";
                                $resultm = mysqli_query($connect, $sqlm);
                                $valorm = mysqli_fetch_assoc($resultm);
                                $numm = $valorm['total'];
                                ?>
                                <div class="number count-to" data-from="0" data-to="<?php echo $numm; ?>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                        <div class="info-box bg-red hover-expand-effect">
                            <div class="icon">
                                <i class="material-icons">equalizer</i>
                            </div>
                            <div class="content">
                                <div class="text">Mercadoria Apreendida</div>
                                <?php
                                $sqlma = "SELECT COUNT(*) AS total FROM mercadoria WHERE disponivel='4';";
                                $resultma = mysqli_query($connect, $sqlma);
                                $valorma = mysqli_fetch_assoc($resultma);
                                $numma = $valorma['total'];
                                ?>
                                <div class="number count-to" data-from="0" data-to="<?php echo $numma; ?>" data-speed="1000" data-fresh-interval="20"></div>

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
                                <h2>Mercadoria</h2>
                            </div>
                            <div class="body">
                                <div class="table-responsive">
                                    <table class="table table-hover dashboard-task-infos">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Situacao da Mercadoria</th>
                                                <th>Tipo de Mercadoria</th>
                                                <th>Quantidade</th>
                                                <th>Navio</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <?php
                                            $sql2 = "SELECT * FROM mercadoria;";
                                            $result2 = mysqli_query($connect, $sql2);
                                            while ($row2 = mysqli_fetch_assoc($result2)) {
                                                if ($row2["disponivel"] == 0) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo $row2["codigo"]; ?></th>
                                                        <td><?php echo $row2["situacao"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["quantidade"] . " T"; ?></td>
                                                        <td><?php echo "NV" . $row2["navio"]; ?></td>
                                                        <td><span class="label bg-orange">A Caminho</span></td>
                                                    </tr>
                                                    <?php
                                                }
                                                if ($row2["disponivel"] == 1) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo $row2["codigo"]; ?></th>
                                                        <td><?php echo $row2["situacao"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["quantidade"] . " T"; ?></td>
                                                        <td><?php echo "NV" . $row2["navio"]; ?></td>
                                                        <td><span class="label bg-blue">Na Embarcacao</span></td>
                                                    </tr>
                                                    <?php
                                                }
                                                if ($row2["disponivel"] == 2) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo $row2["codigo"]; ?></th>
                                                        <td><?php echo $row2["situacao"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["quantidade"] . " T"; ?></td>
                                                        <td><?php echo "NV" . $row2["navio"]; ?></td>
                                                        <td><span class="label bg-green">No Armazem</span></td>
                                                    </tr>
                                                    <?php
                                                }
                                                if ($row2["disponivel"] == 3) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo $row2["codigo"]; ?></th>
                                                        <td><?php echo $row2["situacao"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["quantidade"] . " T"; ?></td>
                                                        <td><?php echo "NV" . $row2["navio"]; ?></td>
                                                        <td><span class="label bg-black">Despachada</span></td>
                                                    </tr>
                                                    <?php
                                                }if ($row2["disponivel"] == 4) {
                                                    ?>
                                                    <tr>
                                                        <th scope="row"><?php echo $row2["codigo"]; ?></th>
                                                        <td><?php echo $row2["situacao"]; ?></td>
                                                        <td><?php echo $row2["tipo"]; ?></td>
                                                        <td><?php echo $row2["quantidade"] . " T"; ?></td>
                                                        <td><?php echo "NV" . $row2["navio"]; ?></td>
                                                        <td><span class="label bg-red">Apreendida</span></td>
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