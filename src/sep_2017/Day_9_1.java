package sep_2017;

import java.util.*;

/**
 * Created by zengyarong on 2017/9/1.
 */
public class Day_9_1 {

    public int lengthOfLongestSubstring_opt1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring_opt2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


    //求字符串最长不含重复字符的子串
    public int lengthOfLongestSubstring(String s) {

        char [] charArray = s.toCharArray();
        List<String> storeList = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();

        for(int i = 0;i < charArray.length;i++){
            tmp.add(charArray[i]);
            if(i != charArray.length-1) {
                if (charArray[i] == charArray[i + 1] || tmp.contains(charArray[i + 1])) {
                    storeList.add(charList2String(tmp));
                    if(charArray[i] != charArray[i + 1]){
                        int tt = tmp.size() - tmp.indexOf(charArray[i + 1])-1;
                        i-= tt;
                    }
                    tmp.clear();
                }
            }
        }
        if(tmp.size()>0)
            storeList.add(charList2String(tmp));

        int maxSize = -1;
        String maxStr = null;
        for(String str:storeList){
            if(str.length() > maxSize) {
                maxSize = str.length();
                maxStr = str;
            }
        }
        System.out.println(maxStr);
        return maxSize;
    }

    public String charList2String(List<Character> list){
        StringBuilder str = new StringBuilder();
        for (Object character : list) {// 对ArrayList进行遍历，将字符放入StringBuilder中
            str.append((char)character);
        }
        return str.toString();
    }

    public static void main(String [] args){
        Day_9_1 main = new Day_9_1();
        int a = main.lengthOfLongestSubstring_opt1("anvinjg");
        System.out.print(a);
    }

}

