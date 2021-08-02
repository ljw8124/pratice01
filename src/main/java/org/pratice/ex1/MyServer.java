package org.pratice.ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    //bad code close 철저히
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999); //이미 사용중인 포트번호는 에러가 나온다.

        System.out.println("Ready....."); //서버소켓은 가게주인 느낌

        while(true) { //콘솔창에서 닫지 않는 이상 계속 while문으로 반복
            Socket client = serverSocket.accept();
            System.out.println(client);

            OutputStream out = client.getOutputStream();

            File file = new File("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\choijun.jpg");

            //이 네 줄이 갖는 의미는 브라우저로 연결하느냐 이다.
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes()); //브라우저에서 이만큼 길이의 파일을 보낸다는 의미.
            out.write(new String("Content-Type: image/jpg\r\n\r\n").getBytes());

//            out.write(97);
            InputStream fin = new FileInputStream("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\choijun.jpg");

            byte[] buffer = new byte[1024 * 8];

            while(true) {
                int count = fin.read(buffer); //몇개나 새로운 데이터를 읽어들일지 세는 count
                if (count == -1) {
                    break;
                }
                out.write(buffer, 0, count);

            }//end while

            Thread.sleep(500);

            fin.close(); // 마지막에 사용한 것부터 close함

            out.close(); //소켓을 닫기 전에 OutPutStream을 닫는게 좋음

            client.close(); //연결확인 후 바로 연결종료

        }//end while

    }

}
