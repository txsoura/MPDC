<?php
include "../../../coneccao.php";
include "sessao.php";

$titulo=$_POST["titulo"];
$descricao=$_POST["descricao"];
$escritor=$_POST["escritor"];
$senha=sha1($_POST["senha"]);

if($senha!= $_SESSION["senha"]){
    echo("<script language='javascript' type='text/javascript'> alert('Senha incorrecta. Por favor tente novamente');window.history.back();</script>");
}else{
$sql="INSERT INTO noticia (titulo,descricao,escritor) VALUES('$titulo','$descricao','$escritor');";

if(mysqli_query($connect, $sql)){
    
    echo("<script language='javascript' type='text/javascript'>alert('Noticia adiccionada com sucesso');window.location.href='noticia.php';</script>");
}
mysqli_close($connect);
}
?>