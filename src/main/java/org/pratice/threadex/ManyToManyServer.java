package org.pratice.threadex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyServer {

    //하지만 존재 하는 문제들
    //close문제
    //중간에 누가 나가버리면 다 같이 에러가 나오는 문제
    //누가 어떤 메시지를 보냈는지 모르는 문제

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9999);
        System.out.println("ready....");
        List<DataOutputStream> dosList = new ArrayList(); //다른 사람이 보낸 메시지를 저장하는 리스트

        while (true) {
            Socket socket = server.accept(); //서버와 소켓을 연결시킴 -> while로 계속 연결.
            System.out.println(socket);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dosList.add(dos); //받은 메시지를 리스트에 저장

            new Thread(() -> {
                while (true) {
                    String str = null;
                    try {
                        str = din.readUTF();
                        System.out.println(str);
                        for (int i = 0; i < dosList.size(); i++) {
                            dosList.get(i).writeUTF(str);
                        }
                    } catch (Exception e) {
                        dosList.remove(dos);
                    }
                }//end while
            }).start();
        }//end while

    }
}
