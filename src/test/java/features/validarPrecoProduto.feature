# language: pt
@test
Funcionalidade: Estes casos de testes descrevem as validações realizadas  no sistema Lista de Importações.

    Esquema do Cenário: Validar Preco do Produto
      Dado usuario acessar o sistema Lista de Importacoes
      Entao sera feita a validacao de todos os precos dos produtos do sistema "<NomeComprador>"

       Exemplos:
         | NomeComprador|
         |João Silva    |
         |Amy Pond      |
         |Marty McFly   |
         |Snake Plissken|

