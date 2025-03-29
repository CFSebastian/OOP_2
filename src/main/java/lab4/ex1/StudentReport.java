package main.java.lab4.ex1;

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
            for (int i=0;i<args.length;i++) {
                this.reportDraft.append("\n");
                for  (int j=0;j<args[i].length;j++) {
                    this.reportDraft.append("Argument("+i+"."+j+"): "+ args[i][j]+" ");
                }
            }
        }
    }


}
