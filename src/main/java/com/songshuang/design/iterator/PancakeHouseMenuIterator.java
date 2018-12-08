package com.songshuang.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {

  ArrayList menus;

  int position = 0;

  @Override
  public boolean hasNext() {

    if (position >= menus.size()) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    MenuItem item = (MenuItem) menus.get(position);
    position++;
    return item;
  }

  public PancakeHouseMenuIterator(ArrayList menus) {
    this.menus = menus;
  }
}
