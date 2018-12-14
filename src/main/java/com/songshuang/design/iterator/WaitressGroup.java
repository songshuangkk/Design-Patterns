package com.songshuang.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class WaitressGroup {

  private ArrayList menus;

  public WaitressGroup(ArrayList menus) {
    this.menus = menus;
  }

  public void printMenu() {
    Iterator menuIterator = menus.iterator();
    while (menuIterator.hasNext()) {
      Menu menu = (Menu) menuIterator.next();
      printMenu(menu.createIterator());
      printMenu(menu.createIterator());
    }
  }

  public void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.printf("%s -- %s %s", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
  }
}
