import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by mickey on 25/10/16.
 */

public class ReportCard {

    private String mStudentName;
    private ArrayList<String> mSubjects;
    private Hashtable<String, String> mGrades;

    public ReportCard(String studentName) {
        mStudentName = studentName;
        initSubjects();
        initGrades();
    }

    public String getStudentName() {
        return mStudentName;
    }

    public void setStudentName(String studentName) {
        this.mStudentName = studentName;
    }

    public ArrayList<String> getSubjects() {
        return mSubjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.mSubjects = subjects;
    }

    public Hashtable<String, String> getGrades() {
        return mGrades;
    }

    public void setGrades(Hashtable<String, String> grades) {
        this.mGrades = grades;
    }

    public String getGrade(String subject) throws Exception {
        // Check for blanks
        if (subject.isEmpty()) {
            throw new Exception("Subject cannot be blank!");
        }

        // Sanitize inputs
        subject = subject.toLowerCase().trim();

        return String.valueOf(mGrades.get(subject));
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
            mGrades.put(subject, grade);
        }
    }

    @Override
    public String toString() {
        String report = "";

        report += "Student Name: " + mStudentName + "\n";
        Set<String> keys = mGrades.keySet();
        for (String key: keys) {
            report += "Grade for " + capitalize(key) + ": ";
            String grade = (String) mGrades.get(key);
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
        return mSubjects.contains(subject);
    }

    private Boolean isValidGrade(String grade) {
        return grade.equals("a") ||
                grade.equals("b") ||
                grade.equals("c") ||
                grade.equals("d") ||
                grade.equals("e");
    }

    private void initSubjects() {
        mSubjects = new ArrayList<>();
        mSubjects.add("english");
        mSubjects.add("maths");
        mSubjects.add("physics");
        mSubjects.add("chemistry");
        mSubjects.add("biology");
        mSubjects.add("history");
    }

    private void initGrades() {
        mGrades = new Hashtable<String, String>();
        for (String subject: mSubjects) {
            mGrades.put(subject, "");
        }
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
