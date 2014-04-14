
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class task_25 implements DocumentListener {
	
	public task_25(CustomFrame frame){
		this.frame = frame;
	}
	
	//2.1 наибольший общий делитель
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
	
	//2.2 сумма цифр числа
	public static int SumN(int n){
		int sum = 0;
		while(n != 0){
		        sum += (n % 10);
		        n/=10;
		}
		return sum;
	}	


	@Override
	public void changedUpdate(DocumentEvent arg0) {

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		frame.resLabel.setText("ins");
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		frame.resLabel.setText("rem");
	}
	
	private CustomFrame frame;
}
