<?php
error_reporting(0);
if (isset($_POST['enviar'])) { //verifica se a variavel existe!
    $fotoPermitido = array("png", "png");
    $extensao = pathinfo($_FILES['userfile']['name'], PATHINFO_EXTENSION);

    if (in_array($extensao, $fotoPermitido) && $_FILES['userfile']['size'] <= 1048576) {
        $pasta = "arquivos/";
        $temporario = $_FILES['userfile']['tmp_name'];
        $novoNome = uniqid() . "." . $extensao;
        if (move_uploaded_file($temporario, $pasta . $novoNome)) {
            $mensagem = "Upload do arquivo .$novoNome. feito com sucesso";
        } else {
            $mensagem = "Erro , não foi possivel fazer upload!";
        }
    } else {
        $mensagem = "Formato Inválido";
    }
    echo "<style> 
   tr{
    border: 1px solid black;
}td{
    border: 1px solid black;
} 
</style>";

    $tabela = "<table  style='border-collapse: collapse; border: 1px solid black'>";
    $tabela .= "<tr>";
    $tabela .= "<td><strong>Nome:</strong></td>";
    $tabela .= "<td>" . $_POST['nome'] . "</td>";
    $tabela .= "<td><strong>Sobrenome:</strong></td>";
    $tabela .= "<td>" . $_POST['sobrenome'] . "</td>";
    $tabela .= "<td><strong>Sexo:</strong></td>";
    $tabela .= "<td>" . $_POST['genero'] . "</td>";
    $tabela .= "</tr>";


    $tabela .= "<tr>";
    $tabela .= "<td><strong>Diciplinas:</strong></td>";
    $disciplinas = $_POST['materias'];
    $tabela .= "<td>";
    foreach ($disciplinas as $valor) {
        $tabela .= $valor . "</br>";
    }
    $tabela .= "</td>";
    $tabela .= "<td><strong>Arquivo:</strong></td>";
    if ($mensagem == "Upload do arquivo .$novoNome. feito com sucesso") {
        $tabela .= "<td>" . "<img width='72' height='82' src=" . $pasta . $novoNome . ">" . "</td>";
    }
    else{
        $tabela .= "<td>" . $mensagem . "</td>";
    }
    $tabela .= "<td><strong>Tipo Sangue:</strong></td>";
    $tabela .= "<td>" . $_POST['tipo_sangue'] . "</td>";
    $tabela .= "</tr>";

    $tabela .= "<tr>";
    $tabela .= "<td><strong>Servidor:</strong></td>";
    $tabela .= "<td colspan='5'>" . "O servidor Web em execução " . $_SERVER['SERVER_SOFTWARE'] . "</td>";
    $tabela .= "</tr>";
    $tabela .= "</table>";
    echo $tabela;

}
?>
