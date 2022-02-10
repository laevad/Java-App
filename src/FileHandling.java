import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;


public class FileHandling implements CheckFile, CreateFile , WriteFile {
	public final String user = "src/user.txt";
	File userDataFile = new File(user);
	FileWriter fileWriter; 
	private Formatter form;

	
	
	
	@Override //mag validate if naay file nabuhat
	public boolean fileExist() {
		return userDataFile.exists();
	}
	@Override
	public void createLoginFile() throws IOException {
			if(!fileExist()) {
				userDataFile.createNewFile();  
			}
		
	}// end validate

	@Override
	public void writeFile(String username,String score) throws IOException {
		fileWriter = new FileWriter(user, true);	
		form = new Formatter(fileWriter);
		form.format("%s,%s\n", username,score);
		
	}
	@Override
	public void writeClose() {
		form.close();		
	}

	
		
	}

	
	
	