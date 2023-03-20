/**
 * Lamport mutex algo
 * 
 * incomplete! never been tested!
 * 
 * contributions are welcomed!!!
 * 
 * 
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class outputStreamHandler extends Thread {
    private Socket client = null;
    private DataOutputStream dout = null;
    private String pid = null;

    public outputStreamHandler(Socket client, String pid) {
        this.client = client;
        this.pid = pid;
    }

    private void beginCommunication(String pid) throws IOException {
        String message = pid;
        dout = new DataOutputStream(client.getOutputStream());
        dout.writeUTF(message); /* handshake basically */
        dout.flush();
        Scanner scan = new Scanner(System.in);
        /**
         * A process sends a REQUEST message to all other processes to get their
         * permission to enter critical section.
         * 
         * A process sends a REPLY message to requesting processes to give its
         * permission to enter the critical section.
         * 
         * A process sends a RELEASE message to all other processes upon exiting the
         * critical section.
         * 
         */
        String start = "Types of messages : REQUEST REPLY RELEASE";
        System.out.println(start);
        String cmd = "";
        while (true) {
            System.out.print(">>> ");
            cmd = scan.nextLine().toLowerCase();
            switch (cmd) {
                case "request":
                    request(dout);

                case "reply":
                    reply(dout);

                case "release":
                    release(dout);

                case "": /* didn't type any command */
                    continue;

                case "exit":
                    break;

                default:
                    break;
            }
        }
    }

    private void request(DataOutputStream dout) throws IOException {
        String request_message = "I need critical section ";
        dout.writeUTF(request_message);
        dout.flush();
        Date timestamp = new Date();
        dout.writeLong(timestamp.getTime()); /* it is easy to transmit time as miliseconds and it will later help in comparing timestamps */
        dout.flush();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        System.out.println("request sent at timestamp : " + format.format(timestamp));
    }

    private void reply(DataOutputStream dout) throws IOException {

    }

    private void release(DataOutputStream dout) throws IOException {

    }

    @Override
    public void run() {
        try {
            beginCommunication(pid);
        } catch (Exception e) {
        }
    }
}

class inputStreamHandler extends Thread {
    private Socket client = null;
    private String pid = null;
    private DataInputStream din = null;

    public inputStreamHandler(Socket client, String pid) {
        this.client = client;
        this.pid = pid;
    }

    /**
     * hmmm...
     */
    private void beginCommunication() throws IOException {
        /**
         * didn't think this far ahead yet...
         * 
         * contributions especially needed here...
         * 
         * 
         */
        String messages = "";
        din = new DataInputStream(client.getInputStream());

        while (true) {
            messages = din.readUTF();
            switch (messages) {
                case "":
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public void run() {
        try {
            beginCommunication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class process {
    public static void main(String[] args) throws Exception {
        /* terminal>java process [number] */
        // String pid = args[0]; /* when working with multiple processes */
        String pid = "Emperor Shaddam Corrino IV"; /* for testing this one process with server */
        System.out.println("Process name/id : " + pid);
        System.out.println("Process Address : " + Inet4Address.getLocalHost().getHostAddress());

        Socket harshu = new Socket("localhost", 9999);

        outputStreamHandler outputStreamHandlerThread = new outputStreamHandler(harshu, pid);
        outputStreamHandlerThread.start();

        inputStreamHandler inputStreamHandlerThread = new inputStreamHandler(harshu, pid);
        inputStreamHandlerThread.start();

    }
}
