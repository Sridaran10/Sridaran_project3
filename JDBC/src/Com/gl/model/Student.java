package Com.gl.model;

	

	public class Student {
		
		int studId;
		String studName;
		String studEmail;
		long studPhone;
		public int getStudId() {
			return studId;
		}
		public void setStudId(int studId) {
			this.studId = studId;
		}
		public String getStudName() {
			return studName;
		}
		public void setStudName(String studName) {
			this.studName = studName;
		}
		public String getStudEmail() {
			return studEmail;
		}
		public void setStudEmail(String studEmail) {
			this.studEmail = studEmail;
		}
		public long getStudPhone() {
			return studPhone;
		}
		public void setStudPhone(long studPhone) {
			this.studPhone = studPhone;
		}
		public Student(int studId, String studName, String studEmail, long studPhone) {
			super();
			this.studId = studId;
			this.studName = studName;
			this.studEmail = studEmail;
			this.studPhone = studPhone;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Student [studId=" + studId + ", studName=" + studName + ", studEmail=" + studEmail + ", studPhone="
					+ studPhone + "]";
		}
		public Student(int studId) {
			super();
			this.studId = studId;
		}
		

	}


