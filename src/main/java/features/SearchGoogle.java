package features;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GlobalDriver;

public class SearchGoogle extends GlobalDriver{
	private SearchGooglePage searchGooglePage;
	private NTTDATAPage nttdataPage;
	
	public SearchGoogle(WebDriver webdriver) {
		GlobalDriver.webdriver = webdriver;
	}

	public SearchGoogle() throws Exception {
		searchGooglePage = new SearchGooglePage(webdriver);
		nttdataPage = new NTTDATAPage(webdriver);
	}
	
	@Given("que Marcelo faz uma busca no google {string} com pesquisa {string} e acessar o Primeiro link apresentado na pesquisa.")
	public void que_marcelo_faz_uma_busca_no_google_com_pesquisa_e_acessar_o_primeiro_link_apresentado_na_pesquisa(String site, String palavraBusca) throws Exception {
		webdriver.navigate().to(site);
		searchGooglePage.Search(palavraBusca);	
		Thread.sleep(3000);
		searchGooglePage.FirstSearchNTTDATA();
		Thread.sleep(3000);
		nttdataPage.ButtonPopupCookiesAll();
		nttdataPage.ButtonMenuCarreira();
		nttdataPage.ButtonEquipe();
	}

	@When("estiver na pagina, clicar em carreira e acessar junte-se a nossa equipe pesquisar {string}.")
	public void estiver_na_pagina_clicar_em_carreira_e_acessar_junte_se_a_nossa_equipe_pesquisar(String vaga) throws Exception {
		nttdataPage.SearchVaga(vaga);
		nttdataPage.SearchVaga1();
	}

	@Then("devera conter {int} vagas e ser vaga de {string}.")
	public void devera_conter_vagas_e_ser_vaga_de(Integer quantidadeVaga, String cargoVaga) {
	   Assert.assertEquals("Quantidades de itens é igual a 3",nttdataPage.getQuantidadeElemento(),(int) quantidadeVaga);
	   Assert.assertTrue("Elemento 1 contém Arquiteto",nttdataPage.getElementoVaga_1().contains(cargoVaga));
	   Assert.assertTrue("Elemento 2 contém Arquiteto",nttdataPage.getElementoVaga_2().contains(cargoVaga));
	   Assert.assertTrue("Elemento 3 contém Arquiteto",nttdataPage.getElementoVaga_3().contains(cargoVaga));
	}
}