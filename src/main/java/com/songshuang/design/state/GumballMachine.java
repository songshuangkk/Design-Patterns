package com.songshuang.design.state;

public class GumballMachine {

  private State soldOutState;

  private State noQuarterState;

  private State hasQuarterState;

  private State soldState;

  private State winnerState;

  private State state  = soldOutState;

  private int count = 0;

  public GumballMachine(int count) {
    soldOutState = new SoldOutState(this);

    soldState = new SoldState(this);

    hasQuarterState = new HasQuarterState(this);

    noQuarterState = new NoQuarterState(this);

    this.count = count;
    if (count > 0) {
      state = noQuarterState;
    }
  }

  public void setState(State state) {
    this.state = state;
  }

  public void insertQuarter() {
    state.insertQuarter();
  }

  /**
   * 退回25分钱.
   */
  public void ejectQuarter() {
    state.ejectQuarter();
  }

  /**
   * 转动曲柄.
   */
  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  public void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
    if (count != 0) {
      count--;
    }
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getWinnerState() {
    return winnerState;
  }

  public void setWinnerState(State winnerState) {
    this.winnerState = winnerState;
  }

  public int getCount() {
    return this.count;
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
