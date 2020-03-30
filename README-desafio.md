# desafio-qa
Projeto sobre o desafio de qa 

* [Setup](#setup)
* [Bugs](#documentação)
* [Passo a passo](#passo-a-passo)
* [Visual regression](#visual-regression)

## Setup

Chromedriver

- Precisa realizar o download do Chromedriver. Caso não tenha o Chromedriver. No projeto estou usando o 78.0.0
> Caso precise alterar deverá ser alterado a versão em package.json 

## Bugs

Vá para o Trello  para encontrar a lista com [bugs](https://trello.com/b/CTacKMym/blu-board).

> No Trello temos 3 labels
> 1. Vermelho: BUG
> 2. Amarelo: Melhoria
> 3. Laranja: Dúvida
 
## Passo a passo

1. Clone o projeto
2. Abra o projeto no seu IDE, no terminal, execute o comando abaixo para instalar as dependências:
```shell script
npm install
```
3. Para realizar a execução dos testes execute o comando
```shell script
npm test
```
Após a execução do teste, será gerado um reporte em html. O caminho é indicado no console. Se preferir, acesse-o na pasta report/cucumber_report.html

Caso queira executar cenários específicos, você pode executar cenários passando a tag do cenário.
Ex: Se quiser executar somente o cenário com a tag

```gherkin
@title
Cenario: Validar titulo e total das vendas
```
Execute o comando abaixo:
```shell script
npm test -- --tags @title
``` 
## Visual regression

Coloquei um teste de visual regression.

A primeira vez que o teste executar ele vai salvar o screenshot como referência na pasta visual-reference.

Nas próximas execuções, caso ocorra alguma diferença de layout, será gerado uma imagem em png com a diferença. Acesse-a na pasta report-visual/visual-regression.

Nesta pasta terá 3 arquivos, imagem referência, imagem corrente e imagem diferença. Ex: Vendas-REFERENCE, Vendas-CURRENT, Vendas-DIFF