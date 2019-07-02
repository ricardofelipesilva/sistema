package br.com.site.dao;


import java.util.List;

import br.com.site.model.Produto;

import java.util.ArrayList;
import java.util.Iterator;
public class Banco {
	

	
	private static Integer chavePrimaria =1;
	
	public static List<Produto> produtos = new ArrayList<>();

	public void adicionar(Produto produto) {
		produto.setCodigo(chavePrimaria++);
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return Banco.produtos;
	}

	public void removerProduto(int codigo) {
		
		Iterator<Produto> it  = produtos.iterator();
		
		while(it.hasNext()) {
			Produto prod = it.next();
			if(prod.getCodigo() == codigo) {
				it.remove();
			}
		}

		
	}

	public Produto buscarProdutoPeloCodigo(int codigo) {
		for (Produto produto : produtos) {
			if(produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
		
	}

}
