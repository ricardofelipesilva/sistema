<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>

<title>Mil Tecnologia | Editar Produto</title>

<meta charset="ISO-8859-1">
<link rel="shortcut icon" type="image/png" href="/img/favicon.png"/>
<!-- ################## Cabe�alho da p�gina ##########################  -->

<c:import url="views/topo.jsp" />  

<!-- ################## fim do Cabe�alho da p�gina ###################  -->	
	


	
	<form action="./mudar-dados" method="post">
		  <h2>Cadastrar Produto:</h2>
		  <div class="col-auto my-1 form-group">
		    <label for="exampleInputEmail1">Nome do Produto:</label>
		    <input  class="form-control" type="text" name="nome" value="${produto.nome}" placeholder="${produto.nome}" required>
		  </div>
		
		  <div class=" col-auto my-1 form-group">
		    <label for="exampleInputEmail1">Valor:</label>
		    <input  class="form-control" type="text" name="valor" value="${produto.valor}"  placeholder="${produto.valor}" />
		  </div>
		  
		  
		  <div class=" col-auto my-1 form-group">
		    <label for="exampleInputEmail1">Quantidade Em Estoque:</label>
		    <input  class="form-control" type="text" name="quantidadeEstoque" value="${produto.quantidadeEstoque}"  placeholder="${produto.quantidadeEstoque}" />
		  </div>
		  
		  <div class=" col-auto my-1 form-group">
		    <label for="exampleInputEmail1">Data De Validade:</label>
		    <input  class="form-control" type="text" name="dataValidade" value='<f:formatDate value="${produto.dataValidade}" />' placeholder='<f:formatDate value="${produto.dataValidade}" />'/>
		  </div>
		  
		   <div class="col-auto my-1">
		  	 <label class="mr-sm-2 " for="inlineFormCustomSelect">Escolha Uma Categoria:</label>
		     <select readonly="readonly" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="categoria">
		       <option selected value="${produto.categoria}">Categorias:</option>
		       <option value="1" >Prote�nas</option>
		       <option value="2">Latic�nios</option>
		       <option value="3">Limpeza</option>
		       <option value="4">Carnes</option>
		      </select>
		    </div>
		 <div class=" col-auto my-1 form-group">
		 	<input type="hidden" name="cod" value="${produto.codigo}"/>
		  <button type="submit" class="btn_enviar btn btn-primary ">CADASTRAR</button>
		  </div>
	</form>
	

</body>
</html>