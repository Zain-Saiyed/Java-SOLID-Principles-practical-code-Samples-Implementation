package org.solid.Good.SRP;

import java.io.FileWriter;
import java.io.IOException;

public class QuizSaveResultsToDisk {

    public static void saveResult(String userName, String quizName, String LetterGrade, int Percentage, int totalQuestions, int score ) {
        FileWriter fileHandlerObj = null;
        try {
            fileHandlerObj = new FileWriter(userName+".txt");
            fileHandlerObj.write(java.time.LocalDate.now()+",Quiz Name:"+quizName+",Total Question:"+totalQuestions+",Correct Answer:"+score+",Percentage:"+Percentage+",Letter Grade:"+LetterGrade+"\n");
            fileHandlerObj.close();
            System.out.println("[**SUCCESS**] Quiz Result saved successfully!");
        } catch (IOException e) {
            System.out.println("[**ERROR**] ERROR SAVING RESULT! ERROR MESSAGE: "+e.getMessage());
        }
    }
}