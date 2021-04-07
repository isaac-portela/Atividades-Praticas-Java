<?php
error_reporting(0);
echo "<style>
    h2{
        text-align: center;
        font-size: 20px;
        font-weight: normal;
    }
    
</style>";
$palavra = $_GET['palavra'];
if (isset($palavra)) {
    $vogais = array("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
    $palavra = str_replace($vogais, "?", $palavra);
    echo "<h2>" . strrev($palavra) . '<br>' . "</h2>";
    echo "<h2>" . "Comprimento da palavra: " . strlen($palavra) . "<h2>";
}
?>