/**
 * Classe para objetos do tipo Produto, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author Ricardo
 * @version 1.0
 * 
 */

package model;

import java.sql.Date;

public class Produto {
	
	private Integer codigo;
	private String nome;
	private Float valor;
	private Date validade;
	private Integer estoque;
	private Integer categoria;
	
	
	 /** 
	  * M�todo para recuperar o c�digo do produto.
	  * @return Integer com o codigo do produto.
	  * */
	
	public Integer getCodigo() {
		return codigo;
	}
	
	 /** 
	 * M�todo para defini��o do c�digo do produto.
	 * @param codigo C�digo do produto.
	 * */
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	 /** 
	  * M�todo para recuperar do nome do produto.
	  * @return String com o nome do produto.
	  * */
	public String getNome() {
		return nome;
	}
	
	/** 
	  * M�todo para defini��o do nome do produto.
	  * 
	  * @param nome Nome do produto
	  * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	 /** 
	  * M�todo para recuperar o valor do produto.
	  * @return Float com o valor.
	  * */
	
	public Float getValor() {
		return valor;
	}
	
	 /** 
	 * M�todo para defini��o do valor do produto
	 * @param  valor valor do produto (pre�o)
	 * */
	
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	 /** 
	  * M�todo para recuperar a data do produto.
	  * @return Date com a data de validade no formato yyyy-MM-aa
	  * */
	
	
	public Date getValidade() {
		return validade;
	}
	
	 /** 
	 * M�todo para defini��o da data de validade do produto no  formato <b> yyyy-MM-aa </b>
	 * @param  validade a data de validade passada com o tipo Date que precisa ser importado do sql.
	 * */
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	 /** 
	  * M�todo para recuperar a quantidade em produto.
	  * @return Integer com a quantidade
	  * */
	
	public Integer getEstoque() {
		return estoque;
	}
	
	 /** 
	 * M�todo para defini��o da quantidade em estoque do produto
	 * @param  estoque Numero que cont�m em estoque.
	 * */
	
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	 /** 
	  * M�todo para recuperar a categoria produto.
	  * @return Integer com o numero relativo a categoria <b> ex: 1 � Proteina 2 � Latic�nios 3 � de Limpeza e 4 s�o carnes </b>
	  * */
	
	public Integer getCategoria() {
		return categoria;
	}
	
	 /** 
	 * M�todo para defini��o da categoria do produto.
	 * @param categoria com o numero relativo a categoria.
	 * */
	
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
	
}
