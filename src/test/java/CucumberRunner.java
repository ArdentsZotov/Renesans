import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resourse",
        glue = "ru.rencredit.autotest",
        tags = "@Deposit",
        plugin = "ru.rencredit.autotest.Utils.AllureReporter"//,
      //  snippets = SnippetType.CAMELCASE
)
public class CucumberRunner {
}

