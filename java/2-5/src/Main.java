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
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Task #1 gui
		//panel to hold input
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0,2));

		JLabel label1 = new JLabel("Value n: ");
		inputPanel.add(label1);
		JLabel label2 = new JLabel("Value a: ");
		inputPanel.add(label2);
		task1InputField = new JTextField(20);
		inputPanel.add(task1InputField);
		task1InputFieldA = new JTextField(20);
		inputPanel.add(task1InputFieldA);
		task251 = new JLabel("-");
		task252 = new JLabel("-");
		task253 = new JLabel("-");
		task254 = new JLabel("-");
		task255 = new JLabel("-");
		task255.setText(Integer.toString(task_25.mirrorSum()));
		JLabel label3 = new JLabel("GCD: ");
		JLabel label4 = new JLabel("Sum of n: ");
		JLabel label5 = new JLabel("Is n prime?: ");
		JLabel label6 = new JLabel("Sum 1!-2!+3!-4!+5!-...+n!: ");
		JLabel label7 = new JLabel("mirrorSum: ");
		inputPanel.add(label3);
		inputPanel.add(task251);
		inputPanel.add(label4);
		inputPanel.add(task252);
		inputPanel.add(label5);
		inputPanel.add(task253);
		inputPanel.add(label6);
		inputPanel.add(task254);
		inputPanel.add(label7);
		inputPanel.add(task255);
		
		//This will listen!
		task_25 t2 = new task_25(this);
		//Notify listnr when input changed
		task1InputField.getDocument().addDocumentListener(t2);
		task1InputFieldA.getDocument().addDocumentListener(t2);
		
	    tabbedPane.addTab("Tab 1", inputPanel);
	     JPanel task1Panel = new JPanel();
	     

	        
			
	     JComponent panel2 = makeTextPanel("Task #2");
	     tabbedPane.addTab("Task #1",  panel2);
		
		add(tabbedPane);
	}
	
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 600;
	
	//t25
	public JTextField task1InputField;
	public JTextField task1InputFieldA;
	public JLabel task251;
	public JLabel task252;
	public JLabel task253;
	public JLabel task254;
	public JLabel task255;

	
}
