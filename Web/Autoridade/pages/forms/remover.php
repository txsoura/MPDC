<?php

include "../../../coneccao.php";

$cod = $_GET["codigo"];

$sql = "DELETE FROM noticia WHERE codigo='$cod';";
if (mysqli_query($connect, $sql)) {
    echo("<script language='javascript' type='text/javascript'>alert('Noticia apagada com sucesso');window.location.href='noticia.php';</script>");
}
mysqli_close($connect);
?>