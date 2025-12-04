package problemSolving;

public class LeetCode2211 {
    public static int countCollisions(String directions){
        int i = 0;
        int j = directions.length()-1;
        while (i<j && directions.charAt(i)=='L'){
            i++;
        }
        while (j>i && directions.charAt(j) == 'R'){
            j--;
        }
        if(i==j){
            return 0;
        }
        int answer = 0;
        while (i<=j){
            if (directions.charAt(i) != 'S'){
                answer++;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String dir1 = "RLRSLL";
        String dir2 = "LLRR";
        System.out.println(countCollisions(dir1));
        System.out.println(countCollisions(dir2));
    }
}
