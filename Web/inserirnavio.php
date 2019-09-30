<?php

include ('pdf/mpdf.php');
include "coneccao.php";
$data = date("Y-m-d");

$matricula = $_POST["matricula"];
$nome = $_POST["nome"];
$telefone = $_POST["telefone"];
$email = $_POST["email"];
$tipo = $_POST["tipo"];
$pais = $_POST["pais"];
$senha = Sha1($_POST["senha"]);

$sql = "SELECT* FROM navio WHERE matricula='$matricula' and pais='$pais' ;";
$result = mysqli_query($connect, $sql);
if (mysqli_num_rows($result) > 0) {
    echo("<script language='javascript' type='text/javascript'> alert('Navio Invalido, ja foi registado. Por favor inicie sessao.');window.history.back();</script>");
} else {

    $sqlct = "SELECT COUNT(*) AS total FROM usuario;";
    $resultct = mysqli_query($connect, $sqlct);
    $valorct = mysqli_fetch_assoc($resultct);
    $nup = $valorct['total'] + 1;

    $sql = "INSERT INTO navio (matricula,nome,telefone,email,tipo,pais,nup) VALUES('$matricula','$nome','$telefone','$email','$tipo','$pais','$nup');";
    if (mysqli_query($connect, $sql)) {
        $sql = "INSERT INTO usuario (senha,tipo) VALUES ('$senha','nv');";
        $result = mysqli_query($connect, $sql);
        $row = mysqli_fetch_assoc($result);

        $pagina = "<html>
        <head>
            <link rel='stylesheet' href='css/visualizar.css' type='text/css'>
        </head>
        <body>
        <img src='img/logo-dark.PNG' width='200px' heigth='150px'> S25&#8226; 58' 21.326 E32&#8226; 33' 50.195 | " . $data . "
        <h1>Confirmacao de Registo</h1>
        <table>
        <tr>
        <th align='center'>Informacoes da Embarcacao</th>
        </tr>
        <tr>
        <td><b>Matricula: </b>" . $matricula . "</td>
        </tr>
        <tr>
        <td><b>Nome: </b>" . $nome . "</td>
        </tr>
        <tr>
        <td><b>Telefone: </b>" . $telefone . "</td>
        </tr>
        <tr>
        <td><b>Email: </b>" . $email . "</td>
        </tr>
        <tr>
        <td><b>Pais: </b>" . $pais . "</td>
        </tr>
        <tr>
        <td><b>Tipo de Embarcacao: </b>" . $tipo . "</td>
        </tr>
        <tr>
        <td><b>NUP:</b> NV" . $nup . "</td>
        </tr>
        </table>
        <br />
        <b>Notas</b><br />
        <b>&#8226;</b>Por favor salve este documento, pois serve de comprovativo no acto da entrada no porto;<br />
        <b>&#8226;</b>A taxa diaria para navio e de 1000 USD;<br />
        <b>&#8226;</b>Apos 2 dias, serao acrescentados 41.7 USD no valor diario;
        </body>
        </html>";
        $arquivo = "MPDC/NV.pdf";
        $mpdf = new mPDF();
        $mpdf->WriteHTML($pagina);

        $mpdf->Output($arquivo, 'I');
        echo("<script language='javascript' type='text/javascript'>alert();window.location.href='navio.php';</script>");
    }
    mysqli_close($connect);
}
?>