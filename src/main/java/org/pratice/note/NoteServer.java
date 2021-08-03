package org.pratice.note;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NoteServer {
    //bad code
    public static void main(String[] args) throws Exception {

        NoteService service = new NoteService();

        //serverSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("ready....");
        //loop
        while (true) {

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream =
                    new DataInputStream(socket.getInputStream());

            String msg = dataInputStream.readUTF();

            Gson gson = new Gson(); //JSON으로 바꾼 데이터를 역직렬화하여 JAVA object로 변환(JAVA에서 읽을 수 있도록)

            Command command = gson.fromJson(msg, Command.class); //fromJson사용은 msg문자열을 Command.class에서 맵핑하라는 의미

            //System.out.println(command);

            String oper = command.getOper();

            if (oper.equalsIgnoreCase("ADD")) {
                service.add(command.getNoteDTO());
                System.out.println("추가완료!");
            } else if (oper.equalsIgnoreCase("READ")) {
                String owner = command.getNoteDTO().getWhom();
                System.out.println(service.getList(owner));
            }
        }
        //socket

        //DataInputStream -> readUTF() => 문자열

        //Gson => 문자열을 객체(Command 객체)로 반환

        //Command 객체의 oper 값이 ADD 면 service.add()를 호출


    }
}
