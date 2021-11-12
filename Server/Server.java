import java.io.*;
import java.rmi.*;


public class Server {
    public static void main(String argv[]){
        try {
            fInterface in = new fImplentation("Server");
            Naming.rebind("//127.0.0.1/Server", in);
            System.out.println("Server Ready...Service is Running");

            

        } catch (Exception e) {
            System.out.println("FileServer: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
