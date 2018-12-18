package com.songshuang.design.state;

public class GumballMachine {

  private final static int SOLD_OUT = 0;

  private final static int NO_QUARTER = 1;

  private final static int HAS_QUARTER = 2;

  private final static int SOLD = 3;

  private int state = SOLD_OUT;

  private int count = 0;

  public GumballMachine(int count) {
    this.count = count;
    if (count > 0) {
      state = NO_QUARTER;
    }
  }

  public void insertQuarter() {
    if (state == HAS_QUARTER) {
      System.out.printf("You can't insert another quarter.\n");
    } else if (state == SOLD_OUT) {
      System.out.printf("You can't insert a quarter, the machine is sold out.\n");
    } else if (state == SOLD) {
      System.out.printf("Please wait, we're already giving you a gumball.\n");
    } else if (state == NO_QUARTER) {
      state = HAS_QUARTER;
      System.out.printf("You inserted a quarter.\n");
    }
  }

  /**
   * 退回25分钱.
   */
  public void ejectQuarter() {
    if (state == HAS_QUARTER) {
      System.out.printf("Quarter returned.\n");
      state = NO_QUARTER;     // 退出前，降状态更改为没有25钱的状态.
    } else if (state == NO_QUARTER) {
      System.out.printf("You haven;t inserted a quarter.\n");
    } else if (state == SOLD) {
      System.out.printf("Sorry, you already turned the crank.\n");
    } else if (state == SOLD_OUT) {
      System.out.printf("You can't eject, you haven't inserted a quarter yet.\n");
    }
  }

  /**
   * 转动曲柄.
   */
  public void turnCrank() {
    if (state == SOLD) {
      System.out.printf("Turning twice doesn't get uou another gumball!\n");
    } else if (state == NO_QUARTER) {
      System.out.printf("You turned but there's no quarter\n");
    } else if (state == SOLD_OUT) {
      System.out.printf("You turned, but there are no gumballs.\n");
    } else if (state == HAS_QUARTER) {
      System.out.printf("You turned...\n");
      dispense();
    }
  }

  /**
   * 发放糖果.
   */
  public void dispense() {
    if (state == SOLD) {
      System.out.printf("A gumball comes rolling out the slot.\n");
      count--;
      if (count == 0) {
        System.out.printf("Oops, out of gumball.\n");
        state = SOLD_OUT;
      } else {
        state = NO_QUARTER;
      }
    } else if (state == NO_QUARTER) {
      System.out.printf("You need to pay first.\n");
    } else if (state == SOLD_OUT) {
      System.out.printf("No gumball dispensed.\n");
    } else if (state == HAS_QUARTER) {
      System.out.printf("No gumball dispensed.\n");
    }
  }

  public static void main(String[] args) {
    GumballMachine gumballMachine = new GumballMachine(5);

    System.out.printf("%s\n", gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();

    System.out.printf("%s\n", gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.ejectQuarter();
    gumballMachine.turnCrank();

    System.out.printf("%s\n", gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.ejectQuarter();

    System.out.printf("%s\n", gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();

    System.out.printf("%s\n", gumballMachine);
  }
}
