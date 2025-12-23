package com.javanauta.desafio4.infrasctruture;

public class IdNaoEncontrado extends RuntimeException{

    public IdNaoEncontrado (String mensagem){
        super(mensagem);
    }

}
