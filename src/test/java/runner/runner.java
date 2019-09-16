package runner;

import br.com.blue.app.DefaultApplicationInitializer;
import br.com.blue.report.ReportManager;
import br.com.blue.util.Globals;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/"},
        tags={"@test"},
        glue = {"steps"}
)
public class runner {

    @BeforeClass
    public static void inicializa() throws Exception {
        new DefaultApplicationInitializer();
        ReportManager.getInstance().generateReport("");
        ReportManager.getInstance().startTest("CaseTeste - Validações HeroukApp");

    }


    @AfterClass
    public static void finalizaTest() {

        ReportManager.getInstance().closeReport();
        Globals.browser.close();
    }
}
