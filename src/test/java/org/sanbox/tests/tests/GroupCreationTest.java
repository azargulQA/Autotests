package org.sanbox.tests.tests;
import org.junit.jupiter.api.Test;
import org.sanbox.tests.model.GroupData;
import org.sanbox.tests.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreation() {
    app.goTo().groupPage();
   Groups before = app.group().all();
    GroupData group = new GroupData().withName("test").withHeader("123").withFooter("456");
    app.group().create(group);
   Groups after = app.group().all();
   assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after.size(), equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}