package org.pratice.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteMapTest {

    public static void main(String[] args) {

        Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>();

        String who = "user1";
        NoteDTO newbie = NoteDTO.builder().who("user2").whom("user1").content("커피한잔").build(); //2가 1에게 ~라고 보냄
        //사용자에게 온 쪽지 목록
        ArrayList<NoteDTO> noteDTOS = noteMap.get(who); //user1이 있는지, 있다면 get하라


        if (noteDTOS == null) { //기존에 아무런 쪽지가 없는 경우, 보내는 사람을 찾아서 newbie 쪽지를 추가.
            ArrayList<NoteDTO> noteList = new ArrayList<>();
            noteList.add(newbie);
            noteMap.put(who, noteList);
        } else {
            noteDTOS.add(newbie); //쪽지가 있다면 그냥 추가.
        }

    }
}
