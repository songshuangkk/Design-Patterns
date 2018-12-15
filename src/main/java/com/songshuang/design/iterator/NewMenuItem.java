package com.songshuang.design.iterator;

public class NewMenuItem extends MenuComponent {

  private String name;

  private String description;

  private boolean vegetarian;

  private double price;

  public NewMenuItem(String name,
                     String description,
                     boolean vegetarian,
                     double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean isVegetarian() {
    return vegetarian;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void print() {
    System.out.printf(" %s ", getName());
    if (isVegetarian()) {
      System.out.printf("(v)");
    }
    System.out.printf(", %d", getPrice());
    System.out.printf("  -- %s\n", getDescription());
  }
}
