package org.pratice.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("Ready....");

        while (true) {

            Socket socket = serverSocket.accept(); //소켓을 만들어서 서버소켓에 연결(accept)
            InputStream in = socket.getInputStream(); //in에는 read기능밖에없음
            //Scanner 대신 DataInputStream으로 in을 받음
            DataInputStream din = new DataInputStream(in); //Scanner와 같은 기능을 함.

            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF(); //UTF-8로 읽겠다.

            System.out.println("Client MSG : " + str);

            String msg = "LeeJoungWoo";

            dos.writeUTF(msg);
            dos.flush();

        }

    }
}
