import java.awt.*;

import javax.swing.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.io.*;
import java.util.Arrays;

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
		
	    tabbedPane.addTab("Task #1", inputPanel);
	     JPanel task1Panel = new JPanel();
	     

	        
		//TASK 2 gui
	     //set up
	     JPanel task2Panel = new JPanel();
	     tabbedPane.addTab("Task #2",  task2Panel);
	     jtaTask2Console = new JTextArea();
	     task2Panel.add(jtaTask2Console);
	     	//no time to prettify
		    System.out.println("Создать массив из 100 элементов и заполнить его простыми числами");
		    System.out.println(Arrays.toString(task_36.arrayOfPrimes()));
	     
	     redirectSystemStreams();
	     //print result
	     System.out.println("Разместить в памяти массив из 20 элементов и заполнить его рядом чисел Фиббоначчи.");
	    System.out.println(Arrays.toString( task_36.fib()));
	    System.out.println("Создать двумерный массив символов и заполнить его буквами Ч и Б в шахматном порядке");
	    task_36.chessArray();
	    System.out.println("Создать целый шестимерный массив с двумя значениями в каждом измерении. сколько потребуется чисел?");
	    System.out.println(Integer.toString(task_36.multiArray()));
	    System.out.println("треугольник Паскаля");
	    task_36.pascalTriangle();
	    
	     
		
		add(tabbedPane);
	}
	
	//where the text get redirected.
	  private void updateTextArea(final String text) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        jtaTask2Console.append(text);
	      }
	    });
	  }
	 
	//Followings are The Methods that do the Redirect
	  private void redirectSystemStreams() {
	    OutputStream out = new OutputStream() {
	      @Override
	      public void write(int b) throws IOException {
	        updateTextArea(String.valueOf((char) b));
	      }
	 
	      @Override
	      public void write(byte[] b, int off, int len) throws IOException {
	        updateTextArea(new String(b, off, len));
	      }
	 
	      @Override
	      public void write(byte[] b) throws IOException {
	        write(b, 0, b.length);
	      }
	    };
	 
	    System.setOut(new PrintStream(out, true));
	    System.setErr(new PrintStream(out, true));
	  }

	
	public static final int DEFAULT_WIDTH = 650;
	public static final int DEFAULT_HEIGHT = 500;
	
	//t25
	public JTextField task1InputField;
	public JTextField task1InputFieldA;
	public JLabel task251;
	public JLabel task252;
	public JLabel task253;
	public JLabel task254;
	public JLabel task255;
	
	private JTextArea jtaTask2Console;

	
}
