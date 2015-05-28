import java.util.Random;

//�������������Ŀ�����жϻش��ߵĴ��Ƿ���ȷ
public class Teacher {
	int numberOne, numberTwo;
	String operator = "";
	boolean right;
	int plusMax;
	int plusMin;
	
	
	
	
	public Teacher() {
		super();
		plusMin = 1;
		plusMax = 100;
	}

	public int getPlusMax() {
		return plusMax;
	}

	public void setPlusMax(int plusMax) {
		this.plusMax = plusMax;
	}

	public int getPlusMin() {
		return plusMin;
	}

	public void setPlusMin(int plusMin) {
		this.plusMin = plusMin;
	}

	public int giveNumber(String operator) {
		if("+".equals(operator)) {
			int random = -1;
			
			do{
				random = (int)(Math.random()*plusMax)+1;
			}while(random<plusMin);
			return random;
		}
		return -1;
		
	}
	
	public int giveNumberOne(int n) {
		numberOne = (int) (Math.random() * n) + 1;
		return numberOne;
	}

	public int giveNumberTwo(int n) {
		numberTwo = (int) (Math.random() * n) + 1;
		return numberTwo;
	}

	public String giveOperator() {
		double d = Math.random();
		if (d > 0.75)
			operator = "+";
		else
			if(d >=0.5)
				operator = "*";
			else
				if(d >= 0.25)
					operator = "/";
				else
			operator = "-";
		return operator;
	}

	public boolean getRight(int answer ,int n1,int n2) {
		if (operator.equals("+")) {
			System.out.println(n1 + n2);
			if (answer == n1 + n2)
				right = true;
			else
				right = false;
		} else if (operator.equals("-")) {
			System.out.println(n1 - n2);
			if (answer == n1 - n2)
				right = true;
			else
				right = false;
		}
		else if (operator.equals("*")) {
System.out.println(n1 * n2);
			if (answer == n1 * n2)
				right = true;
			else
				right = false;
		}
		else if (operator.equals("/")) {
			//System.out.println((int)((n1 / (double)n2)*10)/10.0);
			//if (answer == ((int)((n1 / (double)n2)*10)/10.0))
			System.out.println(n1 + "   "+n2);
			System.out.println(n1/n2);
			if(answer == n1/n2)	
			right = true;
			else
				right = false;
		}
		return right;
	}

public double getAnswer(int n1,int n2) {
	if (operator.equals("+")) {
		return n1 + n2;
			
	} else if (operator.equals("-")) {
		return n1 - n2;
			
	}
	else if (operator.equals("*")) {
		return n1 * n2;
	}
	else  {
		//return ((int)((n1 / (double)n2)*10)/10.0);
		return n1 / n2;
}
	
}}
