package org.sanbox.tests.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;
import org.sanbox.tests.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME);

  @BeforeAll
  public static void setUp() {
    app.init();

  }

  @AfterAll
  public static void tearDown() {
    app.stop();
  }

}
