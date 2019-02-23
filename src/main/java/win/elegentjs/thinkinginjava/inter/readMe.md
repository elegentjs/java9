接口和内部类为我们提供了一种将接口与实现分离的更加结构化的方法

包括抽象方法的类叫做抽象类，如果一个类包含一个或多个抽象方法，该类必须被限定为抽象的。

抽象类是非常有用的重构工具，它们使得我们可以很容易地将公共方法沿着继承层次结构向上移动。

接口表示：所有实现类该接口的类看起来都像这个样子。接口被用来建立类与类之间的协议


接口中的方法默认都是 public abstract 的，因此我们写接口方法定义时可以省略public
接口中可以包含域的，类型是public static final, 即是常量

一个类可以继承多个接口，来达成多重继承的特性

创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略模式。 这类方法包含所要执行
的算法中固定不变的部分，而策略包含变化的部分


任何抽象性都应该是应真正的需求而产生的。