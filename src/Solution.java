import java.util.*;
import java.util.stream.Stream;

import static java.lang.Integer.toBinaryString;
public class Solution {

    /*
     * 461
     */
    public int hammingDistance(int x, int y) {
        //one line: Integer.bitCount(x ^ y);//异或
        List x2List = toBinary(x);
        List y2List = toBinary(y);

        int length = x2List.size(), zeroNum = 0, count = 0;
        //append zero to same length
        if (x2List.size() > y2List.size()) {
            length = x2List.size();
            zeroNum = x2List.size() - y2List.size();
            for (int i = 0; i < zeroNum; i++) {
                y2List.add(0);
            }
        } else if (x2List.size() < y2List.size()) {
            length = y2List.size();
            zeroNum = y2List.size() - x2List.size();
            for (int i = 0; i < zeroNum; i++) {
                x2List.add(0);
            }
        }
        System.out.println(x2List);
        System.out.println(y2List);
        //compare
        for (int i = 0; i < length; i++) {
            if (x2List.get(i) != y2List.get(i))
                count++;
        }

        return count;
    }

    public int hammingDistanceOptimize(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            res += xor & 1;
            xor >>= 1;
            System.out.println(toBinaryString(xor));
        }
        return res;
    }

    public List<Integer> toBinary(int n) {
        List<Integer> temp = new ArrayList<>();
        while (n / 2 >= 1 || n % 2 == 1) {//除2取余， (|| n%2 == 1) 在次为了补上最后一个0或者1
            temp.add(n % 2);
            n = n / 2;
        }
        //Collections.reverse(temp);
        return temp;
    }

    /*
    561
    Given an array of 2n integers, your task is to group these integers into n pairs of integer,
    say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    /*
      476
      Number Complement
     */
    public int findComplement(int num) {
        List<Integer> temp = new ArrayList<>();
        while (num / 2 >= 1 || num % 2 == 1) {//除2取余， (|| n%2 == 1) 在次为了补上最后一个0或者1
            temp.add(Math.abs(num % 2 - 1));
            num = num / 2;
        }
        //remove tail 0
        for (int i = temp.size() - 1; i >= 0; i--) {
            if (temp.get(i) == 0)
                temp.remove(i);
            else if (temp.get(i) == 1)
                break;
        }
        int decimal = 0;
        for (int j = 0; j < temp.size(); j++) {
            decimal = decimal + temp.get(j) * ((int) Math.pow(2, j));
        }

        return decimal;
    }

    /*
     *input: 5 101(+)
     *output: 2 010(+)
     * input + output = 111
     * (Integer.highestOneBit(num) << 1) - 1 即1000-1=0..0 111(+)
     * ~5 : 1..1 010（全部取反）
     * 取 & 后符号位为正，交集为0...0 010
     * notice : ~num全部取反，包括符号位，java中存储的二进制都是补码，~5对应的数是-6。
     */
    public int findComplementOptimize(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    /* 566
     * Reshape the Matrix
     * use matrix[index / width][index % width]
     * O(rc)
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int srcRow = nums.length;
        int srcColumn = nums[0].length;
        if (r * c != srcRow * srcColumn)
            return nums;
        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = nums[i / srcColumn][i % srcColumn];
        }

        return result;
    }

    /*
     *557. Reverse Words in a String III
     */
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String str : arr) {
            StringBuilder a = new StringBuilder(str);
            result.append(a.reverse());
            result.append(" ");

        }
        return result.substring(0, result.length() - 1);
    }

    public String reverseWords2(String s) {
        char[] s1 = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s1.length; j++) {
            if (s1[j] == ' ') {
                reverse(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s1, i, s1.length - 1);
        return new String(s1);
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    //541. Reverse String II
    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    //416. Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {

        Arrays.sort(nums);

        Integer[] newNum = new Integer[nums.length];
        int sum = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            newNum[i] = Integer.valueOf(nums[i]);
            sum += nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(newNum));

        int halfsum = sum / 2;
        if (sum % 2 != 0 || max > halfsum)
            return false;
        else if (max == halfsum)
            return true;

        int tmp = halfsum - max;
        return recSubset(tmp, list, 0);

    }

    public boolean recSubset(int num, List<Integer> list, int index) {

        List<Integer> list_tmp = new ArrayList<>();
        while (num > 0 && index < list.size()) {
            list_tmp.addAll(list);
            int a = num - list.get(index);
            if (a == 0)
                return true;
            if (a < 0)
                return false;
            list_tmp.remove((int) index);
            if (list_tmp.contains(a))
                return true;
            else {
                if (recSubset(a, list_tmp, 0))
                    return true;
                else
                    index++;
            }
            list_tmp.clear();
        }
        return false;

    }

    //时间复杂度是O(nums.length*sum)
    public boolean canPartitionOpt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //remove odd
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;//target number

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];//If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true; //target=0 且一个都不选的时候是可以的
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true; //dp[i][0] = dp[i-1][0]...=dp[0][0]
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {//i表示nums前多少个
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];//不放num[i-1]
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);//状态转移方程
                }
            }
            if(dp[i][sum]==true)
                return true;
        }

        return dp[n][sum];
    }


    public boolean canPartitionOpt2(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }

    //500. Keyboard Row
    public String[] findWords(String[] words) {

        int [] row1 = {'q','w','e','r','t','y','u','i','o','p'};
        int [] row2 = {'a','s','d','f','g','j','h','k','l'};
        int [] row3 = {'z','x','c','v','b','n','m'};
        List<Integer> kewrow1 = new ArrayList(intArrayToList(row1));
        List<Integer> kewrow2 = new ArrayList(intArrayToList(row2));
        List<Integer> kewrow3 = new ArrayList(intArrayToList(row3));

        List<String> result = new ArrayList<>();
        for(String str:words){
            if(inKeyRow(str.toLowerCase(),kewrow1) || inKeyRow(str.toLowerCase(),kewrow2)||inKeyRow(str.toLowerCase(),kewrow3))
                result.add(str);
        }

        return result.toArray(new String[0]);

    }

    public String[] findWordsOpt(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    public String[] findWordsOpt2(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }

    public boolean inKeyRow(String word,List<Integer> kewrow){

        int num = 0;
        for(char c: word.toCharArray()){
            if(kewrow.contains((int)c))
                num++;
        }
        if(num == word.toCharArray().length)
            return true;
        else
            return false;
    }

    public List<Integer> intArrayToList(int [] a){

        Integer[] i_a = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            i_a[i] = Integer.valueOf(a[i]);
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(i_a));

        return list;

    }


    //55. Jump Game
    public boolean canJump55(int[] nums) {

        if(nums.length > 1 && nums[0]==0) return false;
        int count=0,len = nums.length;
        for(int num:nums)//如果数组的值>0，则肯定能到达最后
            if(num>0)
                count++;
        if(count == len)
            return true;
        return deepLoop(nums,0);
    }

    /*
     * 1.max表示当前能到达的最远距离
     * 2.当前索引前面的所有索引都能到达
     */
    public boolean canJump55Opt(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public boolean deepLoop(int [] nums,int index){
        int len = nums.length;
        if(nums[index] >= len-(index+1) || index==nums.length-1) return true;
        else {
            if(nums[index]==0)
                return false;
            int next = Math.min(nums[index],len-index);
            for (int i = next; i >= 1; i--) {
                if(deepLoop(nums, index + i))
                    return true;
            }
        }
        return false;
    }

    public boolean canJump55Opt2(int[] nums) {

        for(int curr = nums.length-2; curr>=0;curr--){//从倒数第二个开始遍历，排查0
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){//该数组前面的元素是否能够跳过0点
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }

    //45. Jump Game II
    public int jump45(int[] nums) {//exceeds time limit

        //初始化
        int [] jumpNum = new int[nums.length];
        for(int i=0;i<jumpNum.length-1;i++){
            if(nums[i]+i>=nums.length)
                jumpNum[i]=1;
            else
                jumpNum[i]=10000;
        }
        jumpNum[nums.length-1]=0;

        for(int i=nums.length-2;i>=0;i--){
            int tmp = Math.min(nums[i],nums.length-i-1);//当前索引i能到达的最远索引间隔
            for (int j = tmp;j>0;j--){
                jumpNum[i] = Math.min(jumpNum[i],1+jumpNum[i+j]);
            }
        }
        for(int i=0;i<jumpNum.length;i++){
            System.out.println(nums[i] + " " +jumpNum[i]);
        }
        return jumpNum[0];
    }

    public int jump45Opt(int[] A) {
        int step_count = 0;//需要的跳跃次数
        int last_jump_max = 0;//最长可达索引
        int current_jump_max = 0;
        for (int i = 0; i < A.length - 1; i++) {//假设一定可达
            current_jump_max = Math.max(current_jump_max, i + A[i]);
            if (i == last_jump_max) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
    int [][] matrix;
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 > row2 || col1 > col2)
            return -1;
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        System.out.print(matrix[0].length);
        int finalsum = 0;
        for(int i = row1;i <= row2;i++)
            for(int j = col1;j <= col2;j++)
                finalsum += matrix[i][j];
        return finalsum;
    }

    // 1.[easy]:two sum
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            int diff = target - nums[i];
            if(hashmap.containsKey(diff)){
                int [] returnArr = {hashmap.get(diff),i};
                return returnArr;
            }
            hashmap.put(nums[i],i);
        }
        return null;
        //test
//        int [] tmp = {-1,-2,-3,-4,-5};
//        int [] test = solution.twoSum(tmp,-8);
//        System.out.println(test[0]);
//        System.out.println(test[1]);
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public  ListNode reversed_linkedlist(ListNode listNode) {
        ListNode head = listNode;
        if(head == null || head.next == null) {
            return head;
        }

        //使用三个节指针
        ListNode current = head;
        ListNode newHead = null;
        ListNode next = null;

        while(current != null) {
            //先将当前节点的下个节点保存
            next = current.next;
            current.next = newHead; //将原来的链表断链,将current的下一个结点指向新链表的头结点
            newHead = current; //将current设为新表头
            current = next; //将之前保存的next设为下一个节点
        }
        return newHead;
    }
    //2.[medium]:Add Two Numbers[single linkedlist]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //init
        int val = (l1.val + l2.val)%10;
        int tmp_val = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(val);
        l1 = l1.next;
        l2 = l2.next;

        ListNode current = head;
        if (l1 == null && l2 == null){
            if(tmp_val!=0){
                ListNode next = new ListNode(tmp_val);
                head.next = next;
            }
        }
        int sum_val = 0;
        while(l1 != null || l2 != null) {
            if (current == head)
                sum_val += tmp_val;
            else
                sum_val /= 10;
            if(l1 != null) {
                sum_val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum_val += l2.val;
                l2 = l2.next;

            }
            current.next = new ListNode(sum_val % 10);
            current = current.next;
        }
        if(sum_val / 10 == 1){
            current.next = new ListNode(sum_val / 10);
        }

        return head;

    }

    public void testAddTwoNumbers(){
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode returnNode = addTwoNumbers(l1,l2);
        System.out.print(returnNode.val);
    }

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
//        System.out.println(merge[half]+front);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testAddTwoNumbers();

//        int sum = solution.sumRegion(1, 1, 2, 2);
//        System.out.print(sum);
//        int [] a = {'a'};
//        System.out.println(a[0]);
//        int a = solution.hammingDistanceOptimize(8,5);
//        System.out.println("The Hamming distance between two integers is "+a);

//        int [] array_test = {4,3,1,2,5,7,9};
//        int a = solution.arrayPairSum(array_test);
//        System.out.println(a);

//        int b = solution.findComplementOptimize(6);
//        int a = solution.findComplement(6);
//        System.out.println(b);
//        System.out.println(a);
//        System.out.println(toBinaryString(n));
    }

}