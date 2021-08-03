package org.pratice.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {

        //key, value -> 원래는 object 타입인데 타입을 지정하는 것이 제네릭 문법이다.
        Map<String, String[]> map = new HashMap<>();

        //넣을때는 put
        map.put("kor", new String[] {"불고기", "비빔밥"});
        map.put("jap", new String[] {"초밥", "라멘"});
        map.put("wes", new String[] {"피자", "파스타"});

        //원하는 것을 get으로 끄지업어낸다.
        String[] arr = map.get("wes");

        System.out.println(Arrays.toString(arr)); //내가 원하는 키값이 없을 때는 null이 나옴.

        int idx = (int)(Math.random() * arr.length);

        System.out.println(arr[idx]); //값이 없을때는 nullPointException 에러 발생
    }
}
