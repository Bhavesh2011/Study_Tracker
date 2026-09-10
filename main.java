import java.util.*;
import java.time.LocalDate;
import java.io.*;

//Done
class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate A,String B,Double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override // Decorator optional
    public String toString()
    {
        return Date + "| "+ Subject + "| "+Duration + "| "+ Description;
    }

    //Getter method
    public LocalDate getDate()
    {
        return Date;
    }
    //Getter method
    public String getSubject()
    {
        return Subject;
    }
    //Getter method
    public Double getDuration()
    {
        return Duration;
    }
    //Getter method
    public String getDescription()
    {
        return Description;
    }
}

class StudyTracker
{
    //Datastructure to hold data about Study
    private ArrayList <StudyLog> DataBase = new ArrayList <StudyLog> ();

    public void InsertLog()
    {
        Scanner Scannerobj = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------Please enter the Valid Details of ur Study--------------");
        System.out.println("---------------------------------------------------------------------");  
        
        LocalDate Dateobj = LocalDate.now();

        System.out.println("Pleased Provide The Name of Subject like c/c++/java/os/ds");
        String sub = Scannerobj.nextLine();

        System.out.println("Enter the Time period of Your Study in Hours");
        double dur = Scannerobj.nextDouble();
        Scannerobj.nextLine();

        System.out.println("Please Provide The description about the study for Future refrence");
        String desc = Scannerobj.nextLine();

        StudyLog Studyobj = new StudyLog(Dateobj,sub,dur,desc);

        DataBase.add(Studyobj);

        System.out.println("Study Log gets Stored Successully");
        System.out.println("---------------------------------------------------------------------");  
    }

    public void DisplayLog()
    {
        System.out.println("---------------------------------------------------------------------"); 
        if(DataBase.isEmpty())
        {
            System.out.println("Nothing to Display As database as empty");
            System.out.println("---------------------------------------------------------------------"); 
            return;
        }

        System.out.println("---------------------------------------------------------------------"); 
        System.out.println("------------Log Report From Marvellous Study Tracker-----------------");
        System.out.println("---------------------------------------------------------------------"); 
        for(StudyLog sobj : DataBase)
        {
            System.out.println(sobj);
        }
        System.out.println("---------------------------------------------------------------------"); 

    }

    public void ExportCSV()
    {
        if(DataBase.isEmpty())
        {
            System.out.println("---------------------------------------------------------------------"); 
            System.out.println("Nothing to Export As database as empty");
            System.out.println("---------------------------------------------------------------------"); 
            return;
        }
        String Filename = "MarvellousStudy.csv";
        //Create New CSV File
        try(FileWriter fwobj = new FileWriter(Filename))
        {
            //Write CSV Header
            fwobj.write("Date,Subject,Duration,Description\n");

            //Travel DataBase
            for(StudyLog sobj : DataBase)
            {
                //Write each record in CSV
                fwobj.write(sobj.getDate() + ","+
                            sobj.getSubject().replace(",", " ") + ","+
                            sobj.getDuration()+ ","+
                            sobj.getDescription().replace(",", " ") + "\n"
                );

            }
            System.out.println("Log Cretaed Succesfully");
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured");
            System.out.println("Report These issue to marvellous Infosystem");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("---------------------------------------------------------------------"); 
        if(DataBase.isEmpty())
        {
            System.out.println("Nothing to Display As database as empty");
            System.out.println("---------------------------------------------------------------------"); 
            return;
        }

        System.out.println("---------------------------------------------------------------------"); 
        System.out.println("----------------------- Summary By Data From ------------------------");
        System.out.println("---------------------------------------------------------------------"); 

        TreeMap<LocalDate, Double> tobj = new TreeMap<LocalDate , Double>();

        LocalDate lobj = null;
        double d,old;
        for(StudyLog sobj : DataBase)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();
            
            lobj = sobj.getDate();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj,d+old);

            }
            else
            {
                tobj.put(lobj,d);
            }
            
        }
        //Display the Details as per date
        for(LocalDate ldbj : tobj.keySet())
        {
            System.out.println("Date : " +ldbj+"Total Study : "+tobj.get(ldbj));
        }
        System.out.println("---------------------------------------------------------------------"); 

        

    }

    public void SummaryBySubject()
    {
           System.out.println("---------------------------------------------------------------------"); 
        if(DataBase.isEmpty())
        {
            System.out.println("Nothing to Display As database as empty");
            System.out.println("---------------------------------------------------------------------"); 
            return;
        }

        System.out.println("---------------------------------------------------------------------"); 
        System.out.println("----------------------- Summary By Data From ------------------------");
        System.out.println("---------------------------------------------------------------------"); 

        TreeMap<LocalDate, Double> tobj = new TreeMap<LocalDate , Double>();

        LocalDate lobj = null;
        double d,old;
        for(StudyLog sobj : DataBase)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();
            
            lobj = sobj.getDate();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj,d+old);

            }
            else
            {
                tobj.put(lobj,d);
            }
            
        }
        //Display the Details as per date
        for(LocalDate ldbj : tobj.keySet())
        {
            System.out.println("Date : " +ldbj+"Total Study : "+tobj.get(ldbj));
        }
        System.out.println("---------------------------------------------------------------------"); 

        
    }

}

class program557 //StudyTrackerStarter
{
    public static void main(String A[])
    {
        StudyTracker stobj = new StudyTracker();

        Scanner Scannerobj = new Scanner(System.in);
        int iChoice = 0;

        System.out.println("---------------------------------------------------------------------");
        System.out.println("----------Welcome To Marvellous Study Tracker Application------------");
        System.out.println("---------------------------------------------------------------------");

        do
        {
            System.out.println("Please Select the Approprite option from below");
            System.out.println("1 : Insert new Log Into database");
            System.out.println("2 : View All Study Logs");
            System.out.println("3 : Summary of study log by Date");
            System.out.println("4 : Summary Of study log by Subject");
            System.out.println("5 : Export Study Log to CSV file");
            System.out.println("6 : Exit The Apllication");

            iChoice = Scannerobj.nextInt();

            switch (iChoice) {
                case 1: //Insert new Log Into database
                    stobj.InsertLog();
                    break;
                case 2: // View All Study Logs
                    stobj.DisplayLog();
                    break;
                case 3: //Summary of study log by Date
                    stobj.SummaryByDate();
                    break;
                case 4: //Summary Of study log by Subject
                    
                    break;
                case 5: //Export Study Log to CSV file
                    stobj.ExportCSV();
                    break;
                case 6:  //Exit
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("-------Thank Your For Using Marvellous Study Log Application---------");
                    System.out.println("---------------------------------------------------------------------");
                    break;
                default : 
                    System.out.println("Please Enter Valid Option");

            }

        }while(iChoice != 6);

    }

}
