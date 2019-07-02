package br.com.site.persistencia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.site.dao.Banco;

@WebServlet("/remover-produto")
public class RemoverProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramCodigo = request.getParameter("codigo");
		int codigo = Integer.valueOf(paramCodigo);
		System.out.println(codigo);
		
		Banco banco= new Banco();
		banco.removerProduto(codigo);
		
		response.sendRedirect("./listar");
	}

}
