# language: pt
@test
Funcionalidade: Estes casos de testes descrevem as validações realizadas  no sistema Lista de Importações.

    Esquema do Cenário: Validar Valor Total do Produto
      Dado usuario acessar o sistema Lista de Importacoes
      Entao sera feita a validacao dos valores totais de cada compra realizada por cada comprador no sistema "<NomeComprador>"

       Exemplos:
         | NomeComprador|
         |João Silva    |
         |Amy Pond      |
         |Marty McFly   |
         |Snake Plissken|