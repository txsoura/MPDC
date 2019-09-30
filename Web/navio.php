<!DOCTYPE html>
<html lang="pt" class="no-js">
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="utf-8"/>
        <title>Navio | MPDC</title>
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
                                <li class="nav-item"><a class="nav-item-child nav-item-hover active" href="navio.php">Navio</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="comboio.php">Comboio</a></li>
                                <li class="nav-item"><a class="nav-item-child nav-item-hover" href="camiao.php">Camião</a></li>
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
        <div class="parallax-window" data-parallax="scroll" data-image-src="img/1920x1080/07.jpg">
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
                            <form name="reserva" method="post" action="inserirnavio.php">
                                <input type="text" class="form-control footer-input margin-b-20" placeholder="Matricula" name="matricula" required>
                                <input type="text" class="form-control footer-input margin-b-20" placeholder="Nome" name="nome" required>
                                <input type="number" class="form-control footer-input margin-b-20" placeholder="Telefone" name="telefone" required>
                                <input type="email" class="form-control footer-input margin-b-20" placeholder="Email" name="email">
                                <p><select name="tipo" id="appearance-select" required>
                                        <option> Selecione o Tipo de Navio... </option>
                                        <option>Pessoal</option>
                                        <option>Rebocador</option>
                                        <option>Graneleiro</option>
                                        <option>Transporte de Gás Liquefeito</option>
                                        <option>Petroleiro</option>
                                        <option>Transporte de Productos Químicos</option>
                                        <option>Porta- Contentores</option>
                                        <option>Submarino</option>
                                        <option>Navio-Tanque</option>
                                        <option>Investigação / Exploração</option>
                                        <option>Porta-aviões</option>
                                        <option>Cargueiros Ro-Ro</option>
                                        <option>Cruzeiro</option>
                                        <option>Cable Layer</option>
                                        <option>Dragas</option>
                                        <option>Semi-Submersíveis</option>
                                        <option>Balsas</option>
                                        <option>Batelão</option>
                                        <option>Carga Geral</option>
                                        <option>Auxiliar</option>
                                        <option>Aviso</option>
                                        <option>Lancha de Ação Rápida</option>
                                        <option>Guerra</option>
                                        <option>Escolta</option>
                                        <option>Aviso de Instrução</option>
                                        <option>Balizador</option>
                                        <option>Contratorpedeiro</option>
                                        <option>Faroleiro</option>
                                        <option>Farol</option>
                                        <option>Hidroceanográfico</option>
                                        <option>Monasco-Bombeiro</option>
                                        <option>NarcoSubmarino</option>
                                        <option>Caça Minas</option>
                                        <option>Draga-Minas</option>
                                        <option>Navio-Almirante</option>
                                        <option>Navio de Assistência Hospitalar</option>
                                        <option>Hidrográfico</option>
                                        <option>SemiSubmersível</option>
                                        <option>Graneleiro Solido</option>
                                        <option>Gás Liquefeito</option>
                                        <option>Combo</option>
                                        <option>Porta-Barcaca</option>
                                    </select></p>
                                <p><select name="pais" id="appearance-select" required>
                                        <option> Selecione o Pais... </option>
                                        <option value="Afeganistao">Afeganistao</option>
                                        <option value="Africa do Sul">Africa do Sul</option>
                                        <option value="Albania">Albania</option>
                                        <option value="Alemanha">Alemanha</option>
                                        <option value="Andorra">Andorra</option>
                                        <option value="Angola">Angola</option>
                                        <option value="Antiga e Barbuda">Antiga e Barbuda</option>
                                        <option value="Arabia Saudita">Arabia Saudita</option>
                                        <option value="Argelia">Argelia</option>
                                        <option value="Argentina">Argentina</option>
                                        <option value="Armenia">Armenia</option>
                                        <option value="Australia">Australia</option>
                                        <option value="Austria">Austria</option>
                                        <option value="Azerbaijao">Azerbaijao</option>
                                        <option value="Bahamas">Bahamas</option>
                                        <option value="Bangladexe">Bangladexe</option>
                                        <option value="Barbados">Barbados</option>
                                        <option value="Barem">Barem</option>
                                        <option value="Belgica">Belgica</option>
                                        <option value="Belize">Belize</option>
                                        <option value="Benim">Benim</option>
                                        <option value="Bielorrussia">Bielorrussia</option>
                                        <option value="Bolivia">Bolivia</option>
                                        <option value="Bosnia e Herzegovina">Bosnia e Herzegovina</option>
                                        <option value="Botsuana">Botsuana</option>
                                        <option value="Brasil">Brasil</option>
                                        <option value="Brunei">Brunei</option>
                                        <option value="Bulgaria">Bulgaria</option>
                                        <option value="Burquina Faso">Burquina Faso</option>
                                        <option value="Burundi">Burundi</option>
                                        <option value="Butao">Butao</option>
                                        <option value="Cabo Verde">Cabo Verde</option>
                                        <option value="Camaroes">Camaroes</option>
                                        <option value="Camboja">Camboja</option>
                                        <option value="Canada">Canada</option>
                                        <option value="Catar">Catar</option>
                                        <option value="Cazaquistao">Cazaquistao</option>
                                        <option value="Chade">Chade</option>
                                        <option value="Chile">Chile</option>
                                        <option value="China">China</option>
                                        <option value="Chipre">Chipre</option>
                                        <option value="Colombia">Colombia</option>
                                        <option value="Comores">Comores</option>
                                        <option value="Congo-Brazzaville">Congo-Brazzaville</option>
                                        <option value="Coreia do Norte">Coreia do Norte</option>
                                        <option value="Coreia do Sul">Coreia do Sul</option>
                                        <option value="Cosovo">Cosovo</option>
                                        <option value="Costa do Marfim">Costa do Marfim</option>
                                        <option value="Costa rica">Costa rica</option>
                                        <option value="Croacia">Croacia</option>
                                        <option value="Cuaite">Cuaite</option>
                                        <option value="Cuba">Cuba</option>
                                        <option value="Dinamarca">Dinamarca</option>
                                        <option value="Dominica">Dominica</option>
                                        <option value="Egito">Egito</option>
                                        <option value="Emirados Arabes Unidos">Emirados Arabes Unidos</option>
                                        <option value="Equador">Equador</option>
                                        <option value="Eritreia">Eritreia</option>
                                        <option value="Eslovaquia">Eslovaquia</option>
                                        <option value="Eslovenia">Eslovenia</option>
                                        <option value="Espanha">Espanha</option>
                                        <option value="Estado da Palestina">Estado da Palestina</option>
                                        <option value="Estados Unidos da America">Estados Unidos da America</option>
                                        <option value="Estonia">Estonia</option>
                                        <option value="Etiopia">Etiopia</option>
                                        <option value="Fiji">Fiji</option>
                                        <option value="Filipinas">Filipinas</option>
                                        <option value="Filandia">Filandia</option>
                                        <option value="Franca">Franca</option>
                                        <option value="Gabao">Gabao</option>
                                        <option value="Gambia">Gambia</option>
                                        <option value="Gana">Gana</option>
                                        <option value="Georgia">Georgia</option>
                                        <option value="Granada">Granada</option>
                                        <option value="Grecia">Grecia</option>
                                        <option value="Guatemala">Guatemala</option>
                                        <option value="Guiana">Guiana</option>
                                        <option value="Guine">Guine</option>
                                        <option value="Guine Equatorial">Guine Equatorial</option>
                                        <option value="Guine-Bissau">Guine-Bissau</option>
                                        <option value="Haiti">Haiti</option>
                                        <option value="Honduras">Honduras</option>
                                        <option value="Hungria">Hungria</option>
                                        <option value="Iemen">Iemen</option>
                                        <option value="Ilhas Marechal">Ilhas Marechal</option>
                                        <option value="India">India</option>
                                        <option value="Indonesia">Indonesia</option>
                                        <option value="Irao">Irao</option>
                                        <option value="Iraque">Iraque</option>
                                        <option value="Irlanda">Irlanda</option>
                                        <option value="Islandia">Islandia</option>
                                        <option value="Israel">Israel</option>
                                        <option value="Italia">Italia</option>
                                        <option value="Jamaica">Jamaica</option>
                                        <option value="Japao">Japao</option>
                                        <option value="Jibuti">Jibuti</option>
                                        <option value="Jordania">Jordania</option>
                                        <option value="Laus">Laus</option>
                                        <option value="Lesoto">Lesoto</option>
                                        <option value="Letonia">Letonia</option>
                                        <option value="Libano">Libano</option>
                                        <option value="Liberia">Liberia</option>
                                        <option value="Libia">Libia</option>
                                        <option value="Listenstaine">Listenstaine</option>
                                        <option value="Lituania">Lituania</option>
                                        <option value="Luxemburgo">Luxemburgo</option>
                                        <option value="Macedonia">Macedonia</option>
                                        <option value="Madagascar">Madagascar</option>
                                        <option value="Malasia">Malasia</option>
                                        <option value="Malaui">Malaui</option>
                                        <option value="Maldivas">Maldivas</option>
                                        <option value="Mali">Mali</option>
                                        <option value="Malta">Malta</option>
                                        <option value="Marrocos">Marrocos</option>
                                        <option value="Mauricia">Mauricia</option>
                                        <option value="Mauritania">Mauritania</option>
                                        <option value="Mexico">Mexico</option>
                                        <option value="Mianmar">Mianmar</option>
                                        <option value="Micronesia">Micronesia</option>
                                        <option value="Mocambique">Mocambique</option>
                                        <option value="Moldavia">Moldavia</option>
                                        <option value="Monaco">Monaco</option>
                                        <option value="Mongolia">Mongolia</option>
                                        <option value="Montenegro">Montenegro</option>
                                        <option value="Namibia">Namibia</option>
                                        <option value="Nauru">Nauru</option>
                                        <option value="Nepal">Nepal</option>
                                        <option value="Nicaragua">Nicaragua</option>
                                        <option value="Niger">Niger</option>
                                        <option value="Nigeria">Nigeria</option>
                                        <option value="Noruega">Noruega</option>
                                        <option value="Nova Zelandia">Nova Zelandia</option>
                                        <option value="Oma">Oma</option>
                                        <option value="Paises Baixos">Paises Baixos</option>
                                        <option value="Palau">Palau</option>
                                        <option value="Panama">Panama</option>
                                        <option value="Papua Nova Guine">Papua Nova Guine</option>
                                        <option value="Paquistao">Paquistao</option>
                                        <option value="Paraguai">Paraguai</option>
                                        <option value="Peru">Peru</option>
                                        <option value="Polonia">Polonia</option>
                                        <option value="Portugal">Portugal</option>
                                        <option value="Quenia">Quenia</option>
                                        <option value="Quirguistao">Quirguistao</option>
                                        <option value="Quiribati">Quiribati</option>
                                        <option value="Reino Unido">Reino Unido</option>
                                        <option value="Republica Centro-Africana">Republica Centro-Africana</option>
                                        <option value="Republica Checa">Republica Checa</option>
                                        <option value="Republica Democratica do Congo">Republica Democratica do Congo</option>
                                        <option value="Republica Dominicana">Republica Dominicana</option>
                                        <option value="Romenia">Romenia</option>
                                        <option value="Ruanda">Ruanda</option>
                                        <option value="Russia">Russia</option>
                                        <option value="Salomao">Salomao</option>
                                        <option value="Salvador">Salvador</option>
                                        <option value="Samoa">Samoa</option>
                                        <option value="Santa Lucia">Santa Lucia</option>
                                        <option value="Sao Cristovao e Neves">Sao Cristovao e Neves</option>
                                        <option value="Sao Marinho">Sao Marinho</option>
                                        <option value="Sao Tome e Principe">Sao Tome e Principe</option>
                                        <option value="Sao Vicente e Granadinas">Sao Vicente e Granadinas</option>
                                        <option value="Seicheles">Seicheles</option>
                                        <option value="Senegal">Senegal</option>
                                        <option value="Serra Leoa">Serra Leoa</option>
                                        <option value="servia">servia</option>
                                        <option value="Singapura">Singapura</option>
                                        <option value="Siria">Siria</option>
                                        <option value="Somalia">Somalia</option>
                                        <option value="Sri Lanca">Sri Lanca</option>
                                        <option value="Suazilandia">Suazilandia</option>
                                        <option value="Sudao">Sudao</option>
                                        <option value="Sudao do Sul">Sudao do Sul</option>
                                        <option value="Suecia">Suecia</option>
                                        <option value="Suica">Suica</option>
                                        <option value="Suriname">Suriname</option>
                                        <option value="Tailandia">Tailandia</option>
                                        <option value="Taiua">Taiua</option>
                                        <option value="Tajiquistao">Tajiquistao</option>
                                        <option value="Tanzania">Tanzania</option>
                                        <option value="Timos-Leste">Timos-Leste</option>
                                        <option value="Togo">Togo</option>
                                        <option value="Tonga">Tonga</option>
                                        <option value="Trindade e Tobago">Trindade e Tobago</option>
                                        <option value="Tunisia">Tunisia</option>
                                        <option value="Turcomenistao">Turcomenistao</option>
                                        <option value="Turquia">Turquia</option>
                                        <option value="Tuvalu">Tuvalu</option>
                                        <option value="Ucrania">Ucrania</option>
                                        <option value="Uganda">Uganda</option>
                                        <option value="Uruguai">Uruguai</option>
                                        <option value="Usbequistao">Usbequistao</option>
                                        <option value="Vanuatu">Vanuatu</option>
                                        <option value="Vaticano">Vaticano</option>
                                        <option value="Venezuela">Venezuela</option>
                                        <option value="Vietname">Vietname</option>
                                        <option value="Zambia">Zambia</option>
                                        <option value="Zimbabue">Zimbabue</option>
                                    </select></p>                                  
                                <input type="password" class="form-control footer-input margin-b-20" name="senha"  placeholder="Senha (6 digitos)" required>                                  
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