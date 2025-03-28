package main.java.lab4.ex2;

public class StudentReport extends Report {
    private String studentName;

    StudentReport(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void generate (Object[]... args) {
        this.reportDraft.append("Student Report\n");
        this.reportDraft.append("Student name: " + this.studentName);
        if(args.length!=0){
            for (Object arg : args) {
                this.reportDraft.append("Argument: "   +arg.toString());
            }
        }
    }


}
