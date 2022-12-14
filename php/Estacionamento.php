<?php
class Estacionamento{
    private $id;
    private $vaga;
    private $setor;

    public function getid(){
        return $this->id;
    }
    public function setId($id){
        $this->id = $id;
    }
    public function getVaga(){
        return $this->vaga;
    }
    public function setVaga($vaga){
        $this->vaga = $vaga;
    }
    public function getSetor(){
        return $this->setor;
    }
    public function setSetor($setor){
        $this->setor = $setor;
    }
}
?>