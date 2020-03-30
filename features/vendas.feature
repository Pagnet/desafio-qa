#language:pt

Funcionalidade: : Validar página de vendas

Eu quero validar as informações da página de vendas da minha loja

  @title
  Cenario: Validar titulo e total das vendas

    Quando Eu acesso a página de vendas
    Então devo visualizar o titulo "Lista de importações da sua loja"
    E devo visualizar o valor total de "TOTAL BRUTO DAS IMPORTAÇÕES R$190,00"

  @visual
  Cenario: Validar layout

    Quando Eu acesso a página de vendas
    Então Eu pego screenshot da pagina "Vendas"
    E Eu espero a página de "Vendas" ter o mesmo layout

  @outline
  Esquema do Cenario: Validar valores da tabela

    Quando Eu acesso a página de vendas
    Então devo visualizar os valores "<vendedor>" "<descricao>" "<quantidade>" "<preco>" "<total>" "<comprador>" "<endereco>" "<linha>"

    Exemplos:
      | vendedor      | descricao                   | quantidade  | preco       | total     | comprador                 | endereco       | linha |
      | João Silva	  | R$10 off R$20 of food		| 4	          | R$ 10,00	| R$ 40,00	| Bob's Pizza				| 987 Fake St	 | 2     |
      | Amy Pond	  | R$30 of awesome for R$10	| 10          | R$ 10,00	| R$ 100,00	| Tom's Awesome Shop		| 456 Unreal Rd  | 3     |
      | Marty McFly	  | R$20 Sneakers for R$5		| 2	          | R$ 5,00	    | R$ 10,00	| Sneaker Store Emporium	| 123 Fake St	 | 4     |
      | Snake Plissken| R$20 Sneakers for R$5		| 8	          | R$ 5,00	    | R$ 40,00	| Sneaker Store Emporium	| 123 Fake St	 | 5     |

