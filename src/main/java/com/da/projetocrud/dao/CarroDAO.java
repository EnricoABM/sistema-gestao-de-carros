package com.da.projetocrud.dao;

import com.da.projetocrud.model.Carro;
import com.da.projetocrud.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// id, marca, modelo, ano, motor, placa, dono, cnh, telefone, endereco

public class CarroDAO {
    public void cadastrar(Carro carro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String sql = "insert into carro (marca, modelo, ano, motor, placa, dono, cnh, telefone, endereco) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement comando = con.prepareStatement(sql);
        comando.setString(1, carro.getMarca());
        comando.setString(2, carro.getModelo());
        comando.setInt(3, carro.getAno());
        comando.setString(4, carro.getMotor());
        comando.setString(5, carro.getPlaca());
        comando.setString(6, carro.getDono());
        comando.setString(7, carro.getCnh());
        comando.setString(8, carro.getTelefone());
        comando.setString(9, carro.getEndereco());
    
        comando.execute();
        
        comando.close();
        con.close();
    }
    
    public void atualizar(Carro carro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String sql = "update carro set marca=?, modelo=?, ano=?, motor=?, placa=?, dono=?, cnh=?, telefone=?, endereco=? where id = ?";
        PreparedStatement comando = con.prepareStatement(sql);
        comando.setString(1, carro.getMarca());
        comando.setString(2, carro.getModelo());
        comando.setInt(3, carro.getAno());
        comando.setString(4, carro.getMotor());
        comando.setString(5, carro.getPlaca());
        comando.setString(6, carro.getDono());
        comando.setString(7, carro.getCnh());
        comando.setString(8, carro.getTelefone());
        comando.setString(9, carro.getEndereco());
        comando.setInt(10, carro.getId());
    
        comando.execute();
        
        comando.close();
        con.close();
    }
    
    public void deletar(Carro carro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String sql = "delete from carro where id = ?";
        PreparedStatement comando = con.prepareStatement(sql);
        comando.setInt(1, carro.getId());
    
        comando.execute();
        
        comando.close();
        con.close();
    }
    
    public Carro consultarPorId(Carro carro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        
        String sql = "select id, marca, modelo, ano, motor, placa, dono, cnh, telefone, endereco from carro where id = ?";
        PreparedStatement comando = con.prepareStatement(sql);
        comando.setInt(1, carro.getId());
        
        ResultSet rs = comando.executeQuery();
        Carro c = new Carro();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setMarca(rs.getString("marca"));
            c.setModelo(rs.getString("modelo"));
            c.setAno(rs.getInt("ano"));
            c.setMotor(rs.getString("motor"));
            c.setPlaca(rs.getString("placa"));
            c.setDono(rs.getString("dono"));
            c.setCnh(rs.getString("cnh"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
        }
        
        return c;
    }
    
    public List<Carro> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        
        String sql = "select id, marca, modelo, ano, motor, placa, dono, cnh, telefone, endereco from carro";
        PreparedStatement comando = con.prepareStatement(sql);
        
        ResultSet rs = comando.executeQuery();
        List<Carro> lcarro = new ArrayList<>(); 
        while (rs.next()) {
            Carro c = new Carro();
            c.setId(rs.getInt("id"));
            c.setMarca(rs.getString("marca"));
            c.setModelo(rs.getString("modelo"));
            c.setAno(rs.getInt("ano"));
            c.setMotor(rs.getString("motor"));
            c.setPlaca(rs.getString("placa"));
            c.setDono(rs.getString("dono"));
            c.setCnh(rs.getString("cnh"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            lcarro.add(c);
            
        }
        
        return lcarro;
    }
}
