<?php

session_start();
if (!isset($_SESSION["codigo"]) and ! isset($_SESSION["senha"])) {
    session_destroy();
    unset($_SESSION["codigo"]);
    unset($_SESSION["senha"]);
    header("location:../nup.php");
}
?>