package Com.gl.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import Com.gl.connection.MYConnections;
import Com.gl.model.Student;

public class StudentDao {
	Connection mycon;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MYConnections mcon;
	public StudentDao(){
		 mcon = new MYConnections();
	}
	public boolean insertStudents(Student student) {
		 
		 boolean flag = false;
		 mycon =mcon.getMyConnection();
		 String query = "insert into students values(?,?,?,?)";
		 try {
			 pstmt = mycon.prepareStatement(query);
			 pstmt.setInt(1, student.getStudId() );
			 pstmt.setString(2, student.getStudName());
			 pstmt.setString(3,student.getStudEmail());
			 pstmt.setLong(4, student.getStudPhone());
			
			 pstmt.execute();
			 flag = true;
		 }catch(SQLException s) {
			 flag = false;
			 s.printStackTrace();
		 }
		 return flag;
		 
	 }
	public boolean updateStudents(Student student) {
		  boolean flag = false;
		  
		  mycon = mcon.getMyConnection();
		  try {
		  String query = " update Student set studName = ? where studId =?";
		  String query2= "update Student set  studEmail =? where studId =?";
		  pstmt.setString(1, student.getStudName());
		  pstmt.setInt(2, student.getStudId());
		  pstmt.setString(1, student.getStudEmail());
		  pstmt.setInt(2, student.getStudId());
		  
		   pstmt.execute();
		   
		   flag = true;
	  }catch(SQLException s) {
		  s.printStackTrace();
		  flag = false;
		  
	  }return flag;
		  }
	
	public boolean deleteStudent(int studId) {
		
		boolean flag = false;
		mycon = mcon.getMyConnection();
		try {
			String query ="delete from Student where studId = ?";
			PreparedStatement pstmt = mycon.prepareStatement(query);
			pstmt.setInt(1, studId);
			pstmt.executeUpdate();
			flag = true;
		}catch(SQLException s) {
			s.printStackTrace();
			flag = false;
			
		}
		return flag;
		
	}
	
	public boolean dropRecord() {
		mycon =mcon.getMyConnection();
		try {
			stmt = mycon.createStatement();
			String query ="Truncate Student";
			int result = stmt.executeUpdate(query);
			System.out.println("dropped successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return true;
	}
	
	
 public  ArrayList<Student>getStudents(){
	 
	 mycon = mcon.getMyConnection();
	 ArrayList<Student> students = new ArrayList<>();
	 
	 try {
		 String query = "select * from Student";
		stmt = mycon.createStatement();
		rs = stmt.executeQuery(query);
		
		String studName,studEmail;
		int studId;
		long studPhone;
		
		while(rs.next()) {
			Student student = new Student();
			studId =rs.getInt(1);
			student.setStudId(studId);
			
			studName =rs.getString(2);
			student.setStudName(studName);
			
			studEmail =rs.getString(3);
			student.setStudEmail(studEmail);
			
			studPhone =rs.getLong(4);
			student.setStudPhone(studPhone);
		
			students.add(student);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  return null;
 }

}


