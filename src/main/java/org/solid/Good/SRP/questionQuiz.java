package org.solid.Good.SRP;

public class questionQuiz {
    private String question,option1,option2,points,answer;

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getPoints() {
        return points;
    }

    public questionQuiz(String question, String answer, String options1, String options2, String points) {
        this.question = question.strip();
        this.answer = answer;
        this.option1 = options1;
        this.option2 = options2;
        this.points = points;
    }

    @Override
    public boolean equals(Object toCheckObj)
    {
        if (toCheckObj == null)
            return false;
        else if (toCheckObj == this)
            return true;
        else {
            questionQuiz QAObj = (questionQuiz) toCheckObj;
            return this.question.equals(QAObj.question)
                    && this.option1.equals(QAObj.option1)
                    && this.option2.equals(QAObj.option2)
                    && this.points.equals(QAObj.points)
                    && this.answer.equals(QAObj.answer);
        }
    }
}