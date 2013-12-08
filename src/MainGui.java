import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.sql.*;

public class MainGui{
	String db_user = "root";
	String db_pswd = "password";
	
	JFrame frame;
	JTabbedPane tabbedPane;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JTable table1;
	JTable table2;
	JTable table3;
	JTable table4;
	JTable table5;
	JTextField text1_1;
	JTextField text1_2;
	JTextField text1_3;
	JTextField text2_1;
	JTextField text2_2;
	JTextField text2_3;
	JTextField text3_1;
	JTextField text3_2;
	JTextField text3_3;
	JTextField text4_1;
	JTextField text4_2;
	JTextField text4_3;
	JTextField text4_4;
	JTextField text5;
	TableModel tabModel_1;
	TableModel tabModel_2;
	TableModel tabModel_3;
	TableModel tabModel_4;
	TableModel tabModel_5;
	JScrollPane scrollPane1;
	JScrollPane scrollPane2;
	JScrollPane scrollPane3;
	JScrollPane scrollPane4;
	JScrollPane scrollPane5;
	
	public static void main(String[] args){
		MainGui gui = new MainGui();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		tabbedPane = new JTabbedPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		
		String[] headers_1 = {"book_id", "title", "author name", "branch_id",
				"total number", "available number"};
		String[] headers_2 = {"card_no", "book_id", "branch_id", "Date Out", "Due Date"};
		String[] headers_3 = {"book_id", "branch_id", "card_no",
				"fname", "lname", "Date Out", "Due Date"};
		String[] headers_4 = {"card_no", "First Name", "Last Name",
				"Address", "Phone"};
		String[] headers_5 = {"card_no", "Book borrowed", "First Name", "Last Name",
				"Address", "Phone"};
		
		table1 = new JTable(new Object[1100][6], headers_1);
		table1.setAutoCreateRowSorter(true);
		tabModel_1 = table1.getModel();
		//table1.setLocation(0, 100);
		table2 = new JTable(new Object[5][5], headers_2);
		table2.setAutoCreateRowSorter(true);
		tabModel_2 = table2.getModel();
		table3 = new JTable(new Object[100][7], headers_3);
		table3.setAutoCreateRowSorter(true);
		tabModel_3 = table3.getModel();
		table4 = new JTable(new Object[100][5], headers_4);
		table4.setAutoCreateRowSorter(true);
		tabModel_4 = table4.getModel();
		table5 = new JTable(new Object[100][6], headers_5);
		table5.setAutoCreateRowSorter(true);
		tabModel_5 = table5.getModel();
		
		
		//=====================
		// Components of Tab 1
		//=====================
		JLabel label1_1 = new JLabel("Book_id:");
		JLabel label1_2 = new JLabel("Title:");
		JLabel label1_3 = new JLabel("Author_name:");
		
		text1_1 = new JTextField(8);
		text1_2 = new JTextField(10);
		text1_3 = new JTextField(15);
		
		JButton button1 = new JButton("Search");
		button1.addActionListener(new Button_1_Listener());
		
		scrollPane1 = new JScrollPane(table1);
		scrollPane1.setPreferredSize(new Dimension(700, 400));
		table1.setFillsViewportHeight(true);
		
		panel1.add(label1_1);
		panel1.add(text1_1);
		panel1.add(label1_2);
		panel1.add(text1_2);
		panel1.add(label1_3);
		panel1.add(text1_3);
		panel1.add(button1);
		//panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(scrollPane1);
		// End Tab 1 components
		
		//=====================
		// Components of Tab 2
		//=====================
		JLabel label2_1 = new JLabel("Book_id:");
		JLabel label2_2 = new JLabel("Branch_id:");
		JLabel label2_3 = new JLabel("Card_no:");
		
		text2_1 = new JTextField(8);
		text2_2 = new JTextField(2);
		text2_3 = new JTextField(10);
		
		JButton button2 = new JButton("Check Out");
		button2.addActionListener(new Button_2_Listener());
		
		scrollPane2 = new JScrollPane(table2);
		scrollPane2.setVisible(false);
		table2.setFillsViewportHeight(true);
		
		panel2.add(label2_1);
		panel2.add(text2_1);
		panel2.add(label2_2);
		panel2.add(text2_2);
		panel2.add(label2_3);
		panel2.add(text2_3);
		panel2.add(button2);
		panel2.add(scrollPane2);
		// End Tab 2 components
		
		//=====================
		// Components of Tab 3
		//=====================
		JLabel label3_1 = new JLabel("Book_id:");
		JLabel label3_2 = new JLabel("Card_no:");
		JLabel label3_3 = new JLabel("Borrower:");
		
		text3_1 = new JTextField(8);
		text3_2 = new JTextField(10);
		text3_3 = new JTextField(15);
		
		JButton button3_1 = new JButton("Search");
		button3_1.addActionListener(new Button_3_1_Listener());
		JButton button3_2 = new JButton("Check In");
		button3_2.addActionListener(new Button_3_2_Listener());
		
		scrollPane3 = new JScrollPane(table3);
		scrollPane3.setPreferredSize(new Dimension(700, 400));
		table3.setFillsViewportHeight(true);
		
		panel3.add(label3_1);
		panel3.add(text3_1);
		panel3.add(label3_2);
		panel3.add(text3_2);
		panel3.add(label3_3);
		panel3.add(text3_3);
		panel3.add(button3_1);
		panel3.add(scrollPane3);
		panel3.add(button3_2);
		// End Tab 3 components
		
		//=====================
		// Components of Tab 4
		//=====================
		JLabel label4_1 = new JLabel("First Name:");
		JLabel label4_2 = new JLabel("Last Name:");
		JLabel label4_3 = new JLabel("Address:");
		JLabel label4_4 = new JLabel("Phone: ");
		
		text4_1 = new JTextField(8);
		text4_2 = new JTextField(8);
		text4_3 = new JTextField(15);
		text4_4 = new JTextField(8);
		
		JButton button4_1 = new JButton("Add");
		button4_1.addActionListener(new Button_4_1_Listener());
		JButton button4_2 = new JButton("Search All");
		button4_2.addActionListener(new Button_4_2_Listener());
		JButton button4_3 = new JButton("Delete");
		button4_3.addActionListener(new Button_4_3_Listener());
		
		scrollPane4 = new JScrollPane(table4);
		scrollPane4.setPreferredSize(new Dimension(600, 450));
		table4.setFillsViewportHeight(true);
		
		panel4.add(label4_1);
		panel4.add(text4_1);
		panel4.add(label4_2);
		panel4.add(text4_2);
		panel4.add(label4_3);
		panel4.add(text4_3);
		panel4.add(label4_4);
		panel4.add(text4_4);
		panel4.add(button4_1);
		panel4.add(button4_2);
		panel4.add(scrollPane4);
		panel4.add(button4_3);
		// End Tab 4 components
		
		//=====================
		// Components of Tab 5
		//=====================
		JLabel label5_1 = new JLabel("List borrowers who has booked at least");
		JLabel label5_2 = new JLabel("book(s)");
		
		text5 = new JTextField(1);
		
		JButton button5 = new JButton("Find");
		button5.addActionListener(new Button_5_Listener());
		
		scrollPane5 = new JScrollPane(table5);
		scrollPane5.setPreferredSize(new Dimension(650, 450));
		table5.setFillsViewportHeight(true);
		
		panel5.add(label5_1);
		panel5.add(text5);
		panel5.add(label5_2);
		panel5.add(button5);
		panel5.add(scrollPane5);
		// End Tab 5 components
		
		tabbedPane.addTab("Check Availability", panel1);
		tabbedPane.addTab("Check Out", panel2);
		tabbedPane.addTab("Check In", panel3);
		tabbedPane.addTab("Borrower Mgmt", panel4);
		tabbedPane.addTab("Borrower Count", panel5);
		
		// Set frame appearance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tabbedPane);
		frame.setSize(980,600);
		frame.setVisible(true);
	}
	
	class Button_1_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String t1 = text1_1.getText(); // book_id
			String t2 = text1_2.getText(); // title
			String t3 = text1_3.getText(); // author_name
			
			// Empty stale data in table
			for (int row = 0; row < tabModel_1.getRowCount(); row++) {
				for( int i = 0; i < 6; i++) {
					tabModel_1.setValueAt(null, row, i);
				}
			}
			
			String select_sql = "SELECT distinct a.book_id, b.title, c.author_name, a.branch_id, a.no_of_copies," +
								" (select count(*) from book_loans d where d.branch_id = a.branch_id " +
								"and d.book_id = a.book_id)" + " as no_loaned ";
			//String from_sql = " FROM book_copies natural join book natural join book_authors as a";
			String from_sql = " FROM book_copies a, book b, book_authors c ";
			String where_sql = " WHERE a.book_id = b.book_id and a.book_id = c.book_id and ";
			
			if ( t1.length() != 0 && t2.length() != 0 && t3.length() != 0 ) {
				where_sql += "a.book_id = '" + t1 + "'" +
							" and b.title like '%" + t2 + "%'" +
							" and c.author_name like '%" + t3 + "%'";
			} else if ( t1.length() != 0 && t2.length() != 0 ) {
				where_sql += "a.book_id = '" + t1 + "' and b.title like '%" + t2 + "%'";
			} else if ( t1.length() != 0 && t3.length() != 0 ) {
				where_sql += "a.book_id = '" + t1 + "' and c.author_name like '%" + t3 + "%'";
			} else if ( t2.length() != 0 && t3.length() != 0 ) {
				where_sql += "b.title like '%" + t2 + "%' and c.author_name like '%" + t3 + "%'";
			} else if ( t1.length() != 0 ) {
				where_sql += "a.book_id = '" + t1 + "'";
			} else if ( t2.length() != 0 ) {
				where_sql += "b.title like '%" + t2 + "%'";
			} else if ( t3.length() != 0 ) {
				where_sql += "c.author_name like '%" + t3 + "%'";
			} else {
				// If all text fields are empty, SQL is empty
				select_sql = from_sql = where_sql = "";
			}
			String sql = select_sql + from_sql + where_sql;
			//System.out.println(sql);
			
			
			Connection conn = null;
			String book_id, title, author_name, branch_id;
			int no_total, no_loaned, no_avail;
			int linect = 0;
			try {
				// Create a connection to the local MySQL server
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
		
				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				ResultSet rs = stmt.executeQuery(sql);

				// If result set empty
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(panel1, "No result found!");
					rs.close();
					conn.close();
					return;
				}
				// Iterate through the result set.
				do {
					book_id = rs.getString("book_id");
					title = rs.getString("title");
					author_name = rs.getString("author_name");
					branch_id = rs.getString("branch_id");
					no_total = rs.getInt("no_of_copies");
					no_loaned = rs.getInt("no_loaned");
					no_avail = no_total - no_loaned;

					tabModel_1.setValueAt(book_id, linect, 0);
					tabModel_1.setValueAt(title, linect, 1);
					tabModel_1.setValueAt(author_name, linect, 2);
					tabModel_1.setValueAt(branch_id, linect, 3);
					tabModel_1.setValueAt(no_total, linect, 4);
					tabModel_1.setValueAt(no_avail, linect, 5);
					linect++;
				} while (rs.next());
				// End while

				rs.close();
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel1, ex.getMessage(), 
					"Error in connection", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	class Button_2_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String t1 = text2_1.getText(); // book_id
			String t2 = text2_2.getText(); // branch_id
			String t3 = text2_3.getText(); // card_no
			scrollPane2.setVisible(false); // Restore scrollpane to be invisible
			
			// Empty stale data in table
			for (int row = 0; row < tabModel_2.getRowCount(); row++) {
				for( int i = 0; i < 5; i++) {
					tabModel_2.setValueAt(null, row, i);
				}
			}
			
			// All names and address fields can't be empty
			if ( t1.length() == 0 || t2.length() == 0 || t3.length() == 0 ) {
				JOptionPane.showMessageDialog(panel2, "Either one of " +
					"'book_id', 'branch_id', 'card_no' can't be empty!");
				return;
			}
			
			Connection conn = null;
			Statement stmt = null;
			String sql;
			int linect = 0;
			
			// Prepare connection handler
			try {
				// Create a connection to the local MySQL server
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
				stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel2, ex.getMessage(), 
						"Error in connection", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Do pre-transaction checking
			try {
				// Check that user inputs are valid
				sql = "SELECT no_of_copies FROM book_copies WHERE book_id = '" +
						t1 +"' AND branch_id = '" + t2 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(panel2, "There is no book " + t1 +" in branch " + t2 + "!");
					rs.close();
					conn.close();
					return;
				} else if (rs.getInt(1) == 0) {
					JOptionPane.showMessageDialog(panel2, "Book " + t1 +" in branch " + t2 + " has 0 copy!");
					rs.close();
					conn.close();
					return;
				}
				
				// Check that card_no are valid
				sql = "SELECT * from borrower where card_no = '" + t3 + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(panel2, "Card_no " + t3 + " doesn't exist!");
					rs.close();
					conn.close();
					return;
				}
				
				// Check that a user can't have more than 3 book loaned
				sql = "SELECT card_no, book_id, branch_id, date_out, due_date" +
						" FROM book_loans WHERE card_no = '" + t3 + "'";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String cno = rs.getString(1); // card_no
					String bkid = rs.getString(2); // book_id
					String brchid = rs.getString(3); // branch id
					String dout = rs.getString(4); // Date out
					String ddate = rs.getString(5); // Due date
					
					tabModel_2.setValueAt(cno, linect, 0);
					tabModel_2.setValueAt(bkid, linect, 1);
					tabModel_2.setValueAt(brchid, linect, 2);
					tabModel_2.setValueAt(dout, linect, 3);
					tabModel_2.setValueAt(ddate, linect, 4);
					linect++;
				}
				if (linect >= 3) {
					scrollPane2.setVisible(true);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					JOptionPane.showMessageDialog(panel2, "User has reached maximum allowed 3 book loans!");
					rs.close();
					conn.close();
					return;
				}
				
				// Check that book at that branch is still available
				sql = "SELECT (select no_of_copies from book_copies where book_id = '" + t1 +
						"' and branch_id = '" + t2 + "') - (select count(*) from book_loans " +
						"where book_id = '" + t1 + "' and branch_id = '" + t2 + "')";
				rs = stmt.executeQuery(sql);
				rs.next();
				if (rs.getInt(1) <= 0) {
					JOptionPane.showMessageDialog(panel2, "There is no more book copies of " + 
							t1 +" available in branch " + t2 + "!");
					rs.close();
					conn.close();
					return;
				}
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel2, ex.getMessage(), 
						"Error in execution", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Check the book out
			sql = "INSERT INTO book_loans VALUES ('" + t1 + "', '" + t2 + 
					"', '" + t3 + "', CURDATE(), DATE_ADD(CURDATE(),INTERVAL 14 DAY))";
			try {
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(panel2, "Check Out Complete!");
				
				// Display user check out information
				sql = "SELECT card_no, book_id, branch_id, date_out, due_date" +
						" FROM book_loans WHERE card_no = '" + t3 + "'";
				ResultSet rs = stmt.executeQuery(sql);
				scrollPane2.setVisible(true);
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
				linect = 0;
				while (rs.next()) {
					String cno = rs.getString(1); // card_no
					String bkid = rs.getString(2); // book_id
					String brchid = rs.getString(3); // branch id
					String dout = rs.getString(4); // Date out
					String ddate = rs.getString(5); // Due date
					
					tabModel_2.setValueAt(cno, linect, 0);
					tabModel_2.setValueAt(bkid, linect, 1);
					tabModel_2.setValueAt(brchid, linect, 2);
					tabModel_2.setValueAt(dout, linect, 3);
					tabModel_2.setValueAt(ddate, linect, 4);
					linect++;
				}
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel2, ex.getMessage(), 
						"Error in execution", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Button_3_1_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String t1 = text3_1.getText(); // book_id
			String t2 = text3_2.getText(); // card_no
			String t3 = text3_3.getText(); // borrower
			
			// Empty stale data in table
			for (int row = 0; row < tabModel_3.getRowCount(); row++) {
				for( int i = 0; i < 7; i++) {
					tabModel_3.setValueAt(null, row, i);
				}
			}
			
			
			String select_sql = "SELECT book_id, branch_id, card_no," +
					" fname, lname, date_out, due_date ";
			String from_sql = " FROM book_loans NATURAL JOIN borrower ";
			String where_sql = " WHERE ";

			if ( t1.length() == 0 && t2.length() == 0 && t3.length() == 0 ) {
				// If fields are all empty, display all book check-out status
				where_sql = "";
			} else if ( t1.length() != 0 && t2.length() != 0 ) {
				where_sql += "book_id = '" + t1 + "' and card_no = '" + t2 + "'";
			} else if ( t1.length() != 0 && t3.length() != 0 ) {
				where_sql += "book_id = '" + t1 + "' and fname like '%" + t3 + "%' or lname like '%" + t3 + "%'";
			} else if ( t2.length() != 0 && t3.length() != 0 ) {
				where_sql += "card_no = '" + t2 + "' and fname like '%" + t3 + "%' or lname like '%" + t3 + "%'";
			} else if ( t1.length() != 0 ) {
				where_sql += "book_id = '" + t1 + "'";
			} else if ( t2.length() != 0 ) {
				where_sql += "card_no = '" + t2 + "'";
			} else if ( t3.length() != 0 ) {
				where_sql += "fname like '%" + t3 + "%' or lname like '%" + t3 + "%'";
			} else {
				// Not expect to reach here
			}
			String sql = select_sql + from_sql + where_sql;
			//System.out.println(sql);


			Connection conn = null;
			String book_id, branch_id, card_no, fname, lname, date_out, due_date;
			
			int linect = 0;
			try {
				// Create a connection to the local MySQL server
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
		
				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				ResultSet rs = stmt.executeQuery(sql);

				// If result set empty
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(panel3, "No result found!");
					rs.close();
					conn.close();
					return;
				}
				// Iterate through the result set.
				do {
					book_id = rs.getString("book_id");
					branch_id = rs.getString("branch_id");
					card_no = rs.getString("card_no");
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					date_out = rs.getString("date_out");
					due_date = rs.getString("due_date");

					tabModel_3.setValueAt(book_id, linect, 0);
					tabModel_3.setValueAt(branch_id, linect, 1);
					tabModel_3.setValueAt(card_no, linect, 2);
					tabModel_3.setValueAt(fname, linect, 3);
					tabModel_3.setValueAt(lname, linect, 4);
					tabModel_3.setValueAt(date_out, linect, 5);
					tabModel_3.setValueAt(due_date, linect, 6);
					linect++;
				} while (rs.next());
				// End while

				rs.close();
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel3, ex.getMessage(), 
					"Error in connection", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Button_3_2_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String book_id, branch_id, card_no, sql;
			int[] highlighted = table3.getSelectedRows();
			
			try {
				// Create a connection to the local MySQL server
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
		
				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				
				for(int row: highlighted ) {
					book_id = (String) tabModel_3.getValueAt(row, 0);
					branch_id = (String) tabModel_3.getValueAt(row, 1);
					card_no = (String) tabModel_3.getValueAt(row, 2);
					//System.out.println(book_id +":"+ branch_id +":"+ card_no);
					sql = "DELETE FROM book_loans WHERE book_id = '" + 
							book_id + "' AND branch_id = '" + branch_id +
							"' AND card_no = '" + card_no + "'";
					stmt.executeUpdate(sql);
				}
				JOptionPane.showMessageDialog(panel3, "Check In complete!");
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel3, ex.getMessage(), 
					"Error in connection", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Button_4_1_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String t1 = text4_1.getText(); // fname
			String t2 = text4_2.getText(); // lname
			String t3 = text4_3.getText(); // address
			String t4 = text4_4.getText(); // phone
			
			// Empty stale data in table
			for (int row = 0; row < tabModel_4.getRowCount(); row++) {
				for( int i = 0; i < 5; i++) {
					tabModel_4.setValueAt(null, row, i);
				}
			}
						
			// All names and address fields can't be empty
			if ( t1.length() == 0 || t2.length() == 0 || t3.length() == 0 ) {
				JOptionPane.showMessageDialog(panel4, "Either one of " +
					"'First Name', 'Last Name', 'Address' can't be empty!");
				return;
			}
			
			Connection conn = null;
			Statement stmt = null;
			String sql;
			int card_no; // card_no to be created
			String fname, lname, addr, phone;
			int linect = 0;
			
			// Prepare connection handler
			try {
				// Create a connection to the local MySQL server
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
				stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel4, ex.getMessage(), 
						"Error in connection", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Check that same user can't be inserted twice
			sql = "SELECT card_no FROM borrower WHERE fname = '" + t1 + "' AND lname = '" +
					t2 + "' AND address = '" + t3 + "'";
			//System.out.println(sql);
			try {
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next() == true) {
					JOptionPane.showMessageDialog(panel4, "Borrower already exists!");
					// Displayg user
					card_no = rs.getInt("card_no");
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					addr = rs.getString("address");
					phone = rs.getString("phone");

					tabModel_4.setValueAt(card_no, linect, 0);
					tabModel_4.setValueAt(fname, linect, 1);
					tabModel_4.setValueAt(lname, linect, 2);
					tabModel_4.setValueAt(addr, linect, 3);
					tabModel_4.setValueAt(phone, linect, 4);
					
					rs.close();
					conn.close();
					return;
				}
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel4, ex.getMessage(), 
						"Error in execution", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// Get maximum card_no in database
			// New card_no should plus 1
			try {
				ResultSet rs = stmt.executeQuery("SELECT MAX(card_no) FROM borrower;");
				rs.next();
				int max_cardno = rs.getInt(1); // If empty table, rs.getInt() should return 0
				
				sql = "INSERT INTO borrower VALUES ('" + (max_cardno + 1) + "', '" +  t1 +
						"', '" + t2 + "', '" + t3 + "', '" + t4 + "')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(panel4, "Add Borrower complete!");
				
				sql = "SELECT card_no, fname, lname, address, phone FROM borrower";
				rs = stmt.executeQuery(sql);
				// Iterate through the result set.
				while (rs.next()) {
					card_no = rs.getInt("card_no");
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					addr = rs.getString("address");
					phone = rs.getString("phone");

					tabModel_4.setValueAt(card_no, linect, 0);
					tabModel_4.setValueAt(fname, linect, 1);
					tabModel_4.setValueAt(lname, linect, 2);
					tabModel_4.setValueAt(addr, linect, 3);
					tabModel_4.setValueAt(phone, linect, 4);
					linect++;
				}
				
				rs.close();
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel4, ex.getMessage(), 
						"Error in execution", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Button_4_2_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// Empty stale data in table
			for (int row = 0; row < tabModel_4.getRowCount(); row++) {
				for( int i = 0; i < 5; i++) {
					tabModel_4.setValueAt(null, row, i);
				}
			}
			
			int card_no; // card_no
			String fname, lname, addr, phone;
			int linect = 0;
			
			// Prepare connection handler
			try {
				// Create a connection to the local MySQL server
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
				Statement stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				String sql = "SELECT card_no, fname, lname, address, phone FROM borrower";
				ResultSet rs = stmt.executeQuery(sql);
				// Iterate through the result set.
				while (rs.next()) {
					card_no = rs.getInt("card_no");
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					addr = rs.getString("address");
					phone = rs.getString("phone");

					tabModel_4.setValueAt(card_no, linect, 0);
					tabModel_4.setValueAt(fname, linect, 1);
					tabModel_4.setValueAt(lname, linect, 2);
					tabModel_4.setValueAt(addr, linect, 3);
					tabModel_4.setValueAt(phone, linect, 4);
					linect++;
				}
				
				rs.close();
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel4, ex.getMessage(), 
						"Error in connection", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
	
	class Button_4_3_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int card_no; // card_no
			String sql;
			int[] highlighted = table4.getSelectedRows();
			
			try {
				// Create a connection to the local MySQL server
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
		
				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				
				for(int row: highlighted ) {
					if ( tabModel_4.getValueAt(row, 0) != null) {
						card_no = (int) tabModel_4.getValueAt(row, 0);
						sql = "DELETE FROM borrower WHERE card_no = '" + card_no + "'";
						stmt.executeUpdate(sql);
					}
				}
				JOptionPane.showMessageDialog(panel4, "Borrower deleted!");
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel4, ex.getMessage(), 
					"Error in connection", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Button_5_Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String t = text5.getText(); // book borrowed
			
			// book quantity can't be empty
			if ( t.length() == 0 ) {
				JOptionPane.showMessageDialog(panel5, "Book quantity can't " +
					"be empty!");
				return;
			}
			int t1 = Integer.parseInt(t); // book borrowed
			
			// Empty stale data in table
			for (int row = 0; row < tabModel_5.getRowCount(); row++) {
				for( int i = 0; i < 6; i++) {
					tabModel_5.setValueAt(null, row, i);
				}
			}
						

			if ( t1 <= 0 ) {
				JOptionPane.showMessageDialog(panel5, "Book quantity should " +
					"be greater than 0!");
				return;
			}
			
			Connection conn = null;
			Statement stmt = null;
			String sql = "SELECT card_no, count(*) as book_borrowered, fname, lname, address, phone" +
					" FROM borrower NATURAL JOIN book_loans" +
					" GROUP BY card_no" +
					" HAVING book_borrowered >= " + t1;
			int card_no, book_borrow;
			String fname, lname, addr, phone;
			int linect = 0;
			
			// Prepare connection handler
			try {
				// Create a connection to the local MySQL server
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", db_user, db_pswd);
				stmt = conn.createStatement();
				stmt.executeQuery("use Library;");
				ResultSet rs = stmt.executeQuery(sql);

				// If result set empty
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(panel5, "No result found!");
					rs.close();
					conn.close();
					return;
				}
				
				// Iterate through the result set.
				do {
					card_no = rs.getInt("card_no");
					book_borrow = rs.getInt("book_borrowered");
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					addr = rs.getString("address");
					phone = rs.getString("phone");

					tabModel_5.setValueAt(card_no, linect, 0);
					tabModel_5.setValueAt(book_borrow, linect, 1);
					tabModel_5.setValueAt(fname, linect, 2);
					tabModel_5.setValueAt(lname, linect, 3);
					tabModel_5.setValueAt(addr, linect, 4);
					tabModel_5.setValueAt(phone, linect, 5);
					linect++;
				} while (rs.next());
				// End while

				rs.close();
				conn.close();
			}
			catch(SQLException ex) {
				JOptionPane.showMessageDialog(panel5, ex.getMessage(), 
						"Error in connection", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}