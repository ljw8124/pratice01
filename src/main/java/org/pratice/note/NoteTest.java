package org.pratice.note;

import com.google.gson.Gson;

public class NoteTest {
    public static void main(String[] args) {
//        //Json의 장점 : 직접 문자를 DTO로 바꾸지 않아도 자동으로 만들어줌.
//        NoteDTO dto = NoteDTO.builder().who("A").whom("B").content("밥먹자").build();
//
//        Gson gson = new Gson();
//
//        String jsonStr = gson.toJson(dto);
//
//        System.out.println(jsonStr);
//
//        NoteDTO result = gson.fromJson(jsonStr, NoteDTO.class);
//
//        System.out.println(result);
//        //문자열을 객체로, 객체를 문자열로 바꿔줄 수 있어짐 -> 더 수월하게 변경가능(JSON에서 자동으로 변경해줌)

        //add
        NoteDTO data = NoteDTO.builder().who("A").whom("B").content("커피한잔?").build();

        Command command = Command.builder().oper("ADD").noteDTO(data).build();

        System.out.println(command);

        Gson gson = new Gson(); //키와 값을 구분하는 기능

        System.out.println(gson.toJson(command));


    }
}
