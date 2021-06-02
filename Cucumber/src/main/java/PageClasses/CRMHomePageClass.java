package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class CRMHomePageClass extends TestBase{
	
	@FindBy(xpath="//span[text()='Home']")
	public WebElement HomeIcon;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[6]/button[1]/i[1]")
	public WebElement TasksIcon;
	
	@FindBy(xpath="//*[text()='Save']")
	public WebElement SaveButton;
	
	@FindBy(xpath="//input[@name='title']")
	public WebElement TitleBar;
	

	@FindBy(xpath="//div[@role='listbox' and @class='ui fluid selection dropdown']")
	public WebElement AssignedTo;
	
	
	@FindBy(xpath="//div[@class='visible menu transition']//span[text()='Harpreet Singh']")
	public WebElement AssignedToHarpreet;

	@FindBy(xpath="//div[@name='deal']//input")
	public WebElement Deal;
	
	
	@FindBy(xpath="//div[@name='deal']//span")
	public WebElement DealSelected;
	
	@FindBy(name="description")
	public WebElement description;
	
	
	@FindBy(xpath="//div[@name='type' and @role='listbox']")
	public WebElement Type;
	
	@FindBy(xpath="//span[text()='General Support']")
	public WebElement ChooseType;
	
	
	@FindBy(xpath="//div[@name='contact']//input")
	public WebElement Contact;
	
	@FindBy(xpath="//div[@name='case']//input")
	public WebElement Case;
	
	@FindBy(name="completion")
	public WebElement completion;
	
public CRMHomePageClass()
{
	PageFactory.initElements(driver, this);
}
	
	
	
	

}
