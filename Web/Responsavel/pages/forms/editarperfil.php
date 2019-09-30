<?php
include "../../../coneccao.php";
include "sessao.php";
include ('../../../pdf/mpdf.php');
$data=date("Y-m-d");

$nome=$_POST["nome"];
$telefone=$_POST["telefone"];
$email=$_POST["email"];
$senha=sha1($_POST["senha"]);

if($senha!= $_SESSION["senha"]){
    echo("<script language='javascript' type='text/javascript'> alert('Senha incorrecta. Por favor tente novamente');window.history.back();</script>");
}else{
$sql="UPDATE responsavel SET nome='$nome',telefone='$telefone',email='$email' WHERE nup='$_SESSION[codigo]';";

if(mysqli_query($connect, $sql)){
    $sql="SELECT * FROM responsavel WHERE nup='$_SESSION[codigo]';";
    $result=mysqli_query($connect,$sql);
    $row=mysqli_fetch_assoc($result);

    $pagina=
        "<html>
        <head>
            <link rel='stylesheet' href='../../../css/visualizar.css' type='text/css'>
        </head>
        <body>
        <img src='../../../img/logo-dark.PNG' width='200px' heigth='150px'> S25&#8226; 58' 21.326 E32&#8226; 33' 50.195 | ".$data."
        <h1>Confirmacao de Registo</h1>
        <table>
        <tr>
        <th align='center'>Informacoes Actualizadas do Responsavel</th>
        </tr>
        <tr>
        <td><b>Nome: </b>".$nome."</td>
        </tr>
        <tr>
        <td><b>Telefone: </b>".$telefone."</td>
        </tr>
        <tr>
        <td><b>Email: </b>".$email."</td>
        </tr>
        <tr>
        <td><b>NUP:</b> RS".$_SESSION['codigo']."</td>
        </tr>
        </table>
        <br />
        <b>Notas</b><br />
        <b>&#8226;</b>Por favor salve este documento, pois serve de comprovativo no acto da entrada no porto;<br />
        <b>&#8226;</b>A taxa diaria da portagem para automovel e de 1 USD;<br />
        <b>&#8226;</b>A taxa diaria da portagem para camiao e de 5 USD;<br />
        <b>&#8226;</b>A taxa diaria para comboio e de 25 USD;<br />
        <b>&#8226;</b>Apos 2 dias, serao acrescentados 1.1 USD no valor diario;<br />
        <b>&#8226;</b>A primerira semana o armazenamento e gratis;<br />
        <b>&#8226;</b>Apos a primeira semana, o armazem custa 2 USD diarios por tonelada;<br />
        <b>&#8226;</b>A mercadoria em importacao pode permanecer no porto durante 1 mes, enquanto a em transito 3 meses;<br />
        <b>&#8226;</b>Apos o periodo referido acima, a mercadoria e apreendida pelas alfandegas;
        </body>
        </html>";
    $arquivo="MPDC/RS.pdf";
    $mpdf=new mPDF();
    $mpdf->WriteHTML($pagina);

    $mpdf->Output($arquivo, 'I');
    echo("<script language='javascript' type='text/javascript'>alert();window.location.href='../../index.php';</script>");
}
mysqli_close($connect);
}
?>