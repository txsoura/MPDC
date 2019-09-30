<?php
include "../../../coneccao.php";

$cod=$_GET["codigo"];

$sql="DELETE FROM responsavel WHERE nup='$cod';";

if(mysqli_query($connect, $sql)){
    
    echo("<script language='javascript' type='text/javascript'>alert('Responsavel apagado com sucesso');window.location.href='responsavel.php';</script>");
}
mysqli_close($connect);

?>