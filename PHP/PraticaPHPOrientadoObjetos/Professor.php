<?php
require_once 'Pessoa.php';
class Professor extends Pessoa implements iProfessor
{
    private $salario;


    public function getSalario()
    {
        return $this->salario;
    }

    public function setSalario($salario): void
    {
        $this->salario = $salario;
    }

    public function Professor()
    {
        return 'professor';
    }
}

?>