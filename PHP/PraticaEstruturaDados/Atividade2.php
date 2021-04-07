<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Atividade 02</title>
</head>
<body>
<form action="Atividade2.php" method="post">
    <input type="radio" name="ordenar" value="chave">
    <label>Ordenar o array pela chave</label>
    <input type="radio" name="ordenar" value="valor">
    <label>Ordenar o array pelo valor</label>
    <input type="submit" value="enviar">
</form>
</body>
</html>


<?php
error_reporting(0);
$ordenar = $_POST['ordenar'];
$alfabeto = range('A', 'Z');
$ascci = array();
foreach ($alfabeto as $letra) {
    array_push($ascci, ord($letra));
}
// perguntar sobre como  a escolha do usuario;
$terceiroArray = array();
for ($i = 0; $i < count($alfabeto); $i++) {
    $terceiroArray[$alfabeto[$i]] = $ascci[$i];
}
if (!empty($ordenar)) {
    ordenaVetor($terceiroArray,$ordenar);
}else{
    echo "";
}
function ordenaVetor(&$vetor,$ordenar)
{
    if ($ordenar == "chave") {
        ksort($vetor);
        foreach ($vetor as $key => $value) {
            echo $key . "=>" . $value . "<br>";
        }
    } else {
        asort($vetor);
        foreach ($vetor as $key => $value) {
            echo $key . "=>" . $value . "<br>";
        }
    }
}

?>