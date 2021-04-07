<?php
// criando interface
$cabeçalho = "<p id='texto-1'> MDC - MÁXIMO DIVISOR COMUM</p>";
$cabeçalho .= "<p id='texto-2'> mmc - Mínimo múltiplo Comum</p>";
echo $cabeçalho;

if (isset($_POST['n1']) && isset($_POST['n2'])) {
    $n1 = $_POST['n1'];
    $n2 = $_POST['n2'];
    if (!empty($n1) && !empty($n2) && isset($_POST["divComum"])) {
        if ($_POST["divComum"] == "mdc") {
            $resultado = calculoMDC($n1, $n2);
            echo "<p  style='color: red'>" . "MDC: " . $resultado . "</p>";
        } else {
            $resultado = calculoMMC($n1, $n2);
            echo "<p style='color: red'>" . "mmc: " . $resultado . "</p>";
        }
    } else {
        echo "<p style='color: red'>Erro!!! Algum campo está vazio!</p>";
    }
} else {
    echo "";
}
//Função recursiva que calcula o MDC (máximo divisor comum)
function calculoMDC($x, $y)
{
    $maior = max($x, $y); // A função max retorna qual é o maior numero
    $menor = min($x, $y); // A função mix retorna qual é o menor numero
    if ($maior % $menor == 0) {
        return $menor;
    } else {
        $resto = $maior % $menor;
        return calculoMDC($menor, $resto);
    }
}

function calculoMMC($x, $y)
{
    $mdc = calculoMDC($x, $y);
    $resultado = ($x * $y) / $mdc;
    return $resultado;
}

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Calculo de MDC e MMC</title>
</head>
<body>
<form action="mdc_mmc.php" method="post">
    MDC:<input type="radio" name="divComum" value="mdc" id="mdc">
    mmc:<input type="radio" name="divComum" value="mmc" id="mmc">
    <p>
        1º Número: <input type="number" name="n1">
    </p>
    <p>
        2º Número: <input type="number" name="n2">
    </p>
    <input type="submit" value="Enviar">

</form>

<script>
    let texto1 = document.querySelector("#texto-1");
    let texto2 = document.querySelector("#texto-2");
    let mdc = document.querySelector("#mdc");
    let mmc = document.querySelector("#mmc");

    mdc.addEventListener('click', corVerde);
    mmc.addEventListener('click', corAzul);

    function corVerde() {
        texto1.style.color = "green";
        texto1.style.fontWeight = "bold";
        texto2.style.color = "green";
        texto2.style.fontWeight = "bold";
    }

    function corAzul() {
        texto1.style.color = "blue";
        texto1.style.fontWeight = "bold";
        texto2.style.color = "blue";
        texto2.style.fontWeight = "bold";
    }
</script>
</body>
</html>
