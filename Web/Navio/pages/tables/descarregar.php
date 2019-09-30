<?php

include "../../../coneccao.php";
$data = date("Y-m-d");

$cod = $_GET["codigo"];
$sql = "UPDATE mercadoria SET disponivel=2, chegada='$data' WHERE codigo='$cod';";

if (mysqli_query($connect, $sql)) {
    echo("<script language='javascript' type='text/javascript'> alert('Aprovacao de descarga de mercadoria efectuada com sucesso!');window.location.href='mercadoriad.php';</script>");
}
mysqli_close($connect);
?>