package problemSolving;

public class LeetCode2169 {
    public static int countOperations(int num1, int num2) {
        int count = 0;
        while ( true  ) {
            if(num1 == 0 || num2 == 0){
                break;
            }
            else if (num1 > num2) {
                num1 = num1 - num2;
                count++;
            } else if (num2 > num1) {
                num2 = num2 - num1;
                count++;
            } else if (num1 == num2) {
                num1 = num1 - num2;
                count++;
            }


        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countOperations(2,3));
        System.out.println(countOperations(10,10));
        System.out.println(countOperations(0,0));
    }
}
