package assignment8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator_Frame extends JFrame {
	/**
	 * 7 steps
	 * 		1.create container
	 * 		2.create component
	 * 		3.set Layout
	 * 		4.add components
	 * 		5.create listener(implements ActionListener)
	 * 		6.add listener
	 * 		7.make container visuable
	 */
	
	private JTextField num1, num2, result,selected;
	private JButton one, two, three, four,
					five, six, seven, eight,
					nine, zero, dot, clear,
					plus, minus, multiply, divide;
	private JLabel firstLabel, secondLabel, thirdLabel;
	private OperatorListener operator;
	private NumberListener number;
	
	 
	public MyCalculator_Frame() {
		createComponent();
		setLayout();//!!!this should be in front of the addComponent 
		addComponent();
		createListener();
		addListener();
		makeItVisuable();
	}
	
	
	
	private void makeItVisuable() {
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}



	private void addListener() {
		num1.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            selected = num1;
	        }
	    });
	    num2.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            selected = num2;
	        }
	    });
		plus.addActionListener(operator);
		minus.addActionListener(operator);
		multiply.addActionListener(operator);
		divide.addActionListener(operator);
		clear.addActionListener(operator);
		one.addActionListener(number);
		two.addActionListener(number);
		three.addActionListener(number);
		four.addActionListener(number);
		five.addActionListener(number);
		six.addActionListener(number);
		seven.addActionListener(number);
		eight.addActionListener(number);
		nine.addActionListener(number);
		zero.addActionListener(number);
		dot.addActionListener(number);
	}



	private void createListener() {
		operator=new OperatorListener();
		number=new NumberListener();
	}

	class OperatorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double a=Double.parseDouble(num1.getText());
			double b=Double.parseDouble(num2.getText());
			Object o=e.getSource();
			try {
			if(o==plus) {
				double r=a+b;
				result.setText(r+"");
			}
			
			if(o==minus) {
				double r=a-b;
				result.setText(r+"");
			}

			if(o==multiply) {
				double r=a*b;
				result.setText(r+"");
			}

			if(o==divide) {
				double r=a/b;
				result.setText(r+"");
			}
			
			if(o==clear) {
				num1.setText("");
				num2.setText("");
				result.setText("");
			}
			}catch(Exception e1) {
				
			}
		}
		
	}

		
		class NumberListener implements ActionListener{		
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o=e.getSource();
					if(o==one) {
						selected.setText(selected.getText()+1);
					}
					if(o==two) {
						selected.setText(selected.getText()+2);
					}
					if(o==three) {
						selected.setText(selected.getText()+3);
					}
					if(o==four) {
						selected.setText(selected.getText()+4);
					}
					if(o==five) {
						selected.setText(selected.getText()+5);
					}
					if(o==six) {
						selected.setText(selected.getText()+6);
					}
					if(o==seven) {
						selected.setText(selected.getText()+7);
					}
					if(o==eight) {
						selected.setText(selected.getText()+8);
					}
					if(o==nine) {
						selected.setText(selected.getText()+9);
					}
					if(o==zero) {
						selected.setText(selected.getText()+0);
					}
					if(o==dot) {
						selected.setText(selected.getText()+".");
					}	
		}
	}

	
	
	private void setLayout() {
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
	}



	private void addComponent() {
		Container c=getContentPane();
		addIn_OutControl(c);
		addButtonControl(c);
	}

	private void addButtonControl(Container c) {
		Box left=Box.createVerticalBox();
		JPanel p1=new JPanel();
		p1.add(one);
		p1.add(two);
		p1.add(three);
		
		JPanel p2=new JPanel();
		p2.add(four);
		p2.add(five);
		p2.add(six);
		
		JPanel p3=new JPanel();
		p3.add(seven);
		p3.add(eight);
		p3.add(nine);
		
		JPanel p4=new JPanel();
		p4.add(zero);
		p4.add(dot);
		p4.add(clear);
		left.add(p1);
		left.add(p2);
		left.add(p3);
		left.add(p4);
		
		Box right=Box.createVerticalBox();
		right.add(plus);
		right.add(minus);
		right.add(multiply);
		right.add(divide);
		
		Box top=Box.createHorizontalBox();
		top.add(left);
		top.add(right);
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		c.add(top,BorderLayout.CENTER);
	}



	private void addIn_OutControl(Container c) {
		JPanel p=new JPanel();
		p.add(firstLabel);
		p.add(num1);
		p.add(secondLabel);
		p.add(num2);
		p.add(thirdLabel);
		p.add(result);
		c.add(p,"North");
	}



	private void createComponent() {
		setTitle("MyCalculator");
		
		//JLabel
		firstLabel=new JLabel("Input 1:");
		secondLabel=new JLabel("Input 2:");
		thirdLabel=new JLabel("Result:");
		
		//JTextField
		num1=new JTextField(5);//max allows 5 digit
		selected=num1;
		num2=new JTextField(5);
		result=new JTextField(5);
		result.setEnabled(false);
		
		//JButton
		one=new JButton("1");
		two=new JButton("2");
		three=new JButton("3");
		four=new JButton("4");
		five=new JButton("5");
		six=new JButton("6");
		seven=new JButton("7");
		eight=new JButton("8");
		nine=new JButton("9");
		zero=new JButton("0");
		dot=new JButton(".");
		clear=new JButton("C");
		plus=new JButton("+");
		minus=new JButton("-");
		multiply=new JButton("*");
		divide=new JButton("/");
	}



	public static void main(String[] args) {
		new MyCalculator_Frame(); 
	}
	
}
