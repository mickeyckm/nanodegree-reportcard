/**
 * Created by mickey on 25/10/16.
 */

public class Main {
    public static void main(String[] args){
        ReportCard reportCard = new ReportCard("Mickey");
        try {
            reportCard.setGrade("english", "a");
            reportCard.setGrade("physics", "b");
            reportCard.setGrade("biology", "a");
            reportCard.setGrade("maths", "e");
            reportCard.setGrade("chemistry", "c");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(reportCard.toString());
    }
}
