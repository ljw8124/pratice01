package org.prtice.quiz;

import org.junit.jupiter.api.Test;
import org.pratice.quiz.QuizDTO;
import org.pratice.quiz.QuizService;

import java.util.Scanner;

public class QuizUITests {

    @Test
    private void test() {
        resolve();
    }

        private Scanner scanner;
        private QuizService quizService;

        public void resolve () {
            System.out.println("문제를 푸시겠습니까?");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                return;
            }
            QuizDTO quizDTO = new QuizDTO();

            System.out.printf("%d * %d = \n", quizDTO.getR1(), quizDTO.getR2());
            System.out.println("정답을 입력하세요.");

            int userAnswer = Integer.parseInt(scanner.nextLine());

            boolean result = quizService.grading(quizDTO, userAnswer);

            if (result) {
                System.out.println("정답입니다.");
            } else {
                System.out.println("오답입니다.");
            }

            this.resolve(); //틀릴 경우 다시 반복,재귀호출


        }
}
