# language: pt

Funcionalidade: Lista de importacoes

	Contexto: 
		Dado que tenha acessado a url "https://desafio-qa.herokuapp.com"
	  Quando a tela for carregada totalmente

	  	Cenario: Validar titulo da tela
				Entao deve ser exibido o titulo "Lista de importações da sua loja"
		   
		  Cenario: Validar valor total abaixo do titulo
				Entao deve ser exibido o valor total abaixo do titulo igual a "95,00"
					
			Cenario: Validar valor total acima da tabela
				Entao deve ser exibido o valor total acima da tabela igual a "95,00"
					
			Cenario: Validar o nome do comprador 
				Entao deve ser exibido o nome do comprador igual a "João Silva"
					
			Cenario: Validar a descricao do item
				Entao deve ser exibido a descricao do item igual a "R$10 off R$20 of food"
					
			Cenario: Validar o preco de um item
				Entao deve ser exibido o preco do item igual a "R$ 10,00"
					
			Cenario: Validar a quantidade de itens vendidos
				Entao deve ser exibido a quantidade de itens vendidos igual a '2'
					
			Cenario: Validar o valor total de itens vendidos por vendedor
				Entao deve ser exibido o valor total de itens vendidos do vendedor igual a "R$ 20,00"
					
			Cenario: validar nome do vendedor
				Entao deve ser exibido o nome do vendedor igual a "Bob's Pizza"
					
			Cenario: Validar endereço do vendedor
				Entao deve ser exibido o endereco do vendedor igual a "987 Fake St"