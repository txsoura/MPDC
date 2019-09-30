<?php
include "../../../coneccao.php";
include "sessao.php";

$nome=$_POST["nome"];
$telefone=$_POST["telefone"];
$email=$_POST["email"];
$endereco=$_POST["endereco"];
$senha=sha1($_POST["senha"]);

if($senha!= $_SESSION["senha"]){
    echo("<script language='javascript' type='text/javascript'> alert('Senha incorrecta. Por favor tente novamente');window.history.back();</script>");
}else{
$sql="UPDATE autoridade SET nome='$nome',telefone='$telefone',email='$email',endereco='$endereco' WHERE nup='$_SESSION[codigo]';";

if(mysqli_query($connect, $sql)){
    
    echo("<script language='javascript' type='text/javascript'>alert('Perfil actualizado com sucesso');window.location.href='../../index.php';</script>");
}
mysqli_close($connect);
}
?>