package StepsDefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;

public class FlujoAmazon {

	@Managed
	WebDriver driver;
	
	@Given("^que se ingrese a la pagina de Amazon$")
	public void que_se_ingrese_a_la_pagina_de_Amazon() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		time();
	}

	@When("^el usuario busca zapatillas$")
	public void el_usuario_busca_zapatillas() throws InterruptedException {
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("zapatillas");
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);	
	}

	@And("^filtra por marca adidas$")
	public void filtra_por_marca_adidas() throws InterruptedException {
		List<WebElement> lista = driver.findElements(By.xpath("//*[@id='brandsRefinements']/ul[1]/li//a/span"));
		for(WebElement lst : lista){
			if(lst.getText().equals("adidas")){
				lst.click();
				break;
			}
		}
		time();	
	}

	
	//necesita mejora
	@Then("^el sistema visualiza los datos$")
	public void el_sistema_visualiza_los_datos() throws InterruptedException {
		List<WebElement> listaNombres = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//a[@class='a-link-normal a-text-normal']"));
		List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']/span[2]"));
		for(int i=0; i< 5; i++){
			System.out.println("Nombres: " + listaNombres.get(i).getText());
			System.out.println("Precios: " + listaPrecios.get(i).getText());
		}
		time();
	}

	@And("^el usuario selecciona ordenar precio de mayor a menor$")
	public void el_usuario_selecciona_ordenar_precio_de_mayor_a_menor() throws InterruptedException {
		List<WebElement> lista = driver.findElements(By.xpath("//select[@id='s-result-sort-select']/option"));
		for(WebElement lst : lista){
			if(lst.getText().equals("Price: High to Low")){
				lst.click();
				break;
			}
		}
		time();
	}
	
	@Then("^el usuario quita el filtro$")
	public void el_usuario_quita_el_filtro() throws InterruptedException {
		List<WebElement> lista = driver.findElements(By.xpath("//*[@id='brandsRefinements']/ul[1]/li//a/span"));
		for(WebElement lst : lista){
			if(lst.getText().equals("adidas")){
				lst.click();
				break;
			}
		}
		time();
	}
	
	//necesita mejora
	@Then("^el sistema valida los datos$")
	public void el_sistema_valida_los_datos() throws InterruptedException {

		List<WebElement> listaNombres = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//a[@class='a-link-normal a-text-normal']"));
		List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']/span[2]"));
		for(int i=0; i< 5; i++){
			System.out.println("Nombres: " + listaNombres.get(i).getText());
			System.out.println("Precios: " + listaPrecios.get(i).getText());
			
			Assert.assertTrue(!listaNombres.get(i).getText().isEmpty());
			Assert.assertTrue(!listaPrecios.get(i).getText().isEmpty());
		}
	}
	
	public void time() throws InterruptedException{
		Thread.sleep(3000);
	}
}
