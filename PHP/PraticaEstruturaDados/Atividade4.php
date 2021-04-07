<?php
$alunos = array(
    array("Mario", 50, 70),
    array("João", 80, 90),
    array("Karine", 30, 50),
    array("Isaac", 70, 90),
    array("Kaio", 30, 40),
    array("Marina", 90, 100),
    array("Giovanna", rand(20, 100), rand(20, 100)),
    array("Matheus", rand(10, 100), rand(10, 100)),
    array("Lucas", rand(15, 100), rand(15, 100)),
    array("Joana", rand(40, 100), rand(40, 100))
);

function mediaNotas($vetor)
{
    $aux = 0;
    $aprovados = array();
    for ($i = 0; $i < count($vetor); $i++) {

        $nota1 = $vetor[$i][1];
        $nota2 = $vetor[$i][2];
        $media = ($nota1 + 2 * $nota2) / 3;
        if ($media >= 60) {
            $aprovados[$aux][0] = $vetor[$i][0];
            $aprovados[$aux][1] = $media;
            $aux = $aux + 1;
        }
    }
    return $aprovados;
}

$aux = mediaNotas($alunos);
$alunosAprovados = array();
for ($i = 0; $i < count($aux); $i++) {
    $alunosAprovados[$aux[$i][0]] = $aux[$i][1];
}
ksort($alunosAprovados);
// imprimindo a lista de aprovados
echo "Lista dos Alunos Aprovados:<br><br>";
foreach ($alunosAprovados as $chaves => $valor) {
    echo $chaves. " teve media final de: ". number_format($valor,2,',','.') ." pontos" . "<br>";
}
?>