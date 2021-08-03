package org.pratice.note;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class NoteClient {

    //bad code
    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("기능을 골라주세요. 나가려면 exit");
            Scanner scanner = new Scanner(System.in);
            String operLogic = scanner.nextLine();
            if (operLogic.equalsIgnoreCase("exit")) {
                break;
            } else {
                NoteDTO data = NoteDTO.builder().who("A").whom("B").content("커피한잔?").build(); //객체 형성
                Command command = Command.builder().oper(operLogic).noteDTO(data).build(); //객체안에 객체를 넣음

                Gson gson = new Gson();

                String str = gson.toJson(command);

                Socket socket = new Socket("127.0.0.1", 9999);

                DataOutputStream dataOutputStream =
                        new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF(str);
            }
        }
    }
}
