import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Accessories.feature",
        tags = " @DesignerSearch",
        plugin = "json:target/cucumbner.json",
        //glue = "src/test/java/com/accessoryStepDef/StepDefinitionForAccessories",
        dryRun = false

)


public class AccessoryRunTest {





}
