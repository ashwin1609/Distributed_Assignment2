import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class fImplentation extends UnicastRemoteObject
implements fInterface {

    private String name;

    public fImplentation(String s) throws RemoteException {
        super();
        name = s;
    }

    public double Add(double a, double b){
        
        return a + b;
    }

    public double Subtract(double a, double b){
        return a - b;
    }
    public double Multiply(double a, double b){
        return a * b;
    }
    public double Divide(double a, double b){
        return a/b;
    }
    
    public void saveCalculations(double a, String temp, double b, String temp2, double c)throws IOException,RemoteException
    {

        File save = new File("test.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(save, true));
        writer.append("\n"+ a+temp+b+temp2 + c);
        writer.close();
    
    }

    public byte[] downloadFile(String fileName){
        try {
            
           File file = new File(fileName);
       
           byte buffer[] = new byte[(int)file.length()];
           BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
           input.read(buffer,0,buffer.length);
           input.close();
           return(buffer);
        } catch(Exception e){
           System.out.println("FileImpl: "+e.getMessage());
           e.printStackTrace();
           return(null);
        }
     }
     public int rounded_value(double Result){

        int rnd_number = (int) Result; 
        return rnd_number;


     }
  
}
