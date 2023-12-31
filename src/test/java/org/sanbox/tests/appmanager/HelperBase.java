package org.sanbox.tests.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
public class HelperBase {
  protected final WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    /*if (text != null) {
      String existingText = driver.findElement(locator).getAttribute("value");  //перехват исключения
      if (! text.equals(existingText)) {  */
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    /*}
  } */ //закомментированные скобки перехвата исключения

  public boolean isAlertPresent() {   //конструкция позволяет перехватить исключения
   try {
     driver.switchTo().alert();
     return true;
   } catch (NoAlertPresentException e) {  //тут происходит перехват(catch) и указан тип исключения
     return false;
   }
  }

}
