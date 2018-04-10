package assignment8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboCalculatorFrame extends JFrame {
	private String[] operatorStrings= {"+","-","*","/","C"};
	private JLabel firstLabel,secondLabel,thirdLabel;
	private JTextField num1,num2,result;
	private JComboBox operator;
	private OperatorListener ol;
	Font font=new Font("Times",Font.BOLD,14);
	class OperatorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double a=Integer.parseInt(num1.getText());
			double b=Integer.parseInt(num2.getText());
			JComboBox cb=(JComboBox) e.getSource();
			String op=(String) cb.getSelectedItem();
			if(op=="+") {
				result.setText(a+b+"");
			}
			if(op=="-") {
				result.setText(a-b+"");
			}
			if(op=="*") {
				result.setText(a*b+"");
			}
			if(op=="/") {
				result.setText(a/1.0/b+"");
			}
			if(op=="C") {
				result.setText("");
			}
		}
		
	}
	
	public ComboCalculatorFrame() {
		createComponents();
		setLayout();
		addComponents();
		createListeners();
		addListeners();
		makeItVisiable();
	}
	
	
	private void createComponents() {
		//title
		setTitle("Calculator");
		
		//JLabel
		firstLabel=new JLabel("Input the 1st Number:");
		firstLabel.setFont(font);
		secondLabel=new JLabel("Input the 2nd Number:");
		secondLabel.setFont(font);
		thirdLabel=new JLabel("Result:");
		thirdLabel.setFont(font);
		
		//JTextField
		num1=new JTextField(5);
		num2=new JTextField(5);
		result=new JTextField(10);
		
		//JComboBox
		operator=new JComboBox(operatorStrings);
		operator.setFont(new Font("Times",Font.BOLD,16));
		
	}
	

	private void setLayout() {
		Container c=new Container();
		c.setLayout(new BorderLayout());
	}

	private void addComponents() {
		Container c=getContentPane();
		addInputControl(c);
		addOperatorControl(c);
		addOutputControl(c);
	}

	private void addOutputControl(Container c) {
		JPanel p=new JPanel();
		p.add(thirdLabel);
		p.add(result);
		c.add(p,"South");
	}

	private void addOperatorControl(Container c) {
		JPanel p=new JPanel();
		p.add(operator);
		c.add(p,"Center");
	}

	private void addInputControl(Container c) {
		JPanel p=new JPanel();
		p.add(firstLabel);
		p.add(num1);
		p.add(secondLabel);
		p.add(num2);
		c.add(p,"North");
	}

	private void createListeners() {
		ol=new OperatorListener();
	}
	
	private void addListeners() {
		operator.addActionListener(ol);
	}

	private void makeItVisiable() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		new ComboCalculatorFrame();
	}

}
