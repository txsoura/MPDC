<?php 
include "../../../coneccao.php";
include "sessao.php";
        
$cod=$_GET["codigo"];

$sqld="UPDATE mercadoria SET disponivel=4 WHERE codigo='$cod';";
if(mysqli_query($connect,$sqld)){
    echo("<script language='javascript' type='text/javascript'>alert('Mercadoria apreendida com sucesso');window.location.href='mercadoriaarmazem.php';</script>");
}  
mysqli_close($connect);
?>