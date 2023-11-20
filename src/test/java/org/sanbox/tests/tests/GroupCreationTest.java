package org.sanbox.tests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sanbox.tests.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreation() {
    app.getNavigationHelper().goToGroupPage();
   List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", "null", "null");
    app.getGroupHelper().createGroup(group);
   List<GroupData> after = app.getGroupHelper().getGroupList();
    Assertions.assertEquals(after, before.size() + 1);


    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assertions.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}