//Author: Axita Patel

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class A214273122_Q2 implements ActionListener {

	public A214273122_Q2() {
		JFrame frame = new JFrame();
		frame.setSize(500, 700);
		Panel panel = new Panel();
		frame.add(panel);
		panel.setLayout(new FlowLayout());
		panel.setBounds(100, 100, 100, 100);
		frame.setTitle("Q2");
		
		String columns[] = {"Date", "Conferences", "Journals", "Books"};
		Object rows[][] = {};
		JTable table1 = new JTable(rows, columns);
		
		
		JScrollPane scrollPane = new JScrollPane(table1);
		
		JTableHeader header = table1.getTableHeader();
		header.setBackground(Color.PINK);
		header.setFont(new Font("Helvetica", Font.BOLD, 13));
		
		panel.add(scrollPane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		new A214273122_Q2();
		
	}

}
