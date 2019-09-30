<?php

include "coneccao.php";
$codigo = $_POST['codigo'];
$senha = sha1($_POST['senha']);

$sql = "SELECT* FROM usuario WHERE nup='$codigo' and senha='$senha';";
$result = mysqli_query($connect, $sql);
if (mysqli_num_rows($result) > 0) {

    $sql = "INSERT INTO controle (nup) VALUES ('$codigo');";
    mysqli_query($connect, $sql);

    session_start();
    $_SESSION["codigo"] = $codigo;
    $_SESSION["senha"] = $senha;
    $row = mysqli_fetch_assoc($result);
    if ($row["tipo"] == "nv") {
        header("location:Navio/index.php");
    } else
    if ($row["tipo"] == "cm") {
        header("location:Camiao/index.php");
    } else
    if ($row["tipo"] == "cb") {
        header("location:Comboio/index.php");
    }else
        if ($row["tipo"] == "at") {
        header("location:Autoridade/index.php");
    }else
        if ($row["tipo"] == "rs") {
        header("location:Responsavel/index.php");
    }
} else {

    echo("<script language='javascript' type='text/javascript'> alert('Codigo e/ou senha invalida!');window.location.href='nup.php';</script>");
    session_destroy();
    unset($_SESSION["codigo"]);
    unset($_SESSION["senha"]);
    mysqli_close($connect);
}
?>