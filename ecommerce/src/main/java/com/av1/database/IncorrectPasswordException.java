package com.av1.database;

/**
 * Exceção que deve ser lançada caso a senha informada para um usuáro não seja a correta.
 */
public class IncorrectPasswordException extends Exception {

    public IncorrectPasswordException() {}
    
    @Override
    public String getMessage(){
        return "Senha incorreta.";
    }
}