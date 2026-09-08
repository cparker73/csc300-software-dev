//package finalProject;

import java.util.Comparator;

public class StudentPriority implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		if (s1.getStudentType().compareTo(s2.getStudentType()) == 0)
		{
			return s1.getArrivalTimeAtAdvisingCenter() - s2.getArrivalTimeAtAdvisingCenter();
		}
		else
		{
			return s1.compareTo(s2);
		}
		
	}
}
