import java.io.*;
import java.net.*;

class Server{

  public static void main(String argv[]) throws Exception{
  
    String clientSentence;
    
    //Getting the port number to create a server socket and message to send to client from command line
    int port = Integer.parseInt(argv[0]);
    String messageToClient = argv[1];
    
    //Creating the object welcomeSocket of type ServerSocket and will hold the port number 
    //ServerSocket will listen for a connection request from some client 
    ServerSocket welcomeSocket = new ServerSocket(port);
    System.out.println("Server Socket Listening For Connection Request At Port: " + port);
    
    //This function is logic for when am incoming connection request is made by a client 
    while(true){
      
      //After a connection request is made and TCP then establishes a direct virtual pipe between
      //the client and server
      Socket connectionSocket = welcomeSocket.accept();
      System.out.println("Establishing TCP connection");
      System.out.println("Socket Created At Port: " + port);
      
      //Creates streams attached to the socket
      //BufferedReader inFromClient provides process input from the client socket
      //DataOutputStream outToClient provides process output to the client socket
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      
      //Takes the process input from the client and stores it to a String clientSentence then prints the message
      clientSentence = inFromClient.readLine();
      System.out.println("Client's Message: " + clientSentence);
      
      //TODO Logic for parsing client message and send to API 
      
      //TODO Logic for query to weather API 
      
      //TODO Implement an algorithm to create a person object specified to what the API returns 
      
      //Sending back new person object 
      //'\n\' tells the client its done receiving data
      messageToClient = "PERSON OBJECT";
      outToClient.writeBytes(messageToClient);
      
      
      //Close and flush the server socket so we do not get a socket exception
      System.out.println("Colin Im closing server cause idk if we need it open or closed");
      outToClient.flush();
      outToClient.close();
      inFromClient.close();
      connectionSocket.close();
      break;
    }
    welcomeSocket.close();
  }
}
