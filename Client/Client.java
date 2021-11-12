import java.io.*;
import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String argv[]) {
        if (argv.length != 1) {
            System.out.println("Usage: java FileClient machineName");
            System.exit(0);
        }
        try {
            String name = "//" + argv[0] + "/Server";
            fInterface in = (fInterface) Naming.lookup(name);
            System.out.println("Client Ready....remote stub active");
            
            Scanner scan = new Scanner(System.in);
            System.out.println("** Welcome to Client-Server based Calculator **");
            System.out.println("Select one of the operation from the following choices : ");

            int choice = 0;
            double round = 0;

                // choices for the client
                while (choice != -1) {
                    
                    System.out.println("Select one of the operation from the following choices : ");
                    System.out.println("Enter 1 to perform add operation : ");
                    
                    System.out.println("Enter 2 to perform subtract operation : ");
                    
                    System.out.println("Enter 3 to perform multiply operation : ");
                    
                    System.out.println("Enter 4 to perform division operation : ");
                    
                    System.out.println("Enter 5 to download the saved file  : ");

                    System.out.println("Enter 6 to round the result  : ");
                    
                    System.out.println("Enter -1 to close the application : ");

                    choice = scan.nextInt();

                    if (choice == 1) {
                        System.out.println("Enter 2 numbers : ");
                        
                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        double result = in.Add(a, b);

                        in.saveCalculations(a,"+",b,"=", result);

                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Recieving the answer from the Server .... ");
                        System.out.println("Result is : " + result + "\n");
                        round = result;
                        

                    } else if (choice == 2) {
                        System.out.println("Enter 2 numbers : ");
                        
                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        double result = in.Subtract(a, b);

                        in.saveCalculations(a,"-",b,"=", result);

                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Recieving the answer from the Server .... ");
                        System.out.println("Result is : " + result + "\n");
                        round = result;
                        

                    } else if (choice == 3) {
                        System.out.println("Enter 2 numbers : ");
                        
                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        double result = in.Multiply(a, b);

                        in.saveCalculations(a,"*",b,"=", result);

                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Recieving the answer from the Server .... ");
                        System.out.println("Result is : " + result + "\n");
                        

                    } else if (choice == 4) {
                        System.out.println("Enter 2 numbers : ");
                        
                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        double result = in.Divide(a, b);

                        in.saveCalculations(a,"/",b,"=", result);

                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Recieving the answer from the Server .... ");
                        System.out.println("Result is : " + result + "\n");
                        

                    } 
                    else if (choice == 5) {
                        byte[] filedata = in.downloadFile("test.txt");
                        File file = new File("test.txt");
                            
                        BufferedOutputStream output = new
                        BufferedOutputStream(new FileOutputStream(file.getName()));
                        output.write(filedata,0,filedata.length);
                        output.flush();
                        output.close();
                        System.out.println("File downloaded successfully");

                    } 
                    else if (choice == 6) {
                        System.out.println("The rounded result is : ");
                    
                        

                        int result = in.rounded_value(ciel(round));
                        System.out.println("Recieving the answer from the Server .... ");
                        System.out.println("Result is : " + result + "\n");
                        

                    } 
                    
                    else {
                        System.out.println("Invalid choice: ");
                        

                    }
                }
                    scan.close();
        } catch (Exception e) {
            System.err.println("FileServer exception: " + e.getMessage());
            e.printStackTrace();
        }
}
}
