package com.da.projetocrud.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoTest {

    public static void main(String[] args) {

        try {
            Connection con = Conexao.getConexao();
            if (con != null) {
                System.out.println("Conectado");
            } else {
                System.out.println("Falha ao conectar");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
