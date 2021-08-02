package org.pratice.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class FileFastCopy {

    public static void main(String[] args) { //입출력하는데 있어서 가장 중요한 코드중 하나

        //try with resource
        try(
            InputStream fin = new FileInputStream("C:\\Users\\ljw81\\sample.txt");
            OutputStream fos = new FileOutputStream("C:\\Users\\ljw81\\copy.txt")
        ) {

            byte[] arr = new byte[5]; // 1024*8은 8 키로바이트, arr가 버퍼임.

            while (true) {
                int count = fin.read(arr); //몇 개나 새로운 데이터를 읽었는지. -> 속도가 월등하게 빨라짐.

                System.out.println("Count: " + count);
                System.out.println(Arrays.toString(arr));

                if (count == -1) {break;} //-1은 더이상 읽을 데이터가 없다는 의미 -> 더 이상 읽을게 없다면 break
                //fos.write(arr, 0, count); //arr는 버퍼, 0은 인덱스, count는 새로운 개수만큼
                fos.write(arr);
            }//while end

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
