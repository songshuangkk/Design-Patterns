package com.songshuang.design.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

  @Override
  public String sayHello() throws RemoteException {
    return "Server says 'Hey'";
  }

  public MyRemoteImpl() throws RemoteException {}

  public static void main(String[] args) {
    try {
      MyRemote service = new MyRemoteImpl();
      Naming.rebind("RemoteHello", service);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
