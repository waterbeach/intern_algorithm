package SwordOffer;

public class BigNumberOperation {
    public static void main(String [] args){

        String str1 = "852";
        String str2 = "67890";
        System.out.println(add(str1,str2));

        String str3 = "8963";
        String str4 = "765";
        System.out.println(multiply(str3,str4));

        String str5 = "6766";
        String str6 = "7765";
        System.out.println(subtract(str5,str6));

    }
    /*
    大数相加：
    result结果集的长度，其值为较长字符串的长度加一。
     */
    public static String add(String str1,String str2){
        char [] charList1 = new StringBuffer(str1).reverse().toString().toCharArray();
        char [] charList2 = new StringBuffer(str2).reverse().toString().toCharArray();

        int len1 = charList1.length;
        int len2 = charList2.length;

        int maxLen = len1 > len2 ? len1 : len2;
        int [] result = new int [maxLen + 1];

        for(int i = 0;i< maxLen+1;i++){
            int c1 = i < len1 ? charList1[i]-'0':0;
            int c2 = i < len2 ? charList2[i]-'0':0;
            result[i] = c1+c2;
        }

        for(int i = 0;i<maxLen;i++){
            if(result[i]>=10){
                result[i+1] += result[i]/10;
                result[i] %= 10;
            }
        }

        StringBuffer res = new StringBuffer();
        if(result[maxLen]!=0)
            res.append(result[maxLen]);
        for(int i = maxLen-1;i >= 0;i--)
            res.append(result[i]);

        return res.toString();
    }

    /*
     大数相减：
     result结果集的长度，其值为较长字符串的长度。
     要考虑结果为0的情况
   */
    public static String subtract(String str1, String str2) {

        char[] charList1 = new StringBuffer(str1).reverse().toString().toCharArray();
        char[] charList2 = new StringBuffer(str2).reverse().toString().toCharArray();
        int lenA = charList1.length;
        int lenB = charList2.length;

        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];

        // 结果的正负
        char sign = '+';
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            while (i > 0 && charList1[i] == charList2[i]) {
                i--;
            }
            if (charList1[i] < charList2[i]) {
                sign = '-';
            }
        }

        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (charList1[i] - '0') : 0;
            int bint = i < lenB ? (charList2[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要
        if (sign == '-') {
            sb.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        return sb.toString();
    }

      /**
     * 大数相乘基本思想，输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;<br>
     * 公式：AB*CD = AC (BC+AD) BD , 然后从后到前满十进位(BD,(BC+AD),AC)。
     * @param str1
     * @param str2
     */
    public static String multiply(String str1, String str2){// 98*765=74970
        //反转字符串
        char [] charList1 = new StringBuffer(str1).reverse().toString().toCharArray(); // 89
        char [] charList2 = new StringBuffer(str2).reverse().toString().toCharArray(); // 567

        int len1 = charList1.length;
        int len2 = charList2.length;

        int [] result = new int [len1+len2];

        for(int i = 0;i<len1;i++){
            for(int j = 0;j<len2;j++){
                result[i+j] += (charList1[i]-'0') * (charList2[j] - '0');
            }
        }

        for(int i = 0; i<len1+len2;i++){
            if(result[i] >= 10){
                result[i+1] += result[i]/10;
                result[i] = result[i]%10;
            }
        }

        StringBuffer res = new StringBuffer();
        boolean flag = true;
        for(int i = len1+len2-1;i>=0;i--){
            if(result[i]==0 && flag){
                continue;
            }
            else{
                flag = false;
            }
            res.append(result[i]);
        }

        return res.toString();
    }
}


