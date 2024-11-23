import java.io.*;
import java.util.*;

public class arp {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        String input;
        int choice = -1;
        while(choice <= 3){
            try { 
                Scanner reader = new Scanner(new File("arp.txt"));
                System.out.println("\n1. ARP");
                System.out.println("2. RARP");
                System.out.println("3. Exit");
                System.out.print("Enter choice : ");
                choice = sc.nextInt();
                sc.nextLine();

                if(choice == 1){
                    int flag = 0;
                    System.out.print("Enter IP address : ");
                    input = sc.nextLine();
                    while(reader.hasNextLine()){
                        String[] parts = reader.nextLine().split("\\s+");
                        if(input.equals(parts[0])){
                            System.out.println("Coresponding MAC address is : " + parts[1]);
                            flag = 1;
                        }
                    } 
                    if(flag == 0) {
                        System.out.println("No such IP address found....");
                    }
                } else if (choice == 2) {
                    int flag = 0;
                    System.out.print("Enter MAC address : ");
                    input = sc.nextLine();
                    while(reader.hasNextLine()){
                        String[] parts = reader.nextLine().split("\\s+");
                        if(input.equals(parts[1])){
                            System.out.println("Coresponding IP address is : " + parts[0]);
                            flag = 1;
                        }
                    } 
                    if(flag == 0) {
                        System.out.println("No such MAC address found....");
                    }
                } else {
                    System.out.println("Bye.....");
                    reader.close();
                    sc.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }  
}