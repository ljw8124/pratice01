package org.pratice.ex2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);

        while(true){

            System.out.println("Input Your Message");
            String msg = keyScanner.nextLine();

            if(msg.equalsIgnoreCase("exit")){
                break;
            }
            Socket socket = new Socket("127.0.0.1",9999);
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);
            OutputStream out = socket.getOutputStream();

            String sendMsg = msg +"\n";
            out.write(sendMsg.getBytes()); //전송 완료
            System.out.println(inScanner.nextLine());

            out.close();
            inScanner.close();
            in.close();
            socket.close();


        }//end while


    }
}
