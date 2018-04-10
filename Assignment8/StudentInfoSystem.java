package assignment8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


class Student{
	private String name;
	private String roll;
	private String grade;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getLine() {
		return roll+", "+name+", "+gender+", "+grade;
	}

	public static Student fromLine(String line) {
		String t[]=line.split("\\,");
		Student s=new Student();
		s.setRoll(t[0]);
		s.setName(t[1]);
		s.setGender(t[2]);
		s.setGrade(t[3]);
		return s;	
	}
}

class StudentManagerImpl{
	private List<Student> students=new ArrayList<Student>();
	public void addStudent(Student student) {
		students.add(student);
	}
	public void deleteStudent(String roll) {
		Student s=findStudent(roll);
		students.remove(s);
	}
	
	public Student findStudent(String roll) {
		for(Student s:students) {
			if(s.getRoll().equals(roll)) {
				return s;
			}
		}
		return null;
	}
	
	public void ModifyGrade(String roll, String grade) {
		Student s=findStudent(roll);
		s.setGrade(grade);
	}
	
	public void displayStudents() {
		for(Student s:students) {
			System.out.println(s.getLine());
		}
	}
	
	public List<Student> getStudents(){
		return students;
	}
}

class StudentsPersistorImpl{
	String file="F:\\NEU-Graduate Study\\Application Engineering and Development\\studentsinfo.txt";
	public void save(StudentManagerImpl manager) throws Exception {
		File f=new File(file);
		if(f.exists()==false) {
			f.createNewFile();
		}
		FileOutputStream fos=new FileOutputStream(f);
		PrintStream ps=new PrintStream(fos);
		for(Student s:manager.getStudents()) {
			ps.println(s.getLine());
		}
		ps.flush();
		ps.close();
	}
	
	public StudentManagerImpl load() throws Exception {
		File f =new File(file);
		if(f.exists()==false) {
			return new StudentManagerImpl();
		}
		FileInputStream fis=new FileInputStream(f);
		StudentManagerImpl manager=new StudentManagerImpl();
		DataInputStream dis=new DataInputStream(fis);
		while(true) {
			String line=dis.readLine();
			if(line==null) {
				break;
			}
			Student s=Student.fromLine(line);
			manager.addStudent(s);
		}
		dis.close();
		return manager;
	}
}

public class StudentInfoSystem extends JFrame{

	public static void main(String[] args) throws Exception {
		new StudentInfoSystem();
	}
	private StudentsPersistorImpl pr=new StudentsPersistorImpl();
	private List<Student> students;
	private Student s=new Student();
	private StudentManagerImpl manager=new StudentManagerImpl();
	private JTable studentTabel;
	private JButton add, delete, find, modify,save,clear;
	private JTextField roll_field,name_field,gender_field,grade_field;
	private JLabel roll_label,name_label,gender_label,grade_label,studentInfo;
	private StudentTableModel model;
	public StudentInfoSystem() throws Exception{
		pr=new StudentsPersistorImpl();
		manager=pr.load();//every time start the app,load the data
		students=manager.getStudents();
		
		setTitle("Student Infomation System");
		//Function Add 
		
		add=new JButton("add");
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {		
					try {
					s.setRoll(roll_field.getText());
					s.setName(name_field.getText());
					s.setGender(gender_field.getText());
					s.setGrade(grade_field.getText());
					manager.addStudent(s);
					
					}catch( Exception ne) {
						ne.printStackTrace();
					}
					model=new StudentTableModel(students);
					studentTabel.setModel(model);
			}
		});
		
		
		delete=new JButton("delete");
		delete.addActionListener(new ActionListener()  {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cur_roll=roll_field.getText();
				try {
					Student	s1=manager.findStudent(cur_roll);
					if(s1==null) {
						JOptionPane.showMessageDialog(StudentInfoSystem.this, "No Student with this roll number! Please try other function!");
					}
					manager.deleteStudent(cur_roll);
				}catch(Exception ne) {
					ne.printStackTrace();
				}
				model=new StudentTableModel(students);
				studentTabel.setModel(model);	
			}
		});
		find=new JButton("find");
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			 String cur_roll=roll_field.getText();
				try {
				Student	s1=manager.findStudent(cur_roll);
				if(s1==null) {
					JOptionPane.showMessageDialog(StudentInfoSystem.this, "No Student with this roll number! Please try other function!");
				}
			}catch(Exception ne) {
				ne.printStackTrace();
			}
				model=new StudentTableModel(students);
				studentTabel.setModel(model);
			}
		});
		modify=new JButton("modify");
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cur_roll=roll_field.getText();
				try {
					Student	s1=manager.findStudent(cur_roll);
					if(s1==null) {
						JOptionPane.showMessageDialog(StudentInfoSystem.this, "No Student with this roll number! Please try other function!");
					}
					String cur_grade=grade_field.getText();
					s1.setGrade(cur_grade);
				}catch(Exception ne) {
					ne.printStackTrace();
				}
				model=new StudentTableModel(students);
				studentTabel.setModel(model);
			}
		});
		
		save=new JButton("save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pr.save(manager);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		clear=new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					roll_field.setText("");
					name_field.setText("");
					gender_field.setText("");
					grade_field.setText("");
				}catch(Exception ec) {
					ec.printStackTrace();
				}
				model=new StudentTableModel(students);
				studentTabel.setModel(model);
			}
		});
		
		roll_field=new JTextField(5);
		name_field=new JTextField(5);
		gender_field=new JTextField(5);
		grade_field=new JTextField(5);
		
		roll_label=new JLabel("Roll:  ");
		name_label=new JLabel("Name:  ");
		gender_label=new JLabel("Gender:");
		grade_label=new JLabel("Grade: ");
		studentInfo=new JLabel("Student Information");
		
		
		model=new StudentTableModel(students);
		studentTabel=new JTable(model);
		
		Container c=getContentPane();
		
		JPanel pbutton=new JPanel();//put JButton
		pbutton.add(add);
		pbutton.add(delete);
		pbutton.add(modify);
		pbutton.add(find);
		pbutton.add(save);
		pbutton.add(clear);
		
		Box pInfo=Box.createVerticalBox();//put StudentInfo
		pInfo.add(studentInfo);
		
		Box info=Box.createVerticalBox();
		JPanel rollinfo=new JPanel(new FlowLayout());
		rollinfo.add(roll_label);
		rollinfo.add(roll_field);
		
		JPanel nameinfo=new JPanel(new FlowLayout());
		nameinfo.add(name_label);
		nameinfo.add(name_field);
		
		JPanel genderinfo=new JPanel(new FlowLayout());
		genderinfo.add(gender_label);
		genderinfo.add(gender_field);
		
		JPanel gradeinfo=new JPanel(new FlowLayout());
		gradeinfo.add(grade_label);
		gradeinfo.add(grade_field);
	
		info.add(rollinfo);
		info.add(nameinfo);
		info.add(genderinfo);
		info.add(gradeinfo);
		
		
		Box middle=Box.createHorizontalBox();
		middle.add(pInfo);
		middle.add(info);
		
		JScrollPane jsp=new JScrollPane(studentTabel);
		c.add(jsp,"North");
		c.add(middle,"Center");
		c.add(pbutton,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setVisible(true);
		pack();
	
	}
	class StudentTableModel implements TableModel{
		private List<Student> students;
		public StudentTableModel(List<Student> students){
			this.students=students;
		}
		
		@Override
		public int getRowCount() {
			return students.size();
		}

		@Override
		public int getColumnCount() {
			return 4;//roll_number, name, grade and gender
		}

		@Override
		public String getColumnName(int c) {
			if(c==0)
				return "Roll";
			if(c==1)
				return "Name";
			if(c==2)
				return "Gender";
			if(c==3)
				return "Grade";
			
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Student s=students.get(rowIndex);
			if(columnIndex==0)return s.getRoll();
			if(columnIndex==1)return s.getName();
			if(columnIndex==2)return s.getGender();
			if(columnIndex==3)return s.getGrade();
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
		
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {		
		}
		
	}

}
