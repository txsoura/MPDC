<?php
include "sessao.php";
include "../../../coneccao.php";
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Autoridade Portuaria | NUP</title>
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

        <!-- JQuery DataTable Css -->
        <link href="../../plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="../../css/style.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="../../css/themes/all-themes.css" rel="stylesheet" />
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
                        <?php
                        $sql = "SELECT * FROM autoridade WHERE nup='$_SESSION[codigo]';";
                        $result = mysqli_query($connect, $sql);
                        $row = mysqli_fetch_array($result);
                        ?>
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">AT<?php echo $_SESSION["codigo"]; ?></div>
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
                        <li class="active">
                            <a href="noticia.php">
                                <span>Noticia</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Responsavel</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="verificar.php">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="../tables/responsavel.php">Visualizar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Mercadoria</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../tables/mercadoriacaminho.php">A Caminho</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriaatracado.php">No Navio Atracado</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriaarmazem.php">No Armazem</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriadespachada.php">Despachada</a>
                                </li>
                                <li>
                                    <a href="../tables/mercadoriaapreendida.php">Apreendida</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Navio</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../tables/naviodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="../tables/navioprevisao.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="../tables/navio.php">Todos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Comboio</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../tables/comboiodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="../tables/comboiochegada.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="../tables/comboio.php">Todos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <span>Camiao</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../tables/camiaodisponivel.php">Disponivel</a>
                                </li>
                                <li>
                                    <a href="../tables/camiaochegada.php">Previsao de Chegada</a>
                                </li>
                                <li>
                                    <a href="../tables/camiao.php">Todos</a>
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

                <!-- Vertical Layout | With Floating Label -->
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="body">
                                <form name="actualizar" method="post" action="noticiaphp.php">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="titulo" class="form-control">
                                            <label class="form-label">Titulo</label>
                                        </div>
                                    </div>
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <textarea name="descricao" class="form-control"></textarea>
                                            <label class="form-label">Descricao</label>
                                        </div>
                                    </div>
                                    <input type="hidden" name="escritor" class="form-control" value="<?php echo $row["nome"]; ?>">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="password" name="senha" class="form-control">
                                            <label class="form-label">Senha</label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary m-t-15 waves-effect">Guardar</button>
                                    <a href=../../index.php><button class="btn btn-secundary m-t-15 waves-effect" type="button">Cancelar</button></a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Vertical Layout | With Floating Label -->
                <!-- Basic Examples -->
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="body">
                                <table class="table table-bordered table-striped table-hover js-basic-example ">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Titulo</th>
                                            <th>Descricao</th>
                                            <th>Remover</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php
                                        $sqlc = "SELECT * FROM noticia WHERE escritor='$row[nome]';";
                                        $resultc = mysqli_query($connect, $sqlc);
                                        while ($rowc = mysqli_fetch_assoc($resultc)) {
                                            $cod = $rowc["codigo"];
                                            ?>
                                            <tr>
                                                <th scope="row"><?php echo "NT" . $rowc["codigo"]; ?></th>
                                                <td><?php echo $rowc["titulo"]; ?></td>
                                                <td><?php echo $rowc["descricao"]; ?></td>
                                                <?php
                                                echo "<td><a onclick=\"return confirm('Tem certeza que quer remover a noticia NT$cod?');\" href='remover.php?codigo= NT$cod'> Sim </a></td>";
                                            }
                                            mysqli_close($connect);
                                            ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Basic Examples -->
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

        <!-- Waves Effect Plugin Js -->
        <script src="../../plugins/node-waves/waves.js"></script>

        <!-- Jquery DataTable Plugin Js -->
        <script src="../../plugins/jquery-datatable/jquery.dataTables.js"></script>
        <script src="../../plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

        <!-- Custom Js -->
        <script src="../../js/admin.js"></script>
        <script src="../../js/pages/tables/jquery-datatable.js"></script>

        <!-- Demo Js -->
        <script src="../../js/demo.js"></script>
    </body>

</html>