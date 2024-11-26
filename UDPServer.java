import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(8080);
        byte buff[] = new byte[8000];

        while(true){
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            ds.receive(dp);

            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Client : "+ msg);
            if(msg.equals("bye")){
                break;
            }
            buff = new byte[8000];   
        }
    }
}