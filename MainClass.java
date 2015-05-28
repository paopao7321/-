public class MainClass
{ public static void main(String args[])
  { // new ComputerFrame("算术测试");
	Teacher t = new Teacher();
	t.setPlusMin(11);
	t.setPlusMax(50);
	System.out.println(t.giveNumber("+"));
  }
}