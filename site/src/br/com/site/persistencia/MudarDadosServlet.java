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

@WebServlet("/mudar-dados")
public class MudarDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String nomeProduto = request.getParameter("nome");
		String paramCodigo = request.getParameter("cod");
		int codigoProduto = Integer.valueOf(paramCodigo);
		
		String paramValor = request.getParameter("valor");
		Float valorProduto = Float.valueOf(paramValor);
		
		String paramEstoque = request.getParameter("quantidadeEstoque");
		Integer estoqueProduto = Integer.valueOf(paramEstoque);
		
		String paramCategoria = request.getParameter("categoria");
		Integer categoriaProduto = Integer.valueOf(paramCategoria);
		
		Banco banco = new Banco();
		Date dataValidadeProduto = null;
		if( request.getParameter("dataValidade") != "" ) {
			String paramDataValidade = request.getParameter("dataValidade");
			
			
			try {
			 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataValidadeProduto = sdf.parse(paramDataValidade);
			} catch (ParseException e) {
				
				throw new ServletException(e);
			}
			
			
		}
		
		

		
		Produto produto = banco.buscarProdutoPeloCodigo(codigoProduto);
		produto.setNome(nomeProduto);
		
		produto.setValor(valorProduto);
		
		produto.setQuantidadeEstoque(estoqueProduto);
		
		produto.setCategoria(categoriaProduto);
		
		produto.setDataValidade(dataValidadeProduto);
		
		response.sendRedirect("./listar");

	}

}
