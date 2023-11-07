package org.sanbox;
import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) {

    String sum1 = getString("25500000");

    System.out.println(sum1);
  //сохранить в переменную, потом вывести переменную
  }

  private static String getString(String editSum) {

    DecimalFormat format = new DecimalFormat("###,###");
    format.setGroupingSize(3);
    return format.format(Integer.parseInt(editSum)) + " P";
  }
}