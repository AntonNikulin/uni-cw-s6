
public class q25 {

	public static void main(String[] args) {
		System.out.print(q25.SumN(342));
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

}
