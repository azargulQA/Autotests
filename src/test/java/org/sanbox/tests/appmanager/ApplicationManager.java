package org.sanbox.tests.appmanager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
  WebDriver driver;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  public SessionHelper sessionHelper;
  JavascriptExecutor js;
  public Map<String, Object> vars;
  private final org.openqa.selenium.remote.Browser Browser;

  public ApplicationManager(org.openqa.selenium.remote.Browser browser) {
    this.Browser = browser;
  }

  public void init() {
    if (Browser.equals(Browser.CHROME)) {
      driver = new ChromeDriver();
    } else if (Browser.equals(Browser.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if (Browser.equals(Browser.IE)) {
      driver = new InternetExplorerDriver();
    }
    sessionHelper = new SessionHelper(driver);
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(918, 1047));
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    driver.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
