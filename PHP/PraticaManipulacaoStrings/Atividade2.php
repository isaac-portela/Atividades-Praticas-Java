<?php
error_reporting(0);
echo "<style>
    h2{
        text-align: center;
        font-size: 20px;
        font-weight: normal;
    }
    
</style>";
$cep = $_GET['CEP'];
if (isset($cep)) {
    $tresUltimosNumeros = substr($cep, -3);
    echo "<h2>" . "Os três Ultimos números do seu CEP são: " . $tresUltimosNumeros . " </h2 > ";
}
?>