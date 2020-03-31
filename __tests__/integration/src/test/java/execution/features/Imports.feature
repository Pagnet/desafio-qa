# language: pt
# encoding: UTF-8
Funcionalidade: Listagem de Importacoes
    Listagem que exibe informacoes sobre as importacoes realizadas pela empresa

  Cenario: Verificar abertura do site
    Dado que acesso ao site 'https://desafio-qa.herokuapp.com/'
    Então o site exibir corretamente o cabecalho da pagina

  Cenario: Verificar totalizadores de importacoes
    Dado que acesso a o site 'https://desafio-qa.herokuapp.com/'
    Então deve exibir corretamente os Totalizadores das Importacoes

  Cenario: Verificar titulos da tabela de importacoes
    Dado que acesso a o site 'https://desafio-qa.herokuapp.com/'
    Então deve exibir corretamente os titulos da tabela de importacoes
      | titulo             |
      | Descrição          |
      | Preço              |
      | Qtde.              |
      | Total              |
      | Nome vendedor      |
      | Endereços vendedor |

  Cenario: Verificar informacoes da tabela de importacoes
    Dado que acesso a o site 'https://desafio-qa.herokuapp.com/'
    Então deve exibir corretamente as informacoes de venda na tabela de importacoes
      | Descricao               | Preco   | Qtde. | Total    | Nome vendedor          | Enderecos vendedor |
      | 2 Sneakers for R$100,00 | R$50,00 |     2 | R$100,00 | Sneaker Store Emporium | 987 Fake St        |