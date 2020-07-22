# Configuração para executar o ambiente de teste


## Especificações para o projeto

- IDE Eclipse
- Java 8
- JUnit 4
- Selenium 3.4.0
- Maven
- Chrome

## Como executar

1- Importar o projeto no Eclipse como Maven Project

2- Abrir a classe "ListaImportacoesTest.java" -> Run As -> JUnit Test



# Relatório de erros econtrados


## Descrição dos erros que foram encontrados

1.	O valor do total bruto das importações que está logo a baixo do título da página está zerado.
2.	O valor total bruto das importações está incorreto.
3.	O título da coluna 2 da tabela, “Comprado”, está escrito errado.
4.	O título da coluna 3 da tabela, “Preco”, está escrito errado.
5.	O título da coluna 6 da tabela, “Nome vendendor”, está escrito errado.
6.	O título da coluna 7 da tabela, “Endereços vendedor”, está escrito errado.
7.	Os valores da coluna 5, “Total”, estão trocados com os valores da coluna 4, “Qtde.”.
8.	Os valores da coluna 5, “Total”, não estão sendo multiplicados corretamente com os valores do preço e quantidade.
9.	Os valores da coluna 6, “Nome vendendor”, estão trocados com os valores da coluna 7, “Endereços vendedor”.
10.	A formatação da coluna 5, “Total” está fora do padrão.

## Solução proposta para os erros encontrados

1.	O valor do total bruto das importações que está logo a baixo do título da página deveria ser o resultado do cálculo da soma de todos os valores totais das importações.
2.	O valor total bruto das importações deveria ser o resultado do cálculo da soma dos valores da coluna “Total” da tabela.
3.	O correto seria alterar o título da coluna 2 de “Comprado” para “Comprador”.
4.	O correto seria alterar o título da coluna 3 de “Preco” para “Preço”.
5.	O correto seria alterar o título da coluna 6 de “Nome vendendor” para “Nome vendedor”
6.	O correto seria alterar o título da coluna 7 de “Endereços vendedor” para “Endereço vendedor”.
7.	Os valores que estão na coluna 5, “Total”, deveriam estar na coluna 4, “Qtde.”, e os valore da coluna 4, “Qtde.”, deveriam estar na coluna 5, “Total”.
8.	O valor da coluna 4, “Total”, deveria ser o resultado da multiplicação da coluna 3, “Preço”, pela coluna 4, “Qtde.”.  
9.	Os valores que estão na coluna 6, “Nome vendendor”, deveriam estar na coluna 7, “Endereços vendedor”, e os valore da coluna 7, “Endereços vendedor”, deveriam estar na coluna 6, “Nome vendendor”.
10.	Na coluna 5, “Total”, os valores deveriam estar centralizados conforme estão nas outras colunas.

