/**
		 * @author Ricardo
		 * Classe respons�vel pelo cria��o de objetos de conex�o.
		 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname;
	private int port;
	private String database;
	private String username;
	private String password;
	
	private Connection connection;
	
	/**
	 * M�todo para conectar
	 * 
	 *Conex�o com o banco de dados
	 *
	 *Cont�m um tratamento de exce��es.
	 *
	 */
	
	public DataSource() {
		
		try {
			hostname = "localhost";
			port = 3306;
			database = "supermil";
			username = "root";
			password = "123456";
			
			String url = "jdbc:mysql://"+ hostname + ":"+port+"/"+database+"?useTimezone=true&serverTimezone=UTC";
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection(url,username,password);
			
//			System.out.println("Conectou!");
		} catch (SQLException ex) {
			System.err.println("Erro na conexao" + ex.getMessage());
		}catch(Exception ex) {
			System.err.println("Erro geral" + ex.getMessage());
		}
	}
	
	/** M�todo solicitar a conexao
	 *@return Connection connection
	 */
	
	public Connection getConnection() {
		
		return this.connection;
	}
	
	/** M�todo fechar a conexao
	 *	
	 */
	
	public void closeDataSource() {
		try {
			connection.close();
//			System.out.println("Conex�o encerrada!");
		} catch (Exception ex) {
			System.err.println("Erro ao desconectar" + ex.getMessage());
		}
	}
}
