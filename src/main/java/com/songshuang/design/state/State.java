package com.songshuang.design.state;

/**
 * 定义糖果机的每个动作.
 */
public interface State {
  /**
   * 投币.
   */
  void insertQuarter();

  /**
   * 拒绝投币.
   */
  void ejectQuarter();

  /**
   * 转动旋钮。
   */
  void turnCrank();

  /**
   * 分配糖果.
   */
  void dispense();
}
