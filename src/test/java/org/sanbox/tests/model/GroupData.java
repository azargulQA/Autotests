package org.sanbox.tests.model;


import java.util.Objects;

public class GroupData {
private int id = Integer.MAX_VALUE;
private String name;
private String header;
private String footer;


public String getName() {
  return name;
}
public String getHeader() {
  return header;
}

public String getFooter() {
  return footer;
}

public int getId() {
  return id;
}

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public String name() {
    return name;
  }

  public String header() {
    return header;
  }

  public String footer() {
  return footer;
}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

   if ( id != groupData.id) return false;
   return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
