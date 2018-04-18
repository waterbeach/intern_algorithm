public class ArrayTest {
    public static void main(String [] args){
        String a = "abc";
        String b = "abc";

        char [] ca = "abd".toCharArray();
        char [] cb = "abd".toCharArray();

        System.out.println("a == b ? "+(a==b));
        System.out.println("a.equals(b) ? "+(a.equals(b)));
        System.out.println("a.hashcode "+a.hashCode());
        System.out.println("b.hashcode "+b.hashCode());

        System.out.println("ca == cb ? "+(ca==cb));
        System.out.println("ca.equals(ca) ? "+(ca.equals(b)));
    }
}
