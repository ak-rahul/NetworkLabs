import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClient {
    public static void main(String args[]) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        byte buff[] = new byte[8000];

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Client : ");
            String msg = sc.nextLine();
            buff = msg.getBytes();
            DatagramPacket dp = new DatagramPacket(buff, buff.length, ip, 8080);
            ds.send(dp);
            if(msg.equals("bye")){
                break;
            }
            buff = new byte[8000];
        }
    }
    
}
