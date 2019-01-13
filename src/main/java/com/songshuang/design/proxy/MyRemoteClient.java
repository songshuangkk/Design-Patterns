package com.songshuang.design.proxy;

import java.rmi.Naming;

public class MyRemoteClient {

  private void go() {
    try {
      MyRemote myRemote = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
      System.out.printf("Remote Result is %s \n", myRemote.sayHello());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new MyRemoteClient().go();
  }
}
