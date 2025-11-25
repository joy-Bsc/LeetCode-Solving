package problemSolving;

public class LeetCode1015 {
    public static int smallestRepunitDivByK(int k){
        if(k%2==0 || k%5==0) return -1;
        int remainder = 1%k;
        int length = 1;
        while(remainder != 0){
            remainder = ((remainder*10)+1)%k;
            length++;
            if(length > k) return -1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(3));
    }
}
