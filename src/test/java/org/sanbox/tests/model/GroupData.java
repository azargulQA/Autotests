package org.sanbox.tests.model;

import java.util.Objects;

public class GroupData {
public final String id;
public final String name;
public final String header;
public final String footer;



public  GroupData(String name, String header, String footer) {
  this.id = null;
  this.name = name;
  this.header = header;
  this.footer = footer;
  }
public  GroupData(String id, String name, String header, String footer) {
  this.id = id;
  this.name = name;
  this.header = header;
  this.footer = footer;
}

public String getName() {
  return name;
}
public String getHeader() {
  return header;
}

public String getFooter() {
  return footer;
}

public String getId() {
  return id;
}

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
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
}
