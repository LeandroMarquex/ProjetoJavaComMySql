/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetojavacommysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leandro Marques
 */
public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao = null;

        //chamar p driver
        //           Class.forName("com.mysql.jdbc.Driver");
        String driver = "com.mysql.cj.jdbc.Driver";

        // informações referente ao BD
        String url = "jdbc:mysql://localhost:3306/dbinfoq";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("conexao efetuado com sucesso");
            return conexao;
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println("conexao efetuado com sucesso");
            return null;
        }
    }

}
