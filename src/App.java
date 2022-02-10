
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel loginPanel = new JPanel();
	JPanel frame = new JPanel();
	
	JTextField usernameTextField = new JTextField();
	JLabel lblUsername = new JLabel("User Name");
	JLabel lblQuiz = new JLabel("QUIZ");
	JLabel lblQuiz1 = new JLabel("QUIZ");
	JLabel lblQuiz2 = new JLabel("QUIZ");
	JLabel lblGame = new JLabel("GAME");
	JLabel lblGame1 = new JLabel("GAME");
	JLabel lblGame2 = new JLabel("GAME");
	JButton btnLogin = new JButton("Login");
	
	
	String[] questions = {
			"Which company created Java?",
            "Which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?",
            "A data item specified in a method call",
            "A method that has no implementation",
            "Keyword used to create instance of a class",
            "Another name for class method",
            "A class or interface",
            "An operator that has two arguments"
            };
	String[][] options = {
			{"Sun Microsystems","Starbucks","Microsoft", "Alphabet"},
            {"1989","1996","1972", "1492"},
            {"Apple","Latte","Oak", "Koffing"},
            {"Steve Jobs","Bill Gates","James Gosling", "Mark Zuckerberg"},
            {"Argument","Functions","Methods", "Class"},
            {"Abstract method","Class method","Constructors", "void method"},
            {"null","void","private", "new"},
            {"Abstract method","Class method","Static method", "Void method"},
            {"Constructor","Type","Method", "Parameters"},
            {"Arithmetic operator","Bitwise operator","Comparison operators", "Binary operator"}
            };
	char[] answers = {
			'A',
            'B',
            'C',
            'C',
            'A',
            'A',
            'D',
            'C',
            'B',
            'D',
	        };
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	
	JTextField textField = new JTextField();
	JTextField textField1 = new JTextField();
	public JButton buttonA = new JButton();
	public JButton buttonB = new JButton();
	public JButton buttonC = new JButton();
	public JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	public Timer timer = new Timer(1000, e -> {
	seconds--;
	seconds_left.setText(String.valueOf(seconds));
	if(seconds<=0) {
	displayAnswer();
	}
	
	});

	public App() {
		setResizable(false);
		int width =650 , height= 650; //frame size
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, width, height); //frame 
		JPanel contentPane = new JPanel();  //login panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2);
		
		
		
		loginPanel.setBackground(new Color(51,204,204));
		loginPanel.setBounds(0, 0, 634, 611);
		loginPanel.setLayout(null);
		
		frame.setBackground(new Color(255,255,204));
		frame.setBounds(0, 0, 634, 611);
		frame.setLayout(null);
		
		contentPane.add(loginPanel);
		contentPane.add(frame);
		frame.setLayout(null);
		
		
		lblQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiz.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblQuiz.setForeground(new Color(255,255,255));
		lblQuiz.setBounds(-50, 20, 600, 150);
		loginPanel.add(lblQuiz);
		
		lblQuiz1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiz1.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblQuiz1.setForeground(new Color(246,33,203));
		lblQuiz1.setBounds(-60, 30, 600, 150);
		loginPanel.add(lblQuiz1);
		
		lblQuiz2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiz2.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblQuiz2.setForeground(new Color(246,223,33));
		lblQuiz2.setBounds(-70, 40, 600, 150);
		loginPanel.add(lblQuiz2);
		
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblGame.setForeground(new Color(246,33,203));
		lblGame.setBounds(-100, 140, 1000, 150);
		loginPanel.add(lblGame);
		
		lblGame1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame1.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblGame1.setForeground(new Color(246,223,33));
		lblGame1.setBounds(-110, 140, 1000, 150);
		loginPanel.add(lblGame1);
		
		lblGame2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame2.setFont(new Font("Snap ITC", Font.BOLD, 100));
		lblGame2.setForeground(new Color(255,255,255));
		lblGame2.setBounds(-100, 150, 1000, 150);
		loginPanel.add(lblGame2);
		
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblUsername.setForeground(new Color(255,255,255));
		lblUsername.setBounds(218, 300, 188, 43);
		loginPanel.add(lblUsername);
		
		
		usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		usernameTextField.setBounds(218, 350, 188, 43);
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnLogin.setBounds(218, 400, 188, 43);
		btnLogin.setBackground(new Color (163, 204, 74));
		btnLogin.setForeground(new Color (255,255,255));
		loginPanel.add(btnLogin);
		loginPanel.getRootPane().setDefaultButton(btnLogin);
		
		btnLogin.addActionListener(e -> {
			try {
				if(new LoginFunc(usernameTextField.getText()).checkUserInfo()) {
					loginPanel.setVisible(false);
					frame.setVisible(true);
					quiz();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}// TODO Auto-generated catch block

		});
	}




		
		
	public void quiz() throws Exception {
		
		 
		textField.setBounds(0,0,650,50);
		textFieldBg(textField);

		textField1.setBounds(0,50,650,50);
		textFieldBg(textField1);


		 buttonA.setBounds(0,100,100,100);
		 buttonA.setFont(new Font("SansSerif Bold",Font.BOLD,35));
		 buttonA.setFocusable(false); 
		 buttonA.addActionListener(this);
		 buttonA.setText("A");
		 buttonA.setBackground(new Color(255, 204, 153));
		 buttonA.setForeground(new Color(255, 255, 255));
		 
		 
		 buttonB.setBounds(0,200,100,100);
		 buttonB.setFont(new Font("SansSerif Bold",Font.BOLD,35));
		 buttonB.setFocusable(false);
		 buttonB.addActionListener(this);
		 buttonB.setText("B");
		 buttonB.setBackground(new Color(255, 204, 153));
		 buttonB.setForeground(new Color(255, 255, 255));
		 
		 buttonC.setBounds(0,300,100,100);
		 buttonC.setFont(new Font("SansSerif Bold",Font.BOLD,35));
		 buttonC.setFocusable(false);
		 buttonC.addActionListener(this);
		 buttonC.setText("C");
		 buttonC.setBackground(new Color(255, 204, 153));
		 buttonC.setForeground(new Color(255, 255, 255));
		 
		 buttonD.setBounds(0,400,100,100);
		 buttonD.setFont(new Font("SansSerif Bold",Font.BOLD,35));
		 buttonD.setFocusable(false);
		 buttonD.addActionListener(this);
		 buttonD.setText("D");
		 buttonD.setBackground(new Color(255, 204, 153));
		 buttonD.setForeground(new Color(255, 255, 255));
		 
		 answer_labelA.setBounds(125,100,500,100);
		 answer_labelA.setBackground(new Color(255,204,153));
		 answer_labelA.setForeground(new Color(25,255,0));
		 answer_labelA.setFont(new Font("SansSerif Bold",Font.PLAIN,35));

		 
		 answer_labelB.setBounds(125,200,500,100);
		 answer_labelB.setBackground(new Color(255,204,153));
		 answer_labelB.setForeground(new Color(25,255,0));
		 answer_labelB.setFont(new Font("SansSerif Bold",Font.PLAIN,35));

		 
		 answer_labelC.setBounds(125,300,500,100);
		 answer_labelC.setBackground(new Color(255,204,153));
		 answer_labelC.setForeground(new Color(25,255,0));
		 answer_labelC.setFont(new Font("SansSerif Bold",Font.PLAIN,35));

		 
		 answer_labelD.setBounds(125,400,500,100);
		 answer_labelD.setBackground(new Color(255,204,153));
		 answer_labelD.setForeground(new Color(25,255,0));
		 answer_labelD.setFont(new Font("SansSerif Bold",Font.PLAIN,35));

		 
		 seconds_left.setBounds(535,510,100,100);
		 seconds_left.setBackground(new Color(183,232,221));
		 seconds_left.setForeground(new Color(255,0,0));
		 seconds_left.setFont(new Font("SansSerif Bold",Font.BOLD,60));
		 seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		 seconds_left.setOpaque(true);
		 seconds_left.setHorizontalAlignment(JTextField.CENTER);
		 seconds_left.setText(String.valueOf(seconds));
		 
		 time_label.setBounds(535,475,100,25);
		 time_label.setBackground(new Color(183,232,221));
		 time_label.setForeground(new Color(255,0,0));
		 time_label.setFont(new Font("SansSerif Bold",Font.PLAIN,20));
		 time_label.setHorizontalAlignment(JTextField.CENTER);
		 time_label.setText("TIMER: ");
		 
		number_right.setBounds(225,225,200,100);
		numberRightBg(number_right);

		percentage.setBounds(225,325,200,100);
		numberRightBg(percentage);


		frame.add(time_label);
		 frame.add(seconds_left);
		 frame.add(answer_labelA);
		 frame.add(answer_labelB);
		 frame.add(answer_labelC);
		 frame.add(answer_labelD);
		 frame.add(buttonA);
		 frame.add(buttonB);
		 frame.add(buttonC);
		 frame.add(buttonD);
		 frame.add(textField1);
		 frame.add(textField);
		 frame.setVisible(true);

		 
		 nextQuestion();
		 

		
	}

	private void numberRightBg(JTextField number_right) {
		number_right.setBackground(new Color(255,166,77));
		number_right.setForeground(new Color(255,255,255));
		number_right.setFont(new Font("SansSerif Bold",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
	}

	private void textFieldBg(JTextField textField) {
		textField.setBackground(new Color(255,166,77));
		textField.setForeground(new Color(255,255,255));
		textField.setFont(new Font("SansSerif Bold",Font.BOLD,30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
	}

	public void nextQuestion() throws Exception {
		 if(index>=total_questions) { //to determine which question are we
			 results();
		 }
		 else {
			 textField.setText("Question" +(index+1)); //the number question will increase as we call the nextQuestion()
			 textField1.setText(questions[index]); //the display being asked, the array of questions in certain index
			 answer_labelA.setText(options[index][0]); //to call the elements of array (options) by index
			 answer_labelB.setText(options[index][1]);
			 answer_labelC.setText(options[index][2]);
			 answer_labelD.setText(options[index][3]);
			 timer.start(); //start na dayun ang timer after question
		 }
		 
	}
	@Override
	public void actionPerformed(ActionEvent e) { //to trigger when someone clicks the button
		   
			buttonA.setEnabled(false); //to disable sa para di niya mabuhat diretso ang gusto buhaton, ayha sa condition
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer='A';
				if(answer == answers[index]) { //check if ang answer kay naa sa index 
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer='B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer='C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer='D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}

	public void displayAnswer() {
		timer.stop(); //to stop the timer
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);


		if(answers[index] != 'A' ) //check if imong answer is tugma ba sa index sa answers
			answer_labelA.setForeground(new Color(255,108,0));
		if(answers[index] != 'B' )
			answer_labelB.setForeground(new Color(255,108,0));
		if(answers[index] != 'C' )
			answer_labelC.setForeground(new Color(255,108,0));
		if(answers[index] != 'D' )
			answer_labelD.setForeground(new Color(255,108,0));

		Timer pause = new Timer(2000, e -> { //adding pause after we display the answer, new ActionListener()
			answer_labelA.setForeground(new Color(5,174,89));
			answer_labelB.setForeground(new Color(5,174,89));
			answer_labelC.setForeground(new Color(5,174,89));
			answer_labelD.setForeground(new Color(5,174,89));
			//to reset the answers
			answer = ' '; 
			seconds=10;
			seconds_left.setText(String.valueOf(seconds));
			buttonA.setEnabled(true); // re enable button
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			index++; //to go to the next question
			try {
				nextQuestion();
			} // TODO Auto-generated catch block
			catch (Exception fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}// TODO Auto-generated catch block

		});
		pause.setRepeats(false); //to stop the repeatition
		pause.start();
	}

   public void results() throws Exception{
	
	FileHandling fileHandling = new  FileHandling();
	  
	   
   	buttonA.setEnabled(false);
   	buttonB.setEnabled(false);
   	buttonC.setEnabled(false);
   	buttonD.setEnabled(false);

   	result = (int)((correct_guesses/(double)total_questions)*100);
   	
   	textField.setText("RESULTS!!!");
	textField1.setText("Score of "+ usernameTextField.getText());
   	answer_labelA.setText("");
   	answer_labelB.setText("");
   	answer_labelC.setText("");
   	answer_labelD.setText("");

   	number_right.setText("("+correct_guesses+"/"+total_questions+")");
   	percentage.setText(result+"%");
   	fileHandling.writeFile(usernameTextField.getText(),( result+" "));
   	fileHandling.writeClose();
   	
  
   	
   	frame.add(percentage);
   	frame.add(number_right);
   }

   
}

		