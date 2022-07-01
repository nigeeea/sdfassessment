package myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws IOException {
        
        Socket cs = new Socket("68.183.239.26",80);

        OutputStream os = cs.getOutputStream();
        InputStream is = cs.getInputStream();
        
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ObjectInputStream ois = new ObjectInputStream(is);

        String request = ois.readUTF();
        System.out.println(request);

        String[] serverRequest = request.split(" ");

        String[] numbers = serverRequest[1].split(",");

        ArrayList<Integer> numberList = new ArrayList<Integer>();

        for(String number: numbers){
             numberList.add(Integer.parseInt(number));
         }

        //sum of numbers
        int c = 0;
        for(int i=0; i<numberList.size(); i++){
            c = c + numberList.get(i);
        }

        float d = numberList.size();

        float average = c/d;

        oos.writeUTF(serverRequest[0]);
        oos.writeUTF("Nigel Tan Jit Kyen");
        oos.writeUTF("nigeltjk1@gmail.com");
        oos.writeFloat(average);
        oos.flush();

        boolean status = ois.readBoolean();

        System.out.println(status);        

        if(status){
            System.out.println("SUCCESS");
        }
        else{
            System.out.println("FAILED");

            System.out.println(ois.readUTF());
            
        }
        
        


        cs.close();
        

    }
    
}
