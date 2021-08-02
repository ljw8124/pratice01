package org.pratice.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneTwoOneClient {
    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);
        Socket socket = new Socket("192.168.0.6",9999);

        System.out.println("Connected...");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);
        for (int i = 0; i < 100; i++) {
            //문자열을 byte[]로 바꿔서 out.write로 바이트 배열을 전송
//        String msg = "저녁 머먹을까여\n"; //서버에서 \n전까지 읽기 때문에 \n을 추가하여 보내주어야함.
            String msg = keyScanner.nextLine() + "\n";

            out.write(msg.getBytes());
            System.out.println("---------------------------------");
            System.out.println(inScanner.nextLine());
        }//end for

        keyScanner.close();
        out.close();
        socket.close();

    }
}
