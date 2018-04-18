package singleInstance;

//单线程
public class singleInstance {
    private static singleInstance sin = null;
    private void singleInstance(){}

    public static singleInstance getInstance(){
        if(sin==null)
            sin = new singleInstance();
        return sin;
    }

}

//饿汉式 类加载需要一些时间
//public class singleInstance {
//    private static singleInstance sin = new singleInstance();
//    private void singleInstance(){}
//
//    public static singleInstance getInstance(){
//        return sin;
//    }
//
//}

//饿汉式 静态内部类 调用getInstance方法才会进行实例化
//public class singleInstance {
//    private void singleInstance(){}
//
//    private static class singleClass{
//        private static final singleInstance sin1 = new singleInstance();
//    }
//
//    public static final sigleInstance getInstance(){
//        return singleClass.sin1;
//    }
//
//}


//懒汉式 线程安全，但是效率低
//public class singleInstance {
//    private static singleInstance sin;
//    private void singleInstance(){}
//
//    public static synchronized singleInstance getInstance(){
//        if(sin==null){
//            sin = new singleInstance();
//        }
//        return sin;
//    }
//
//}

//懒汉式 双重加锁机制，效率有所上升，若sin存在则直接返回；
//public class singleInstance {
//    private static singleInstance sin;
//    private void singleInstance(){}
//
//    public static singleInstance getInstance(){
//        if(sin==null){
//            synchronized (singleInstance.class) {
//                if(sin==null)
//                    sin = new singleInstance();
//            }
//        }
//        return sin;
//    }
//
//}






