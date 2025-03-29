package main.java.lab4.ex1;

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
            for (int i=0;i<args.length;i++) {
                this.reportDraft.append("\n");
                if(args[i][0] instanceof Classroom) {
                    Classroom[] presentClassroom = (Classroom[]) args[i];
                    for (int j = 0; j < presentClassroom.length; j++) {
                        this.reportDraft.append("For the school "+ j +" ,argument(" + i + "."+j+  "): " + presentClassroom[j].getType() + " ");
                    }
                } else if(args[i][0] instanceof Schedule) {
                    Schedule[] presentSchedule = (Schedule[]) args[i];
                    for (int j = 0; j < presentSchedule.length; j++) {
                        this.reportDraft.append("For the schedule"+ j +" ,argument(" + i + "."+j+  "): " + presentSchedule[j].getDay() + " ");
                    }
                }
            }
        }
    }

}
