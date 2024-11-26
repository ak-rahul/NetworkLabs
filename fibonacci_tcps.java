import java.util.*;
import java.io.*;
import java.net.*;

public class fibonacci_tcps {
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
            int number = Integer.parseInt(msg);
            int fibo = 1;
            while(number > 0){
                fibo *= number;
                number -= 1 ;
            }
            System.out.println("Server : " + fibo);
            out.println(fibo);
            out.flush();
        }
    }
}
