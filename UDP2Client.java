import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class UDP2Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte[] receive = new byte[65535];

        while (true) {
            System.out.print("Enter message: ");
            String inp = sc.nextLine();

            DatagramPacket DpSend = new DatagramPacket(inp.getBytes(), inp.length(), ip, 1234);
            ds.send(DpSend);

            if (inp.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }

            DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);

            String serverResponse = new String(receive, 0, DpReceive.getLength());
            System.out.println("Server: " + serverResponse);
        }
        sc.close();
        ds.close();
    }
}