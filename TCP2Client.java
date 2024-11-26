import java.util.*;
import java.net.*;
import java.io.*;

public class TCP2Client {
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",8080);   
        
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream());

        while(true){
            System.out.print("Client : ");
            String clientMsg = sc.nextLine();
            out.println(clientMsg);
            out.flush();
            if(clientMsg.equals("bye")){
                break;
            }
            String serverMsg = in.nextLine();
            System.out.println("Server : " + serverMsg);
            if(serverMsg.equals("bye")){
                break;
            }
        }
    }
}