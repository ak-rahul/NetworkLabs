import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDP2Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        while (true) {
            DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);

            String clientMessage = new String(receive, 0, DpReceive.getLength());
            System.out.println("Client: " + clientMessage);

            if (clientMessage.equals("exit")) {
                System.out.println("Client sent exit... Server shutting down.");
                break;
            }

            System.out.print("Enter message: ");
            String response = sc.nextLine();

            DatagramPacket DpSend = new DatagramPacket(response.getBytes(), response.length(), DpReceive.getAddress(), DpReceive.getPort());
            ds.send(DpSend);

            receive = new byte[65535];
        }
        sc.close();
        ds.close();
    }
}