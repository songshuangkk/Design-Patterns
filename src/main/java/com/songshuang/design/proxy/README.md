# 远程调用代码实现

### 制作远程接口.

* 扩展java.rmi.Remote
```java
public interface MyRemote extends Remote {}
```

* 声明所有的方法都必须抛出RemoteException
```java
public interface MyRemote extends Remote {
  String sayHello() throws RemoteException;   // 每次调用远程方法的时候都必须考虑成果"有风险的"。在每个方法中声明RemoteException，可以让客户注意到这件事，并了解这可能是无法工作的。
}
```

* 调用的数据类型应该是可以序列化的类型


### 制作远程实现
* 实现远程接口
```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
  
  @Override
  public String sayHello() {
    return "Server says, 'Hey'";
  }
}
```

* 扩展UnicastRemoteObject
为了要成为远程服务对象，你的对象需要某些"远程的"功能。最简单的方式是扩展java.rmi.server.UnicastRemoteObject,
让超类帮你做这些工作
```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
//  .....
}
```

* 设计一个不带变量的构造器，并声明RemoteException

* 使用RMI Register注册此服务
```java
public class Register {
  public static void main(String[] args) {
    try {
      MyRemote service = new MyRemoteImpl();
      // 为你的服务命名，好让客户用来注册表中找到它，并在RMI Registry中注册此名字和服务。
      // 当你绑定(bind)服务对象时, RMI会把服务换成stub, 然后把stub放到registry中.
      (Naming).rebind("RemoteHello", service);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
```

### 产生Stub和Skeleton
在远程实现类(不是远程接口)上执行rmic命令.
```jshelllanguage
rmic MyRemoteImpl
```

rmic是JDK内的一个工具，用来为一个服务类产生stub和skeleton。命名习惯是在远程实现的名字后面加上_Stub或_Skel。
rmic有一些选项可以调整，包括不要产生skeleton、查看源代码，甚至使用IIOP作为协议。我们这里使用rmic的方式是常用的
方式，降类产生在当前目录下。请注意，rmic必须看到你的实现类，所以你可能会从你的远程所在目录执行rmic

### 执行rmiregistry
开启一个终端，启动rmiregistry。先确定启动目录必须可以访问你的类。最简单的做法是从你的"classes"目录启动.

### 启动服务
开启另一个终端，启动服务
```jshelllanguage
java myRemoteImpl
```
