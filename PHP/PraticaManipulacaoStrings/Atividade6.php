<?php
echo "<style>
    b{
        color: red;
    }
    
</style>";
error_reporting(0);
if (isset($_POST['enviar'])) {
    $string = $_POST['area-texto'];
    $substring = $_POST['string2'];
    $string = trim($string);
    if (!empty($string) && !empty($substring)) {
        $numero_ocorrencias = 0;
        $tamanho = strlen($substring);
        $vetor_String = str_split($string);
        while (($numero_ocorrencias = stripos($string, $substring, $numero_ocorrencias + 1)) != 0) {
            for ($i = $numero_ocorrencias; $i < $numero_ocorrencias + ($tamanho); $i++) {
                $estilo = "<b>$vetor_String[$i]</b>";
                $vetor_String[$i] = $estilo;
            }

        }
        echo implode($vetor_String, "");
    } else {
        echo "Você não preencheu todos os campos<br>";
    }

}


?>