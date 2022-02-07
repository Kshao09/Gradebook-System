package main;
import util.Grade;
import util.Gradebook;
import util.Student;

import java.util.*;

/**
 * This class asks the user to fill in the required information and use a while loop to add the information to a Student arraylist.
 * Then asks user for different commands to perform a certain task such as finding a minimum number or maximum letter grade.
 */
public class Main {
    public static void main(String[] args) {
        Gradebook book = new Gradebook();
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        String answer = "";

        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using this format: " +
                "firstName lastName PID Grade");
        System.out.println("Press ENTER when your are done.");

       do {
            System.out.print("First Name: ");
            String fName = sc.next();
            System.out.print("Last Name: ");
            String lName = sc.next();
            System.out.print("ID: ");
            int pID = sc.nextInt();
            System.out.print("Grade: ");
            int grade = sc.nextInt();
            Grade grade1 = new Grade(grade);

            if(isValid(fName, lName, pID, grade)) {
                book.add(new Student(fName, lName, pID, grade1));
            }
            System.out.println("Please enter the information of the next student using the same format.");
            System.out.println("If there is no more students, please enter the keyword \"DONE\".");
            System.out.println("Press Enter when you are done.");

            userInput = sc.next();
        }   while (!userInput.equalsIgnoreCase("done"));

        do {
            System.out.println("Please enter a new command.");
            answer = sc.nextLine();

            switch (answer) {
                case "min score":
                    System.out.println(book.findMinScore());
                    break;
                case "min letter":
                    System.out.println(book.findMinLetter());
                    break;
                case "max score":
                    System.out.println(book.findMaxScore());
                    break;
                case "max letter":
                    System.out.println(book.findMaxLetter());
                    break;
                case "letter id":
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.println(book.findLetterGrade(id));
                    break;
                case "name id":
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    System.out.println(book.findFullName(id));
                    break;
                case "change id grade":
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    System.out.print("Grade: ");
                    int grade = sc.nextInt();
                    System.out.println(book.updateGrade(id, grade));
                    break;
                case "average score":
                    System.out.println(book.avgScore());
                    break;
                case "average letter":
                    System.out.println(book.avgLetter());
                    break;
                case "median score":
                    System.out.println(book.findMedianScore());
                    break;
                case "median letter":
                    System.out.println(book.findMedianLetter());
                    break;
                case "tab scores":
                    book.tabScores();
                    break;
                case "tab letters":
                    book.tabLetters();
                    break;
                case "quit":
                    book.quit();
                    break;
                default:
                    break;
            }
        } while (!answer.equalsIgnoreCase("quit"));
    }

    /**
     * checks if the conditions of the info are met and asks the user to repeat if not
     */
    public static boolean isValid (String fName, String lName, int pID, int grade) {
        Scanner sc = new Scanner(System.in);

        while (!fName.matches("[a-zA-Z]+") || !Character.isUpperCase(fName.charAt(0))) {
            System.out.println("Invalid first name! Please try again!");
            fName = sc.next();
        }
        while (!lName.matches("[a-zA-Z]+") || !Character.isUpperCase(lName.charAt(0))) {
            System.out.println("Invalid last name! Please try again!");
            lName = sc.next();

            int dots = 0;
            for (int i = 0; i < lName.length(); i++) {
                if (lName.charAt(i) == '.') {
                    dots++;
                }
            }
            if (dots > 1) {
                System.out.println("Invalid last name! Please try again!");
                lName = sc.next();
            }
        }

        while (pID < 1000000 || pID > 9999999) {
            System.out.println("Invalid id! Please try again!");
            pID = sc.nextInt();
        }

        while (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Please try again!");
            grade = sc.nextInt();
        }
        return true;
    }
}