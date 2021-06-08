package Anuncios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AdicionarAnuncio {
        private WebDriver driver;  // Declarar o objeto Selenium WebDriver

        @Before
        public void iniciar() {
            // Apontamento do driver do Chrome
            System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver");
            driver = new ChromeDriver(); // Instanciando o objeto do Selenium
            driver.manage().window().setSize(new Dimension(1600, 833));
            driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        }

        @After
        public void finalizar() {
            //driver.quit();
        }

        @Test
        public void anuncios() {
            // acessando o site
            driver.get("https://demodirectory.com.br");

            // Clica no menun Papés do Site
            driver.findElement(By.cssSelector(".livebar-nav-item:nth-child(2) span")).click();
            driver.findElement(By.linkText("Administrador")).click();

            // Limpando as informações gravadas nos campos usuário e senha
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).clear();

            // Logando no site através de um usuário e senha
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).sendKeys("sitemgr@demodirectory.com");
            driver.findElement(By.id("password")).sendKeys("abc123");
            driver.findElement(By.cssSelector(".btn-primary")).click();

            // Acessando menu "Conteudo" e submenu "Anuncios" e botao "Adicionar anuncio"
            WebElement element = driver.findElement(By.cssSelector("#panel-listing span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
            driver.findElement(By.id("tour-content-menu")).click();
            driver.findElement(By.linkText("Anúncios")).click();
            driver.findElement(By.cssSelector(".btn-sm > span")).click();

            //Selecionar o Modelo de anuncio com a opcao "Empresa"
            driver.findElement(By.id("listingTemplate"));
            driver.findElement(By.id("listingTemplate")).sendKeys("Empresa");

            //Informar o nome do anúncio
            driver.findElement(By.id("listingTemplate")).click();
            driver.findElement(By.id("name")).click();
            driver.findElement(By.id("name")).sendKeys("Academia Saúde e Bem Estar");

            //Selecionar uma Categorias
            driver.findElement(By.id("browse-categories")).click();
            driver.findElement(By.cssSelector(".categories-item:nth-child(8) .fa")).click();

            //Salvar o anúncio
            driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
            }
        }
