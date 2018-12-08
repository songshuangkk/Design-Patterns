package com.songshuang.design.iterator;

import java.util.ArrayList;

public class Alice {

  public void printMenu() {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    for (int i = 0; i < breakfastItems.size(); i++) {
      MenuItem menuItem = (MenuItem) breakfastItems.get(i);
      System.out.printf("%s %s %s \n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }

    System.out.printf("Lunch\n");
    for (int i = 0; i < lunchItems.length; i++) {
      MenuItem menuItem = lunchItems[i];
      System.out.printf("%s %s %s \n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
  }
}
