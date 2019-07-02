/**
 * Classe para instanciar Objeto  de acesso aos dados do banco.
 * @author Ricardo
 * @version 1.0
 * 
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

public class ProdutoDAO {
	/**
	 * Ultiliza a Classe Produto para criar os objetos.
	 * Ultiliza o DataSource para acessar o banco de dado.
	 */
	
	private DataSource dataSource;
	/**
	 * Cria o acesso ao banco
	 * 
	 * @param dataSource Um objeto de conex�o da classe DataSource
	 */
	public ProdutoDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public ArrayList<Produto> realAll(int categoria){
		/**
		 * @author Ricardo
		 * Exibe todos os dados que contem no banco de dado ou filtra pela categoria
		 * @return ArrayList<Produto>
		 * @param categoria
		 */
		if(categoria == 0) {
			try {
				String sql = "Select * from produtos ";
				PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				ArrayList<Produto> lista = new ArrayList<Produto>();
				while(rs.next()) {
					Produto produto = new Produto();
					
					produto.setCodigo(rs.getInt("codigo"));
					produto.setNome(rs.getString("nome"));
					produto.setCategoria(rs.getInt("categoria"));
					produto.setValor(rs.getFloat("valor"));
					produto.setEstoque(rs.getInt("quantidade_estoque"));
					produto.setValidade(rs.getDate("validade"));
					
					lista.add(produto);
				}
				
				ps.close();
				
				return lista;
			}catch (SQLException ex) {
				System.err.println("Erro ao recuperar " + ex.getMessage());
			}
			catch (Exception ex) {
				System.err.println("Erro geral ao recuperar " + ex.getMessage());
			}
			
			return null;
		}
			
		else {
		try {
			String sql = "Select * from produtos where categoria = " + categoria;
			PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setCategoria(rs.getInt("categoria"));
				produto.setValor(rs.getFloat("valor"));
				produto.setEstoque(rs.getInt("quantidade_estoque"));
				produto.setValidade(rs.getDate("validade"));
				
				lista.add(produto);
			}
			
			ps.close();
			
			return lista;
		}catch (SQLException ex) {
			System.err.println("Erro ao recuperar " + ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral ao recuperar " + ex.getMessage());
		}
		
		return null;
	}
		
	
		
	}
	
	public void cadastrarProduto(Produto produto) {
		/**
		 * @author Ricardo
		 * Cadastra um produto
		 * @param Produto
		 */
		try {
			
			
			
			String sql = "INSERT INTO `supermil`.`produtos` (`nome`,`valor`,`categoria`,`quantidade_estoque`,`validade`)VALUES(?,?,?,?,?)";
			PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setFloat(2, produto.getValor());
			ps.setInt(3, produto.getCategoria());
			ps.setInt(4, produto.getEstoque());
			ps.setDate(5, produto.getValidade());
			
			ps.executeUpdate();
			ps.close();
			
			
			
			System.out.println(produto.getNome() + " inserido com sucesso!");
			
			
		}catch (SQLException ex) {
			System.err.println("Erro ao recuperar " + ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral ao recuperar " + ex.getMessage());
		}
	
	}
	
	public void editarProduto(int codigo) {
		/**
		 * @author Ricardo
		 * Exibe Edita um produto
		 * @param codigo
		 */
		try {
			Scanner sc = new Scanner(System.in);
			String deseja;
			
			
			System.out.println("Deseja mudar o nome? (S/N)");
				
				deseja =  sc.nextLine();
				
				switch(deseja){
				case "s":
				case "S":
					
						System.out.println("Qual o novo nome?");
						String novoNome = sc.nextLine();
						String sql = "UPDATE `supermil`.`produtos` SET `nome` = '" + novoNome + "' WHERE `codigo` = " + codigo;
					
						PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						ps.close();
			
					break;
				}
				
				System.out.println("Deseja mudar o valor? (S/N)");
				
				deseja =  sc.nextLine();
				
				switch(deseja){
				case "s":
				case "S":
					
						System.out.println("Qual o novo valor?");
						Float novoValor = Float.valueOf(sc.nextLine());
						String sql = "UPDATE `supermil`.`produtos` SET `valor` = '" + novoValor + "' WHERE `codigo` = " + codigo;
						
						PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						ps.close();
			
					break;
				}
				
				
				System.out.println("Deseja mudar a categoria? (S/N)");
				
				deseja =  sc.nextLine();
				
				switch(deseja){
				case "s":
				case "S":
					
						System.out.println("Qual a nova categoria? 1- Prote�nas | 2- Laticinios | 3- Limpeza | 4- Carnes");
						Integer novoValor = Integer.valueOf(sc.nextLine());
						String sql = "UPDATE `supermil`.`produtos` SET `categoria` = '" + novoValor + "' WHERE `codigo` = " + codigo;
						
						PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						ps.close();
			
					break;
				}
				
				System.out.println("Deseja mudar a quantidade no estoque? (S/N)");
				
				deseja =  sc.nextLine();
				
				switch(deseja){
				case "s":
				case "S":
					
						System.out.println("Quantos itens h� no estoque?");
						Integer novoValor = Integer.valueOf(sc.nextLine());
						String sql = "UPDATE `supermil`.`produtos` SET `quantidade_estoque` = '" + novoValor + "' WHERE `codigo` = " + codigo;
						
						PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						ps.close();
			
					break;
				}
				
				System.out.println("Deseja mudar a data de validade? (S/N)");
				
				deseja =  sc.nextLine();
				
				switch(deseja){
				case "s":
				case "S":
					
						System.out.println("Quantos a nova data? ex: 2019-07-02");
						Date novoValor = Date.valueOf(sc.nextLine());
						String sql = "UPDATE `supermil`.`produtos` SET `validade` = '" + novoValor + "' WHERE `codigo` = " + codigo;
						
						PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
						ps.executeUpdate();
						ps.close();
			
					break;
				}
				
			

			
			
		}catch (SQLException ex) {
			System.err.println("Erro ao recuperar " + ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral ao recuperar " + ex.getMessage());
		}
	
	}
	
	
	
	public void apagarProduto(int codigo) {
		/**
		 * @author Ricardo
		 * Remove um produto
		 * @param codigo
		 */
		try {
			
			String sql = "DELETE FROM `supermil`.`produtos`WHERE codigo = " + codigo;
			PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("O item de c�digo " + codigo + " foi apagado com sucesso!");
			
			
		}catch (SQLException ex) {
			System.err.println("Erro ao recuperar " + ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("Erro geral ao recuperar " + ex.getMessage());
		}
	}
}

