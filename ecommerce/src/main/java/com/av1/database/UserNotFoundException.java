package com.av1.database;

/**
 * Exceção que deve ser lançada ao não encontrar um usuário no banco de dados.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {}
    
    @Override
    public String getMessage(){
        return "Usuário não encontrado.";
    }
}