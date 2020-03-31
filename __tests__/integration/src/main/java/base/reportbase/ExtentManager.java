package base.reportbase;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    static ExtentReports extent;
    
    public static ExtentReports getInstance() {
        return extent;
    }
    
    public static ExtentReports createInstance(String productName, String analysisStrategy, String outputReport) {
    	AnalysisStrategy strategy;
    	
    	switch (analysisStrategy.toLowerCase()) {
    	case "test":
    		strategy = AnalysisStrategy.TEST;
    		break;
    	case "bdd":
    		strategy = AnalysisStrategy.BDD;
    		break;
		default:
    		strategy = AnalysisStrategy.SUITE;
    		break;
    	}
    	
        try {
        	ExtentHtmlReporter reporter = new ExtentHtmlReporter(outputReport);
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setDocumentTitle(productName + " Report Automation");
            reporter.config().setEncoding("utf-8");
            reporter.config().setReportName(productName +"Report Automation");
            reporter.config().enableTimeline(false);

            extent = new ExtentReports();
            extent.setAnalysisStrategy(strategy);
            extent.attachReporter(reporter);
        } catch (Exception e) {
        	System.out.println("Erro ao tentar instanciar o relatório: " + e);
        }
        
        
        return extent;    
    }   
}
