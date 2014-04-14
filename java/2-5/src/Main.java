import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CustomFrame frame = new CustomFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class CustomFrame extends JFrame
{
	public CustomFrame()
	{
		setTitle("Java control work");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JTextField textField = new JTextField();
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(2,2));
		westPanel.add(textField);
		
		add(westPanel, BorderLayout.WEST);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
}
