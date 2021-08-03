package org.pratice.ex2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EchoServer {

    //bad code
    public static void main(String[] args)throws Exception {

        Map<String, String[]> map = new HashMap<>();

        map.put("kor", new String[]{"불고기","비빔밥"});
        map.put("jap", new String[]{"초밥","라멘"});
        map.put("wes", new String[]{"피자","파스타"});

        //서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready..");
        //루프 시작
        while(true){
            //연결 accept() Socket
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress());

            //클라이언트가 보낸 메시지 읽기
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);

            String msg = inScanner.nextLine();
            System.out.println(msg); //kor,jap

            String[] arr = map.get(msg);

            //읽은 메시지를 다시 전송
            String sendMsg = null;

            if(arr == null){
                sendMsg ="다른 키워드를 입력하세요\n";
            }else {
                int idx = (int)(Math.random() * arr.length);
                sendMsg = arr[idx]+"\n";
            }


            OutputStream out = socket.getOutputStream();

            out.write(sendMsg.getBytes());
            out.flush();

            out.close();
            inScanner.close();
            in.close();
            socket.close();
            //소켓 연결 종료
        }//end while
    }
}
