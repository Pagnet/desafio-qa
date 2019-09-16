package br.com.blue.report;

import br.com.blue.factory.PropertiesFactory;
import br.com.blue.util.PathUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {

    private static ReportManager reportManager = new ReportManager();

    private ReportManager(){

    }

    public static ReportManager getInstance(){
        return ReportManager.reportManager;
    }

    public ExtentTest extentTest;
    public String extentReportFile;
    public ExtentReports extent;
    public String extensionFile = ".jpg";
    public String nameFile = "Report_";

    String nomeProjeto = PropertiesFactory.getProp().getProperty("prop.nameProject");

    public void generateReport(String currentTest) {
        File extentReportFile1 = new File(PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.pathReportFile")));
        Date data = new Date();
        SimpleDateFormat formatdata = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        String dataFormatada = formatdata.format(data);

        if (!extentReportFile1.exists()) {
            extentReportFile1.mkdirs();
        }

        extentReportFile = extentReportFile1 + "/" + "Report_" + nomeProjeto + currentTest + "_" + dataFormatada + ".html";
        extent = new ExtentReports(extentReportFile, false);
        Path caminhoExtenteConfig = Paths.get(PropertiesFactory.getProp().getProperty("prop.pathExtentConfig"));
        extent.loadConfig(new File(String.valueOf(caminhoExtenteConfig)));
    }

    public void evidenceTestFail(String currentTest, String detailsFailed, WebDriver driver) {
        String screenshotImagensErro = generateEvidenceReport(currentTest, driver,"erro");
        extentTest.log(LogStatus.INFO, "Error Snapshot : " + extentTest.addScreenCapture(screenshotImagensErro));
        extentTest.log(LogStatus.FAIL, "ERRO - " + detailsFailed);
    }

    public void evidenceTestSucess(String currentTest, String detailsPass, WebDriver driver) {
        String screenshotImagens = generateEvidenceReportSucess(currentTest, driver,"sucesso");
        extentTest.log(LogStatus.INFO, "Snapshot : " + extentTest.addScreenCapture(screenshotImagens));
        extentTest.log(LogStatus.PASS, "PASS - " + detailsPass);
    }

    public void evidenceTestInfo(String currentTest, String detailsInfo, WebDriver driver) {
        String screenshotImagens = generateEvidenceReport(currentTest, driver,"sucesso");
        extentTest.log(LogStatus.INFO, "Snapshot : " + extentTest.addScreenCapture(screenshotImagens));
    }

    public void evidenceTestSucess(String detailsPass) {

        extentTest.log(LogStatus.PASS, "PASS - " + detailsPass);
    }

    public void evidenceTestFail( String detailsFailed) {
        extentTest.log(LogStatus.FAIL, "ERRO - " + detailsFailed);
    }

    public void evidenceTestInfo( String detailsInfo) {
        extentTest.log(LogStatus.INFO, "INFO - " + detailsInfo);
    }

    public void endTestReport() {
        System.out.println("#### Escrevendo no report o teste corrente ####");
        extent.endTest(extentTest);
    }

    public void flushReport() {
        System.out.println("#### Escrevendo no report o teste corrente ####");
        extent.flush();
    }

    public void closeReport() {
        System.out.println("#### Fechando report ####");
        extent.close();
    }

    public String generateEvidenceReport(String currentTest, WebDriver driver, String statusTest) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File pathreporterror = new File(PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.getPathReportError")));
            File pathreportpass = new File(PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.getPathReportSucess")));

            if (!pathreporterror.exists() && !pathreportpass.exists()) {
                pathreporterror.mkdirs();
                pathreportpass.mkdirs();
            }

            String nomeArquivo = nameFile+currentTest+"_"+dateFormat()+extensionFile;

            String destinoFinal = pathFile(statusTest,nomeArquivo);

            FileUtils.copyFile(screenshot, new File(destinoFinal));

            return destinoFinal;
        } catch (Exception ex) {
            throw new RuntimeException("Erro na geracao do Screenshot do report", ex);
        }
    }

    public String generateEvidenceReportSucess(String currentTest, WebDriver driver, String statusTest) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File pathreportpass = new File(PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.getPathReportSucess")));

            if (!pathreportpass.exists()) {
                pathreportpass.mkdirs();
            }

            String nomeArquivo = nameFile+currentTest+"_"+dateFormat()+extensionFile;

            String destinoFinal = pathFile(statusTest,nomeArquivo);

            FileUtils.copyFile(screenshot, new File(destinoFinal));

            return destinoFinal;
        } catch (Exception ex) {
            throw new RuntimeException("Erro na geracao do Screenshot do report", ex);
        }
    }

    public String dateFormat(){
        Date data = new Date();
        SimpleDateFormat formatdata = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String dataFormatada = formatdata.format(data);
        data.getTime();

        return dataFormatada;
    }

    public String pathFile(String statusTest, String nomeArquivo){
        String destinoFinal= null;

        if(statusTest.equals("erro")) {
            destinoFinal = PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.getPathReportError")) + "/" + nomeArquivo;
        }
        else {
            destinoFinal = PathUtils.getPath(PropertiesFactory.getProp().getProperty("prop.getPathReportSucess")) + "/" + nomeArquivo;
        }
        return destinoFinal;
    }

    public void startTest(String testName){
        this.extentTest = this.extent.startTest(testName);
    }

}
