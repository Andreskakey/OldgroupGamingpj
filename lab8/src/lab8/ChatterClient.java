package lab8;
import java.io.*;
import java.net.*;
 
public class ChatterClient {
    public static void main(String [] args) throws Exception {
    Socket serverSocket = new Socket(args[0], SERVER_PORT);
    String myReply="";
    PrintWriter toServer = new PrintWriter(serverSocket.getOutputStream(), true);
    BufferedReader fromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
 
    String incoming = "";
    String endstr = "end";
    String stopc = "over";
    
    while (true){
    	
    	while (true){
    		incoming = fromServer.readLine();
    	
        System.out.println(incoming);
       if ((incoming.compareTo(stopc) == 0) || 
    	  (incoming.compareTo(endstr) == 0))
    	   break;
    	}
    	if (incoming.compareTo(endstr) == 0)
    		break;
        System.out.print("Your turn> ");
        
        while (true){
        myReply = keyboard.readLine();
        toServer.println(myReply);
        if ((myReply.compareTo(stopc) == 0) || 
          	  (myReply.compareTo(endstr) == 0))
        break;
        System.out.println(">>");
        }
        if (myReply.compareTo(endstr) == 0)
        	break;
    	}
    	System.out.println("...");
    	}
        
 
    
    final static int SERVER_PORT = 3333;
}
