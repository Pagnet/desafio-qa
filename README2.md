Projeto

Desafio de QA

Especificação:

- Java 8
- Junit 4
- Selenium 3
- Maven
- IDE utilizada para gerar este projeto Intellij IDEA
- Rest Assured - API

# Modo de usar

mvn package -Dbrowser=CHROME -DpathDriver=/path/to/browser_driver -Denvironment=PRD

Possíveis parametros para inicialização

-Dbrowser = CHROME ( nó momento com suporte apenas para o chrome )
-DpathDriver = Caminho do driver correspondente ao browser
--Denvironment= ambiente em que se esta realizando o teste

# Finalizando Teste

Sera gerado um report em src/main/reportTesting em .html com os dados dos testes automatizados UI.