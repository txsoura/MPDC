<?php

include "../../../coneccao.php";
include "sessao.php";
$data = date("Y-m-d");

$matricula = $_POST["matricula"];
$empresa = $_POST["empresa"];
$telefone = $_POST["telefone"];
$email = $_POST["email"];
$senha = sha1($_POST["senha"]);

if ($senha != $_SESSION["senha"]) {
    echo("<script language='javascript' type='text/javascript'> alert('Senha incorrecta. Por favor tente novamente');window.history.back();</script>");
} else {
    $sql = "UPDATE comboio SET matricula='$matricula',empresa='$empresa',telefone='$telefone',email='$email' WHERE nup='$_SESSION[codigo]';";

    if (mysqli_query($connect, $sql)) {

        echo("<script language='javascript' type='text/javascript'>alert('Perfil editado');window.location.href='../../index.php';</script>");
    }
    mysqli_close($connect);
}
?>