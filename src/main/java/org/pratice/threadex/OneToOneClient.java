package org.pratice.threadex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {
    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 9999);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream din = new DataInputStream(socket.getInputStream());

        new Thread(() -> { //Thread를 새로 만들어서 람다식을 이용해서 기능 일부분을 파라미터로 씀
            while (true) {
                try {
                    String serverMsg = din.readUTF(); //readUTF는 try/catch가 필요
                    System.out.println("SERVER : " + serverMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            System.out.println("INPUT YOUR MESSAGE");
            String msg = keyScanner.nextLine();
            dos.writeUTF(msg);
        }




    }
}
