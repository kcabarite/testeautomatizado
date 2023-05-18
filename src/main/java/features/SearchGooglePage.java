package features;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchGooglePage {
	WebDriver webdriver;

	@FindBy(xpath = "//textarea[@title='Pesquisar']")
	WebElement search;
	
	@FindBy(xpath = "//div[4]//input[@value='Pesquisa Google']")
	WebElement buttonGoogleSearch;

	@FindBy(xpath = "//a[@href='https://nttdata-solutions.com/br/']")
	WebElement SearchNTTDATA;
	
	@FindBy(xpath = "//li[1]//div[@role='option']")
	WebElement firstSearchElementRoleNTTDATA;
	
	@FindBy(xpath = "//textarea[@aria-expanded='true']")
	WebElement presentRoleSearchNTTDATA;
	
	public SearchGooglePage(WebDriver webdriver) {
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}
	
	public void Search(String palavraPesquisa) throws Exception {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		search.sendKeys(palavraPesquisa);
	}
	
	public void ButtonSearch() throws Exception {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		buttonGoogleSearch.click();
	}
	
	public void FirstSearchNTTDATA() throws Exception {
		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(presentRoleSearchNTTDATA.isDisplayed() == true) {
			firstSearchElementRoleNTTDATA.click();
			SearchNTTDATA.click();
		}
		else{
			ButtonSearch();
			SearchNTTDATA.click();
		}
	}
	
}
	
	

