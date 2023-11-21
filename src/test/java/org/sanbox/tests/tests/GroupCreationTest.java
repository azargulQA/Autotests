package org.sanbox.tests.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sanbox.tests.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreation() {
    app.goTo().groupPage();
   List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("test");
    app.group().create(group);
   List<GroupData> after = app.group().list();
   Assertions.assertEquals(after.size(), before.size() + 1);


   before.add(group);
   Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
   before.sort(byId);
   after.sort(byId);
   Assertions.assertEquals(before, after);

  }

}