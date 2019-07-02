package br.com.site.persistencia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.site.dao.Banco;
import br.com.site.model.Produto;

@WebServlet("/editar-produto")
public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramCodigo = request.getParameter("codigo");
		int codigo = Integer.valueOf(paramCodigo);
		
		Banco banco = new Banco();
		
		Produto produto = banco.buscarProdutoPeloCodigo(codigo);

		request.setAttribute("produto", produto );
		RequestDispatcher rd = request.getRequestDispatcher("/controle-produto.jsp");
		rd.forward(request, response);
	}

}
