package org.pratice.ex3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StoreDTO {

    private Long sno;
    private String name;
    private String area;
    private String desc;
    private String link;
    private Timestamp regDate;
    private Timestamp modDate;

    //MySQL table 양식에 맞게 StoreDTO 생성
}
