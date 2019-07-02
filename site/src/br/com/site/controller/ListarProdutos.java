package br.com.site.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.site.dao.Banco;
import br.com.site.model.Produto;

@WebServlet("/listar")
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Produto> lista = banco.getProdutos();
		
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/listarProdutos.jsp");
		
		rd.forward(request, response);
		
	}

}
