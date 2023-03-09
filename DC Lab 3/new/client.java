import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class clientOutputHandler implements Runnable {
    private Socket client = null;
    private DataOutputStream dout = null;
    private String name = null;

    public clientOutputHandler(Socket client,String name){
        this.client = client;
        this.name = name;
    }

    public void sendMessages(){
        try {
            dout = new DataOutputStream(client.getOutputStream());
            Scanner scan = new Scanner(System.in);
            String message = "";
            while (true) {
                message = scan.nextLine();
                if (message.contains("!exit")) {
                    break;
                }
                dout.writeUTF(name + " : "  +message);
                dout.flush();
            }
            scan.close();
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        sendMessages();
    }
}

class clientinputHandler implements Runnable{
    private Socket client = null;
    private DataInputStream din = null;
    public clientinputHandler(Socket client){
        this.client = client;
    }

    public void receiveMessages(){
        try {
            din = new DataInputStream(client.getInputStream());
            String message = "";
            while (true) {
                message = din.readUTF();
                System.out.println(message);
            }

        } catch (IOException e) {}
    }

    @Override
    public void run() {
        receiveMessages();
    }
}

public class client {
    public static void main(String[] args) {
        String name = args[0];
        try {
            Socket myclient = new Socket("localhost", 9999);
            
            clientOutputHandler output = new clientOutputHandler(myclient,name);
            Thread outputHandlerThread = new Thread(output);
            outputHandlerThread.start();

            clientinputHandler input = new clientinputHandler(myclient);
            Thread inputHandlerThread = new Thread(input);
            inputHandlerThread.start();

            System.out.println("begin talking! ");

        } catch (IOException e) {}
    }
}
