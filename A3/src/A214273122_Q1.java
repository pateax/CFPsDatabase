//Author: Axita Patel

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class A214273122_Q1 implements ActionListener {
	
	//Event table
	JLabel EventName = new JLabel("Event Name:");
	JTextField EN = new JTextField(10);
	JLabel Link = new JLabel("Event Link:");
	JTextField L = new JTextField(10);
	JLabel CFPText = new JLabel("CFP Text:");
	JTextField CT = new JTextField(10);
	
	//Conference type
	JLabel City = new JLabel("City:");
	JTextField Cy = new JTextField(10);
	JLabel Country = new JLabel("Country:");
	JTextField Co = new JTextField(10);
	JLabel Date = new JLabel("Date (YYYY-MM-DD):");
	JTextField Dt = new JTextField(10);
	
	//Journal and book type
	JLabel JournalName = new JLabel("Journal Name:");
	JTextField JN = new JTextField(10);
	JLabel Publisher = new JLabel("Publisher:");
	JTextField PN = new JTextField(10);
	
	//Activities
	JLabel Activity = new JLabel("Activity Name");
	JTextField AN = new JTextField(10);
	JLabel ADate = new JLabel("Activity Date");
	JTextField AD = new JTextField(10);
	
	
	//Topics
	JLabel Topic = new JLabel("Topic");
	JTextField Tp = new JTextField(10);
	JLabel Area = new JLabel("Area");
	JTextField Ar = new JTextField(10);
	
	//People
	JLabel PName = new JLabel("Person Name");
	JTextField Nm = new JTextField(10);
	JLabel Role = new JLabel("Role");
	JTextField Rl = new JTextField(10);
	JLabel Affil = new JLabel("Affilliation");
	JTextField Aff = new JTextField(10);
	
	//random
	JLabel ch = new JLabel("Number of activities:");
	
	JButton insert = new JButton("Insert");

	
	JButton addEvent = new JButton("Add Event");
	
	JFrame frame = new JFrame();
	Panel panel = new Panel();

	EmptyBorder border = new EmptyBorder(3, 5, 3, 170);
	EmptyBorder border2 = new EmptyBorder(10, 200, 10, 200);
	EmptyBorder border3 = new EmptyBorder(50, 15, 15, 200);
	
	String[] TypeList = {"", "Conference", "Journal", "Book" };
	JComboBox<String> type = new JComboBox<String>(TypeList);
	
	int num = 0;
	
	public A214273122_Q1() {
		
		frame.setSize(500, 650);
		frame.setResizable(false);
		//frame.add(panel, BorderLayout.CENTER);
		frame.add(panel);
		//panel.setLayout(new FlowLayout());
		//panel.setLayout(new GridLayout (0, 1));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 100, 200, 200);
		frame.setTitle("214273122_Q1");
		JLabel ax = new JLabel("Insert a new CFP:");
		ax.setBorder(border);
		panel.add(ax);
		
		
		insert.setPreferredSize(new Dimension(200, 33));
		
		
		addEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		type.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JComboBox<String> a = (JComboBox<String>)e.getSource();
				String EType = (String)a.getSelectedItem();
				
				frame.setVisible(true);
				
				if (EType.equals("Conference")) {
					num = 1;
					
				City.setBorder(border);
				Cy.setBorder(border);
				Country.setBorder(border);
				Co.setBorder(border);
				Date.setBorder(border);
				Dt.setBorder(border);
					
				
				panel.add(City);
				panel.add(Cy);
				panel.add(Country);
				panel.add(Co);
				panel.add(Date);
				panel.add(Dt);
				
				panel.remove(JournalName);
				panel.remove(JN);
				panel.remove(Publisher);
				panel.remove(PN);
				panel.add(insert);
				
					
				frame.setVisible(true);	
					
				
				
				} else if(EType.equals("Journal")) {
					num = 2;
					
					panel.remove(City);
					panel.remove(Cy);
					panel.remove(Country);
					panel.remove(Co);
					panel.remove(Date);
					panel.remove(Dt);

					JournalName.setBorder(border);
					JN.setBorder(border);
					Publisher.setBorder(border);
					PN.setBorder(border);
					
					panel.add(JournalName);
					panel.add(JN);
					panel.add(Publisher);
					panel.add(PN);
					
					panel.add(insert);
					frame.setVisible(true);	
				
				
					
				} else {
					
					num = 3;
					panel.remove(City);
					panel.remove(Cy);
					panel.remove(Country);
					panel.remove(Co);
					panel.remove(JournalName);
					panel.remove(JN);
					panel.remove(Date);
					panel.remove(Dt);
					
					
					Publisher.setBorder(border);
					PN.setBorder(border);
					
					panel.add(Publisher);
					panel.add(PN);
					panel.add(insert);
					
					frame.setVisible(true);	
				}
			}
			
		});
		
		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JLabel done = new JLabel("Insert successful!");
				panel.add(done);
			}
			
		}); 
		
		EventName.setBorder(border);
		EN.setBorder(border);
		Link.setBorder(border);
		L.setBorder(border);
		CFPText.setBorder(border);
		CT.setBorder(border);
		
		panel.add(EventName);
		panel.add(EN);
		panel.add(Link);
		panel.add(L);
		panel.add(CFPText);
		panel.add(CT);
		type.setBorder(border2);
		
		JLabel choose = new JLabel("Select type of event:");
		choose.setBorder(border2);
		panel.add(choose);
		panel.add(type);
		
		ch.setBorder(border);
		Activity.setBorder(border);
		AN.setBorder(border);
		ADate.setBorder(border);
		AD.setBorder(border);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main (String[] args) {
		new A214273122_Q1();
		
	}
	

}
