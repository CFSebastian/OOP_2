package main.java.lab4.ex2;

public class SchoolSummaryReport extends Report {
    private int numberOfClassrooms;

    SchoolSummaryReport(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
    }

    @Override
    public void generate (Object[]... args) {
        this.reportDraft.append("School Summary Report\n");
        this.reportDraft.append("Number of Classrooms: " + this.numberOfClassrooms);
        if(args.length!=0){
           for (Object arg : args) {
               this.reportDraft.append("Argument: "   +arg.toString());
           }
        }
    }

}
