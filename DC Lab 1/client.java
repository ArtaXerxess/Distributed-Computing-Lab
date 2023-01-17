import java.io.*;  
import java.net.*;  
import java.util.*;
public class client {  
    public static void main(String[] args) {  
        Scanner userInput = new Scanner(System.in);
        try{      
            Socket s=new Socket("localhost",6666);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 

            System.out.println("Entre 1st no: ");
            int x= userInput.nextInt();

            System.out.println("Entre 2nd no: ");
            int y= userInput.nextInt();

            dout.writeInt(x);  
            dout.writeInt(y); 
            dout.flush();  
            dout.close();  
            s.close(); 
            userInput.close();
        }

        catch(Exception e){
            System.out.println(e);
        }  
    }  
}  
