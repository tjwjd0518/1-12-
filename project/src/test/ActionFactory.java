package test;

public class ActionFactory {
	Action getAction(String command) {
		
		Action result = null;
		switch(command) {
		case "login":
			result = new LoginAction();
			break;
		case "login_check":
			result = new LoginCheckAction();
			break;
		case "register":
			result = new RegisterAction();
			break;
		case "register_check":
			result = new RegisterCheckAction();
			break;
		case "admin":
			result = new AdminAction();
			break;
			
		}
		return result;	
	}
}
