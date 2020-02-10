package SeleniumPractice.Homework;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class practiceTest extends basicTest{

	basicTest page;
	pomPracticePage method = new pomPracticePage(driver);
	
	@Ignore
	@Test
	public void testMultipleSelect() throws InterruptedException {
		assertTrue(method.isMultipleSelectWorking());
	}
	
	@Ignore
	@Test
	public void testMultipleChecbox() {
		assertTrue(method.areCheckboxesWorking());
	}
	
	@Ignore
	@Test
	public void testFindPrice() {
		int coursePrice = method.getPriceOfCourse("Python Programming Language");
		System.out.println("The price for the book is: " + coursePrice );
		assertEquals(30, coursePrice);
	}
	
	@Ignore
	@Test
	public void testFindBookAuthor() {
		System.out.println("Author of the book The Green Mile??? ");
	}
	
//	@Ignore
	@Test
	public void testGetDescription() throws InterruptedException {
		String javaPackage = "java.applet", description;
		description = method.getDescription(javaPackage);
		System.out.println("The description of " + javaPackage + " is: " + description);
		assertTrue(description.length() != 0);
	}
	
//	@Ignore
	@Test
	public void testLink(){
		method.clickOnAbstractButton();
		System.out.println(method.getTitle());
		assertEquals("Class AbstractButton", method.getTitle());
		method.navigateBack();
	}
	
}