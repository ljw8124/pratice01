package org.pratice.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteService {

    private Map<String, ArrayList<NoteDTO>> noteMap = new HashMap<>(); //Map에서 HashMap을 제일 많이 사용
    private Integer idx = 0; //쪽지에 번호를 부여하기 위해서 idx를 사용


    public Integer add(NoteDTO noteDTO) {

        noteDTO.setNo(++idx);

        String owner/*whom*/ = noteDTO.getWhom(); //쪽지함 주인

        ArrayList<NoteDTO> noteDTOS = noteMap.get(owner); //그 사람 쪽지함을 추적해서 noteDTOS에 저장

        if (noteDTOS == null) { //owner의 noteDTOS가 없으면 새로 만듦
            ArrayList<NoteDTO> noteList = new ArrayList<>(); //쪽지함이 없으므로 ArrayList 형식으로 만든다음
            noteList.add(noteDTO); //owner가 받은 noteDTO를 넣어줌
            noteMap.put(owner,noteList);
        } else { //owner의 noteDTOS가 있는 경우 그냥 넣기만 하면 됨
            noteDTOS.add(noteDTO);
        }
        return idx;
    }

    public ArrayList<NoteDTO> getList(String owner) {
        return noteMap.get(owner);
    }

//    public static void main(String[] args) {
//        NoteService service = new NoteService();
//
//        NoteDTO noteDTO = NoteDTO.builder().who("user1").whom("user2").content("이해가 안가").build();
//        service.add(noteDTO);
//
//        NoteDTO noteDTO2 = NoteDTO.builder().who("user3").whom("user2").content("나도 이해가 안가").build();
//        service.add(noteDTO2);
//
//        NoteDTO noteDTO3 = NoteDTO.builder().who("user2").whom("user1").content("끝나고 남아").build();
//        service.add(noteDTO3);
//
//        System.out.println(service.noteMap);
//
//    }
}
