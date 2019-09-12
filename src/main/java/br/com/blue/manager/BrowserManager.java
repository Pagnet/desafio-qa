package br.com.blue.manager;

import br.com.blue.browser.Browser;
import br.com.blue.report.ReportManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BrowserManager {

    private Browser browser;

    private SeleniumManager selenium = SeleniumManager.getInstance();

    public BrowserManager(Browser browser){
        this.browser = browser;
    }

    public FluentWait fluentWait(int timeout, int polling) {

        FluentWait<WebDriver> fluentWait = new FluentWait<>(this.browser.getWebDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);

        return fluentWait;
    }

    // ### Waits ###

    public void waitElementPresent(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selenium.By(by,element)));
    }

    public void waitElementDone(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.presenceOfElementLocated(selenium.By(by, element)));
        ClickableWait.until(ExpectedConditions.visibilityOfElementLocated(selenium.By(by, element)));

    }

    public void waitElementClicabel(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selenium.By(by, element)));
        ClickableWait.until(ExpectedConditions.visibilityOfElementLocated(selenium.By(by, element)));
        ClickableWait.until(ExpectedConditions.elementToBeClickable(selenium.By(by, element)));

    }

    public void waitElementInvisibility(String by, String element) {
        FluentWait ClickableWait = fluentWait(10, 2);
        ClickableWait.until(ExpectedConditions.invisibilityOfElementLocated(selenium.By(by, element)));
    }

    public void waitElementInvisibility(String by, String element,int timeout, int polling) {
        FluentWait ClickableWait = fluentWait(timeout, polling);
        ClickableWait.until(ExpectedConditions.invisibilityOfElementLocated(selenium.By(by, element)));
    }

    public void waitForPageLoad(String paginaAtual) {

        timeoutImplicityWait(15);
        Wait<WebDriver> wait = new WebDriverWait(this.browser.getWebDriver(), 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Status da Página " + paginaAtual + ": " + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void waitLodingElement(String by,String element) throws Exception {
        try {
            if (this.browser.getWebDriver().findElement(selenium.By(by,element)).isDisplayed()) {
                this.browser.getWebDriverWait(10).until(ExpectedConditions.invisibilityOf(this.browser.getWebDriver().findElement(selenium.By(by,element))));
            }
        } catch (RuntimeException e) {
            throw (e);
        }
    }

    // ## End Waits ##

    public double formataValor(double valorParaFormatar, int casasDecimais) {

        BigDecimal bd = new BigDecimal(valorParaFormatar);
        bd = bd.setScale(casasDecimais, BigDecimal.ROUND_HALF_DOWN);
        valorParaFormatar = bd.doubleValue();

        return valorParaFormatar;

    }

    public void changeFrame(String by, String element) throws Exception {

        try {
            timeoutImplicityWait(15);
            WebElement frame = this.browser.getWebDriver().findElement(selenium.By(by,element));
            this.browser.getWebDriver().switchTo().frame(frame);
        } catch (RuntimeException e) {
            throw (e);
        }

    }

    public void timeoutImplicityWait(int tempoEmSegundos) {

        this.browser.getWebDriver().manage().timeouts().implicitlyWait(tempoEmSegundos, TimeUnit.SECONDS);

    }

    public void selectValueReference(String by,String element, String valorSelecionadoNoTeste) throws Exception {

        try {
            List<WebElement> valorExtraido = this.browser.getWebDriver().findElements(selenium.By(by,element));
            int contador = valorExtraido.size();

            for (int i = 0; i < contador; i++) {
                String valor = valorExtraido.get(i).getAttribute("innerText");

                if (valor.contains(valorSelecionadoNoTeste)) {
                    valorExtraido.get(i).click();
                    break;
                }
            }
        } catch (RuntimeException e) {
            throw (e);
        }


    }

    public void selectValueDisplayed(String by,String element) throws Exception {

        try {

            List<WebElement> valorExtraido = this.browser.getWebDriver().findElements(selenium.By(by,element));
            int contador = valorExtraido.size();

            for (int i = 0; i < contador; i++) {

                if (valorExtraido.get(i).isDisplayed()) {
                    valorExtraido.get(i).click();
                    break;
                }

            }
        } catch (RuntimeException e) {
            throw (e);
        }
    }

    public String returnValueReference(String by,String element, String valorSelecionadoNoTeste, String valorInicialString, String valorFinalString) throws Exception {

        String retornaValor = null;

        try {

            List<WebElement> valorExtraido = this.browser.getWebDriver().findElements(selenium.By(by,element));
            int contador = valorExtraido.size();

            for (int i = 0; i < contador; i++) {
                String valor = valorExtraido.get(i).getText();

                if (valor.contains(valorSelecionadoNoTeste) && valorExtraido.get(i).isDisplayed()) {

                    retornaValor = valorExtraido.get(i).getText();
                    String tratarValor = retornaValor.substring(retornaValor.indexOf(valorInicialString), retornaValor.indexOf(valorFinalString));
                    String trataValor2 = tratarValor.replace(valorInicialString, "");
                    if (trataValor2.contains(",")) {
                        String tratar = trataValor2.replace(",", ".");
                        retornaValor = tratar;
                    } else {
                        retornaValor = trataValor2;
                    }
                    break;
                }

            }
        } catch (RuntimeException e) {
            throw (e);
        }

        return retornaValor;

    }

    public void compareElementInListIsEqual(String typeBy, String element, String messageSucess, String messageError, String valueCompare)throws  Exception{

        try{

            waitElementPresent(typeBy,element);
            List<WebElement> elementFind =  SeleniumManager.getInstance().findList(typeBy,element);
            int size =  SeleniumManager.getInstance().findList(typeBy,element).size();

            for (int i = 0; i < size ; i++){

                if(elementFind.equals(valueCompare)){

                    System.out.println(messageSucess);
                }
            }

        }
        catch(TimeoutException | NoSuchElementException e){
            ReportManager.getInstance().evidenceTestFail(messageError);
            System.out.println(messageError);
        }
    }

    public void verifyElementIsSelected(String typeBy, String element, String messageSucess, String messageError)throws  Exception{

        try{
            By elementBy = SeleniumManager.getInstance().By(typeBy,element);

            fluentWait(10,2).until(ExpectedConditions.visibilityOfElementLocated(elementBy));

            if(SeleniumManager.getInstance().findElement(typeBy, element).isSelected()){

                ReportManager.getInstance().evidenceTestSucess(messageSucess);
                System.out.println(messageSucess);

            }

        }
        catch(TimeoutException | NoSuchElementException e){
            ReportManager.getInstance().evidenceTestFail(messageError);
            System.out.println(messageError);
        }
    }

    public void verifyElementIsEnable(String typeBy, String element, String messageSucess, String messageError)throws  Exception{

        try{
            By elementBy = SeleniumManager.getInstance().By(typeBy,element);

            fluentWait(10,2).until(ExpectedConditions.visibilityOfElementLocated(elementBy));

            if(SeleniumManager.getInstance().findElement(typeBy, element).isSelected()){

                ReportManager.getInstance().evidenceTestSucess(messageSucess);
                System.out.println(messageSucess);

            }

        }
        catch(TimeoutException | NoSuchElementException e){
            ReportManager.getInstance().evidenceTestFail(messageError);
            System.out.println(messageError);
        }
    }

    public boolean isElementDisplayed(String typeBy, String element)throws  Exception{

        By elementBy = SeleniumManager.getInstance().By(typeBy,element);

        fluentWait(10,2).until(ExpectedConditions.visibilityOfElementLocated(elementBy));

        if(SeleniumManager.getInstance().findElement(typeBy, element).isDisplayed()) {

            return true;
        }
        else{
            return false;
        }

    }





}
