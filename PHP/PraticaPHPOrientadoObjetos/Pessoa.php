<?php

class Pessoa
{
    private $identificacao;

    public function getIdentificacao()
    {
        return $this->identificacao;
    }

    public function setIdentificacao($identificacao): void
    {
        $this->identificacao = $identificacao;
    }

}

?>