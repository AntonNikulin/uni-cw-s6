
public class q251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(q251.GCD(342,12));
	}
	
	//2.1 greatest common divisor
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }

}
