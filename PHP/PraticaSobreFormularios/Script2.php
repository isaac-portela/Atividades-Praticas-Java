<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Calculadora Equação de Segundo Grau</title>
</head>
<body>
<form action="Script2.php" method="get">
    a: <input type="number" name="a">
    b: <input type="number" name="b">
    c: <input type="number" name="c">
    <input type="submit" name="botao" value="Calcular">
</form>
</body>
</html>

<?php
error_reporting(0);
$a = $_GET['a'];
$b = $_GET['b'];
$c = $_GET['c'];
if (isset($a) && isset($b) && isset($c)) {
    if (!empty($a) && !empty($b) && !empty($c)) { // verica se  os campos estão vazios
        $delta = pow($b, 2) - (4 * $a * $c);
        $x1 = (-$b + sqrt($delta)) / (2 * $a);
        $x2 = (-$b - sqrt($delta)) / (2 * $a);
        echo "S ={" . $x1 . "," . $x2 . "}";
    } else {
        echo "ERRO!! você não definiu todos os valores";
    }
}
?>