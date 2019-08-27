package myApplicationTest;



import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import myApplicationOject.BasePageObject;
import myApplicationOject.HomePageObject;


public class HomePageTest {
	
	HomePageObject homepag;
	BasePageObject bspag;
	
	public HomePageTest ()
	{
		homepag = new HomePageObject();
		bspag = new BasePageObject();
	}
	
@Test(enabled=true)
public void verifyTextWomen()
{
	Assert.assertTrue(homepag.gettxtWomen().isDisplayed());
}
@Test(enabled=true)
public void verifyTestDressess()
{
 Assert.assertTrue(homepag.gettxtDressess().isDisplayed());	
}
@Test(enabled=true)
public void VerifyTextTshirt()
{
 Assert.assertTrue(homepag.gettxtTshirt().isDisplayed());	
}
@Test (enabled=true)
public void VerifyPagwTitle()
{
 Assert.assertTrue(homepag.clickWomenLink().contains("Women"));
}
@Test(enabled=true)
public void VerifyPagdTitle()
{
Assert.assertTrue(homepag.clickDressesLink().contains("Dresses"));	
}
@Test(enabled=true)
public void VerifyPagstitle()
{
 Assert.assertTrue(homepag.clickTshirtLink().contains("T-shirt"));
}
@Test(enabled=true)
public void VerifyNewsletterAlert()
{
	String txt="Newsletter : You have successfully subscribed to this newsletter.";
 Assert.assertTrue(homepag.NewsLetter().contentEquals(txt));
}
@Test(enabled=false)
public void VerifySizeSmall()
{
	Assert.assertTrue(homepag.sizeSispresent().isDisplayed());
	}
@Test(enabled=true)
public void VerifySizeMedium()
{
	Assert.assertTrue(homepag.sizeMispresent().isDisplayed());

	}
@Test(enabled=true)
public void VerifySizeLarge()
{
	Assert.assertTrue(homepag.sizeLispresent().isDisplayed());
	Assert.assertTrue(homepag.L.isDisplayed());
	}
@Test(enabled=true)
public void checkProductCount()
{
	int actual=homepag.productCount();
	int expected=homepag.ProductListSize();
	Assert.assertTrue(actual==expected, "Success");
	}
@Test
public void ProceedToCheckout()
{
String Title=homepag.addToCart();
System.out.println(Title );
}
}
