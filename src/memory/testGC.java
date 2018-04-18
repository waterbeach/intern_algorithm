package memory;

public class testGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;

    private byte[] bigsize = new byte[2*_1MB];

    public static void testgc(){
        testGC a = new testGC();
        testGC b = new testGC();

        a.instance = null;
        b.instance = null;
        System.gc();
    }


    public static void testAllocation(){
        /*
        对象优先在 Eden区进行分配
        VM　param： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
         */
        byte [] alloc1,alloc2,alloc3,alloc4;
        alloc1 = new byte[2*_1MB];
        alloc2 = new byte[2*_1MB];
        alloc3 = new byte[2*_1MB];
        alloc4 = new byte[4*_1MB];
    }

    public static void testTenuringThreshold(){
        /*
        长期存货的对象将进入老年代
        VM　param： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
                    -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
         */
        byte [] alloc1,alloc2,alloc3;
        alloc1 = new byte[1/_1MB];
        alloc2 = new byte[4*_1MB];
        alloc3 = new byte[4*_1MB];
        alloc3 = null;
        alloc3 = new byte[4*_1MB];

    }

    public static void main(String [] args){
        testGC.testTenuringThreshold();
    }

}
