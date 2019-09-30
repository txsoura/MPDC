<?php

include "../../../coneccao.php";
include "sessao.php";
$data = date("Y-m-d");

$senha = sha1($_POST["senha"]);
$mercadoria = $_POST['mercadoria'];
$responsavel = $_POST["responsavel"];
$quantidade = $_POST["quantidade"];
$situacao = $_POST['situacao'];
$tipo = $_POST['tipo'];

if ($senha != $_SESSION['senha']) {
    echo("<script language='javascript' type='text/javascript'> alert('Senha invalida!');window.history.back();</script>");
} else if ($responsavel <= 0) {
    echo("<script language='javascript' type='text/javascript'> alert('Responsavel invalido! Tem de ser superior a 0.');window.history.back();</script>");
} else if ($quantidade <= 0) {
    echo("<script language='javascript' type='text/javascript'> alert('Quantidade invalida! Tem de ser superior a 0.');window.history.back();</script>");
} else {
    $sqlm = "INSERT INTO mercadoria (navio,situacao, tipo,responsavel,quantidade) VALUES('$_SESSION[codigo]','$situacao','$tipo','$responsavel','$quantidade');";
    if (mysqli_query($connect, $sqlm)) {

        echo("<script language='javascript' type='text/javascript'>alert('Mercadoria declarada');window.location.href='mercadoria.php';</script>");
    }
}
mysqli_close($connect);
?>