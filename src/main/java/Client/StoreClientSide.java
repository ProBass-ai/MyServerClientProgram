package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StoreClientSide {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static Scanner scanner;


    public void startConnection(String ip, int port) throws IOException {
        // a socket is set up for a client to use when connecting with/to the server
        // client-side sockect requirements are usually the servers IP Address and the servers port number
        clientSocket = new Socket(ip, port);
        // the socket is then used to send and recieve messages to and from the server
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {

        out.println(msg);
        String resp = in.readLine();
        return resp;

    }

    public void stopConnection() throws IOException {

        in.close();
        out.close();
        clientSocket.close();

    }

    public static void main(String[] args) throws IOException {

        System.out.println("M&M Shopping: now online");

        StoreClientSide client = new StoreClientSide();

        scanner = new Scanner(System.in);
        System.out.println("Do you wish to start shopping(y/n)?");
        String userInput = scanner.nextLine();

        if (userInput.equals("y")) {
            client.startConnection("localhost", 5000);
            client.sendMessage("start_shopping");
        } else if (userInput.equals("n")) {

        }


    }

}
