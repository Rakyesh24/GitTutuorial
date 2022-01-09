package amazonpompages;

public class Add {
	int a,b;
	double c,d;
	public Add(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public Add(double c,double d) {
		this.c=c;
		this.d=d;
	}
	
	public void addInt() {
		System.out.println(a+b);
	}
	public void addDouble() {
		System.out.println(a+b);
	}

	

}

class Test{
	public static void main(String[] args) {
		Add ad=new Add(2,3);
		ad.addInt();
		ad.addDouble();

	}
}
