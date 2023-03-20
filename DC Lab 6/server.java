
/**
 * Lamport mutex algo
 * 
 * incomplete! contributions are welcomed!!
 * 
 * this server actually shouldn't exist, the processes should communicate with themselves without any form of communication interface in between.
 * 
 * the purpose of this code is to only broadcast messages from one process's socket to other processes in order to reduce complexity of the implementation of this algo
 * 
 * 
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class serverHandler extends Thread {
    private Socket lamport_process = null;
    private ArrayList<Socket> connections = null;
    private DataInputStream din = null;
    private DataOutputStream dout = null;

    public serverHandler(Socket lamport_process, ArrayList<Socket> connections) {
        this.lamport_process = lamport_process;
        this.connections = connections;
    }

    private void broadcast(String message) throws IOException {
        for (Socket socket : connections) {
            if (lamport_process == socket) {
                continue;
            }
            dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
        }
    }

    private void startReceiving() throws IOException {
        din = new DataInputStream(lamport_process.getInputStream());
        String message = "";
        /*
         * it is incomplete, we have to broadcast the clocks as well to other processes
         * as well
         */
        while (true) {
            message = din.readUTF();
            System.out.println(
                    "message from lamport_process " + lamport_process.getRemoteSocketAddress() + " is " + message);
            broadcast(message);
        }
    }

    @Override
    public void run() {
        try {
            startReceiving();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class server {

    public static void main(String[] args) throws Exception {
        System.out.println("Setting up server...");
        System.out.println("Address  : " + Inet4Address.getLocalHost().getHostAddress());
        System.out.println("Port : 9999");

        ArrayList<Socket> connections = new ArrayList<>();

        ServerSocket server = new ServerSocket(9999);

        System.out.println("Server Started!...\nWaiting for connections...");

        while (true) {
            Socket lamport_process = server.accept(); /* connect as many processes as you want */
            if (lamport_process.isConnected()) {
                connections.add(lamport_process);
                serverHandler serverThread = new serverHandler(lamport_process, connections);
                serverThread.start();
            }
            else{
                if (lamport_process.isClosed()) {
                    if (connections.contains(lamport_process)){
                        connections.remove(lamport_process);
                                                
                    }
                }
            }
        }
    }
}
