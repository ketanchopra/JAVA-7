import java.util.Scanner;
public class StudentGrading{
String[] studentName = new String[5];
char[] grade = {'A','B','C','D','F'};
double[][] testMarks = new double[5][4]; // for input of 5 students and 4 subjects



String getStudentName(int i) {
	return studentName[i];					//return the specific name of student
}
char getGradeOfStudent(int i) {					//this fuction call the getTotolMarks and then return the grade of the student
	double total_Marks = getTotalMarks(i);
	total_Marks = total_Marks/5;					//conditions return the appropriate grade for appropriate marks

	if(total_Marks >= 90 && total_Marks <= 100)
		return grade[0];
	else if (total_Marks >= 80 && total_Marks <= 89)
		return grade[1];
	else if (total_Marks >= 70 && total_Marks <= 79)
		return grade[2];
	else if (total_Marks >= 60 && total_Marks <= 69)
		return grade[3];
	else
		return grade[4];
}
double getTotalMarks(int i) {				//return the total marks of the specific student
	double total_Marks = 0;

	for(int j = 0;j<4;j++)
	{
		total_Marks = total_Marks+testMarks[i][j];
	}
	return total_Marks;

}
void setMarks(int j)				//this fuction will set the marks of students according to index
{
	double marks;
	Scanner sc = new Scanner(System.in);
	for(int i = 0;i<4;i++)
	{
		marks = sc.nextDouble();
		testMarks[j][i] = marks;
	}
}
	public static void main(String []args)								//main function
	{
		String name;
		StudentGrading sg = new StudentGrading();				//create the instance of class
		Scanner sc = new Scanner(System.in);			//input method
		for(int i = 0 ;i<5;i++)
		{
			System.out.println("Enter the name of Student");
			name = sc.nextLine();
			sg.studentName[i] = name;


		}
		double marks;
		for(int i = 0;i<5;i++)			//loop for set the marks and call the setMarks function
		{
			System.out.println("Enter the marks of "+sg.getStudentName(i));
			sg.setMarks(i);
		}
		//display the average marks
		//display the grade on the basis of average marks
		//display the total marks
		for(int i = 0 ;i< 5 ;i++) {

			System.out.println("Total marks of " + sg.getStudentName(i) + " is " + sg.getTotalMarks(i));
			System.out.println("Average marks of " + sg.getStudentName(i) + " is " + sg.getTotalMarks(i)/5);
			System.out.println("Grade of " + sg.getStudentName(i) + " is " +  sg.getGradeOfStudent(i));
			System.out.println("-----------------------------------------------------------------");
		}

	}
}
