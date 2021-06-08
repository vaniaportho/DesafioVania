package steps;

import cucumber.api.CucumberOptions;
//Api de integração cucumber x junit
//Roda classe runner se comunicando com a classe cucumber (steps)
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//Ordenação das sequencias que os testes serão executados
@RunWith(Cucumber.class)
@CucumberOptions(
        features   = "src/test/resources/features",
        glue       = "steps",
        dryRun     = true,
        monochrome = true,
        plugin     =  {
                "prety",
                "html:target/extentsreport",//saida
                "json:target/extentsreport.json",//saida
                "com.cucumber.listener.ExtentCucumberFormatter:target/extentreports/relatorio01.html"
        }
)
public class Runner {

}