<?php
//Configura tipo de alfabeto
header("Content-type: text/html; charset=utf8");
//Abre sessão
session_start();
$sessao = session_id();
//Abre conexão com BD e Tabela
function conecta()
{
    global $conexao;
    $servidor = 'localhost';
    $usuario = 'root';
    $senha = '';
    $basededados = 'visitasonline';
// Servidor MySQL // Usuário MySQL // Senha MySQL
// Banco de dados MySQL
    $conexao = mysqli_connect($servidor, $usuario, $senha) or die("MySQL: impossível conectar-se ao servidor $servidor");
    $sql = "CREATE DATABASE IF NOT EXISTS `visitasonline` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;";
    if ($result = mysqli_query($conexao, $sql)) {
        //  printf("Sucesso: Banco de Dados 'biblioteca' foi criado.<br>");
    } else {
        // printf("Erro ao criar BD: " . mysqli_error($conexao));
    }
    mysqli_close($conexao);
    $conexao = mysqli_connect($servidor, $usuario, $senha, $basededados) or die("MySQL: impossível conectar-se ao servidor $servidor");
    $sql = "CREATE TABLE IF NOT EXISTS `visitas` (
                `id` int UNSIGNED NOT NULL AUTO_INCREMENT, 
                `data` date NOT NULL,
                `usuarios` varchar(30) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
                `pageviews` int UNSIGNED NOT NULL DEFAULT '0', PRIMARY KEY (`id`) 
                
                 ) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
    mysqli_select_db($conexao, $basededados);
    mysqli_query($conexao, $sql);
}

//Função que recupera os valores contidos na tabela
function recuperaVisitas($sql, $indice)
{
    global $conexao, $sessao;
    $query = mysqli_query($conexao, $sql);
    $resultado = mysqli_fetch_row($query);
  // var_dump($resultado);
    return $resultado[$indice];
}

//Armazena as quantidades de visitas recebidas
function gravaVisitas()
{
    global $conexao, $sessao;
    $sql = "SELECT * FROM `visitas` WHERE `data` = CURDATE() AND `usuarios` = '".$sessao."' ";
    $requisicao = mysqli_query($conexao,$sql);
    $resultado = mysqli_fetch_array($requisicao,1);

    if (!$resultado) {
        $sql = "INSERT INTO `visitas` (`data`,`usuarios`,`pageviews`) VALUES (CURDATE(), '" . $sessao . "', 1)";
    } else {
            $sql = "UPDATE `visitas` SET `pageviews` = (`pageviews` + 1) WHERE `data` =CURDATE() AND  `usuarios` ='".$sessao."' ";
    }
    mysqli_query($conexao, $sql);
}

//Mostra quantidade de visitantes e visualizações
function mostraVisitas()
{
    global $conexao, $sessao;
    $sql = "SELECT  * FROM  `visitas` WHERE `data` = CURDATE() AND `usuarios` = '" . $sessao . "'";
    $user = recuperaVisitas($sql, 2);
    $datinha = recuperaVisitas($sql, 1);
    $datinha = strtotime($datinha);
    $visitas = recuperaVisitas($sql, 3);
    $sql = "SELECT SUM(pageviews) AS sum FROM `visitas`  WHERE `data` = CURDATE()";
    $resultado = mysqli_query($conexao, $sql);
    while ($row = mysqli_fetch_assoc($resultado)) {
        $totalVisitas = $row["sum"];
    }


    $sql = "SELECT COUNT(*) FROM visitas";
    $resultado = mysqli_query($conexao, $sql);
    $totalVisitantes = mysqli_fetch_row($resultado);

    echo "SESSÃO ID: " . "<b>" . $user . "</b>" . ">>> visitas em " . date('d/m/Y', $datinha) . ": " . $visitas . "<br>";
    echo "TOTAL GERAL DE VISITAS EM " . date('d/m/Y', $datinha) . ": " . $totalVisitas . "<br>";
    echo "TOTAL GERAL DE VISITANTES: " . $totalVisitantes[0] . "<br>";
}

conecta();
gravaVisitas();
mostraVisitas();

?>
