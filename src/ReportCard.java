import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by mickey on 25/10/16.
 */

public class ReportCard {

    private String studentName;
    private ArrayList<String> subjects;
    private Hashtable<String, String> grades;

    public ReportCard(String name) {
        studentName = name;

        initSubjects();
        initGrades();
    }

    public String getGrade(String subject) throws Exception {
        // Check for blanks
        if (subject.isEmpty()) {
            throw new Exception("Subject cannot be blank!");
        }

        // Sanitize inputs
        subject = subject.toLowerCase().trim();

        return String.valueOf(grades.get(subject));
    }

    public void setGrade(String subject, String grade) throws Exception {
        // Check for blanks
        if (subject.isEmpty() || grade.isEmpty()) {
            throw new Exception("Subject or grade cannot be blank!");
        }

        // Sanitize inputs
        subject = subject.toLowerCase().trim();
        grade = grade.toLowerCase().trim();

        // Record grade
        if (!isValidSubject(subject)) {
            throw new Exception("Invalid subject!");
        }
        else if (!isValidGrade(grade)) {
            throw new Exception("Invalid grade!");
        }
        else {
            grades.put(subject, grade);
        }
    }

    public String toString() {
        String report = "";

        report += "Student Name: " + studentName + "\n";
        Set<String> keys = grades.keySet();
        for (String key: keys) {
            report += "Grade for " + capitalize(key) + ": ";
            String grade = (String) grades.get(key);
            if (!grade.isEmpty()) {
                report += grade.toUpperCase();
            }
            else {
                report += "-";
            }
            report += "\n";
        }
        return report;
    }

    private Boolean isValidSubject(String subject) {
        return subjects.contains(subject);
    }

    private Boolean isValidGrade(String grade) {
        return grade.equals("a") ||
                grade.equals("b") ||
                grade.equals("c") ||
                grade.equals("d") ||
                grade.equals("e");
    }

    private void initSubjects() {
        subjects = new ArrayList<>();
        subjects.add("english");
        subjects.add("maths");
        subjects.add("physics");
        subjects.add("chemistry");
        subjects.add("biology");
        subjects.add("history");
    }

    private void initGrades() {
        grades = new Hashtable<String, String>();
        for (String subject: subjects) {
            grades.put(subject, "");
        }
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
