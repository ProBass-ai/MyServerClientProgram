package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class StoreServerSide {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startServer(int port) throws IOException {
        // when creating a server - it will have to be given a port number from which it must run at
        // once the port number number has been provided the server object is then created and starts listening for client connection
        serverSocket = new ServerSocket(port);
        // this is the point at which client connection is bindend to that of the server
        clientSocket = serverSocket.accept();

        // messeges sent to the client are sent using PrintWriter
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        // and messeges recieved from the client are read using BufferedReader
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // the readline() method reads input from the client on a line
        String greeting = in.readLine();
        //at this point the server should have a string value of the message sent by the client
        // further processing can happen from this point
        if ("start_shopping".equals(greeting)) {
            out.println("Online Shopping: Active Now\n...sending you to store.");
        } else if("quit".equals(greeting)){
            out.println("Quitting program");
            stop();
        } else {
            System.out.println("Unrecognised command");
        }

    }

    public void stop() throws IOException {
        // usually when working with servers, alot of streams are open
        // ideally we would not have much of an issue with them
        // but because they still continue to use up system resources
        // we have to switch them off once again
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();

    }

    public static void main(String[] args) throws IOException {
        // a quite weired thing about servers is that when you start them from their main, you also need to have created an instance of them as follows
        StoreServerSide server = new StoreServerSide();
        server.startServer(5000);

    }
}
