package Knowledge;

/**
 * 设计模式之单例模式
 * 有很多种实现方法= =
 *
 * 优点
 * 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能。
 *
 * 缺点
 * 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new，可能会给其他开发人员造成困扰，特别是看不到源码的时候。
 *
 * 适用场合
 * 需要频繁的进行创建和销毁的对象；
 * 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
 * 工具类对象；
 * 频繁访问数据库或文件的对象。
 */

//1.饿汉式（静态常量）【可用】
//优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
//缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
class Singleton_1 {
    private final static Singleton_1 INSTANCE = new Singleton_1();
    private Singleton_1(){}
    public static Singleton_1 getInstance(){
        return INSTANCE;
    }
}
//2.饿汉式（静态代码块）【可用】
//优缺点与上面类似。只是将类的实例化放在了静态代码块中。
class Singleton_2 {
    private static Singleton_2 instance;
    static {
        instance = new Singleton_2();
    }
    private Singleton_2(){}
    public static Singleton_2 getInstance(){
        return instance;
    }
}
//3.懒汉式（线程不安全）【不可用】
//这种写法起到了Lazy Loading的效果，但是只能在单线程下使用。
//如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
//另一个线程也通过了这个判断语句，这时便会产生多个实例。
class Singleton_3 {
    private static Singleton_3 instance;
    private Singleton_3(){}
    public static Singleton_3 getInstance(){
        if (instance == null)
            instance = new Singleton_3();
        return instance;
    }
}
//4.懒汉式（线程安全，同步方法）【不推荐用】
//对getInstance()方法进行了线程同步。
//缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
//而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。
//方法进行同步效率太低要改进。
class Singleton_4 {
    private static Singleton_4 instance;
    private Singleton_4(){}
    public static synchronized Singleton_4 getInstance(){
        if (instance == null)
            instance = new Singleton_4();
        return instance;
    }

}
//5.懒汉式（线程安全，同步代码块）【不可用】
//同步产生实例化的的代码块。但是这种同步并不能起到线程同步的作用。
//跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，
//还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
class Singleton_5 {
    private static Singleton_5 instance;
    private Singleton_5(){}
    public static Singleton_5 getInstance(){
        if (instance == null)
            synchronized (Singleton_5.class) {
                instance = new Singleton_5();
            }
        return instance;
    }
}
//6.双重检查【推荐用】
//Double-Check
//我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
//这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
class Singleton_6 {
    private static volatile Singleton_6 instance;//volatile!!!!!!
    private Singleton_6(){}
    public static Singleton_6 getInstance(){
        if (instance == null)
            synchronized (Singleton_6.class){
                if (instance == null)
                    instance = new Singleton_6();
            }
        return instance;
    }
}
//7.静态内部类【推荐用】
//这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
//不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
//而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，
//调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
//类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，
//在类进行初始化时，别的线程是无法进入的。
//优点：避免了线程不安全，延迟加载，效率高。
class Singleton_7 {
    private Singleton_7(){}
    private static class SingletonInstance{
        private final static Singleton_7 INSTANCE = new Singleton_7();
    }
    public static Singleton_7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
//8.枚举【推荐】
//不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
enum Singleton_8 {
    INTANCE;
    public void whateverMethod(){}
}