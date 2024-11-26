import java.util.*;
import java.io.*;
import java.net.*;

public class TCP2Server {
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("Server is listening at port 8080");
        Socket s = ss.accept();
        System.out.println("Connection estabilished successfully.....");
        
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream());

        while (true){
            String msg = in.nextLine();
            System.out.println("Client : " + msg);
            if(msg.equals("bye")){
                break;
            }
            System.out.print("Server : ");
            String serverMsg = sc.nextLine();
            out.println(serverMsg);
            out.flush();
            if(serverMsg.equals("bye")){
                break;
            }
        }
    }
}
