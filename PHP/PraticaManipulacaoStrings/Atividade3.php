<?php
error_reporting(0);
echo "<style>
    h2{
        font-size: 20px;
        font-weight: normal;
    }
    
</style>";
echo "Esse codigo aceita a data das seguintes formas: dia/mês/ano ou por exemplo: 20 de setembro de 1998";
$dataCompleta = $_GET['data'];
if (isset($dataCompleta)) {
    $dataCompleta = ltrim($dataCompleta);
    if (mb_strpos($dataCompleta, "/") !== false) {
        $data = explode("/", $dataCompleta);
        $dia = $data[0];
        $mes = $data[1];
        $ano = $data[2];
    } else {
        $data = explode(" de ", $dataCompleta);
        $dia = $data[0];
        $mes = $data[1];
        $ano = $data[2];
    }
    echo "<h2>" . "dia: " . $dia . "<br>" . "</h2>";
    echo "<h2>" . "mês: " . $mes . "<br>" . "</h2>";
    echo "<h2>" . "ano: " . $ano . "<br>" . "</h2>";

}

?>