package Com.gl.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Com.gl.Service.StudentService;
import Com.gl.model.Student;

public class StudentDbManager {

	
	Connection myCon;
	Statement stmt;
	ResultSet rs;
	String reply ="yes";
	int choice;
	StudentService sService;
	
	public StudentDbManager() {
		sService = new StudentService();
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {

		
		while(reply.equals("yes")|| (reply.equals("YES")))
		{
			System.out.println("------------MAIN MENU-------");
			System.out.println("1.View Students..");
			System.out.println("2.Insert Students..");
			System.out.println("3.update Students..");
			System.out.println("4.Delete Students..");
			System.out.println("5.truncate record");
			System.out.println("6.Exit Students..");
			System.out.println("Enter your choice...");
			
			choice =sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("viewing Students");
				ArrayList<Student> Students =sService.getStudentsSvc();
				Iterator<Student> eIter = Students.iterator();
				while(eIter.hasNext()) {
					Student e = eIter.next();
					System.out.println(e);
				}
				break;
		
			case 2:
				System.out.println("Inserting Students");
				System.out.println();
				
				Student Student = new Student();
				String studName,studEmail;
				int studId;
				long studPhone;
				
				System.out.println("Enter the Student id ");
				studId = sc.nextInt();
				
				System.out.println("Enter the Student name");
				studName =sc.nextLine();
				
				System.out.println("Enter the Student email ");
				studEmail = sc.nextLine();
				
				System.out.println("Enter the Student Phone ");
				studPhone= sc.nextLong();
				
				
				Student student = new Student(studId, studName, studEmail, studPhone);
				
				if(sService.insertStudentSvc(Student)) {
					
					System.out.println("Student record inserted successfully..");
					
				}else {
					
					System.out.println("Student insertion  failed..");
				}
					
				break;
			case 3:
				
				System.out.println("updating Students");
				int studId1;
				String  StudName;
				System.out.println("enter the name of the Student whose id u want to change..");
				studId1 = sc.nextInt();
				Student student1 = new Student(studId1);
				sService.updateStudentSvc(student1);
			
				if(sService.updateStudentSvc(student1)) {
					System.out.println("updated successfully");
				}else {
					System.out.println("updation failed");
				}
				
					
				break;
				
			case 4:
				System.out.println("deleting student by id");
				System.out.println("Enter the student id which u want to delete..");
				int studId2 = sc.nextInt();
				sService.deleteStudentByIdSvc(studId2);
				if(sService.deleteStudentByIdSvc(studId2))
				System.out.println("Student id deleted successfully...");
				else
					System.out.println("some error occured");
				
			case 5:
				System.out.println("trucating the table");
				sService.dropRecordsSvc();
				
				
				
				
			default:
					System.out.println("Allowed options are 1 to 6");
				break;
			}
			System.out.println("Do u want to continue yes/no");
			reply = sc.next();
			
			
			
		}
		}public static void main(String[] args) {
		
			
			StudentDbManager sdb = new StudentDbManager();
			sdb.displayMenu();
		}}
