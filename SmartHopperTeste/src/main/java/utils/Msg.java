/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dao.Conexao;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Msg {    

    public Msg() {
    }
    
    public static void ServidorErro(SQLException e, String method, Class classe) {
        System.out.println("Erro: " + e.getMessage()
                + "\nmetodo: " + method
                + "\nCausa: " + e.getCause()
                + "\nClasse: " + classe.getSimpleName());
    }
    
    public static void ServidorErro(String mensagem, Class classe, SQLException e) {
        System.out.println("Erro: " + e.getMessage()
                + "\nmetodo: " + mensagem
                + "\nCausa: " + e.getCause()
                + "\nClasse: " + classe.getSimpleName());
    }
    
    public static void ServidorErro(String msg, String metodo, Class classe, Exception error) {
        System.out.println("Erro: " + error.getMessage()
                + "\nmetodo: " + metodo
                + "\nCausa: " + error.getCause()
                + "\nClasse: " + classe.getSimpleName());
        error.printStackTrace();
    }
}
