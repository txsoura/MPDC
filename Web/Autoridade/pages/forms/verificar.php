<?php
include ('sessao.php');
include "../../../coneccao.php";

$sql="SELECT* FROM autoridade WHERE nup='$_SESSION[codigo]' and cargo='Alfandegas' ;";
$result=mysqli_query($connect,$sql);
if (mysqli_num_rows($result)>0){
  echo("<script language='javascript' type='text/javascript'> window.location.href='responsavel.php';</script>");  
}else{
  echo("<script language='javascript' type='text/javascript'> alert('Acesso Bloqueiado! Nao tem permissao para aceder a essa funcao.');window.history.back();</script>");
    mysqli_close($connect);  
    
}

     

?>