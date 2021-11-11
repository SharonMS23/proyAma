Feature: Navegar por Amazon

  @HaltAmazon1
  Scenario: Navegar por Pagina Amazon
  	Given que se ingrese a la pagina de Amazon
  	When el usuario busca zapatillas
  	And filtra por marca adidas
  	And el sistema visualiza los datos
  	
  @HaltAmazon2
  Scenario: Navegar por Pagina Amazon
  	Given que se ingrese a la pagina de Amazon
  	When el usuario busca zapatillas
  	And el usuario selecciona ordenar precio de mayor a menor
  	And el sistema visualiza los datos
  	
 	 @HaltAmazon3
  Scenario: Navegar por Pagina Amazon
  	Given que se ingrese a la pagina de Amazon
  	When el usuario busca zapatillas
  	And filtra por marca adidas
  	And el usuario quita el filtro
  	Then el sistema valida los datos
  	
   @HaltAmazon4
  Scenario: Navegar por Pagina Amazon
  	Given que se ingrese a la pagina de Amazon
  	When el usuario busca zapatillas
  	And filtra por marca adidas
  	And el sistema visualiza los datos
  	And el usuario selecciona ordenar precio de mayor a menor
  	And el sistema visualiza los datos
  	And el usuario quita el filtro
  	Then el sistema valida los datos