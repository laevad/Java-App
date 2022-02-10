import java.awt.EventQueue;

import javax.swing.JFrame;



public class Main {



	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			try {
				new FileHandling().createLoginFile(); //file handling method
				JFrame frame = new App();
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

	
