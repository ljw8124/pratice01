package org.pratice.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FoodClient {
    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);

        while (true) {

            System.out.println("Input your Menu");
            String msg = keyScanner.nextLine();

            if (msg.equalsIgnoreCase("exit")) {
                break;
            }

            Socket socket = new Socket("127.0.0.1",9999);
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);
            OutputStream out = socket.getOutputStream();

            String sendMsg = msg + "\n"; //scanner로 읽을 것이므로 \n 필요
            out.write(sendMsg.getBytes()); //byte의 배열로 변환하여 보내버림.
            System.out.println(inScanner.nextLine());

            out.close();
            inScanner.close();
            in.close();
            socket.close();
            //연결하고 바로 닫아버림.

        }//end while

    }
}

