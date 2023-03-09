import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class groupCommunicationHandler implements Runnable {

    private Socket newclient = null;
    private ArrayList<Socket> connectionlist = null;
    private DataInputStream din = null;
    private DataOutputStream dout = null;

    public groupCommunicationHandler(Socket newclient, ArrayList<Socket> connectionlist) {
        this.newclient = newclient;
        this.connectionlist = connectionlist;
    }

    private void broadcast(String message) {
        System.out.println(message);
        for (Socket socket : connectionlist) {
            if (newclient == socket) {
                continue;
            }
            try {
                dout = new DataOutputStream(socket.getOutputStream());
                dout.writeUTF(message);
                dout.flush();
            } catch (IOException e) {}
        }
    }

    private void handle() {

        try {
            din = new DataInputStream(newclient.getInputStream());
            String message = "";
            while (true) {
                message = din.readUTF();
                broadcast(message);
            }
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        handle();
    }
}

public class server {
    public static void main(String[] args) {
        ArrayList<Socket> connectionlist = new ArrayList<>();
        System.out.println("<------Server Log------>");
        while (true) {
            try (ServerSocket server = new ServerSocket(9999)) {
                Socket newclient = server.accept();
                if (newclient.isConnected()) {
                    System.out.println("New Connection! : "+newclient.getRemoteSocketAddress());
                    connectionlist.add(newclient);
                    groupCommunicationHandler handler = new groupCommunicationHandler(newclient, connectionlist);
                    Thread handlerThread = new Thread(handler);
                    handlerThread.start();
                }
            } catch (IOException e) {}
        }
    }
}
