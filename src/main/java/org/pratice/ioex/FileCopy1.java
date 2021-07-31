package org.pratice.ioex;

import java.io.*;
import java.net.URL;

public class FileCopy1 {
    //bad code. 한바이트씩 읽고 쓰고 하기때문에 굉장히 느림 -> 좋은 방법이 아님
    public static void main(String[] args) throws Exception {



        URL url = new URL("https://postfiles.pstatic.net/MjAyMTA3MjlfMjMx/MDAxNjI3NTQ0OTYxNzYw.WmDMbRSy4vSMI4yBcjZmAa0O6ykDA1YpROdVzcgqYrkg.9SCYuKHpZ43JaCUm4YnebR1En8tAP1At6J0WfJ66-P8g.JPEG.mimim_b/9.JPG?type=w966");
        InputStream in = url.openStream();

        System.out.println(in);

        OutputStream out = new FileOutputStream("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\copy.jpg");

        System.out.println(out);

        while (true) {

            int data = in.read();

            if(data == -1) {
                break;
            }

            out.write(data);

        }

    }
}
