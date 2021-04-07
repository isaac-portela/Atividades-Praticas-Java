<?php

class ProfessorEstudante
{
 public  function  getDetalhesProfessorEstudante(Professor $objProfessor,Estudante $objEstudante){
        return 'Eu sou '.$objProfessor->Professor().' e '.$objEstudante->Estudante().'. Meu ID é '.$objProfessor->getIdentificacao(). ' e eu ganho R$'. number_format($objProfessor->getSalario(),2,',','').' por semana! ;)';
 }
}

?>