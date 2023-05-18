package features;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NTTDATAPage {
	WebDriver webdriver;
	private int quantidadeElemento;
	private String elementoVaga_1;
	private String elementoVaga_2;
	private String elementoVaga_3;
	
	@FindBy(id="all")
	WebElement buttonPopupCookiesAll;
	
	@FindBy(xpath = "//li[@id='menu-item-32094']//a[@href='https://nttdata-solutions.com/br/carreira-na-nttdata/']")
	WebElement buttonMenuCarreira;
	
	@FindBy(xpath = "//a[contains(text(),'Junte-se a nossa equipe')]")
	WebElement buttonJunteseanossaequipe;
	
	@FindBy(id = "pesquisar-vaga-localidade-etc")
	WebElement campoSearchVagas;
	
	@FindBy(xpath = "//div[@class='portlet-body']//div[@ng-repeat='vacancy in vm.model.vacancies | limitTo:vm.paginationModel.pageSize']//div//div//h4")
	List<WebElement>vagasDaPesquisa;
		
	public NTTDATAPage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}
	
	public void ButtonPopupCookiesAll() throws Exception {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		buttonPopupCookiesAll.click();
	}
	
	public void ButtonMenuCarreira() throws Exception {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		buttonMenuCarreira.click();
	}
	
	public void ScrollElement() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("arguments[0].scrollIntoView();", buttonJunteseanossaequipe);
	}
	
	public void ButtonEquipe() throws Exception {
		ScrollElement();
		buttonJunteseanossaequipe.click();
	}
	
	public void SearchVaga(String palavraPesquisa) throws Exception {
		ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
		webdriver.switchTo().window(tabs.get(1));
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		campoSearchVagas.sendKeys(palavraPesquisa);
	}
	
	public void SearchVaga1() throws Exception {
		Thread.sleep(5000);
		List<WebElement> options = webdriver.findElements(By.xpath("//div[@class='portlet-body']//div[@ng-repeat='vacancy in vm.model.vacancies | limitTo:vm.paginationModel.pageSize']//div//div//h4"));
		int add = 0;
			for(WebElement elem  : options) {
				add = add + 1;
				System.out.println(elem.getText());
			}
		
		quantidadeElemento = add;
		elementoVaga_1 = options.get(0).getText();
		elementoVaga_2 = options.get(1).getText();
		elementoVaga_3 = options.get(2).getText();
	}

	public int getQuantidadeElemento() {
		return quantidadeElemento;
	}

	public void setQuantidadeElemento(int quantidadeElemento) {
		this.quantidadeElemento = quantidadeElemento;
	}
	
	public String getElementoVaga_1() {
		return elementoVaga_1;
	}

	public void setElementoVaga_1(String elementoVaga_1) {
		this.elementoVaga_1 = elementoVaga_1;
	}

	public String getElementoVaga_2() {
		return elementoVaga_2;
	}

	public void setElementoVaga_2(String elementoVaga_2) {
		this.elementoVaga_2 = elementoVaga_2;
	}

	public String getElementoVaga_3() {
		return elementoVaga_3;
	}

	public void setElementoVaga_3(String elementoVaga_3) {
		this.elementoVaga_3 = elementoVaga_3;
	}
}
	
	

