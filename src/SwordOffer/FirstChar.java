package SwordOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/*
第一个只出现一次的字符
 */
public class FirstChar {
    public static int FirstNotRepeatingChar(String str) {
        if(str.length()==0)
            return -1;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<str.length();i++){
            if(map.containsKey(str.charAt(i)))
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            else
                map.put(str.charAt(i),1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()==1)
                return str.indexOf(entry.getKey());
        }
        return -1;
    }

    public static  void main(String [] args){
        String a = "aaccdeff";
        System.out.println(FirstNotRepeatingChar(a));
    }
}
