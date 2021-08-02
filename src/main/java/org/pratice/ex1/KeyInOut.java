package org.pratice.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyInOut {


    public static void main(String[] args) {
        //입출력 시스템의 원리
        // => 1.빨대 꽂기 2.읽고 쓰기 3.빨대 뽑기->왜냐하면 입출력 시스템은 자동으로 메모리를 회수하지 않기 때문에
        // => close()가 중요!, 반드시 finally(끝끝내)에 해야 함.

        InputStream in = System.in;
        OutputStream out = null;

        try {
            out = new FileOutputStream("C:\\Users\\ljw81\\test.txt");

            for (int i = 0; i < 10; i++) { //열번만 입력을 받음
                int data = in.read(); //1byte의 내용을 읽음. 그런데 왜 리턴타입은 byte 타입이 아닌가? byte가 -1이 되면 더 이상 읽을 내용이 없어진다.
                out.write(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally { //close할 때 finally를 사용해야한다.
            if (out != null) {
                try {
                    out.close(); //close를 하고나면 더 이상 건드릴 수 없다.-> 잘못되면 예외가 아닌 에러의 영억으로 넘어감.
                } catch (Exception e) {/*비어있는 이유는 프로그래머가 건드릴 수 없는 영역이기 때문에*/}
            }
            if (in != null) { // 만약 out이 에러가 뜨면 in은 닫히지 않고 예외처리가 되기 때문에 in을 따로 만들어줘야 한다.
                try {
                    in.close(); //close를 하고나면 더 이상 건드릴 수 없다.-> 잘못되면 예외가 아닌 에러의 영억으로 넘어감.
                } catch (Exception e) {/*비어있는 이유는 프로그래머가 건드릴 수 없는 영역이기 때문에*/}
            }

        }

    }
}
