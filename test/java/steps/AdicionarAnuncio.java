package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdicionarAnuncio extends Base {

    private Base base;
    public AdicionarAnuncio(Base base) {
        this.base = base;
    }

    @Dado("^que acesso o site demodirectory$")
    public void queAcessoOSiteDemodirectory() {
        base.driver.get(base.url);
        System.out.println("Passo 1 - Acesso o site demodirectory");
    }

    @E("^clica no menu \"([^\"]*)\"$")
    public void clicaNoMenu(String Administrador) {
        base.driver.findElement(By.cssSelector(".livebar-nav-item:nth-child(2) span")).click();
        base.driver.findElement(By.linkText("Administrador")).click();
        System.out.println("Passo 2 - E clica no menu" + Administrador);
    }

    @E("^na tela de login limpa as informacoes gravadas nos campos \"([^\"]*)\" e \"([^\"]*)\"$")
    public void naTelaDeLoginLimpaAsInformacoesGravadasNosCamposE(String email, String senha)  {
        base.driver.findElement(By.id("username")).click();
        base.driver.findElement(By.id("username")).clear();
        base.driver.findElement(By.id("password")).click();
        base.driver.findElement(By.id("password")).clear();
        System.out.println("Passo 3 - Na tela de login limpa as informacoes gravadas nos campos" + email + " e " + senha);
    }

    @Então("^informa nos campos o email \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void informaNosCamposOEmailESenha(String email, String senha)  {
        base.driver.findElement(By.id("username")).click();
        base.driver.findElement(By.id("username")).sendKeys("sitemgr@demodirectory.com");
        base.driver.findElement(By.id("password")).sendKeys("abc123");
        base.driver.findElement(By.cssSelector(".btn-primary")).click();
        System.out.println("Passo 4 - Informa nos campos email " + email + " e senha " + senha);
    }

    @E("^em seguida clica no botao \"([^\"]*)\"$")
    public void emSeguidaClicaNoBotao(String Entre)  {
        base.driver.findElement(By.cssSelector(".btn-primary")).click();
        System.out.println("Passo 5 - Em seguida clica no botao " + Entre);
    }

    @E("^no menu lateral clica em \"([^\"]*)\" e em seguida em \"([^\"]*)\"$")
    public void noMenuLateralClicaEmEEmSeguidaEm(String Conteudo, String Anuncios)  {
        WebElement element = base.driver.findElement(By.cssSelector("#panel-listing span"));
        Actions builder = new Actions(base.driver);
        builder.moveToElement(element).perform();
        base.driver.findElement(By.id("tour-content-menu")).click();
        base.driver.findElement(By.linkText("Anúncios")).click();
        System.out.println("Passo 6 - no menu lateral clica em " + Conteudo + " e em seguida em "  + Anuncios);
            }

    @Entao("^na tela de inclusao clica no botao \"([^\"]*)\"$")
    public void naTelaDeInclusaoClicaNoBotao(String botao)  {
        driver.findElement(By.cssSelector(".btn-sm > span")).click();
        System.out.println("Passo 7 - Na tela de inclusao clica no botao " + botao);
    }

    @E("^ao abrir a tela seleciona no campo Modelo de anuncio a opcao \"([^\"]*)\"$")
    public void aoAbrirATelaSelecionaNoCampoModeloDeAnuncioAOpcao(String opcao)  {
        base.driver.findElement(By.id("listingTemplate"));
        base.driver.findElement(By.id("listingTemplate")).sendKeys("Empresa");
        System.out.println("Passo 8 - Ao abrir a tela seleciona no campo Modelo de anuncio a opcao " + opcao);
    }

    @E("^no campo Nome do Anuncio digita \"([^\"]*)\"$")
    public void noCampoNomeDoAnuncioDigita(String digita)  {
        driver.findElement(By.id("listingTemplate")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Academia Saúde e Bem Estar");
        System.out.println("Passo 9 - No campo Nome do Anuncio digita " + digita);
    }

    @E("^no campo Categorias selecina a opcao \"([^\"]*)\"$")
    public void noCampoCategoriasSelecinaAOpcao(String opcao) {
        driver.findElement(By.id("browse-categories")).click();
        driver.findElement(By.cssSelector(".categories-item:nth-child(8) .fa")).click();
        System.out.println("Passo 10 - no campo Categorias selecina a opcao " + opcao);
    }

    @Entao("^clica no botao \"([^\"]*)\" para gravar o anuncio$")
    public void clicaNoBotaoParaGravarOAnuncio(String botao) {
        base.driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
        System.out.println("Passo 11 - clica no botao " + botao + " para gravar o anuncio");
    }
}
