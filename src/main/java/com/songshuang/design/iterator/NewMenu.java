package com.songshuang.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class NewMenu extends MenuComponent {

  private ArrayList menuComponents = new ArrayList();

  private String name;

  private String decription;

  public NewMenu(String name, String description) {
    this.name = name;
    this.decription = description;
  }

  @Override
  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  @Override
  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  @Override
  public MenuComponent getChild(int i) {
    return (MenuComponent) menuComponents.get(i);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return decription;
  }

  @Override
  public void print() {
    System.out.printf(" %s\n", getName());
    System.out.printf("%s\n", getDescription());
    System.out.printf("----------------------\n");

    Iterator iterator = menuComponents.iterator();
    while (iterator.hasNext()) {
      MenuComponent menuComponent = (MenuComponent) iterator.next();
      menuComponent.print();
    }
  }
}
