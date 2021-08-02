package org.pratice.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneTwoOneServer {
    //bad code => 앞으로는 웹서버를 쓸것이기 때문에 bad code로 작성
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in); //내가 보내는 것
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");

        Socket client = serverSocket.accept(); //client가 서버에 연결(accept)
        System.out.println("Client connected...");

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        Scanner inScanner = new Scanner(in);//상대가 보낸 것을 읽는 것
        for (int i = 0; i < 100; i++) {
            String line = inScanner.nextLine(); // \n전까지 읽음 -> client에서 \n을 쓰는 이유.

            System.out.println(line);

            String myMsg = keyScanner.nextLine() + "\n";
            out.write(myMsg.getBytes());
        }//end for

        inScanner.close();
        in.close();
        client.close();
        serverSocket.close();

    }
}
