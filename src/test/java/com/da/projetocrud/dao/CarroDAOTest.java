package com.da.projetocrud.dao;

import com.da.projetocrud.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOTest {
    
    private static void cadastrar() {
        Carro carro = new Carro();
        carro.setMarca("X");
        carro.setModelo("Y");
        carro.setAno(2024);
        carro.setMotor("Z");
        carro.setPlaca("AAA1234");
        carro.setDono("Joao da Silva");
        carro.setCnh("12345678900");
        carro.setTelefone("1190000-0000");
        carro.setEndereco("Rua sem Fim");
        
        CarroDAO cdao = new CarroDAO();
        try {
            cdao.cadastrar(carro);
            System.out.println("Cadastrado com sucesso");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Falha ao cadastrar: " + ex.getMessage());
        }
    }
    
    private static void atualizar() {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setMarca("X AT");
        carro.setModelo("Y AT");
        carro.setAno(2025);
        carro.setMotor("Z AT");
        carro.setPlaca("AAA1234");
        carro.setDono("Joao da Silva");
        carro.setCnh("12345678900");
        carro.setTelefone("1190000-0000");
        carro.setEndereco("Rua sem Fim");
        
        CarroDAO cdao = new CarroDAO();
        try {
            cdao.atualizar(carro);
            System.out.println("Atualizado com sucesso");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Falha ao atualizar: " + ex.getMessage());
        }
    }
    
    private static void deletar() {
        Carro carro = new Carro();
        carro.setId(1);
        
        CarroDAO cdao = new CarroDAO();
        try {
            cdao.deletar(carro);
            System.out.println("Deletado com sucesso");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Falha ao deletar: " + ex.getMessage());
        }
    }
            
    private static void consultarPorId() {
        Carro carro = new Carro();
        carro.setId(2);
        
        CarroDAO cdao = new CarroDAO();
        try {
            carro = cdao.consultarPorId(carro);
            if (carro.getDono() != null) {
                System.out.println("Carro encontrado com sucesso");
                System.out.println(carro);
            } else {
                System.out.println("Carro não encontrado");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Falha ao consultar: " + ex.getMessage());
        }
    }
        

    private static void consultarTodos() {
        List<Carro> lcarro = new ArrayList<>();
        
        CarroDAO cdao = new CarroDAO();
        try {
            lcarro = cdao.consultarTodos();
            for (Carro carro : lcarro) {
                System.out.println(carro);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Falha ao consultar: " + ex.getMessage());
        }
    }
    
}
