package com.da.projetocrud.controller;

import com.da.projetocrud.dao.CarroDAO;
import com.da.projetocrud.model.Carro;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarroController", urlPatterns = {"/CarroController"})
public class CarroController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String op = request.getParameter("op");

        if (op.equals("Novo Carro")) {
            request.getRequestDispatcher("tela_novocadastro.jsp").forward(request, response);
        } else if (op.equals("Cadastrar")) {

            String marca = request.getParameter("txtmarca");
            String modelo = request.getParameter("txtmodelo");
            int ano = Integer.parseInt(request.getParameter("txtano"));
            String motor = request.getParameter("txtmotor");
            String placa = request.getParameter("txtplaca");
            String dono = request.getParameter("txtdono");
            String cnh = request.getParameter("txtcnh");
            String telefone = request.getParameter("txttelefone");
            String endereco = request.getParameter("txtendereco");

            Carro carro = new Carro();
            carro.setMarca(marca);
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setMotor(motor);
            carro.setPlaca(placa);
            carro.setDono(dono);
            carro.setCnh(cnh);
            carro.setTelefone(telefone);
            carro.setEndereco(endereco);

            CarroDAO cdao = new CarroDAO();
            try {
                cdao.cadastrar(carro);
                request.setAttribute("msgSucesso", "Carro cadastrado com sucesso");
                List<Carro> lcarro = cdao.consultarTodos();
                request.setAttribute("lcarro", lcarro);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao cadastrar o novo carro");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }
        } else if (op.equals("Consultar Todos")) {

            List<Carro> lcarro = new ArrayList<>();

            CarroDAO cdao = new CarroDAO();
            try {
                lcarro = cdao.consultarTodos();
                request.setAttribute("msgSucesso", "Consulta de todos os carros bem sucedida");
                request.setAttribute("lcarro", lcarro);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao consultar a lista de carros");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }

        } else if (op.equals("Filtrar")) {

            int id = Integer.parseInt(request.getParameter("txtid"));

            Carro carro = new Carro();
            carro.setId(id);

            List<Carro> lcarro = new ArrayList<>();

            CarroDAO cdao = new CarroDAO();
            try {
                carro = cdao.consultarPorId(carro);
                if (carro.getDono() != null) {
                    lcarro.add(carro);
                    request.setAttribute("lcarro", lcarro);
                    request.setAttribute("msgSucesso", "Carro encontrado com sucesso");
                } else {
                    request.setAttribute("msgSucesso", "Carro não encontrado");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao filtrar por id");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }
        } else if (op.equals("Deletar")) {

            int id = Integer.parseInt(request.getParameter("txtid"));

            Carro carro = new Carro();
            carro.setId(id);

            CarroDAO cdao = new CarroDAO();
            try {
                cdao.deletar(carro);
                request.setAttribute("msgSucesso", "Carro deletado com sucesso");
                List<Carro> lcarro = cdao.consultarTodos();
                request.setAttribute("lcarro", lcarro);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao deletar");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }
        } else if (op.equals("Editar")) {

            int id = Integer.parseInt(request.getParameter("txtid"));

            Carro carro = new Carro();
            carro.setId(id);

            CarroDAO cdao = new CarroDAO();
            try {
                carro = cdao.consultarPorId(carro);
                request.setAttribute("carro", carro);
                request.getRequestDispatcher("tela_formularioeditar.jsp").forward(request, response);

            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao editar");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }

        } else if (op.equals("Atualizar")) {
            
            int id = Integer.parseInt(request.getParameter("txtid"));
            String marca = request.getParameter("txtmarca");
            String modelo = request.getParameter("txtmodelo");
            int ano = Integer.parseInt(request.getParameter("txtano"));
            String motor = request.getParameter("txtmotor");
            String placa = request.getParameter("txtplaca");
            String dono = request.getParameter("txtdono");
            String cnh = request.getParameter("txtcnh");
            String telefone = request.getParameter("txttelefone");
            String endereco = request.getParameter("txtendereco");

            Carro carro = new Carro();
            carro.setId(id);
            carro.setMarca(marca);
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setMotor(motor);
            carro.setPlaca(placa);
            carro.setDono(dono);
            carro.setCnh(cnh);
            carro.setTelefone(telefone);
            carro.setEndereco(endereco);

            CarroDAO cdao = new CarroDAO();
            
            try {
                cdao.atualizar(carro);
                request.setAttribute("msgSucesso", "Carro atualizado com sucesso");
                List<Carro> lcarro = cdao.consultarTodos();
                request.setAttribute("lcarro", lcarro);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("msgErro", "Falha ao atualizar");
                request.getRequestDispatcher("tela_erros.jsp").forward(request, response);
            }
        } else if (op.equals("Voltar")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
