<?php
// crinado a interface
$cabecalho = "<p style='color: green;font-weight: bold'>SÉRIE DE MACLAURIN - SEN(X)</p>";
$cabecalho .= "<img src='maclaurin.png'>";
echo $cabecalho;

if (!empty($_POST['graus']) && !empty($_POST['ntermos'])) {
    $angulo = $_POST['graus'];
    $numeroTermos = $_POST['ntermos'];
    $ang_rad = deg2rad($angulo);
    $seno = 0;
    for ($n = 0; $n < $numeroTermos; $n++) {
        $seno += pow(-1, $n) * pow($ang_rad, 2 * $n + 1) / fatorial(2 * $n + 1);
    }
    echo "<p style='color: red'>" . "sen(" . $angulo . ")" . " = " . $seno . "</p>";
}


function fatorial($x)
{
    $F = 1;
    for ($i = 1; $i <= $x; $i++) {
        $F *= $i;
    }
    return $F;
}

?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SÉRIE DE MACLAURIN</title>
</head>
<body>
<form action="SerieDeMaclaurin_Ex2.php" method="post">
    <p> Valor em Graus: <input type="number" name="graus"></p>
    <p>No Termos: <input type="number" name="ntermos"></p>
    <input type="submit" value="Calcular Seno()">
</form>
</body>
</html>