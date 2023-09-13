package Com.gl.Service;



import java.util.ArrayList;

import Com.gl.DAO.StudentDao;
import Com.gl.model.Student;


public class StudentService {
	StudentDao sDao;

	public StudentService() {
		sDao= new StudentDao();
		
	}
	
	public ArrayList<Student> getStudentsSvc(){
		return sDao.getStudents();
	}
	
	
	public boolean insertStudentSvc(Student student) {
		return sDao.insertStudents(student);
	}
	
	public boolean updateStudentSvc(Student student)
	{
			return sDao.updateStudents(student);
	}
	
	public boolean deleteStudentByIdSvc(int studentId) {
		return sDao.deleteStudent(studentId);
	}
	
	public boolean dropRecordsSvc() {
		return sDao.dropRecord();
		
	}
	
	}




