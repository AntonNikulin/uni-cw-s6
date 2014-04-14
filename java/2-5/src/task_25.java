
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class task_25 implements ActionListener {
	
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
	
	public void actionPerformed(ActionEvent event){
		frame.resLabel.setText("Hello");
	}
	
	private CustomFrame frame;
}
