工厂方法模式介绍
工厂方法模式是一种结构相对比较简单的创建型模式之一。应用广泛。
###1、定义

简单一句话：定义一个创建各种对象的接口，让子类决定去实例化哪个类的对象。

###工厂模式的使用场景

在任何需要创建生成复杂对象的地方。都可以使用工厂方法模式。复杂对象适合使用工厂方法模式。
直接使用new就可以创建的对象无需使用工厂模式



###工厂方法中使用反射类生成对应的产品对象的。


### 简单工厂模式的终极理解：
简单工厂一般理解就是减少new创建对象的方式，用接口的方式来返回一个对象，而new创建的方式被封装了。放在了工厂方法里面