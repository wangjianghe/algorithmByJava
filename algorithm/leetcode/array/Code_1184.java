package leetcode.array;

public class Code_1184 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (destination<start){
            int swap=start;
            start=destination;
            destination=swap;
        }
        int clockwise=0;
        int partSum=0;
        int distanceSize=destination-start;
        if (distanceSize>(distance.length/2)){
            for (int i=destination;i!=start;){
                clockwise+=distance[i];
                if (i+1==distance.length){
                    i=0;
                }else{
                    i++;
                }
            }
            for (int i=start;i<destination;i++){
                partSum+=distance[i];
                if (partSum>clockwise){
                    return clockwise;
                }
            }
            return partSum;
        }else{
            for (int i=start;i<destination;i++){
                partSum+=distance[i];
            }
            for (int i=destination;i!=start;){
                clockwise+=distance[i];
                if (i+1==distance.length){
                    i=0;
                }else{
                    i++;
                }
                if (clockwise>partSum){
                    return partSum;
                }
            }
            return clockwise;
        }
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4},0,3));
    }
}
