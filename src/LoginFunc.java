import javax.swing.*;



public class LoginFunc extends FileHandling {
	final String username;
	
	
	public LoginFunc(String username) {
		this.username = username;
	}
	
	public boolean checkUserInfo() {
		if(username.equals("")) {
			JOptionPane.showMessageDialog(null, "no username has been entered");
		}else {
			JOptionPane.showMessageDialog(null, "Player saved!");
			return true;
		}
		return false;
	}
	

}
