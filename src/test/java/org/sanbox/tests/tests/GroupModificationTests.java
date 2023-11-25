package org.sanbox.tests.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.sanbox.tests.model.GroupData;
import org.sanbox.tests.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class GroupModificationTests extends TestBase {

  @BeforeAll
  public static void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @ParameterizedTest
  public void testGroupModification(GroupData modifiedGroup) {
    Groups before = app.group().all();
    int index = before.size() - 1;
    GroupData group = new GroupData()
             .withId(before.get(index).getId()).withName("slurm").withHeader( "test2").withFooter("test3");
    app.group().modify(index, group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
