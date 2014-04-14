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
		
		JButton btnTask1 = new JButton("Task 2-5");
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.add(btnTask1);

		add(westPanel, BorderLayout.WEST);
	}
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 600;
}
