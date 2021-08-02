package org.pratice.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FoodServer {
    //bad code
    public static void main(String[] args) throws Exception {

        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready...");
        //루프 시작
        while (true) {
            FoodSuggester suggester = new FoodSuggester();
            //서버와 연결 accept() Socket
            Socket socket = serverSocket.accept(); //사용자가 들어오는 것을 기다림
            System.out.println(socket.getInetAddress()); //연결되자마자 메시지를 보낼 수 있도록 함

            //Client가 보낸 메시지 읽기
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String msg = inScanner.nextLine();

            String randomMenu =  suggester.suggest(msg);

            //읽은 메시지 다시 전송
            String sendMsg = msg + " 메뉴 : " + randomMenu + "\n";
            OutputStream out = socket.getOutputStream();

            out.write(sendMsg.getBytes());
            out.flush(); //화장실 물내려주듯이 outPutStream을 내려주는 것

            //Socket 연결 종료
            out.close();
            in.close();
            inScanner.close();
            socket.close();

        }//end while

    }
}

