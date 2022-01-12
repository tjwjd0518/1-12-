package test;

public class MemberDaoTest {
	static MemberDao dao = new MemberDao();
	static void testLoginCheck() {
		System.out.println(dao.loginCheck(new MemberDto("SJ","1234","",""))); 
	}
	static void testRegisterCheck() {
		System.out.println(dao.registerCheck(new MemberDto("SH","1234","SH","")));
	}
	public static void main(String[] args) {
		testLoginCheck();
		testRegisterCheck();
	}
}
