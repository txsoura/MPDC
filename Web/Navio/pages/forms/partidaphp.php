<?php

include "../../../coneccao.php";
include "sessao.php";
$data = date("Y-m-d");

$partida = $_POST["partida"];
$passageiro = $_POST["passageiro"];
$senha = sha1($_POST["senha"]);

if ($partida < $data) {
    echo("<script language='javascript' type='text/javascript'> alert('Data invalida! Tem de ser superior a data de hoje.');window.history.back();</script>");
} else if ($passageiro <= 0) {
    echo("<script language='javascript' type='text/javascript'> alert('Passageiros invalidos! Tem de ser superior a 0.');window.history.back();</script>");
} else if ($senha != $_SESSION['senha']) {
    echo("<script language='javascript' type='text/javascript'> alert('Senha invalida!');window.history.back();</script>");
} else {

    $sql = "SELECT * FROM navio WHERE nup='$_SESSION[codigo]';";
    $result = mysqli_query($connect, $sql);
    $row = mysqli_fetch_assoc($result);

    $pa = $partida;
    $che = $row['chegada'];

    $pa = explode('-', $pa);
    $che = explode('-', $che);

    $p = strtotime("$pa[2]-$pa[1]-$pa[0]");
    $c = strtotime("$che[2]-$che[1]-$che[0]");

    $dias = ($p - $c) / 86400;
    $preco = $dias * 1000;

    $sqld = "UPDATE navio SET partida='$partida',passageiros='$passageiro',preco='$preco' WHERE nup='$_SESSION[codigo]';";
    if (mysqli_query($connect, $sqld)) {

        echo("<script language='javascript' type='text/javascript'>alert('Partida marcada');window.location.href='chegada.php';</script>");
    }
}

mysqli_close($connect);
?>