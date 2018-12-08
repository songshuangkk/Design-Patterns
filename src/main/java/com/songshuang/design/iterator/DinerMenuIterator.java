package com.songshuang.design.iterator;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {

  MenuItem[] items;

  int position = 0;

  public DinerMenuIterator(MenuItem[] items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    if (position >= items.length || items[position] == null) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    MenuItem item = items[position];
    position ++;
    return item;
  }
}
