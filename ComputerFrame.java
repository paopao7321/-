/*ComputerFrame�������Ϊ������Ŀ�ṩ��ͼ��
 * �����û�����ͨ��ComputerFrame������ṩ��GUI���濴����Ŀ��
 * ��ͨ����GUI���������Ŀ�Ĵ𰸣�
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ComputerFrame extends JFrame implements ActionListener,KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField textOne, textTwo, textResult;
	JButton getProblem, giveAnwser;
	Label operatorLabel, message;
	Teacher teacher;
	int number1;
	int number2;
	public static final int KEYCODE_ENTER = KeyEvent.VK_ENTER;

	ComputerFrame(String s) {
		super(s);
		
		teacher = new Teacher();
		setLayout(new FlowLayout());
		textOne = new TextField(10); // ����textOne,��ɼ��ַ�����10
		textTwo = new TextField(10); // ����textTwo,��ɼ��ַ�����10
		textResult = new TextField(10); // ����textResult,��ɼ��ַ�����10
		operatorLabel = new Label("+");
		message = new Label("你还没回答呢");
		getProblem = new JButton("生成题目");
		giveAnwser = new JButton("确认答案");

		add(getProblem);
		add(textOne);
		add(operatorLabel);
		add(textTwo);
		add(new Label("="));
		add(textResult);
		add(giveAnwser);
		add(message);
		
		textResult.requestFocus();
		textOne.setEditable(false);
		textTwo.setEditable(false);

		getProblem.addActionListener(this);// ����ǰ����ע��ΪgetProblem��ActionEvent�¼�������
		giveAnwser.addActionListener(this);// ����ǰ����ע��ΪgiveAnwser��ActionEvent�¼�������
		textResult.addActionListener(this); // ����ǰ����ע��ΪtextResult��ActionEvent�¼�������
		textResult.addKeyListener(this);
				
	
		setBounds(100, 100, 450, 100);
		setVisible(true);
		validate();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	int chanceNum=3;
	public void keyPressed(KeyEvent e){
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KEYCODE_ENTER){
			giveAnwser.doClick();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == getProblem) // �ж��¼�Դ�Ƿ���getProblem
		{
			number1 = teacher.giveNumberOne(100);
			number2 = teacher.giveNumberTwo(100);
			String operator = teacher.giveOperator();
			while(operator.equals("/")){
				if(number1%number2==0&&number2!=1&&number2!=number1)
				{
					break;
				}else{
					number1 = teacher.giveNumberOne(100);
					number2 = teacher.giveNumberOne(100);
				}
			}
//			if(operator.equals("+")||operator.equals("-")||operator.equals("*")){
			textOne.setText("" + number1);
			textTwo.setText("" + number2);
			operatorLabel.setText(operator);
			message.setText("请回答");
			textResult.setText(null);
			chanceNum = 3;
//			}
		}
		
		if (e.getSource() == giveAnwser) // �ж��¼�Դ�Ƿ���giveAnwser
		{
			chanceNum--;
			String answer = textResult.getText();
			if (chanceNum >=0) {
				try {
					 int result = Integer.parseInt(answer);
					//double result = Double.parseDouble(answer);
					System.out.print(chanceNum);
					if (teacher.getRight(result,number1,number2) == true) {
						message.setText("回答正确");
					} else  {
					
						message.setText("回答错误" + " 您还有" + chanceNum + "次机会");
					} 
					
					if(chanceNum==0){
//						if(teacher.operator.equals("/"))
//						message.setText("回答错误" + "  正确答案为："
//								+ teacher.getAnswer());
//						else
							message.setText("回答错误" + "  正确答案为："
									+ teacher.getAnswer(number1,number2));
							
					}

				} catch (NumberFormatException ex) {
					message.setText("请输入数字字符");
				}
			
			}
		}
		textResult.requestFocus();
		validate();
//		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
//		    public void eventDispatched(AWTEvent event) {
//		        if (((KeyEvent) event).getID() == KeyEvent.KEY_PRESSED) {
//		            //放入自己的键盘监听事件
//		            if(KEYCODE_ENTER == ((KeyEvent) event).getID()){
//		            	giveAnwser.doClick();
//		            }
//		        }
//		    }
//		}, AWTEvent.KEY_EVENT_MASK);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}