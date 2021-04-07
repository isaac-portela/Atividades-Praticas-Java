<?php
$entrada = array('A: XXXXX', 'B: XXXXX', 'C: XXXXX');
$troca = array('ALTA', 'MÉDIA', 'BAIXA');
echo "Classes Sociais:<br>";
for ($i = 0; $i < count($entrada); $i++) {
    $novaFrase[$i] = str_replace("XXXXX", $troca[$i], $entrada[$i]);
    echo $novaFrase[$i] . "<br>";
}
?>