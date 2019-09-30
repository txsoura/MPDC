<?php
include "../../../coneccao.php";
include "sessao.php";
        
$cod=$_GET["nup"];

$sql="UPDATE mercadoria SET disponivel=1 WHERE navio='$cod' and disponivel=0";
  
if(mysqli_query($connect,$sqld)){
    echo("<script language='javascript' type='text/javascript'>alert('Navio atracado com sucesso');window.location.href='navioprevisao.php';</script>");
}  
mysqli_close($connect);
?>