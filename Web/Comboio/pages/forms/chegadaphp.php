<?php

include "../../../coneccao.php";
include "sessao.php";
$data = date("Y-m-d");

$chegada = $_POST["chegada"];
$passageiro = $_POST["passageiro"];
$senha = sha1($_POST["senha"]);

if ($chegada < $data) {
    echo("<script language='javascript' type='text/javascript'> alert('Data invalida! Tem de ser superior a data de hoje.');window.history.back();</script>");
} else if ($passageiro <= 0) {
    echo("<script language='javascript' type='text/javascript'> alert('Passageiros invalidos! Tem de ser superior a 0.');window.history.back();</script>");
} else if ($senha != $_SESSION['senha']) {
    echo("<script language='javascript' type='text/javascript'> alert('Senha incorrecta!');window.history.back();</script>");
} else {
    $sqld = "UPDATE comboio SET chegada='$chegada',passageiros='$passageiro',partida='NULL', preco='0' WHERE nup='$_SESSION[codigo]';";
    if (mysqli_query($connect, $sqld)) {

        echo("<script language='javascript' type='text/javascript'>alert('Chegada marcada');window.location.href='chegada.php';</script>");
    }
}
mysqli_close($connect);
?>