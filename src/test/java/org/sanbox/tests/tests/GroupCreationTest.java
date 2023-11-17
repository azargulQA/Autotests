package org.sanbox.tests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sanbox.tests.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreation() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Hello_Jupiter", "123", "456"));
   int after = app.getGroupHelper().getGroupCount();
    Assertions.assertEquals(after, before + 1);
  }

}