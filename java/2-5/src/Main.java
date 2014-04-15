import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CustomFrame frame = new CustomFrame();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		*/		
		task_36.pascalTriangle();
	}	
}

class CustomFrame extends JFrame
{
	public CustomFrame()
	{
		setTitle("Java control work");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//navigation Button for each task!
		JButton btnTask1 = new JButton("Task 2-5");
		
		//Frame panel
		JPanel mainPanel = new JPanel();
		
		//panel will hold our navigation
		JPanel westPanel = new JPanel();
		westPanel.add(btnTask1);
		mainPanel.add(westPanel);
		
		//panel to hold input
		JPanel inputPanel = new JPanel();
		JTextField textField = new JTextField(20);
		inputPanel.add(textField);
		mainPanel.add(inputPanel);
		
		
		resLabel = new JLabel("Test");
		inputPanel.add(resLabel);
		
		task_25 t2 = new task_25(this);
		textField.getDocument().addDocumentListener(t2);

		
		
		add(mainPanel);
	}
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 600;
	
	public JLabel resLabel;
}
