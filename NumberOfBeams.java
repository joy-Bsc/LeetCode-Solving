package problemSolving;

public class NumberOfBeams {
    public static int numberOfBeams(String[] bank){
        int totalBeam = 0;
        int PreviousDevice = 0;
        for(String row : bank){
            int CurrentDevice = numberOfDevices(row);
            if(CurrentDevice == 0) {
                continue;
            }
             totalBeam  += PreviousDevice * CurrentDevice;
                 PreviousDevice =CurrentDevice ;
        }
         return totalBeam;
    }
    private static int numberOfDevices(String row){
        int count = 0;
         for(char device : row.toCharArray()){
             if(device == '1'){
                 count++;
             }
         }
         return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }
}
