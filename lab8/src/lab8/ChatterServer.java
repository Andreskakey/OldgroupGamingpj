package lab8;

import java.io.*;
import java.net.*;
 
public class ChatterServer {
    public static void main(String [] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
    System.err.println("Waiting for a client");
    Socket clientSocket = serverSocket.accept();
 
    System.out.println("Connection requested from: " + clientSocket.getLocalAddress());
    String myReply = "";
    PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    String endstr = "end";
    String stops = "over";
    String incoming= " ";
   while (true){
    	
   	while (true){
    		
    toClient.println("Whatcha want?");
    incoming = fromClient.readLine();
    if ((incoming.compareTo(stops) == 0) || 
      	  (incoming.compareTo(endstr) == 0))
      	   break;
    } 
        System.out.println(incoming);
    	if (incoming.compareTo(endstr) == 0)
    		break;
        System.out.print("Your turn> ");
    while (true){
        myReply = keyboard.readLine();
        toClient.println(myReply);
        if ((myReply.compareTo(stops) == 0) || 
            	  (myReply.compareTo(endstr) == 0))
          break;
          }
        if (myReply.compareTo(endstr) == 0)
        	break;
    }
 
    }
 
    final static int SERVER_PORT = 3333;
}