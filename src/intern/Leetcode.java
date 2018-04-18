package intern;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zengyarong on 2018/2/9.
 */
public class Leetcode
{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] merge = new int[len1+len2];

        int i=0,j=0,p=0;
        while(i < len1 & j < len2){
            if(nums1[i] < nums2[j]) {
                merge[p++] = nums1[i];
                i++;
            }else {
                merge[p++] = nums2[j];
                j++;
            }
        }

        while(i<len1){
            merge[p++] = nums1[i];
            i++;
        }
        while(j<len2){
            merge[p++] = nums2[j];
            j++;
        }
        int half = (len1+len2)/2;
        int front = merge[half];
        reverseArrays(merge);
        return (merge[half]+front)/2.0;

    }

    public void reverseArrays(int [] validData){
        for(int i = 0; i < validData.length / 2; i++)
        {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        for(Map.Entry entry:map.entrySet()){
            if(entry.getValue().equals(1))
                return (int)entry.getKey();
        }
        return -1;

        /* Op
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result ^= nums[i]
        }
        return result;

         */
    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);//reverse all
        reverse(nums, 0, k - 1); // reverse first k nums
        reverse(nums, k, nums.length - 1); // reverse remain nums
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }
    /*
    sort list, optimal store memory
     */
    public int[] intersect_op(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i< nums1.length && j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map <String,List> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char [] c = strs[i].toCharArray() ;
            Arrays.sort(c); // used to find same word
            String key = String.valueOf(c);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n==0)
            return 0;
        Set set = new HashSet(); // sliding window
        int result=0,i=0,j=0;
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j = j+1;
                result = Math.max(result,j-i);
            }
            else{
                set.remove(s.charAt(i));
                i = i+1;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstringOp(String s) {
        if (s.length()==0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0,j=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    public String longestPalindrome(String s) {// brute force solution
        int max = 0;
        String result = s.substring(0,1);

        for(int i=0;i<s.length();i++)
            for(int j = i+1;j<s.length();j++) {
                if(isPalindromic(s,i,j)){
                    if(max<j-i+1){
                        max = j-i+1;
                        result = s.substring(i,j+1);
                    }
                }
            }
        return result;
    }

    public boolean isPalindromic(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

    public String longestPalindrome2(String s) { // dynamic programmming O(n^2)
        if(s.length()==0)
            return null;
        int max = 0,n=s.length();
        String result = s.substring(0,1);
        boolean dp[][] = new boolean[n][n];

        for(int i=0;i<n;i++)
            for(int j=i;j>=0;j--){
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((i-j<3)||dp[i-1][j+1]);

                if(dp[i][j] && (i-j+1)>max){
                    max = i-j+1;
                    result = s.substring(j,i+1);
                }
            }
        return result;
    }

    public String longestPalindrome3(String s) {// center expand O(n^2)
        int n=s.length();
        String result = s.substring(0,1);

        for(int i = 0;i<n;i++){
            String s1 = palindromicStr(s,i,i); //odd
            String s2 = palindromicStr(s,i,i+1); //even
            if(s1.length() > result.length())
                result = s1;
            if(s2.length() > result.length())
                result = s2;
        }
        return result;

    }

    public String palindromicStr(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){ //first satisfy index,then satisfy equation
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        Set set = new HashSet();
        for(int i = 0;i < s.length();i++){
            if(set.contains(s.charAt(i))) {
                if(map.containsKey(s.charAt(i)))
                    map.remove(s.charAt(i));
            }
            else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return getMinValue(map);
    }

    public static int getMinValue(Map<Character, Integer> map) {
        if (map == null || map.size()==0)
            return -1;
        Collection<Integer> c = map.values();
        Object [] obj = c.toArray();
        Arrays.sort(obj);
        return Integer.parseInt(obj[0].toString());
    }

    public int firstUniqChar1(String s) {
        int [] freq = new int[26]; //26 letter
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public int removeAllDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int j = 0;
        int count = 0;
        while(j < nums.length -1){
            boolean delBool = false;
            if(nums[j] == nums[j+1])
                delBool = true;
            if(delBool){
                int delVal = nums[j];
                while(j< nums.length && nums[j] == delVal){
                    j++;
                }
            }
            else{
                count++;
                j++;
            }
        }
        if(j==nums[nums.length-1])
            count++;
        return count;
    }

    public String magicCoin(int a){
        String result = "";
        while(a>0){
            if(a%2==0){
                result = "2"+result;
                a = (a-2)/2;
            }
            else{
                result = "1"+result;
                a = (a-1)/2;
            }
        }
        return result;

    }

    public int oppositeNumber(int a){
        String a_str = String.valueOf(a);
        a_str = new StringBuilder(a_str).reverse().toString();
        int del = 0,i = 0;
        while(true){
            if(a_str.charAt(i)=='0'){
                i++;
                del++;
            }
            else
                break;
        }
        int result = Integer.parseInt(a_str.substring(del,a_str.length()))+a;
        return result;
    }

    public static String stringPiece(String s){
        int num = 1;
        if(s.length()==0)
            return "0";
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                num++;
            }
        }
        String str = String.format("%.02f",div(s.length(),num,2));
        //System.out.print(str);
        return str;//;
    }

    public static double div(double d1,double d2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;// skip same result
            int lo=i+1,hi=nums.length-1,target = 0-nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++; // skip same result
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--; // skip same result
                    lo++;
                    hi--;
                }
                else if (nums[lo] + nums[hi] < target)
                    lo++;
                else
                    hi--;
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums,int target) {

        List<List<Integer>> result = new ArrayList();
        if(nums.length<4)
            return result;
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        for(int f=0;f<nums.length-3;f++){
            if (nums[f] + 3 * max < target) // too small
                continue;
            if (4 * nums[f] > target) // too large
                break;
            if(f>0 && nums[f]==nums[f-1]) // avoid duplicate
                continue;
            int threesum = target-nums[f]; // three sum
            for(int i = f+1;i<nums.length-2;i++){
                if(i>f+1 && nums[i]==nums[i-1]) // avoid duplicate
                    continue;
                int lo=i+1,hi=nums.length-1,twosum = threesum-nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == twosum) {
                        result.add(Arrays.asList(nums[f],nums[i],nums[lo],nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++; // skip same result
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--; // skip same result
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < twosum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return result;
    }

    public static void main(String [] args){
        Leetcode l = new Leetcode();
        String a = "wwwwssffiuuuuusssssooooolllsssssshhhhcccchhhhhllo";
        System.out.println(l.stringPiece(a));
        Scanner input =new Scanner(System.in);
    }



}
