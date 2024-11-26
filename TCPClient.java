import java.util.*;
import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",8080);   
        
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream());

        while(true){
            System.out.print("Client : ");
            String msg = sc.nextLine();
            out.println(msg);
            out.flush();
            if(msg.equals("bye")){
                break;
            }
        }
    }
}