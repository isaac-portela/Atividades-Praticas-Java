<?php
$banco = "BD_Bliblioteca.sql";
$conexao = mysqli_connect("localhost", "root", "");
$dados = file_get_contents($banco); //le os dados do arquivo e converte para string
mysqli_multi_query($conexao, $dados); // cria o banco de dados do arquivo no phpmyadmin
mysqli_close($conexao);
//pegandos dados da tabela para criar o arquivo txt
$conexao = mysqli_connect("localhost", "root", "", "biblioteca");
if (!$conexao) {
    die("Conexao falhou: " . mysqli_connect_error());
    echo '<script>location.reload()</script>';
}

$requisicao1 = "SELECT * FROM autores";
$resultado1 = mysqli_query($conexao, $requisicao1);
$requisicao2 = "SELECT * FROM livros";
$resultado2 = mysqli_query($conexao, $requisicao2);

$string = "";
while ($livros = mysqli_fetch_assoc($resultado2)) {
    $dadosAutores = "";
    $dadosLivro = "";
    $aux = 0;
    while ($autores = mysqli_fetch_assoc($resultado1)) {

        if ($livros['id'] == $autores['id-livro']) {
            $dadosLivro = "<i>" . $livros["titulo"] . "</i>" . ". ed." . $livros["edicao"] . "ª. " . $livros["cidade"] . ": " . $livros["editora"] . ", " . $livros["ano"] . "." . "\n";
            if ($dadosAutores == "") {
                $dadosAutores = "<b>" . $autores['sobrenome'] . "</b>" . ", " . $autores['nomes'];
            } else if ($dadosAutores != "") {
                $aux = 1;
                $dadosAutores .= "; " . "<b>" . $autores['sobrenome'] . "</b>" . ", " . $autores['nomes'] . ". ";
            }
        }
    }
    if ($resultado1 = mysqli_query($conexao, $requisicao1)) {
    } else {
        echo '<script>location.reload()</script>';
    }

    if ($aux != 1)
        $string .= $dadosAutores . ". " . $dadosLivro;
    else
        $string .= $dadosAutores . $dadosLivro;

}
$arquivo = fopen("arquivo.txt", "w");
fwrite($arquivo, "<b>BIBLIOGRAFIA</b>" . "\n\n");
fwrite($arquivo, $string);
fclose($arquivo);
mysqli_close($conexao);

// parte 3
$conexao = mysqli_connect("localhost", "root", "", "biblioteca");

$item_livros = "INSERT INTO livros(titulo,ano,editora,cidade,edicao) 
     VALUES  ('Use a Cabeça C#',2007,'Alta Books','São Paulo',2)";

if ($result = mysqli_query($conexao, $item_livros)) {

} else {
    echo '<script>location.reload()</script>';
}

$ultimo_reg = mysqli_insert_id($conexao);
echo 'ultimo registro: ' . $ultimo_reg;

$item_autores1 = "INSERT INTO autores(`id-livro`,nomes,sobrenome) 
VALUES  ($ultimo_reg,'Andrew','STELLMA')";
if ($result = mysqli_query($conexao, $item_autores1)) {

} else {
    echo '<script>location.reload()</script>';
}


$item_autores2 = "INSERT INTO autores(`id-livro`,nomes,sobrenome) 
VALUES  ($ultimo_reg,'Jennifer','GREENE')";
if ($result = mysqli_query($conexao, $item_autores2)) {

} else {
    echo '<script>location.reload()</script>';
}
mysqli_close($conexao);
$vetordeBiblografia = array();
$arq = fopen("arquivo.txt", "r");
while (!feof($arq)) {
    $linha = fgets($arq, 1024);
    array_push($vetordeBiblografia, $linha);
}
fclose($arq);
sort($vetordeBiblografia);
foreach ($vetordeBiblografia as $item) {
    echo $item;
    echo "<br>";
}

?>


