package util;
/**
 * methods for all the commands that the program supports
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {
    private ArrayList<Student> listOfStudents = new ArrayList<>();

    public void add(Student s) {
        listOfStudents.add(s);
    }
    /**
     * find the minimum score using an enhanced for loop
     */
    public int findMinScore() {
        int minScore = listOfStudents.get(0).getGrade().getScore();
        for (Student s : listOfStudents) {
            if (s.getGrade().getScore() < minScore) {
                minScore = s.getGrade().getScore();
            }
        }
        return minScore;
    }

    /**
     * if else statements to calculate letter grade
     */
    public String LetterGrade(int score) {
        String letter = "";
        if (score >= 90) {
            letter = "A";
        } else if (score < 90 && score >= 85) {
            letter = "A-";
        } else if (score < 85 && score >= 80) {
            letter = "B+";
        } else if (score < 80 && score >= 75) {
            letter = "B";
        } else if (score < 75 && score >= 70) {
            letter = "B-";
        } else if (score < 70 && score >= 65) {
            letter = "C+";
        } else if (score < 65 && score <= 60) {
            letter = "C";
        } else if (score < 60 && score >= 50) {
            letter = "D";
        } else if (score < 50) {
            letter = "F";
        }
        return letter;
    }

    /**
     * find the min letter
     */
    public String findMinLetter() {
        int score = findMinScore();
        return LetterGrade(score);
    }

    /**
     * find the maximum score
     */
    public int findMaxScore() {
        int maxScore = listOfStudents.get(0).getGrade().getScore();
        for (Student s : listOfStudents) {
            if (s.getGrade().getScore() > maxScore) {
                maxScore = s.getGrade().getScore();
            }
        }
        return maxScore;
    }

    /**
     * find the maximum letter grade
     */
    public String findMaxLetter() {
        int score = findMaxScore();
        return LetterGrade(score);
    }

    /**
     * find the letter grade by user input of id
     */
    public String findLetterGrade(int pID) {
        String grade = "";
        int score;
        for (Student s : listOfStudents) {
            if (pID == s.getPid()) {
                score = s.getGrade().getScore();
                grade = LetterGrade(score);
            }
        }
        return grade;
    }

    /**
     * find full name of student by user input of id
     */
    public String findFullName(int pID) {
        String name = "";
        for (Student s : listOfStudents) {
            if (pID == s.getPid()) {
                name = s.getFirstName() + " " + s.getLastName();
            }
        }
        return name;
    }

    /**
     * find and update a new grade by replacing the student's grade
     */
    public String updateGrade(int pID, int nScore) {
        int sc;
        String oldGr = null;
        for (Student s : listOfStudents) {
            if (pID == s.getPid()) {
                sc = s.getGrade().getScore();
                oldGr = LetterGrade(sc);
                s.setGrade(new Grade(nScore));
                break;
            }
        }
        return oldGr;
    }

    /**
     * find the average score of all the scores in the student arraylist
     */
    public int avgScore() {
        int sum = 0;
        for(Student s: listOfStudents) {
            sum += s.getGrade().getScore();
        }
        return sum / listOfStudents.size();
    }

    /**
     * returns the average letter grade
     */
    public String avgLetter() {
        int score = avgScore();
        return LetterGrade(score);
    }

    /**
     * find the median score
     */
    public float findMedianScore() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for(Student s: listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return (float) scores[n / 2];
    }

    /**
     * returns the median letter grade
     */
    public String findMedianLetter() {
        int score = (int) findMedianScore();
        return LetterGrade(score);
    }

    /**
     * returns the information in a table form with score
     */
    public void tabScores() {
        for(Student s: listOfStudents) {
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
        }
    }

    /**
     * returns the info in a table form with letter grade
     */
    public void tabLetters() {
        for(Student s: listOfStudents) {
            System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), LetterGrade(s.getGrade().getScore()));
        }
    }

    /**
     * quits the program
     */
    public void quit() {
    }
}