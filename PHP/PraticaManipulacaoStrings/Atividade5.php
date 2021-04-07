<?php
error_reporting(0);
echo "<style>
    h2{
        text-align: center;
        font-size: 20px;
        font-weight: normal;
    }
    
</style>";
$nome = $_GET['nome'];
if (isset($nome)) {
 formatanome($nome);
} else {
    echo "Digite seu nome na url, nome da variavel = ['nome']";
}
function formatanome($nome)
{
    $nome = strtolower($nome); //tranformando todos os caracteres para minusculo
    $nome = ltrim($nome);
    $array = explode(" ", $nome);
    foreach ($array as $elemento) {
        if ($elemento == "e" || $elemento == "de" || $elemento == "da" || $elemento == "do" || $elemento == "dos") {
            $saida .= $elemento . " ";
        } else {
            $saida .= ucfirst($elemento) . " ";   //ucfirst — Converte para maiúscula o primeiro caractere de uma string
        }
    }
    echo "<h2>" . $nome . " => " . $saida . "</h2>";
}

?>