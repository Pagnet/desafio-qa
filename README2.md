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

mvn package -Dbrowser=CHROME -DpathDriver=/path/to/browser_driver

Possíveis parametros para inicialização

-Dbrowser = CHROME ( nó momento com suporte apenas para o chrome )
-DpathDriver = Caminho do driver correspondente ao browser

# DefaultApplicationInitializer: Inicia o framework.
new DefaultApplicationInitializer();


# Globals: Fornece acesso ao objeto do browser e browser manager.

Globals.browser.setURL("https://www.google.com.br/");
Globals.browserManager.waitElementPresent(TypeSelector.CSSSELECTOR.getTypeSelector(),"element");


# Selenium :  Fronece acesso ao objeto Selenium e Selenium manager

SeleniumManager.getInstance().clickElement(TypeSelector.CLASSNAME.getTypeSelector(), "String com o Elemento");

# ReportManager: Gera relatório de execução dos testes.

ReportManager.getInstance().generateReport("");
ReportManager.getInstance().startTest("Gerar cadastro");
ReportManager.getInstance().evidenceTestFail("CurrentTest", "Mensagem", Globals.browser.getWebDriver());
ReportManager.getInstance().endTestReport();
ReportManager.getInstance().flushReport();