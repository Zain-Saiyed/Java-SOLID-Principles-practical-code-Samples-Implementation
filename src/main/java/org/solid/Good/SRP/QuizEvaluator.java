package org.solid.Good.SRP;

public class QuizEvaluator {

    private String letterGrade;
    private int percentage;

    public String getLetterGrade() {
        return letterGrade;
    }

    public int getPercentage() {
        return percentage;
    }

    public int calculateScore(int score, String inputAnswer, String answer) {
        if (inputAnswer.equals(answer)) {
            return score+1;
        }
        else
            return score;
    }

    public String getLetterGrade(int score, int totalQuestions) {
        int value= this.generatePercentage(score,totalQuestions);
        if (value >= 80) {
            letterGrade="A";
            return "A";
        } else if (value >= 70) {
            letterGrade="B";
            return "B";
        } else if (value >= 55) {
            letterGrade="C";
            return "C";
        } else if (value >= 50) {
            letterGrade="D";
            return "D";
        } else {
            letterGrade="F";
            return "F";
        }
    }

    public int generatePercentage(int score, int totalQuestions) {
        this.percentage = (score*100/totalQuestions);
        return percentage;
    }
}