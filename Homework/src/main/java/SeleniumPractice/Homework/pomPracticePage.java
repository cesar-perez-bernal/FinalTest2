package SeleniumPractice.Homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pomPracticePage {
	WebDriver driver;
	
	@FindBy(how = How.ID, using = "multiple-select-example")
	private WebElement multipleSelect;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//select[@id='multiple-select-example']//option")})
	private List<WebElement> selectOptions;
	
	@FindBy (how = How.ID, using = "checkbox-example")
	private WebElement checkboxContainer;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")})
	private List<WebElement> checkboxes;
	
	@FindBy (how = How.XPATH, using = "//a[@href='javax/swing/AbstractButton.html']")
	private WebElement abstractButton;
	
	@FindBy (how = How.XPATH, using = "//h2[@class='title']")
	private WebElement titleValidator;
	
	public pomPracticePage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isMultipleSelectWorking() throws InterruptedException{
		Boolean validator = false;
		WebElement selectedOption;
		String selectValidator, currentOption;
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(multipleSelect));
		Select selector = new Select(multipleSelect);
		for(WebElement eachOption: selectOptions) {
			currentOption = eachOption.getText().toLowerCase();
			selector.selectByValue(currentOption);
			selectedOption = selector.getFirstSelectedOption();
			selectValidator = selectedOption.getText();
			selector.deselectByValue(currentOption);
			if(selectValidator.equalsIgnoreCase(currentOption)) {
				validator = true;
			} else {
				validator = false;
			}
		}
		System.out.println(validator);
        return validator;
	}
	
	public boolean areCheckboxesWorking() {
		Boolean validator = false;
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkboxContainer));
		for(WebElement eachCheckbox: checkboxes) {
			eachCheckbox.click();
			if(eachCheckbox.isSelected() == true) {
				validator = true;
			} else {
				validator = false;
			}
		}
		System.out.println(validator);
		return validator;
	}
	
	public int getPriceOfCourse(String course) {
		int price;
		String text;
		WebElement locator = driver.findElement(By.xpath("//td[contains(text(),'" + course + "')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
		locator = locator.findElement(By.xpath(".//following-sibling::td"));
		text = locator.getText();
		price = Integer.parseInt(text);
		return price;
	}

	public String getDescription(String javaPackage) throws InterruptedException {
		String description = null;
//		int size = driver.findElements(By.tagName("frame")).size();
//		System.out.println(size);
		driver.switchTo().frame(2);
		description = packageName(javaPackage).getText();
		driver.switchTo().defaultContent();
		return description;
	}
	
	private WebElement packageName(String javaPackage) {
		return driver.findElement(By.xpath("//table//td[@class='colFirst']//a[contains(text(),'" + javaPackage + "')]//parent::td//following-sibling::td//div"));
	}
	
	public void clickOnAbstractButton() {
		driver.switchTo().frame(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", abstractButton);
		driver.switchTo().defaultContent();
	}
	
	public String getTitle() {
		String title;
		driver.switchTo().frame(2);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(titleValidator));
		title = titleValidator.getText();
		driver.switchTo().defaultContent();
		return title;
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
}
