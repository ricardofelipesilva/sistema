package br.com.site.persistencia;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.site.dao.Banco;
import br.com.site.model.Produto;



@WebServlet("/novoproduto")

public class NovoProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProduto = request.getParameter("nome");
		
		String paramValor = request.getParameter("valor");
		Float valorProduto = Float.valueOf(paramValor);
		
		String paramEstoque = request.getParameter("quantidadeEstoque");
		Integer estoqueProduto = Integer.valueOf(paramEstoque);
		
		String paramCategoria = request.getParameter("categoria");
		Integer categoriaProduto = Integer.valueOf(paramCategoria);
		
		Banco banco = new Banco();
		Produto produto = new Produto();
		
		if( request.getParameter("dataValidade") != "" ) {
			String paramDataValidade = request.getParameter("dataValidade");
			Date dataValidade = null;
			
			try {
			 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataValidade = sdf.parse(paramDataValidade);
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			
			produto.setDataValidade(dataValidade);
		}
		
		produto.setNome(nomeProduto);
		
		produto.setValor(valorProduto);
		
		produto.setQuantidadeEstoque(estoqueProduto);
		
		produto.setCategoria(categoriaProduto);
		
		banco.adicionar(produto);
		
		response.sendRedirect("listar");

	}
	

}

