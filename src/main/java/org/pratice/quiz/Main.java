package org.pratice.quiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QuizService quizService = new QuizService();

        QuizUI quizUI = new QuizUI(scanner, quizService);

        quizUI.resolve();


    }
}
