package org.pratice.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //DTO를 Builder를 이용하여 build가능해짐
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {

    private Integer no; //int로 주지않음
    private String who, whom;
    private String content;
}
