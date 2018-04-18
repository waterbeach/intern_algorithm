package intern;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by zengyarong on 2018/2/9.
 */

public class TestLeetcode {
    @Test
    public void testFindMedianSortedArrays(){
        Leetcode solution = new Leetcode();
        int [] num1 = {1,3,4};
        int [] num2 = {2,2,3};
        System.out.println(solution.findMedianSortedArrays(num1,num2));
    }

    @Test
    public void testSingleNumber(){
        Leetcode solution = new Leetcode();
        int [] num1 = {2,2,1};
        System.out.println(solution.singleNumber(num1));
    }

    @Test
    public void testRotate(){
        Leetcode solution = new Leetcode();
        int [] num1 = {1,2,3,4,5,6,7,8};
        solution.rotate(num1,3);
        for(int i = 0; i < num1.length;i++) {
            System.out.println(num1[i]);
        }
    }

    @Test
    public void testIntersect(){
        Leetcode solution = new Leetcode();
        int [] num1 = {1,2,2,3,4,5,6,7,8};
        int [] num2 = {2,2,3,6,7,88,55,22};
        int [] result = solution.intersect(num1,num2);
        for(int i = 0; i < result.length;i++) {
            System.out.println(result[i]);
        }
    }

    @Test
    public void testGroupAnagrams(){
        Leetcode solution = new Leetcode();
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for(List<String> list : result) {
            System.out.print("[");
            for(int i = 0;i<list.size();i++) {
                if(i==list.size()-1)
                    System.out.print(list.get(i));
                else
                    System.out.print(list.get(i) + ",");
            }
            System.out.println("]");
        }
    }

    @Test
    public void testLengthOfLongestSubstring(){
        Leetcode solution = new Leetcode();
        String str = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstringOp(str));
    }

    @Test
    public void testLongestPalindrome(){
        Leetcode solution = new Leetcode();
        String str = "babbad";
        System.out.println(solution.longestPalindrome3(str));
    }

    @Test
    public void testFirstUniqChar(){
        Leetcode solution = new Leetcode();
        String str = "loveleetcode";
        System.out.println(solution.firstUniqChar1(str));
    }

    @Test
    public void testRemoveDuplicates(){
        Leetcode solution = new Leetcode();
        int [] num1 = {1,2,2,3,3,3,6,7,8};
        int [] num2 = {1,2,2,3,3,3,6,8,8};
        System.out.println(solution.removeDuplicates(num1)); // 6 :[1,2,3,6,7,8]
        System.out.println(solution.removeAllDuplicates(num2)); //4: [1,6,7,8]

    }

    @Test
    public void testThreeSum(){
        Leetcode solution = new Leetcode();
        int [] num1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(num1).size());
        for(int i = 0;i<solution.threeSum(num1).size();i++){
            for(int j = 0;j<solution.threeSum(num1).get(i).size();j++)
                System.out.println(solution.threeSum(num1).get(i).get(j));
        }
    }

    @Test
    public void testFourSum(){
        Leetcode solution = new Leetcode();
        int [] num1 = {0,0,0,0};
        System.out.println(solution.fourSum(num1,0).size());
        for(int i = 0;i<solution.fourSum(num1,0).size();i++){
            for(int j = 0;j<solution.fourSum(num1,0).get(i).size();j++)
                System.out.println(solution.fourSum(num1,0).get(i).get(j));
        }
    }

}
