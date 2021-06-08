package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks extends Base {
    private Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver");
        base.driver = new ChromeDriver(); // Instanciando o objeto do Selenium
        base.driver.manage().window().setSize(new Dimension(1600, 833));
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        System.out.println("Passo 0 - Instanciou o Selenium");
    }

    @After
    public void finalizar(){
        //base.driver.quit();
        //System.out.println("Passo 17 - Destruiu o Selenium");
    }
}