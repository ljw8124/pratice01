package org.pratice.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

//server에 접속한 고객
public class MyClient {

    //bad code -> 기억해야 할 세가지) in => read, out => write, throw Exception
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("192.168.0.06",9999); //127.0.0.1이 자기 IP를 가르킴
        System.out.println(socket);

        InputStream in = socket.getInputStream(); //읽는 데이터는 socket과 연결, 약속되있음 => protocol:웹에서는 HTTP
        FileOutputStream fos = new FileOutputStream("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\copy4.jpg");
        /*
        이 방법의 단점. 받는 파일의 이름을 모름.
        내가 원하는 파일만 받을 수 없음. => 파일이름과 파일데이터를 식별할 수 없음

         */

        byte[] buffer = new byte[1024 * 8];

        while(true) {
            int count = in.read(buffer); //몇개나 새로운 데이터를 읽어들일지 세는 count
            if (count == -1) {
                break;
            }
            fos.write(buffer, 0, count);

        }//end while

        fos.close();

        socket.close();

    }
}
