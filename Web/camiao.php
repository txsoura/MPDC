<!DOCTYPE html>
<html lang="pt" class="no-js">
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8"/>
        <title>Camião | MPDC</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="" name="description"/>
        <meta content="" name="author"/>

        <!-- GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
        <link href="vendor/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- PAGE LEVEL PLUGIN STYLES -->
        <link href="css/animate.css" rel="stylesheet">
        <link href="vendor/swiper/css/swiper.min.css" rel="stylesheet" type="text/css"/>

        <!-- THEME STYLES -->
        <link href="css/layout.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/form.css" rel="stylesheet" type="text/css">

        <!-- Favicon -->
        <link rel="shortcut icon" href="favicon.ico"/>

    </head>
    <!-- END HEAD -->

    <!-- BODY -->
    <body>

        <!--========== HEADER ==========-->
        <header class="header navbar-fixed-top">
            <!-- Navbar -->
            <nav class="navbar" role="navigation">
                <div class="container">
                    <!-- Menu Mobile -->
                    <div class="menu-container">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="sr-only">Alterar navegacao</span>
                            <span class="toggle-icon"></span>
                        </button>

                        <!-- Logo -->
                        <div class="logo">
                            <a class="logo-wrap" href="index.php">
                                <img class="logo-img logo-img-main" src="img/logo.png" alt="Asentus Logo">
                                <img class="logo-img logo-img-active" src="img/logo-dark.png" alt="Asentus Logo">
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>

                    <!-- Menu Desktop -->
                    <div class="collapse navbar-collapse nav-collapse">
                        <div class="menu-container">
                            <ul class="navbar-nav navbar-nav-right">
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="navio.php">Navio</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="comboio.php">Comboio</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover active" href="camiao.php">Camião</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="nup.php">NUP</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="contacto.php">Contacto</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- End Menu Desktop -->
                </div>
            </nav>
        </header>
        <!--========== END HEADER ==========-->

        <!--========== PARALLAX ==========-->
        <div class="parallax-window" data-parallax="scroll" data-image-src="img/1920x1080/17.jpg">
            <div class="parallax-content container">

            </div>
        </div>
        <!--// end row -->

        <!--========== PARALLAX ==========-->

        <!--========== PAGE LAYOUT ==========-->
        <div class="content-lg container">


            <div class="row margin-b-40">
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-sm-5 sm-margin-b-30">
                            <form name="reserva" method="post" action="inserircamiao.php">
                                <input type="text" class="form-control footer-input margin-b-20" placeholder="Matricula" name="matricula" required>
                                <input type="text" class="form-control footer-input margin-b-20" placeholder="Empresa" name="empresa" required>
                                <input type="number" class="form-control footer-input margin-b-20" placeholder="Telefone" name="telefone" required>
                                <input type="email" class="form-control footer-input margin-b-20" placeholder="Email" name="email">
                                <p><select name="tipo" id="appearance-select" required>
                                        <option> Selecione o Tipo de Camião... </option>
                                        <option>Plataforma</option>
                                        <option>Baú</option>
                                        <option>Tremonha</option>
                                        <option>Aberto</option>
                                        <option>Refrigerado</option>
                                        <option>Tanque</option>
                                        <option>Graneleiro</option>
                                        <option>Semirreboque</option>
                                        <option>Especial</option>
                                        <option>Passageiros</option>
                                    </select></p>
                                <p><select name="pais" id="appearance-select" required>
                                        <option> Selecione o Pais... </option>
                                        <option value="Africa do Sul">Africa do Sul</option>
                                        <option value="Angola">Angola</option>
                                        <option value="Argelia">Argelia</option>
                                        <option value="Benim">Benim</option>
                                        <option value="Botsuana">Botsuana</option>
                                        <option value="Burquina Faso">Burquina Faso</option>
                                        <option value="Burundi">Burundi</option>
                                        <option value="Cabo Verde">Cabo Verde</option>
                                        <option value="Camaroes">Camaroes</option>
                                        <option value="Chade">Chade</option>
                                        <option value="Comores">Comores</option>
                                        <option value="Costa do Marfim">Costa do Marfim</option>
                                        <option value="Dominica">Djibouti</option>
                                        <option value="Egito">Egito</option>
                                        <option value="Eritreia">Eritreia</option>
                                        <option value="Etiopia">Etiopia</option>
                                        <option value="Gabao">Gabao</option>
                                        <option value="Gambia">Gambia</option>
                                        <option value="Gana">Gana</option>
                                        <option value="Guine">Guine</option>
                                        <option value="Guine Equatorial">Guine Equatorial</option>
                                        <option value="Guine-Bissau">Guine-Bissau</option>
                                        <option value="Lesoto">Lesoto</option>
                                        <option value="Liberia">Liberia</option>
                                        <option value="Libia">Libia</option>
                                        <option value="Madagascar">Madagascar</option>
                                        <option value="Malaui">Malaui</option>
                                        <option value="Mali">Mali</option>
                                        <option value="Marrocos">Marrocos</option>
                                        <option value="Mauricia">Mauricia</option>
                                        <option value="Mauritania">Mauritania</option>
                                        <option value="Mocambique">Mocambique</option>
                                        <option value="Namibia">Namibia</option>
                                        <option value="Niger">Niger</option>
                                        <option value="Nigeria">Nigeria</option>
                                        <option value="Quenia">Quenia</option>
                                        <option value="Republica Centro-Africana">Republica Centro-Africana</option>
                                        <option value="Republica Democratica do Congo">Republica Democratica do Congo</option>
                                        <option value="Ruanda">Ruanda</option>
                                        <option value="Sao Tome e Principe">Sao Tome e Principe</option>
                                        <option value="Senegal">Senegal</option>
                                        <option value="Serra Leoa">Serra Leoa</option>
                                        <option value="servia">Seychelles</option>
                                        <option value="Somalia">Somalia</option>
                                        <option value="Suazilandia">Suazilandia</option>
                                        <option value="Sudao">Sudao</option>
                                        <option value="Sudao do Sul">Sudao do Sul</option>
                                        <option value="Tanzania">Tanzania</option>
                                        <option value="Togo">Togo</option>
                                        <option value="Tunisia">Tunisia</option>
                                        <option value="Uganda">Uganda</option>
                                        <option value="Zambia">Zambia</option>
                                        <option value="Zimbabue">Zimbabue</option>
                                    </select></p>                                  
                                <input type="password" class="form-control footer-input margin-b-20" name="senha"  placeholder="Senha (8 digitos)" required>                                  
                                <button type="submit" class="btn-theme btn-theme-sm btn-base-bg text-uppercase">Registar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--========== END PAGE LAYOUT ==========-->

        <!--========== FOOTER ==========-->
        <?php
        include "foter.php";
        ?>
        <!--========== END FOOTER ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="js-back-to-top back-to-top">^</a>

        <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- CORE PLUGINS -->
        <script src="vendor/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL PLUGINS -->
        <script src="vendor/jquery.easing.js" type="text/javascript"></script>
        <script src="vendor/jquery.back-to-top.js" type="text/javascript"></script>
        <script src="vendor/jquery.smooth-scroll.js" type="text/javascript"></script>
        <script src="vendor/jquery.wow.min.js" type="text/javascript"></script>
        <script src="vendor/jquery.parallax.min.js" type="text/javascript"></script>
        <script src="vendor/swiper/js/swiper.jquery.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="js/layout.min.js" type="text/javascript"></script>
        <script src="js/components/wow.min.js" type="text/javascript"></script>
        <script src="js/components/swiper.min.js" type="text/javascript"></script>

    </body>
    <!-- END BODY -->
</html>