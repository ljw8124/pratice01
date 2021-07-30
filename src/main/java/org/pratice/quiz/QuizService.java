package org.pratice.quiz;

public class QuizService {

    public QuizDTO makeQuiz() {

        return new QuizDTO(getNum(),getNum());

    }

    private int getNum() {

        return (int)(Math.random()*100) +1 ;
    }

    public boolean grading(QuizDTO quizDTO, int answer) {

        int correctAnswer = quizDTO.getR1() * quizDTO.getR2();
        return answer == correctAnswer;
    }
}
