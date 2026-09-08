//package finalProject;

import java.util.Random;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class AdvisingCenter 
{
	private Random randy;
	private PriorityQueue<Student> waitingQ;
	private ArrayList<Student> processedStudents;
	private Advisor[] advisors;
	private String deptName;
	private int currentTime = 0;
	
	public AdvisingCenter(String name, int seed, int numAdvisors)
	{
		deptName = name;
		waitingQ = new PriorityQueue<>(new StudentPriority());
		randy = new Random(seed);
		createAdvisors(numAdvisors);
		processedStudents = new ArrayList<>();
	}
	
	public void createAdvisors(int numAdvisors)
	{
		advisors = new Advisor[numAdvisors];
		
		for (int i = 0; i < numAdvisors; i++)
		{
			advisors[i] = new Advisor();
		}
	}
	
	public void openAdvisingCenter()
	{
		/* This starts the clock at time 0 and runs for 10 minutes (i.e. 0<=currentTime<10) 
		 * of loading up the line before the AdvisingCenter doors open and service begins. 
		 * currentTime should have a value of 10 when this is finished */
		
		for (currentTime = 0; currentTime < 10; currentTime++) //Simulates early arriving Students
		{
			for (int i = 0; i < 10; i++)
			{
				int tempNum = randy.nextInt(1, 31);
				
				if (tempNum < 5) 
					waitingQ.add(new Senior(currentTime, new FullTimeAdvising()));
				else if (tempNum < 6)
					waitingQ.add(new Senior(currentTime, new PartTimeAdvising()));
				else if (tempNum < 14)
					waitingQ.add(new JuniorSoph(currentTime, new FullTimeAdvising()));
				else if (tempNum < 16)
					waitingQ.add(new JuniorSoph(currentTime, new PartTimeAdvising()));
				else if (tempNum < 29)
					waitingQ.add(new Freshman(currentTime, new FullTimeAdvising()));
				else
					waitingQ.add(new Freshman(currentTime, new PartTimeAdvising()));
			}
		}
	}
	
	public void operateAdvisingCenter(int durationForArriving)
	{
		int endArrivalsTime = currentTime + durationForArriving;
		Student tempStudent;
		Advisor tempAdv;
		
		while (processedStudents.size() != Student.idCounter || currentTime < endArrivalsTime) //all arrivals processed this way
		{
			if (currentTime < endArrivalsTime) //simulates arriving Students until office doors close
			{
				for (int i = 0; i < 8; i++)
				{
					int tempNum = randy.nextInt(1, 31);
					
					if (tempNum < 6)
						waitingQ.add(new Senior(currentTime, new FullTimeAdvising()));
					else if (tempNum < 7)
						waitingQ.add(new Senior(currentTime, new PartTimeAdvising()));
					else if (tempNum < 15)
						waitingQ.add(new JuniorSoph(currentTime, new FullTimeAdvising()));
					else if (tempNum < 18)
						waitingQ.add(new JuniorSoph(currentTime, new PartTimeAdvising()));
					else if (tempNum < 29)
						waitingQ.add(new Freshman(currentTime, new FullTimeAdvising()));
					else
						waitingQ.add(new Freshman(currentTime, new PartTimeAdvising()));
				}
			}
			
			for (int i = 0; i < advisors.length; i++)
			{
				tempAdv = advisors[i];
				
				if (!tempAdv.getIsFree())
				{
					tempAdv.decrementTimeRemainingForMeeting();
					
					if (tempAdv.getTimeRemainingForMeeting() == 0)
					{
						tempStudent = tempAdv.getAssignedStudent();
						processedStudents.add(tempStudent);
						tempStudent.setTotalTimeAtAdvisingCenter(currentTime);
						
						tempAdv.removeAssignedStudent();
					}
				}
			}
		
			for (int i = 0; i < advisors.length; i++) //assign students to free advisors
			{
				tempAdv = advisors[i]; 
				
				if (tempAdv.getIsFree() && !waitingQ.isEmpty())
				{
					tempStudent = waitingQ.remove();
					tempStudent.setAdvisorStartTime(currentTime);
					
					tempAdv.setAssignedStudent(tempStudent);
					
					int meetingDuration = randy.nextInt(10, 21);
					
					tempStudent.setMeetingDuration(meetingDuration);
					
					tempAdv.setTimeRemainingForMeeting(meetingDuration);
				}
			}
			
			currentTime++;
		}
	}	
	
	public void generateAdvisingCenterResults(String out) throws IOException
	{
		PrintWriter pw = new PrintWriter(out);
		pw.printf("Data For CSUDH Advising Center For %s Department%n", deptName);
		
		int fCount = 0, jCount = 0, sCount = 0;
		int totalStudentCount = 0;
		double fTotalTime = 0, jTotalTime = 0, sTotalTime = 0;
		double freshAvgTotalTime, juniorSophAvgTotalTime, seniorAvgTotalTime;
		double totalAvgStudentTotalTime;	
		
		pw.printf("%nSummary Data%n");
		for (Advisor temp : advisors)
		{
			pw.printf("%s", temp.toString()); //summary of number of students processed by each advisor
		}
		
		for (Student temp : processedStudents)
		{
			if (temp instanceof Freshman)
			{
				fCount++;
				fTotalTime += temp.getTotalTimeAtAdvisingCenter();
			}
			else if (temp instanceof JuniorSoph)
			{
				jCount++;
				jTotalTime += temp.getTotalTimeAtAdvisingCenter();
			}
			else
			{
				sCount++;
				sTotalTime += temp.getTotalTimeAtAdvisingCenter();
			}
		}
		
		freshAvgTotalTime = fTotalTime / fCount;
		juniorSophAvgTotalTime = jTotalTime / jCount;
		seniorAvgTotalTime = sTotalTime / sCount;
		
		totalStudentCount = sCount + fCount + jCount;
		totalAvgStudentTotalTime = (fTotalTime + jTotalTime + sTotalTime) / totalStudentCount;
		
		pw.printf("%nThe average total time in meeting per students for %d Seniors is %.2f minutes%n", sCount, seniorAvgTotalTime);
		pw.printf("The average total time in office per student for %d JuniorSophs is %.2f minutes%n", jCount, juniorSophAvgTotalTime);
		pw.printf("The average total time in office per student for %d Freshmen is %.2f minutes%n", fCount, freshAvgTotalTime);
		pw.printf("The average total time in office per student for %d Students is %.2f minutes%n", totalStudentCount, totalAvgStudentTotalTime);
		
		pw.printf("%n%19s%28s%19s%19s%16s%14s%19s%13s%n","STUDENT ID", "STUDENT TYPE", "ADVISING TYPE", "ADVISING NUMBER",
			      "ARRIVAL TIME", "WAIT TIME", "MEETING TIME", "TOTAL TIME");
		
		Iterator<Student> studentIt = processedStudents.iterator();
		while (studentIt.hasNext())
		{
			Student temp = (Student) studentIt.next();
			
			pw.printf("%-36s%11s%17s%18s%16d%12d%17d%14d%n", temp.getStudentID(), temp.getStudentType(), temp.getAdvType().getAdvisingType(), temp.getAdvType().getAdvisingNumber(),
					  temp.getArrivalTimeAtAdvisingCenter(), temp.getWaitTime(), temp.getMeetingDuration(), temp.getTotalTimeAtAdvisingCenter());
		}
		
		pw.close();
	}
}
