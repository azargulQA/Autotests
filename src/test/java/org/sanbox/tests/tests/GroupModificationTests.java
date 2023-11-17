package org.sanbox.tests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sanbox.tests.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assertions.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add(group);
    Assertions.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
