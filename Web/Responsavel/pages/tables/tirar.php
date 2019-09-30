<?php

include "../../../coneccao.php";
include "sessao.php";
include ('../../../pdf/mpdf.php');
$data = date("Y-m-d");

$cod = $_GET["codigo"];

$sql = "SELECT * FROM mercadoria WHERE codigo='$cod';";
$result = mysqli_query($connect, $sql);
$row = mysqli_fetch_assoc($result);

$pa = $data;
$che = $row['chegada'];

$pa = explode('-', $pa);
$che = explode('-', $che);

$p = strtotime("$pa[2]-$pa[1]-$pa[0]");
$c = strtotime("$che[2]-$che[1]-$che[0]");

$dias = ($p - $c) / 86400;
if ($dias > 7) {
    $dia = $dias - 7;
    $preco = $dia * 2;
} else {
    $preco = 0;
}

$sqld = "UPDATE mercadoria SET disponivel=3, partida='$data',preco='$preco' WHERE codigo='$cod';";
if (mysqli_query($connect, $sqld)) {

    $pagina = "<html>
                                <head>
                                    <link rel='stylesheet' href='../../../css/visualizar.css' type='text/css'>
                                </head>
                                <body>
                                <img src='../../../img/logo-dark.PNG' width='200px' heigth='150px'> S25&#8226; 58' 21.326 E32&#8226; 33' 50.195 | " . $data . "
                                <h1>Confirmacao de Registo</h1>
                                <table>
                                <tr>
                                <th align='center'>Informacoes da Mercadoria</th>
                                </tr>
                                <tr>
                                <td><b>Codigo: </b>" . $row['codigo'] . "</td>
                                </tr>
                                <tr>
                                <td><b>Situacao da Mercadoria: </b>" . $row['situacao'] . "</td>
                                </tr>
                                <tr>
                                <td><b>Tipo da Mercadoria: </b>" . $row['tipo'] . "</td>
                                </tr>
                                <tr>
                                <td><b>Quantidade: </b>" . $row['quantidade'] . " T</td>
                                </tr>
                                <tr>
                                <td><b>Responsavel: </b> RS" . $row['responsavel'] . "</td>
                                </tr>
                                <tr>
                                <td><b>Data da Chegada:</b> " . $row['chegada'] . "</td>
                                </tr>
                                <tr>
                                <td><b>Data da Partida:</b> " . $data . "</td>
                                </tr>
                                <tr>
                                <td><b>Preco:</b> " . $preco . " USD</td>
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
    $arquivo = "MPDC/MR.pdf";
    $mpdf = new mPDF();
    $mpdf->WriteHTML($pagina);

    $mpdf->Output($arquivo, 'I');
    echo("<script language='javascript' type='text/javascript'>alert();window.location.href='chegada.php';</script>");
}

mysqli_close($connect);
?>