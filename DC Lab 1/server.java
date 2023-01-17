import java.io.*;  
import java.net.*;  
public class server {  
    public static void main(String[] args){  
        try{  
            ServerSocket ss=new ServerSocket(6666);  
            Socket s=ss.accept();//establishes connection   
            DataInputStream dis=new DataInputStream(s.getInputStream());  
            int a =(Integer)dis.readInt();  
            int b =(Integer)dis.readInt();  
            System.out.println(a+b);  
            ss.close();  
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }  
}  
