import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface fInterface extends Remote {

    public double Add(double a, double b) throws RemoteException;
    public double Subtract(double a, double b) throws RemoteException;
    public double Multiply(double a, double b) throws RemoteException;
    public double Divide(double a, double b) throws RemoteException;
    public void saveCalculations(double a,String temp, double b, String temp2,double c) throws RemoteException,IOException;
    
    public byte[] downloadFile(String fileName) throws RemoteException;
    public int rounded_value(double Result) throws RemoteException;
    
}
