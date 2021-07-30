package org.pratice.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor //생성자 자동생성
@Getter //게터 사용 가능 플러그인
@NoArgsConstructor //아규먼트 받지 않는 생성자 생성

public class QuizDTO {

    private int r1,r2;

}
