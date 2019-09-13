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
            features = {"src/test/java/features/caseTests.feature"},
            tags="@test",
            glue = {"steps/caseTests.java"}

    )
    public class runner {

        @BeforeClass
        public static void inicializa() throws Exception {
            new DefaultApplicationInitializer();
            ReportManager.getInstance().generateReport("Testes Desafio QA");
        }



        @AfterClass
        public static void finalizaReport() {
            Globals.browser.close();
        }


}
