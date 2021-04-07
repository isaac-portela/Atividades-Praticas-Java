<?php
$baseDir = 'C:/'; // diretório "arquivo"
$abreDir = ($_GET['dir'] != '' ? $_GET['dir'] : $baseDir);
$diretorio = dir($abreDir);
$arquivos = array();
$pastas = array();
while ($registros = $diretorio->read()) {
    if ($registros != '.' && $registros != '..') {
        if (is_dir($abreDir . $registros)) { // checa se � uma pasta
            $pastas[] = $registros; // caso VERDADEIRO adiciona o item ao vetor de pastas
        } else if (is_file($abreDir . $registros)) {
            $arquivos[] = $registros;// caso FALSO adiciona o item ao vetor de arquivos
        }
    }
}
echo '<table width="500" border="1" cellpadding="5" cellspacing="0">';
foreach ($pastas as $listar) {// lista as pastas
    echo '<tr>';
    echo '<td>' . "<img src='pasta.jpg' width='50px'>" . $listar . '</td>';
    echo '<td align="center"><a href ="GerenciadorArquivos.php?dir=' . $abreDir . $listar . '/">abrir</a></td>';
    echo '</tr>';
}
$i=0;
foreach ($arquivos as $listar) {// lista os arquivos
    $extencões_aceitas = array('.jpg', '.tif', '.gif', '.png', '.jpeg', ".txt");
    $extencao = strrchr($listar, '.');
    if (in_array($extencao, $extencões_aceitas)) {
        echo '<tr>';
        echo '<td>' . "<img src='arquivo.jpg' width='20px'>" . $listar . '</td>';
        echo '<td align="center">' . "<a target='_blank' href='mostraArquivos.php?dir=".$abreDir.$listar."'>ver</a>" . '</td>';
        echo '</tr>';
    } else {
        echo '<tr>';
        echo '<td>' . "<img src='arquivo.jpg' width='20px'>" . $listar . '</td>';
        echo '<td align="center"><a href ="' . $abreDir . $listar . '">ver</a></td>';
        echo '</tr>';
    }

}
echo '</table>';
$diretorio->close();
?>

