//Author: Axita Patel

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;  

public class A214273122_Q3 implements ActionListener {
	
	
	public A214273122_Q3() {
		
		JFrame frame = new JFrame();
		frame.setSize(500, 650);
		Panel panel = new Panel();
		frame.add(panel);
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		JButton insert = new JButton("Insert new CFP");
		panel.add(insert);
	
		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				A214273122_Q1 obj = new A214273122_Q1();
				
				obj.insert.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							
							Connection con = MySQLConnection();
							Statement st = con.createStatement();  

							//insert into Event table
							String eName = obj.EN.getText();
							String link = obj.L.getText();
							String cfpText = obj.CT.getText();
							String event = String.format("INSERT INTO 3421a03.Event VALUES ('%s', '%s', '%s')", eName, link, cfpText);
							
							st.executeUpdate(event);
							
							//Insert based on type of event selected 
							if(obj.num == 1) {
								String city = obj.Cy.getText();
								String country = obj.Co.getText();
								String date = obj.Dt.getText();
								String conference = String.format("INSERT INTO 3421a03.EventConference VALUES ('%s', '%s', '%s', '%s')", 
										eName, city, country, date);
								st.executeUpdate(conference);
							}
							
							else if(obj.num == 2) {
								String journalName = obj.JN.getText();
								String publisher = obj.PN.getText();
								String journal = String.format("INSERT INTO 3421a03.EventJournal VALUES ('%s', '%s', '%s')", 
										eName, journalName, publisher);
								st.executeUpdate(journal);
							
							} else {
								String publisher = obj.PN.getText();
								String book = String.format("INSERT INTO 3421a03.EventBook VALUES ('%s', '%s')", eName, publisher);
								st.executeUpdate(book);
								
							} 
							
							st.close();
							con.close();
							
							
						} catch (Exception a) {
							
							
						} finally {
							
						}
						
					}
					
					
				});
				
				
			}
			
		});
		
		JButton part2 = new JButton("Q2 queries");
		panel.add(part2);
		part2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new A214273122_Q2();
				
			}
			
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	public Connection MySQLConnection() {
		Connection con = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			
			String url="jdbc:mysql://localhost:3306/3421a03?characterEncoding=utf8";
			//String url = "jdbc:mysql://localhost:3306/CFP";
	
		
			con = DriverManager.getConnection(url, "root", "password");   
			
			return con;
		 
			} catch(Exception e){ 
				System.out.println(e);
				return null;
				}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new A214273122_Q3();
		
	}

}
