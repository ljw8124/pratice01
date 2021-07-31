package org.pratice.ioex;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

public class Server2 {
    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket =  new ServerSocket(9999); //서버 연결

        System.out.println("Ready..............");

        for (int i = 0; i < 10; i++) { //blocked io

            Socket client = serverSocket.accept();

            System.out.println(client);

            File file = new File("C:\\Users\\ljw81\\git\\bitcamp-study\\html-pratice\\bitcamp\\basic-html\\layout.html");

            OutputStream out = client.getOutputStream();


            //이 네줄의 코드는 바꾸면 안됨.
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            Files.copy(file.toPath(), out);

        }//end for

    }
}
