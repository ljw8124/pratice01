package org.pratice.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GatewayServer {

    //bad code
    public static void main(String[] args)throws Exception {

        Map<String, String> ipMap = new HashMap<>();

        ipMap.put("A","127.0.0.1"); //뒤 아이피에 A라는 서버로 연결
        ipMap.put("B","192.168.0.12");
        ipMap.put("C","192.168.0.16");
        ipMap.put("D","192.168.0.121");

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ready..");

        while(true){

            Socket socket = serverSocket.accept();
            InputStream in  = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            String str = din.readUTF();

            System.out.println("CLIENT MSG: " + str);

            Socket subSocket = new Socket(ipMap.get(str),9998);
            DataOutputStream subDos = new DataOutputStream(subSocket.getOutputStream());
            DataInputStream subDin = new DataInputStream(subSocket.getInputStream());

            subDos.writeUTF(str);

            String msg = subDin.readUTF();

            dos.writeUTF(msg);
            dos.flush();


        }//end while

    }
}
