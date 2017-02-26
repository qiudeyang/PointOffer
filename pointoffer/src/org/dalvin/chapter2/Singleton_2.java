package org.dalvin.chapter2;

import java.util.Hashtable;

/**
 * Created by qiudeyang on 18/12/16.
 */
//可参考：https://qiudeyang.github.io/2017/02/15/%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F%E7%9A%84%E7%9B%B8%E5%85%B3%E6%80%BB%E7%BB%93/
class Singleton{
    private Singleton(){

    }
    private static volatile Singleton instance = null;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
//The following is the best method
public class Singleton_2 {
    private static Singleton_2 ourInstance = new Singleton_2();

    //private：除了Singleton类内部，其它地方无法访问该变量；
   //static：确保是静态类变量，这样可以通过类名来访问，无须实例；

    public static Singleton_2 getInstance() {
        return ourInstance;
    }

//    public：这样外部才能调用；
//    static：这样外部才能通过类名来访问，否则获取不到单例对象

    private Singleton_2() {
    }
//    需要显式定义构造函数，并将其设置为private，这样在Singleton类之外new的话编译器就会报错，即使是Singleton的子类也不行：
}
