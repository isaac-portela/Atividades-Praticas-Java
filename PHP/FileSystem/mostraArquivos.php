<?php
$caminho = $_GET["dir"];
$extencão_imagens = array('.jpg', '.tif', '.gif', '.png', '.jpeg');

$extencao = strrchr($caminho, '.');
if (in_array($extencao, $extencão_imagens)) {
    $nome = strrchr($caminho, '/');
    $novoCaminho = "temporario/" . $nome;
    copy($caminho, $novoCaminho);
    echo "<img src='$novoCaminho'>";
} else if ($extencao === '.txt') {
    $arquivo = fopen($caminho, 'r');

    while (!feof($arquivo)) {
        echo fgets($arquivo, 1024) . "<br>";
    }
    fclose($arquivo);
}

?>