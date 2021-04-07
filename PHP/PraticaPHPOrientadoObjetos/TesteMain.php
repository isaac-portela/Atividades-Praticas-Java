<?php
require_once 'Pessoa.php';
require_once 'iProfessor.php';
require_once 'iEstudante.php';
require_once 'Professor.php';
require_once 'Estudante.php';
require_once 'ProfessorEstudante.php';

$prof = new Professor();
$prof->setIdentificacao(1);
$prof->setSalario(50000.00);
$estud = new Estudante();
$profEstud = new ProfessorEstudante();
echo $profEstud->getDetalhesProfessorEstudante($prof, $estud);
?>