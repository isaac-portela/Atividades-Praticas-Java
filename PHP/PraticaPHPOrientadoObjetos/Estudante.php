<?php
require_once 'Pessoa.php';
class Estudante extends Pessoa implements iEstudante
{
    private $graduacao;

    public function Estudante()
    {
       return 'estudante';
    }
} ?>