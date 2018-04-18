//import org.junit.jupiter.api.Test;
//
///**
// * Created by zengyarong on 2017/6/5.
// */
//public class testSolution {
//
//    Solution solution = new Solution();
//
//    @Test
//    public void testMatrixReshape(){
//
//        int [][] nums ={{1,2,3},{4,5,6}};
//        int r = 3;
//        int c = 2;
//        int [][] result = solution.matrixReshape(nums,r,c);
//        for(int i = 0;i<r;i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//    }
//
//    @Test
//    public void testReverseWords(){
//        String src = "Let's take LeetCode contest";
//        System.out.println(src.length());
//        String des = solution.reverseWords2(src);
//        System.out.println(des);
//        System.out.println(des.length());
//
//    }
//
//    @Test
//    public void testReverseStr(){
//        String s = "abcdefg";int k = 2;
//        String res = solution.reverseStr(s,k);
//        System.out.println(res);
//    }
//
//    @Test
//    public void testCanPartition(){
//        int [] nums = {3,3,3,4,5};
//        int [] nums2 = {2,3,3,4,6,4};
//        System.out.println(solution.canPartition(nums));
//    }
//
//    @Test
//    public void testFindWords(){
//        String [] a = {"Hello", "Alaska", "Dad", "Peace"};
//        String [] b = solution.findWords(a);
//        for(String str:b)
//            System.out.print(str+" ");
//    }
//
//    @Test
//    public void testCanJump55(){
//        int [] nums = {2,3,1,1,4};
//        int [] nums2 = {3,2,1,0,4};
//        System.out.println(solution.canJump55Opt2(new int[0]));
//    }
//
//    @Test
//    public void testJump(){
//        int [] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
//        System.out.println(solution.jump45Opt(nums));
//    }
//
//    @Test
//    public void testFindMedianSortedArrays(){
//        int [] num1 = {1,3};
//        int [] num2 = {2};
//        System.out.println(solution.findMedianSortedArrays(num1,num2));
//
//    }
//
//
//
//}
