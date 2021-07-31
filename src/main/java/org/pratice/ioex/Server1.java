package org.pratice.ioex;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server1 {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket =  new ServerSocket(9999); //서버 연결

        System.out.println("Ready..............");

        for (int i = 0; i < 10; i++) { //blocked io

            Socket client = serverSocket.accept();

            System.out.println(client);

            InputStream in = client.getInputStream();

            Scanner inScanner = new Scanner(in);

            String line = inScanner.nextLine();

            System.out.println(line);


            OutputStream out = client.getOutputStream();

            String msg = "<h1>Hello World</h1>";

            //이 네줄의 코드는 바꾸면 안됨.
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            out.write(msg.getBytes(StandardCharsets.UTF_8));


        }//end for

    }
}
