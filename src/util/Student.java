package util;

/**
 * Getters and setters for class Student
 */
public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    public Student() {
    }

    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
