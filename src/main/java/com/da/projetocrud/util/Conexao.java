package com.da.projetocrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver"; 
        String uri = "jdbc:mysql://localhost:3306/projetoda";
        String usuario = "root";
        String senha = "admin";
        Class.forName(driver);
        return DriverManager.getConnection(uri, usuario, senha);
    }
}
