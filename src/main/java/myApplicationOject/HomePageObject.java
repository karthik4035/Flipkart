package myApplicationOject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import myApplicationOject.BasePageObject;

public class HomePageObject extends BasePageObject {
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li/a[@title='Women']")
	private WebElement Women;
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement Dresses;
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement Shirt;
	@FindBy (id="newsletter-input")
	private WebElement newsletter;
	@FindBy(xpath="//div[@id='newsletter_block_left']//button")
	private WebElement btn;
	@FindBy (xpath="//*[@id='columns']/p")
	private WebElement alertMessage;
	@FindBy(xpath="//*[@id=\"ul_layered_id_attribute_group_1\"]//li[1]//a")
	private WebElement S;
	@FindBy(xpath="//*[@id=\"ul_layered_id_attribute_group_1\"]//li[2]//a")
	private WebElement M;
	@FindBy(xpath="//*[@id=\"ul_layered_id_attribute_group_1\"]//li[3]//a")
	public WebElement L;
	@FindBys(@FindBy(xpath="//*[@id='center_column']//.//ul[@class='product_list grid row']/li"))
	private List<WebElement> productList;
	@FindBy(xpath="//*[@id='center_column']//h1/span[2]")
	private WebElement prdHederTxt;
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
	private WebElement prd1;
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
	private WebElement addbtn;
	@FindBy (xpath="layer_cart_product col-xs-12 col-md-6")
	private WebElement addTxt;
	@FindBy(xpath="//*[@class='button-container']//a//i")
	private WebElement prcTocheckout;
	@FindBy(id="cart_title")
	private WebElement cartTitle;
	public HomePageObject()
	{
		PageFactory.initElements(driver, this);
	
	}
	public WebElement gettxtWomen()
	{
		return Women;
	}
	public WebElement gettxtDressess()
	{
		return Dresses;
	}
	public WebElement gettxtTshirt()
	{
		return Shirt;
	}
	
	public String clickWomenLink()
	{
		 Women.click();
		 return driver.getTitle();
				 
	}
	
	public String clickDressesLink()
	{
		 Dresses.click();
		 return driver.getTitle();
		 
		 
	}
	public String clickTshirtLink()
	{
	
		 Shirt.click();
		return driver.getTitle();
	}
	
	public String NewsLetter()

	{
		JavaScriptExe();
		int random=new Random().nextInt(2000);
		String email="tomato."+random+"@gmail.com";
		newsletter.sendKeys(email);
		btn.click();
		String mes=alertMessage.getText();
		System.out.println(mes);
		return mes;
	}
	public WebElement sizeSispresent()
	{
		Dresses.click();
		return S;
	}
	public WebElement sizeMispresent()
	{
		Dresses.click();
		return M;
	}
	public WebElement sizeLispresent()
	{
		Dresses.click();
		return L;
	}
	public int productCount()

	{
		Dresses.click();
		return Integer.parseInt(prdHederTxt.getText().split(" ")[2]);
	
	}
	public int ProductListSize()
	{
		Dresses.click();
		return productList.size();
	}
	public String addToCart()
	{
		Dresses.click();
		Actions ac=new Actions(driver);
		ac.moveToElement(prd1).build().perform();
		addbtn.click();
		//System.out.println(addTxt.getText());
		prcTocheckout.click();
		return cartTitle.getText();
		
	}
}
