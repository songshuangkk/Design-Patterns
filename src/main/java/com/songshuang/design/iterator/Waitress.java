package com.songshuang.design.iterator;

import java.awt.*;
import java.util.Iterator;

public class Waitress {

  Menu pancakeHouseMenu;

  Menu dinerMenu;

  public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
  }

  public void printMenu() {
    Iterator pancakeIterator = pancakeHouseMenu.createIterator();
    Iterator dinerIterator = dinerMenu.createIterator();
    System.out.printf("MENU\n----\nBREAKFAST\n");
    printMenu(pancakeIterator);
    System.out.printf("\nLUNCH\n");
    printMenu(dinerIterator);
  }


  private void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.printf("%s %s %s \n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
  }

  public static void main(String[] args) {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();

    Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

    waitress.printMenu();
  }
}
