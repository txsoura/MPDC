<?php
include "sessao.php";
include "../../../coneccao.php";
$data = date("Y-m-d");
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Navio | NUP</title>
        <!-- Favicon-->
        <link rel="icon" href="../../logo.ico" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

        <!-- Bootstrap Core Css -->
        <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- Sweet Alert Css -->
        <link href="../../plugins/sweetalert/sweetalert.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="../../css/style.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="../../css/themes/all-themes.css" rel="stylesheet" />
        <link href="../../../css/form.css" rel="stylesheet" type="text/css">
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
                    <a class="navbar-brand" href="../../index.php">NUP | Número Único Portuário</a>
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
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">NV<?php echo $_SESSION["codigo"]; ?></div>
                        <div class="btn-group user-helper-dropdown">
                            <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="perfil.php">Editar Info</a></li>
                                <li role="seperator" class="divider"></li>
                                <li><a href="../../../logout.php">Sair</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #User Info -->
                <!-- Menu -->
                <div class="menu">
                    <ul class="list">
                        <li class="header">MENU</li>
                        <li>
                            <a href="../../index.php">
                                <span>Inicio</span>
                            </a>
                        </li>
                        <li>
                            <a href="chegada.php">
                                <span>Marcar Chegada</span>
                            </a>
                        </li>
                        <li>
                            <a href="partida.php">
                                <span>Partida</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Mercadoria</span>
                            </a>
                            <ul class="ml-menu">
                                <li class="active">
                                    <a href="mercadoria.php">Declarar</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriad.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriai.php">Indisponivel</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- #Menu -->
                <!-- Footer -->
                <?php
                include "../../../footer.php";
                ?>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
        </section>

        <section class="content">
            <div class="container-fluid">
                <!-- Basic Validation -->
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header">
                                <h2>Mercadoria</h2>
                            </div>
                            <div class="body">
                                <form id="form_validation" method="post" action="mercadoriaphp.php">


                                    <input type="hidden" name="verificar" value="verificar">

                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="number" class="form-control" name="responsavel" required>
                                            <label class="form-label">Responsavel</label>
                                        </div>
                                    </div>
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="number" class="form-control" name="quantidade" required>
                                            <label class="form-label">Quantidade (em toneladas)</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Situacao da Mercadoria</label><br />
                                        <input type="radio" name="situacao" id="importacao" value="importacao" class="with-gap">
                                        <label for="importacao">Importacao</label>

                                        <input type="radio" name="situacao" id="transito" value="transito" class="with-gap">
                                        <label for="transito" class="m-l-20">Transito</label>
                                    </div>
                                    <div class="form-group">
                                        <label class="form-label">Tipo de Mercadoria</label><br />
                                        <input type="radio" name="tipo" id="multi porpose" value="multi porpose" class="with-gap">
                                        <label for="multi porpose">Multi Porpose</label>

                                        <input type="radio" name="tipo" id="box type" value="box type" class="with-gap">
                                        <label for="box type" class="m-l-20">Box Type</label>

                                        <input type="radio" name="tipo" id="heavy lift" value="heavy lift" class="with-gap">
                                        <label for="heavy lift" class="m-l-20">Heavy Lift</label>

                                        <input type="radio" name="tipo" id="reefer" value="reefer" class="with-gap">
                                        <label for="reefer" class="m-l-20">Reefer</label>

                                        <input type="radio" name="tipo" id="porta contentor" value="porta contentor" class="with-gap">
                                        <label for="porta contentor" class="m-l-20">Porta Contentor</label>

                                        <input type="radio" name="tipo" id="ro-ro" value="ro-ro" class="with-gap">
                                        <label for="ro-ro" class="m-l-20">Ro-Ro</label>

                                        <input type="radio" name="tipo" id="outro" value="outro" class="with-gap">
                                        <label for="ro-ro" class="m-l-20">Outro</label>
                                        <br />
                                        <input type="radio" name="tipo" id="porta-barcacas" value="porta-barcacas" class="with-gap">
                                        <label for="porta-barcacas" class="m-l-20">Porta-Barcacas</label>

                                        <input type="radio" name="tipo" id="petroleiros" value="petroleiros" class="with-gap">
                                        <label for="petroleiros" class="m-l-20">Petroleiros</label>

                                        <input type="radio" name="tipo" id="graneleiros solidos" value="graneleiros solidos" class="with-gap">
                                        <label for="graneleiros solidos" class="m-l-20">Graneleiros Solidos</label>

                                        <input type="radio" name="tipo" id="quimicos" value="quimicos" class="with-gap">
                                        <label for="quimicos" class="m-l-20">Quimicos</label>

                                        <input type="radio" name="tipo" id="gases liquefeitos" value="gases liquefeitos" class="with-gap">
                                        <label for="gases liquefeitos" class="m-l-20">Gases Liquefeitos</label>

                                        <input type="radio" name="tipo" id="combos" value="combos" class="with-gap">
                                        <label for="combos" class="m-l-20">Combos</label>
                                    </div>
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="password" class="form-control" name="senha" required>
                                            <label class="form-label">Senha</label>
                                        </div>
                                    </div>
                                    <button class="btn btn-primary waves-effect" type="submit">Guardar</button>
                                    <a href=../../index.php><button class="btn btn-secundary waves-effect" type="button">Cancelar</button></a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Basic Validation -->
            </div>
        </section>

        <!-- Jquery Core Js -->
        <script src="../../plugins/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="../../plugins/bootstrap/js/bootstrap.js"></script>

        <!-- Select Plugin Js -->
        <script src="../../plugins/bootstrap-select/js/bootstrap-select.js"></script>

        <!-- Slimscroll Plugin Js -->
        <script src="../../plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

        <!-- Jquery Validation Plugin Css -->
        <script src="../../plugins/jquery-validation/jquery.validate.js"></script>

        <!-- JQuery Steps Plugin Js -->
        <script src="../../plugins/jquery-steps/jquery.steps.js"></script>

        <!-- Sweet Alert Plugin Js -->
        <script src="../../plugins/sweetalert/sweetalert.min.js"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="../../plugins/node-waves/waves.js"></script>

        <!-- Custom Js -->
        <script src="../../js/admin.js"></script>
        <script src="../../js/pages/forms/form-validation.js"></script>

        <!-- Demo Js -->
        <script src="../../js/demo.js"></script>
    </body>

</html>