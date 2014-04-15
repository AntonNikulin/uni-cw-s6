
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
	
	//2.3 простое число
	public static boolean isPrime(int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	//2.4 Сумма ряда 1!-2!+3!-4!+5!-...+n!
	public static int sumSeq(int n){
		int sum = 0;
		for (int i=1;i<=n;i++){
			sum = (i%2 == 0) ? sum + factorial(i) : sum - factorial(i);
		}
		return sum;
	}
	
	public static int factorial(int n){
		return n <= 1 ? 1 : n * factorial(n-1);
	}
	

	//2.5 Cколько шестизначных цифр имеют равную сумму трех первых и трех последних цифр.
	public static int mirrorSum() {
		int result = 0;
		for (int i = 100000; i < 1000000; i++) {
			int firstPart = i/1000;
			int secondPart = i%1000;
			if (firstPart == secondPart) {
				result++;
			}
		}
		return result;
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
