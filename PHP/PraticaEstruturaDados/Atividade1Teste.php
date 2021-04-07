<?php
$formulario = "<form action='Atividade1Teste.php' method='post'>";
for ($i = 0; $i < 20; $i++) {
    $formulario .= "<input name='palavras[]'  type='text'><br>";
}
$formulario .= "<input type='submit' name='enviar' value='Enviar'><br>";
$formulario .= "</form>";

echo "<p>Digite uma palavra em cada input:</p>";
echo $formulario;
if (isset($_POST['enviar'])) {
    $inputs = $_POST['palavras'];
    $aux = 0;
    for ($i = 0; $i < 20; $i++) {
        if (!empty($inputs[$i])) {
            $aux += 1;
        }
    }
    if ($aux == 20) {
        echo "Vetor Não Ordenado: ";
        foreach ($inputs as $palavra) {
            echo $palavra . ", ";
        }
        echo '<br><br>';
        natsort($inputs);
        echo "Vetor Ordenado na forma natural: ";
        foreach ($inputs as $palavraOrd) {
            echo $palavraOrd . ", ";
        }
    } else {
        echo "Você so preencheu {$aux} inputs, mas você deve preencher todos os 20 inputs <br>";
    }
}
?>