import java.util.*;

public class Hamming{
    public static void main(String args[]){
        
        int bitSize;
        int[] bits = new int[20];
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of bits : ");
        bitSize  = sc.nextInt();
        for(int i = 1; i<=bitSize; i++ ){
            System.out.print("Enter bit at position "+i+": ");
            bits[i] = sc.nextInt();
        }

        int r = 0;
        while(Math.pow(2,r) < (bitSize + r + 1)){
            r++;
        }

        int totalSize = bitSize + r;
        int[] newBits = new int[20];
        int bitsPointer = 1;
        
        int redundant = 0;
        for(int i=1; i<=totalSize; i++){
            if(Math.pow(2, redundant) == i && redundant < r){
                newBits[i] = 8;
                redundant ++;
            } else {
                newBits[i] = bits[bitsPointer];
                bitsPointer++;

            }
        }
 
        for(int i = 0;i<r; i++){
            int countOfOnes = 0;
            for(int j = 1; j<=totalSize; j++){
                if ((j / (int)Math.pow(2, i)) % 2 == 1 && newBits[j] == 1){
                    countOfOnes ++;
                }
            }
            int location = (int)Math.pow(2,i);
            if(countOfOnes % 2 == 0){
                newBits[location] = 0; 
            } else {
                newBits[location] = 1;
            }
        }

        System.out.println("\nHamming Code is: ");
        for(int i=totalSize; i>=1; i--){
            System.out.print(newBits[i] + " ");
        }
        System.out.println();
        
        System.out.print("\nEnter  bit to stimulate an error");
        int errorPosition = sc.nextInt();
        newBits[errorPosition] = newBits[errorPosition] == 1 ? 0 : 1;
        System.out.println("\nError code is : ");
        for(int i=totalSize; i>=1; i--){
            System.out.print(newBits[i] + " ");
        }
        System.out.println();

        String redundantString = new String();
        for(int i = 0;i<r; i++){
            int countOfOnes = 0;
            for(int j = 1; j<=totalSize; j++){
                if ((j / (int)Math.pow(2, i)) % 2 == 1 && newBits[j] == 1){
                    countOfOnes ++;
                }
            }
            if(countOfOnes % 2 == 0){
                redundantString = "0" + redundantString; 
            } else {
                redundantString = "1" + redundantString;
            }
        }
        System.out.println("\n" + redundantString);
        
        if(0 < Integer.parseInt(redundantString,2) && Integer.parseInt(redundantString,2) <= totalSize){
            newBits[Integer.parseInt(redundantString,2)] = newBits[Integer.parseInt(redundantString,2)] == 1 ? 0 : 1;
            System.out.println("\nError is found at location " + Integer.parseInt(redundantString,2));
            System.out.println("\nCorrected HammingCode is : ");
            for(int i=totalSize; i>=1; i--){
                System.out.print(newBits[i] + " ");
            }
            System.out.println();
        }  else {
            System.out.println("No error");
        }

        sc.close();
    }
}