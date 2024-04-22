import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import java.sql.*;

class bank11 implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, adminLoginButton, submitButton, cancelButton;
    JTextField t1, adminAccountField, adminAmountField;
    JPasswordField t2;
    JLabel l1, l2, l3, l4, t3, adminLabel, adminAccountLabel, adminAmountLabel;
    Font myfont = new Font("Calibri", Font.BOLD, 30);
	Font myfont2 = new Font("Calibri", Font.BOLD, 50);

    bank11() {
        f = new JFrame();

       ImageIcon i=new ImageIcon("background.jpg");
	Image i1=i.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
	ImageIcon i2=new ImageIcon(i1);
	JLabel l1=new JLabel(i2);
	l1.setBounds(10,10,1500,1000);
	f.add(l1);

	b1=new JButton("LOGIN");
		b1.setBounds(900,600,150,50);
		b1.setForeground(new Color(255,102,102));
		b1.setFont(myfont);
		b1.addActionListener(this);
		l1.add(b1);

		b2=new JButton("CANCEL");
		b2.setBounds(1300,600,150,50);
		b2.setFont(myfont);
		b2.setForeground(new Color(255,102,102));
		b2.addActionListener(this);
		l1.add(b2);

		b3=new JButton("REGISTER");
		b3.setBounds(1080,600,200,50);
		b3.setForeground(new Color(255,102,102));
		b3.setFont(myfont);
		b3.addActionListener(this);
		l1.add(b3);

		b4=new JButton("FORGOT PASSWORD");
		b4.setBounds(1140,700,300,50);
		b4.setFont(myfont);
		b4.setForeground(new Color(255,102,102));
		b4.addActionListener(this);
		l1.add(b4);

		l4=new JLabel("USERNAME");
		l4.setBounds(980,300,150,50);
		l4.setForeground(new Color(255,102,102));
		l4.setFont(myfont);
		l1.add(l4);

		t2 = new JPasswordField();
		t2.setEchoChar('*');
        t2.setForeground(new Color(192,192,192));
		t2.setBounds(980, 450, 400, 50);
        t2.setFont(myfont);
        t2.setBackground(Color.red);
		l1.add(t2);
        //f5.add(t51);

		l2=new JLabel("PASSWORD");
		l2.setBounds(980,400,150,50);
		l2.setForeground(new Color(255,102,102));
		l2.setFont(myfont);
		l1.add(l2);

		t1=new JTextField();
		t1.setBounds(980,350,400,50);
		t1.setForeground(new Color(192,192,192));
		t1.setFont(myfont);
		t1.setBackground(Color.red);
		l1.add(t1);

		t3=new JLabel("ONLINE   BANKING   SYSTEM");
		t3.setForeground(new Color(244,164,96));
		t3.setBounds(500,80,800,50);
		t3.setFont(myfont2);
		l1.add(t3);

		l3 = new JLabel("LOGIN FORM");
        l3.setBounds(1050, 220, 400, 50);
        l3.setForeground(new Color(125,28,25));
		l3.setFont(myfont);
        l3.setBackground(Color.red);
		l1.add(l3);

        adminLoginButton = new JButton("Employee Login");
        adminLoginButton.setBounds(880, 700, 240, 50);
        adminLoginButton.setForeground(new Color(255, 102, 102));
        adminLoginButton.setFont(myfont);
        adminLoginButton.addActionListener(this);
        l1.add(adminLoginButton);

        f.setLayout(null);
        f.setSize(1500, 2000);
        f.setLocation(0, 0);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("LOGIN")) {
            String username=t1.getText();
			String passw=t2.getText();
			
			// JDBC Connection parameters
        String url = "path of the driver with dbname,port number"; // Change accordingly
        String user = "db username";
        String pass = "db password";

        try {
          // Load the Oracle JDBC driver (this is not needed with recent JDBC versions)
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		  

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Query to check username and password
            String query = "SELECT * FROM register WHERE username=? AND password=?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, passw);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
              
			   // infoLabel.setText("Login Successful");
			   JOptionPane.showMessageDialog(null,"succeessfull");
			    f.dispose();
			   new home1();
            } else {
                JOptionPane.showMessageDialog(null,"not succeessfull");
				//infoLabel.setText("Invalid username or password");
            }

            // Close resources
            rs.close();
            pstmt.close();
            connection.close();

        } 
		catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        } else if (button.equals("CANCEL")) {
            System.exit(0);
        } else if (button.equals("REGISTER")) {
            f.dispose();
			new registrations1();
        } 
		else if (button.equals("FORGOT PASSWORD")) {
            f.dispose();
			new changepassword();
        } 
		else if (button.equals("Employee Login")) {
            f.dispose();
			new adminLogin();
        } 
    }
    public static void main(String args[]) {
        new bank11();
    }
}
class home1 implements ActionListener {
    JFrame f1;
    JButton b1, b2, b3, b5, b6;
    JLabel l1, l2;
    Font myfont2 = new Font("Calibri", Font.BOLD, 30);

    home1() {
        f1 = new JFrame();

        // Corrected code for image loading
        ImageIcon i = new ImageIcon("project.jpeg");
        Image i1 = i.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel background = new JLabel(i2);
        background.setBounds(0, 0, 700, 700);
        f1.add(background);

        l2 = new JLabel("WELCOME TO KYC BANK");
        l2.setBounds(100, 50, 500, 40);
        l2.setFont(myfont2);
        l2.setForeground(Color.red);
        l2.setBackground(Color.blue);
        background.add(l2);

        b1 = new JButton("get balance");
        b1.setBounds(50, 250, 300, 50);
        b1.setFont(myfont2);
        b1.addActionListener(this);
        background.add(b1);

        b2 = new JButton("Fixed deposit");
        b2.setBounds(50, 350, 300, 50);
        b2.setFont(myfont2);
        b2.addActionListener(this);
        background.add(b2);

        b3 = new JButton("transfer");
        b3.setBounds(50, 450, 300, 50);
        b3.setFont(myfont2);
        b3.addActionListener(this);
        background.add(b3);

		b5=new JButton("signout");
		b5.setBounds(50,550,300,50);
		b5.setFont(myfont2);
		b5.addActionListener(this);
		background.add(b5);

		b6=new JButton("add bank account");
		b6.setBounds(50,150,300,50);
		b6.setFont(myfont2);
		b6.addActionListener(this);
		background.add(b6);



        f1.setLayout(null);
        f1.setSize(700, 700);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }

    public static void main(String args[]) {
        home1 h = new home1();
    }

    public void actionPerformed(ActionEvent ae) {
        String button = ae.getActionCommand();
        if (button.equals("get balance")) {
            f1.dispose();
             new BalanceRetrievalApp();
        }
        if (button.equals("Fixed deposit")) {
            f1.dispose();
             new Deposit();
        }
        if (button.equals("transfer")) {
            f1.dispose();
             new transaction();
        }
		if(button.equals("signout"))
		{
			f1.dispose();
			new bank11();
		}
		if(button.equals("add bank account"))
		{
			f1.dispose();
			new BankAcc();
		}
    }
}

 class adminLogin implements ActionListener 
{
    JFrame f;
    JButton LoginButton, cancelButton;
    JTextField usernametf;
    JPasswordField passwordtf;
    JLabel user, pass,button,button1; // Remove this local declaration of l1
    Font myfont = new Font("Calibri", Font.BOLD, 30);

    adminLogin() {
        f = new JFrame();

        ImageIcon i=new ImageIcon("project.jpeg");
	Image i1=i.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
	ImageIcon i2=new ImageIcon(i1);
	JLabel l1=new JLabel(i2);
	l1.setBounds(10,10,1500,1000);
	f.add(l1);

        user = new JLabel("Username");
        user.setBounds(300, 200, 250, 40);
        user.setForeground(new Color(255, 102, 102));
        user.setFont(myfont);
        l1.add(user);

        usernametf = new JTextField();
        usernametf.setBounds(500, 200, 250, 40);
        usernametf.setForeground(new Color(255, 102, 102));
        usernametf.setFont(myfont);
        l1.add(usernametf);

		pass=new JLabel("Password");
		pass.setBounds(300,300,250,40);
		pass.setForeground(new Color(255, 102, 102));
		pass.setFont(myfont);
		l1.add(pass);

		passwordtf=new JPasswordField();
		passwordtf.setEchoChar('*');
		passwordtf.setForeground(new Color(255, 102, 102));
		passwordtf.setFont(myfont);
		passwordtf.setBounds(500,300,250,40);
		l1.add(passwordtf);

		LoginButton=new JButton("Login");
		LoginButton.setBounds(350,400,150,40);
		LoginButton.setFont(myfont);
		LoginButton.setForeground(new Color(255, 102, 102));
		l1.add(LoginButton);
		LoginButton.addActionListener(this);

		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(550,400,150,40);
		cancelButton.setFont(myfont);
		l1.add(cancelButton);
		cancelButton.setForeground(new Color(255, 102, 102));
		cancelButton.addActionListener(this);

		button=new JLabel("Employee Login");
		button.setBounds(450,100,200,40);
		button.setFont(myfont);
		l1.add(button);
		button.setForeground(new Color(255, 102, 102));

		button1=new JLabel("Admin login");
		button1.setBounds(100,100,200,40);
		button1.setFont(myfont);
		f.add(button1);
		button1.setForeground(new Color(255, 102, 102));

        f.setVisible(true);
        f.setLayout(null);
        f.setSize(1500, 1000);
    }

    public static void main(String args[]) {
        new adminLogin();
    }
	public void actionPerformed(ActionEvent ae)
	{
		String button=ae.getActionCommand();
		if(button.equals("Cancel"))
		{
			//System.exit(0);
			f.dispose();
			new bank11();
		}
		else if(button.equals("Login"))
		{
			String u=usernametf.getText();
			String p=passwordtf.getText();
			String url = "path of the driver with dbname,port number"; // Change accordingly
			 String user = "db username";
			 String pass = "db password";
		
			try {
          
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		  

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Query to check username and password
            String query = "SELECT * FROM admin_table WHERE username=? AND password=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, u);
            pstmt.setString(2, p);

			 ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
              
			   // infoLabel.setText("Login Successful");
			   JOptionPane.showMessageDialog(null,"succeessfull");
			    f.dispose();
			  new adminpage();

            } else {
                JOptionPane.showMessageDialog(null,"not succeessfull");
				//infoLabel.setText("Invalid username or password");
            }
			rs.close();
            pstmt.close();
            connection.close();
		}
		catch(Exception e)
			{
				 System.out.println("Exception: " + e);
			}
	}
}
}
class adminpage implements ActionListener
{
	JFrame adminFrame;
	JButton submitButton,cancelButton;
	JLabel adminLabel,adminAccountLabel,adminAmountLabel;
	JTextField adminAccountField,adminAmountField;
	Font myfont = new Font("Calibri", Font.BOLD, 30);


	adminpage()
	{
		 adminFrame = new JFrame("Employee Page");

        adminLabel = new JLabel("Add   Amount");
        adminLabel.setBounds(600, 50, 300, 50);
		adminLabel.setForeground(new Color(255,102,102));
        adminLabel.setFont(myfont);
        adminFrame.add(adminLabel);

        adminAccountLabel = new JLabel("Account Number:");
        adminAccountLabel.setBounds(400, 150, 200, 30);
		adminAccountLabel.setFont(myfont);
		adminAccountLabel.setForeground(new Color(255,102,102));
        adminFrame.add(adminAccountLabel);

        adminAccountField = new JTextField();
        adminAccountField.setBounds(600, 150, 300, 30);
		adminAccountField.setFont(myfont);
		adminAccountField.setForeground(new Color(255,102,102));
        adminFrame.add(adminAccountField);

        adminAmountLabel = new JLabel("Amount to Add:");
        adminAmountLabel.setBounds(400, 200, 250, 30);
		adminAmountLabel.setFont(myfont);
		adminAccountLabel.setForeground(new Color(255,102,102));
        adminFrame.add(adminAmountLabel);

        adminAmountField = new JTextField();
        adminAmountField.setBounds(600, 200, 200, 30);
		adminAmountField.setFont(myfont);
		adminAmountField.setForeground(new Color(255,102,102));
        adminFrame.add(adminAmountField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(500, 300, 200, 40);
		submitButton.setFont(myfont);
		submitButton.setForeground(new Color(255,102,102));
        submitButton.addActionListener(this);
        adminFrame.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(750, 300, 200, 40);
		cancelButton.setFont(myfont);
		cancelButton.setForeground(new Color(255,102,102));
        cancelButton.addActionListener(this);
        adminFrame.add(cancelButton);

        adminFrame.setLayout(null);
        adminFrame.setSize(1200, 600);
        adminFrame.setLocation(300, 100);
        adminFrame.setVisible(true);
    }
		public void actionPerformed(ActionEvent ae)
		{
			String button=ae.getActionCommand();
			if(button.equals("Submit"))
			{
        // Admin submit logic
        String accountNumber = adminAccountField.getText();
        String amountToAdd = adminAmountField.getText();

        // Update the database with the new amount based on your schema
        String updateQuery = "UPDATE bankdetails SET balance = balance + ? WHERE accountnum = ?";

        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection("path of the driver with dbname,port number", "db username", "db password");
            PreparedStatement pstmt = connection.prepareStatement(updateQuery);
            pstmt.setInt(1, Integer.parseInt(amountToAdd));
            pstmt.setString(2, accountNumber);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Amount added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add amount. Please check the account number.");
            }

            pstmt.close();
            connection.close();
            } 
			catch (Exception ex) 
			{
            System.out.println("Exception: " + ex);
            }
			}
			else if(button.equals("Cancel"))
			{
				//System.exit(0);
				adminFrame.dispose();
				new adminLogin();
			}
    }
	public static void main(String args[])
	{
		new adminpage();
	}
}
class BalanceRetrievalApp {
    JFrame frame;
     JLabel accountLabel, pinLabel, balanceLabel;
     JTextField accountTextField, balanceTextField;
	 JPasswordField pinTextField;
     JButton getBalanceButton, backButton;
	 Font myfont=new Font("DialogInput",Font.BOLD,30);

    public BalanceRetrievalApp() {
        // Initialize frame and components
        frame = new JFrame("Balance Retrieval App");

        accountLabel = new JLabel("Account Number:");
		accountLabel.setBounds(100,100,500,40);
		accountLabel.setFont(myfont);
		accountLabel.setBackground(new Color(204,255,204));
		accountLabel.setForeground(new Color(0,102,204));
		frame.add(accountLabel);

		 accountTextField = new JTextField();
		 accountTextField.setBounds(100,150,500,40);
		accountTextField.setFont(myfont);
		accountTextField.setBackground(new Color(204,255,204));
		accountTextField.setForeground(new Color(0,102,204));
		frame.add(accountTextField);


        pinLabel = new JLabel("PIN:");
		pinLabel.setBounds(100,200,500,40);
		pinLabel.setFont(myfont);
		pinLabel.setBackground(new Color(204,255,204));
		pinLabel.setForeground(new Color(0,102,204));
		frame.add(pinLabel);

		pinTextField = new JPasswordField();
		pinTextField .setBounds(100,250,500,40);
		pinTextField.setEchoChar('*');
		pinTextField .setFont(myfont);
		pinTextField .setBackground(new Color(204,255,204));
		pinTextField .setForeground(new Color(0,102,204));
		frame.add(pinTextField );

        balanceLabel = new JLabel("Balance:");
		 balanceLabel.setBounds(100,300,500,40);
		 balanceLabel.setFont(myfont);
		 balanceLabel.setBackground(new Color(204,255,204));
		 balanceLabel.setForeground(new Color(0,102,204));
		frame.add( balanceLabel);
       
        
        balanceTextField = new JTextField();
		 balanceTextField.setBounds(100,350,500,40);
		 balanceTextField.setFont(myfont);
		 balanceTextField.setBackground(new Color(204,255,204));
		 balanceTextField.setForeground(new Color(0,102,204));
		frame.add( balanceTextField);

        getBalanceButton = new JButton("Get Balance");
		getBalanceButton.setBounds(180,450,250,40);
		getBalanceButton.setFont(myfont);
		getBalanceButton.setBackground(new Color(204,255,204));
		getBalanceButton.setForeground(new Color(0,102,204));
		frame.add(getBalanceButton);
		
        backButton = new JButton("Back");
		backButton.setBounds(450,450,200,40);
		backButton.setFont(myfont);
		backButton.setBackground(new Color(204,255,204));
		backButton.setForeground(new Color(0,102,204));
		frame.add(backButton);

        // Set layout manager
        frame.setLayout(null);

        // Add components to the frame
        /*frame.add(accountLabel);
        frame.add(accountTextField);
        frame.add(pinLabel);
        frame.add(pinTextField);
        frame.add(balanceLabel);
        frame.add(balanceTextField);
        frame.add(getBalanceButton);
        frame.add(backButton);*/

        // Set action listeners
        getBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrieveBalance();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
				new home1();
            }
        });

        // Set frame properties
        frame.setSize(800, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void retrieveBalance() {
        // Replace these database details with your actual database information
        String url = "path of the driver with dbname,port number"; // Change accordingly
                String user = "db username";
                String pass = "db password";


        try {
            // Load the JDBC driver
           Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Prepare and execute the query
            String query = "SELECT balance FROM bankdetails WHERE accountnum = ? AND pin = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, accountTextField.getText());
            preparedStatement.setString(2, pinTextField.getText());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Display the retrieved balance
                double balance = resultSet.getDouble("balance");
                balanceTextField.setText(String.valueOf(balance));
            } else {
                // Account not found or invalid credentials
                balanceTextField.setText("Invalid credentials");
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error retrieving balance. Please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BalanceRetrievalApp();
            }
        });
    }
}
class BankAcc implements ActionListener {

    JFrame frame;
    JLabel nameLabel, accNumLabel, ifscLabel, pinLabel, branchLabel;
    JTextField nameTextField, accNumTextField, ifscTextField, branchTextField;
	JPasswordField pinTextField;
    JButton submitButton, cancelButton;
	Font myFont2 = new Font("DialogInput", Font.BOLD, 30);

    BankAcc() {
        frame = new JFrame("Bank Account Details");
        nameLabel = new JLabel("Customer Name:");
        accNumLabel = new JLabel("Account Number:");
        ifscLabel = new JLabel("IFSC Code:");
        pinLabel = new JLabel("Create PIN:");
        branchLabel = new JLabel("Branch:");

        nameTextField = new JTextField();
        accNumTextField = new JTextField();
        ifscTextField = new JTextField();
        pinTextField = new JPasswordField();
        branchTextField = new JTextField();

        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        // Set layout to null for absolute positioning
        frame.setLayout(null);

        // Set bounds for labels and text fields
        nameLabel.setBounds(100, 150, 300, 50);
		 nameLabel.setFont(myFont2);
         nameLabel.setBackground(new Color(255, 240, 245));
         nameLabel.setForeground(new Color(0,102,204));

        nameTextField.setBounds(450, 150, 300, 40);
		nameTextField.setFont(myFont2);
        nameTextField.setBackground(new Color(204,255,204));
        nameTextField.setForeground(new Color(0,102,204));

        accNumLabel.setBounds(100, 250, 300, 40);
		accNumLabel.setFont(myFont2);
        accNumLabel.setBackground(new Color(204,255,204));
        accNumLabel.setForeground(new Color(0,102,204));

        accNumTextField.setBounds(450, 250, 300, 40);
		accNumTextField.setFont(myFont2);
        accNumTextField.setBackground(new Color(204,255,204));
        accNumTextField.setForeground(new Color(0,102,204));

        ifscLabel.setBounds(100, 350, 300, 40);
		ifscLabel.setFont(myFont2);
        ifscLabel.setBackground(new Color(204,255,204));
        ifscLabel.setForeground(new Color(0,102,204));

        ifscTextField.setBounds(450, 350, 300, 40);
		ifscTextField.setFont(myFont2);
        ifscTextField.setBackground(new Color(204,255,204));
        ifscTextField.setForeground(new Color(0,102,204));

        pinLabel.setBounds(100, 450, 300, 40);
		pinLabel.setFont(myFont2);
        pinLabel.setBackground(new Color(204,255,204));
        pinLabel.setForeground(new Color(0,102,204));

        pinTextField.setBounds(450, 450, 300, 40);
		pinTextField.setFont(myFont2);
		pinTextField.setEchoChar('*');
        pinTextField.setBackground(new Color(204,255,204));
        pinTextField.setForeground(new Color(0,102,204));

        branchLabel.setBounds(100, 550, 300, 40);
		 branchLabel.setFont(myFont2);
        branchLabel.setBackground(new Color(204,255,204));
        branchLabel.setForeground(new Color(0,102,204));

        branchTextField.setBounds(450, 550, 300, 40);
		 branchTextField.setFont(myFont2);
        branchTextField.setBackground(new Color(204,255,204));
        branchTextField.setForeground(new Color(0,102,204));


        submitButton.setBounds(200, 650, 150, 50);
		submitButton.setFont(myFont2);
        submitButton.setBackground(new Color(204,255,204));
        submitButton.setForeground(new Color(0,102,204));

        cancelButton.setBounds(400, 650, 150, 50);
		 cancelButton.setFont(myFont2);
        cancelButton.setBackground(new Color(204,255,204));
        cancelButton.setForeground(new Color(0,102,204));

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameTextField);
        frame.add(accNumLabel);
        frame.add(accNumTextField);
        frame.add(ifscLabel);
        frame.add(ifscTextField);
        frame.add(pinLabel);
        frame.add(pinTextField);
        frame.add(branchLabel);
        frame.add(branchTextField);
        frame.add(submitButton);
        frame.add(cancelButton);

        // Registering ActionListener for buttons
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Set frame properties
        frame.setSize(800, 800);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BankAcc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (isValidData()) {
                if (insertData()) {
                    JOptionPane.showMessageDialog(frame, "Details submitted successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(frame, "Error submitting details.","error",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame,"please fill in all the details.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
		if (e.getSource() == cancelButton)
            frame.dispose();
			new home1();
        }

    private boolean isValidData() {
        return !nameTextField.getText().trim().isEmpty() &&
                !accNumTextField.getText().trim().isEmpty() &&
                !ifscTextField.getText().trim().isEmpty() &&
                !pinTextField.getText().trim().isEmpty() &&
                !branchTextField.getText().trim().isEmpty();
    }

    private boolean insertData() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "path of the driver with dbname,port number"; // Change accordingly
            String user = "db username";
            String pass = "db password";
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO bankdetails (accountnum, ifsccode,customername, pin, balance,branch) VALUES (?, ?, ?, ?,?,?)";

				PreparedStatement pst = con.prepareStatement(query);
                
                pst.setInt(1, Integer.parseInt(accNumTextField.getText().trim()));
                pst.setString(2, ifscTextField.getText().trim());
				pst.setString(3, nameTextField.getText().trim());
				pst.setInt(5, 0);
                pst.setInt(4, Integer.parseInt(pinTextField.getText().trim()));
                pst.setString(6, branchTextField.getText().trim());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void clearFields() {
        nameTextField.setText("");
        accNumTextField.setText("");
        ifscTextField.setText("");
        pinTextField.setText("");
        branchTextField.setText("");
    }
}
class changepassword implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t4;
	JPasswordField t2,t3;
	JButton b1,b2,b3;
	JFrame f;
	Font myfont=new Font("DialogInput",Font.BOLD,30);
	changepassword()
	{
		f=new JFrame();
//enter the email id
		l1=new JLabel("enter username");
		l1.setBounds(50,100,500,40);
		l1.setBackground(new Color(204,255,204));
		l1.setForeground(new Color(0,102,204));
		l1.setFont(myfont);
//new password
		l2=new JLabel("new password");
		l2.setBounds(50,200,500,40);
		l2.setBackground(new Color(204,255,204));
		l2.setForeground(new Color(0,102,204));
		l2.setFont(myfont);
//confirm password
		l3=new JLabel("confirm password");
		l3.setBounds(50,300,500,40);
		l3.setBackground(new Color(204,255,204));
		l3.setForeground(new Color(0,102,204));
		l3.setFont(myfont);

		b1=new JButton("continue");
		b1.setBounds(100,500,200,40);
		b1.setBackground(new Color(204,255,204));
		b1.setForeground(new Color(0,102,204));
		b1.setFont(myfont);
		b1.addActionListener(this);

		b2=new JButton("back");
		b2.setBounds(350,500,200,40);
		b2.setBackground(new Color(204,255,204));
		b2.setForeground(new Color(0,102,204));
		b2.setFont(myfont);
		b2.addActionListener(this);
//enter the email id
		t1=new JTextField();
		t1.setBounds(50,150,400,40);
		t1.setBackground(new Color(204,255,204));
		t1.setForeground(new Color(0,102,204));
		t1.setFont(myfont);
//new password
		t2=new JPasswordField();
		t2.setBounds(50,250,400,40);
		t2.setEchoChar('*');
		t2.setBackground(new Color(204,255,204));
		t2.setForeground(new Color(0,102,204));
		t2.setFont(myfont);
//confirm password
		t3=new JPasswordField();
		t3.setEchoChar('*');
		t3.setBounds(50,350,400,40);
		t3.setBackground(new Color(204,255,204));
		t3.setForeground(new Color(0,102,204));
		t3.setFont(myfont);

		t4=new JTextField();
		t4.setBounds(50,300,350,40);
		t4.setBackground(new Color(204,255,204));
		t4.setForeground(new Color(0,102,204));
		t4.setFont(myfont);
		
		f.add(l1);
		f.add(l2);
		f.add(b1);
		f.add(b2);
		//f.add(b3);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.setVisible(true);
		f.setSize(600,600);
		f.setLayout(null);


	}
	public static void main(String args[])
	{
		changepassword c=new changepassword();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String button=ae.getActionCommand();
		if(button.equals("back"))
		{
			//System.exit(0);
			f.dispose();
			new bank11();
		}
		else if(button.equals("continue"))
		{
			 String name = t1.getText();
			 // Assuming account is a string, update if it's an integer
			 if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username");
                return;
            }
			String pass=t2.getText();
			String cpass=t3.getText();
			if(pass.isEmpty()){
				JOptionPane.showMessageDialog(null, "Please enter password");
                return;
			}
			if(pass.equals(cpass))
			{
				 String url = "path of the driver with dbname,port number"; // Change accordingly
            String user = "db username";
            String password = "db password";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establish a connection
                Connection connection = DriverManager.getConnection(url, user, password);

                // Query to check balance based on account number
				 String queryUpdate = "UPDATE register SET password=? WHERE username=?";
                        PreparedStatement pstmtUpdate = connection.prepareStatement(queryUpdate);
                        pstmtUpdate.setString(1, cpass);
                        pstmtUpdate.setString(2, name);

                        int rowsUpdated = pstmtUpdate.executeUpdate();

                        if (rowsUpdated > 0) {
                           JOptionPane.showMessageDialog(null,"successfully updated "+".\n login again");
						} 
						 pstmtUpdate.close();
                connection.close();
            } 
			catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
			
			}
			else
			{
				JOptionPane.showMessageDialog(null,"password and confirm password doesnot match"+"\n"+"try again");
			}

            // JDBC Connection parameters
           
               
				
               
		}
	}
}
class Deposit implements ActionListener {
    JFrame f = new JFrame();
    String pin;
    JButton b1, b2,b3;
    JTextField j, j1,j3;
	JPasswordField j2;
    Font myFont2;
    JLabel l3, l2, l4, l5;

    Deposit() {
        
        myFont2 = new Font("DialogInput", Font.BOLD, 30);

        ImageIcon i = new ImageIcon("project.jpeg");
        Image i1 = i.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(10, 10, 1500, 1000);
        f.add(l1);

//enter account number
        JLabel l = new JLabel("enter account number");
        l.setBounds(150, 200, 700, 40);
        l.setForeground(Color.blue);
        l.setFont(myFont2);
        l1.add(l);

//customer name
        l4 = new JLabel("customer name");
        l4.setBounds(150, 100, 400, 40);
        l4.setFont(myFont2);
        l4.setForeground(Color.blue);
        l4.setBackground(new Color(65, 125, 128));
        l1.add(l4);

//enter deposit amount
        l2 = new JLabel("enter amount");
        l2.setBounds(150, 300, 700, 40);
        l2.setFont(myFont2);
        l2.setForeground(Color.blue);
        l2.setBackground(new Color(65, 125, 128));
        l1.add(l2);

        l5 = new JLabel("FIXED DEPOSIT WINDOW");
        l5.setBounds(350, 30, 700, 40);
        l5.setFont(myFont2);
        l5.setForeground(Color.blue);
        l5.setBackground(new Color(65, 125, 128));
        l1.add(l5);
//enter your pin
        l3 = new JLabel("enter your pin");
        l3.setBounds(150, 400, 600, 40);
        l3.setFont(myFont2);
        l3.setForeground(Color.blue);
        l3.setBackground(new Color(65, 125, 128));
        l1.add(l3);
//enter account number
        j = new JTextField();
        j.setBounds(550, 200, 400, 40);
        j.setBackground(new Color(65, 125, 128));
        j.setForeground(new Color(0,102,204));
        j.setFont(new Font("System", Font.BOLD, 20));
        l1.add(j);

//customer name
        j3 = new JTextField();
        j3.setBounds(550, 100, 400, 40);
        j3.setBackground(new Color(70, 125, 128));
        j3.setForeground(Color.red);
        j3.setFont(new Font("System", Font.BOLD, 20));
        l1.add(j3);

//deposit amount
        j1 = new JTextField();
        j1.setBounds(550, 300, 400, 40);
        j1.setBackground(new Color(65, 125, 128));
        j1.setForeground(new Color(0,102,204));
        j1.setFont(new Font("System", Font.BOLD, 20));
        l1.add(j1);

//enter ur pin
        j2 = new JPasswordField();
        j2.setBounds(550, 400, 400, 40);
		j2.setEchoChar('*');
        j2.setBackground(new Color(65, 125, 128));
        j2.setForeground(new Color(0,102,204));
        j2.setFont(new Font("System", Font.BOLD, 20));
        l1.add(j2);

        b1 = new JButton("Deposit");
        b1.setBounds(580, 500, 200, 80);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.green);
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(800, 500, 200, 80);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.green);
        b2.setFont(new Font("System", Font.BOLD, 20));
        b2.addActionListener(this);
        l1.add(b2);

 b3 = new JButton("get details");
        b3.setBounds(350, 500, 200, 80);
        b3.setBackground(new Color(65, 125, 128));
        b3.setForeground(Color.green);
        b3.setFont(new Font("System", Font.BOLD, 20));
        b3.addActionListener(this);
        l1.add(b3);

 /*b4 = new JButton("Deposit");
        b4.setBounds(750, 500, 200, 80);
        b4.setBackground(new Color(65, 125, 128));
        b4.setForeground(new Color(0,102,204));
        b4.setFont(new Font("System", Font.BOLD, 20));
        b4.addActionListener(this);
        l1.add(b4);*/


        f.setLayout(null);
        f.setSize(2000, 2000);
        f.setLocation(0, 0);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       
            if (e.getSource() == b3) {

				 String account = j.getText();  // Assuming account is a string, update if it's an integer

            // JDBC Connection parameters
            String url = "path of the driver with dbname,port number"; // Change accordingly
            String user = "db username";
            String pass = "db password";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establish a connection
                Connection connection = DriverManager.getConnection(url, user, pass);

                // Query to check balance based on account number
               
				String query = "SELECT customername FROM bankdetails WHERE accountnum=?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, account);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String customerName = rs.getString("customername");

                    // Set the retrieved customer name to the associated text field
                    // Replace "customerNameTextField" with the actual variable representing your text field
                    j3.setText(customerName);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer name not found for the account number");
                }
                // Close resources
                rs.close();
                pstmt.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
			}

			if(e.getSource()==b1){

			 String url = "path of the driver with dbname,port number"; // Change accordingly
            String user = "db username";
            String pass = "db password";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establish a connection
                Connection connection1 = DriverManager.getConnection(url, user, pass);
				
				String account1 =j.getText();
                if (account1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid account number");
                return;
            }
				int account=Integer.parseInt(account1);
				
				String amount=j1.getText();
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount");
                return;
            }
				int amount1 = Integer.parseInt(amount);

				String querySelect1 = "SELECT balance,pin FROM bankdetails WHERE accountnum=?";
                PreparedStatement pstmtSelect1 = connection1.prepareStatement(querySelect1);
				pstmtSelect1.setString(1, account1);
				ResultSet rs1 = pstmtSelect1.executeQuery();
				 if (rs1.next()) {
				int pin1= rs1.getInt("pin");
				int amount2=rs1.getInt("balance");

                // Validate that pin is a number
                int pinEntered = Integer.parseInt(j2.getText());

				if( pinEntered == pin1)
				{
					
                        // Update the balance after withdrawal
                        int newBalance = amount2 - amount1;

                        // Query to update the balance in the database
                        String queryUpdate = "UPDATE bankdetails SET balance=? WHERE accountnum=?";
                        PreparedStatement pstmtUpdate = connection1.prepareStatement(queryUpdate);
                        pstmtUpdate.setInt(1, newBalance);
                        pstmtUpdate.setString(2, account1);

                        int rowsUpdated = pstmtUpdate.executeUpdate();

                        if (rowsUpdated > 0) {
                            // Display withdrawal details
                            JOptionPane.showMessageDialog(null, amount1 + " Rs/- has been credited to FD account " + ".\nAvailable balance is " + newBalance );

                            // Update the text fields
                            //t2.setText(String.valueOf(newBalance));
                            //t4.setText(String.valueOf(newBalance));
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed");
                        }
						 pstmtUpdate.close();

                   
				} else {
					JOptionPane.showMessageDialog(null, "pin is wrong");
				}
				}
				rs1.close();
				pstmtSelect1.close();
				connection1.close();

			}
				catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
            } 
			else if (e.getSource() == b2) {
                f.dispose();
				new home1();
            }
        
    }
    public static void main(String args[]) {
        new Deposit();
    }
}

class registrations1 implements ActionListener {

    // ... (Existing code)

    JButton b5, b6;
    JTextField t1, t2, t3, t4;
    JTextArea ta1;
    JLabel l1, l2, l3, l4, l5, l6, l7,l8,l9,l10, l11;
	JPasswordField t5,t6;
    JFrame f2 = new JFrame();
    Choice c1, c2, c3, c4, c5;
    JRadioButton rb1, rb2;

    Font myFont2 = new Font("DialogInput", Font.BOLD, 20);
    Font myFont3 = new Font("DialogInput", Font.BOLD, 30);

    registrations1() {
        f2.setBackground(new Color(0,102,204));
		//b4  = new JButton("x");
		b5  = new JButton("Cancel");
		b6  = new JButton("Register");

		t1  = new JTextField();
		t2  = new JTextField();
		t3  = new JTextField();
		t4  = new JTextField();
		t5  = new JPasswordField();
		t6  = new JPasswordField();

		ta1 = new JTextArea();

		l1  = new JLabel("First Name");
		l2  = new JLabel("Last Name");
		l3  = new JLabel("Gender");
		l4 = new JLabel("Date Of Birth");
		l5  = new JLabel("Mobile Number");
		l6 = new JLabel("Email ID/User ID");
		l7 = new JLabel("Create Password");
		l8  = new JLabel("Confirm Password");
		l9  = new JLabel("Address");
		l10  = new JLabel("Select");
		l11  = new JLabel("           REGISTRATION FORM");

		rb1  = new JRadioButton("I am a Customer");
		rb2  = new JRadioButton("I am a Employee");

		c1  = new Choice();
		      c1.addItem("DD");
		      c1.addItem("1");
		      c1.addItem("2");
		      c1.addItem("3");
		      c1.addItem("4");
		      c1.addItem("5");
		      c1.addItem("6");
		      c1.addItem("7");
		      c1.addItem("8");
		      c1.addItem("9");
		      c1.addItem("10");
		      c1.addItem("11");
		      c1.addItem("12");
		      c1.addItem("13");
		      c1.addItem("14");
		      c1.addItem("15");
		      c1.addItem("16");
		      c1.addItem("17");
		      c1.addItem("18");
		      c1.addItem("19");
		      c1.addItem("20");
		      c1.addItem("21");
		      c1.addItem("22");
		      c1.addItem("23");
		      c1.addItem("24");
		      c1.addItem("25");
		      c1.addItem("26");
		      c1.addItem("27");
		      c1.addItem("28");
		      c1.addItem("29");
		      c1.addItem("30");			
		      c1.addItem("31");
		c2 = new Choice();
		      c2.addItem("Month");
		      c2.addItem("Janaury");
		      c2.addItem("Febraury");
		      c2.addItem("March");
		      c2.addItem("April");
		      c2.addItem("May");
		      c2.addItem("June");
		      c2.addItem("July");
		      c2.addItem("August");
		      c2.addItem("sepetember");
		      c2.addItem("October");
		      c2.addItem("November");
		      c2.addItem("December");
		c3  = new Choice();
		      c3.addItem("Year");
		      c3.addItem("1980");
		      c3.addItem("1981");
		      c3.addItem("1982");
		      c3.addItem("1983");
		      c3.addItem("1984");
		      c3.addItem("1985");
		      c3.addItem("1986");
		      c3.addItem("1987");
		      c3.addItem("1988");
		      c3.addItem("1989");
		      c3.addItem("1990");
		      c3.addItem("1991");
		      c3.addItem("1992");
		      c3.addItem("1992");
		      c3.addItem("1993");
		      c3.addItem("1994");
		      c3.addItem("1995");
		      c3.addItem("1996");
		      c3.addItem("1997");
		      c3.addItem("1998");
		      c3.addItem("1999");
		      c3.addItem("2000");
		      c3.addItem("2001");
		      c3.addItem("2002");
		      c3.addItem("2003");
		      c3.addItem("2004");
		      c3.addItem("2005");
		      c3.addItem("2006");
		      c3.addItem("2007");
		      c3.addItem("2008");			
		      c3.addItem("2009");
		      c3.addItem("2010");
		      c3.addItem("2011");
		      c3.addItem("2012");
		      c3.addItem("2013");
		      c3.addItem("2014");
		      c3.addItem("2015");
		      c3.addItem("2016");
		      c3.addItem("2017");
		      c3.addItem("2018");
		      c3.addItem("2019");			
		      c3.addItem("2020");
		c4  = new Choice();
		      c4.addItem("SELECT THE GENDER");
		      c4.addItem("Male");
		      c4.addItem("Female");
		      c4.addItem("Not to Mention");
			

		l1.setBounds(50,150,150,40);
		l1.setFont(myFont2);
		l1.setBackground(new Color(204,255,204));
		l1.setForeground(new Color(0,102,204));
		
		l2.setBounds(50,190,150,40);
		l2.setFont(myFont2);
		l2.setBackground(new Color(204,255,204));
		l2.setForeground(new Color(0,102,204));
		
		l3.setBounds(50,230,150,40);
		l3.setFont(myFont2);
		l3.setBackground(new Color(204,255,204));
		l3.setForeground(new Color(0,102,204));
		
		l4.setBounds(50,270,200,40);
		l4.setFont(myFont2);
		l4.setBackground(new Color(204,255,204));
		l4.setForeground(new Color(0,102,204));
		
		l5.setBounds(50,310,200,40);
		l5.setFont(myFont2);
		l5.setBackground(new Color(204,255,204));
		l5.setForeground(new Color(0,102,204));
		
		l6.setBounds(50,350,200,40);
		l6.setFont(myFont2);
		l6.setBackground(new Color(204,255,204));
		l6.setForeground(new Color(0,102,204));
		
		l7.setBounds(50,390,200,40);
		l7.setFont(myFont2);
		//l7.setEchoChar('*');
		l7.setBackground(new Color(204,255,204));
		l7.setForeground(new Color(0,102,204));
		
		l8.setBounds(50,430,200,40);
		l8.setFont(myFont2);
		//l8.setEchoChar('*');
		l8.setBackground(new Color(204,255,204));
		l8.setForeground(new Color(0,102,204));
		
		l9.setBounds(50,470,200,40);
		l9.setFont(myFont2);
		l9.setBackground(new Color(204,255,204));
		l9.setForeground(new Color(0,102,204));
		
		l10.setBounds(50,625,200,40);
		l10.setFont(myFont2);
		l10.setBackground(new Color(204,255,204));
		l10.setForeground(new Color(0,102,204));
		
		l11.setBounds(50,50,700,50);
		l11.setFont(myFont3);
		l11.setBackground(new Color(204,255,204));
		l11.setForeground(new Color(0,102,204));

		t1.setBounds(280,150,350,30);
		t1.setFont(myFont2);
		t1.setBackground(new Color(204,255,204));
		t1.setForeground(new Color(0,102,204));
		
		t2.setBounds(280,190,350,30);
		t2.setFont(myFont2);
		t2.setBackground(new Color(204,255,204));
		t2.setForeground(new Color(0,102,204));
		
		t3.setBounds(280,310,350,30);
		t3.setFont(myFont2);
		t3.setBackground(new Color(204,255,204));
		t3.setForeground(new Color(0,102,204));
		
		t4.setBounds(280,350,350,30);
		t4.setFont(myFont2);
		t4.setBackground(new Color(204,255,204));
		t4.setForeground(new Color(0,102,204));
		
		t5.setBounds(280,390,350,30);
		t5.setFont(myFont2);
		t5.setEchoChar('*');
		t5.setBackground(new Color(204,255,204));
		t5.setForeground(new Color(0,102,204));
		
		t6.setBounds(280,430,350,30);
		t6.setFont(myFont2);
		t6.setEchoChar('*');
		t6.setBackground(new Color(204,255,204));
		t6.setForeground(new Color(0,102,204));
		
		ta1.setBounds(280,470,350,125);
		ta1.setBackground(new Color(204,255,204));
		ta1.setForeground(new Color(0,102,204));
		
		c1.setBounds(280,270,100,30);
		c1.setFont(myFont2);
		c1.setBackground(new Color(204,255,204));
		c1.setForeground(new Color(0,102,204));
		
		c2.setBounds(385,270,120,30);
		c2.setFont(myFont2);
		c2.setBackground(new Color(204,255,204));
		c2.setForeground(new Color(0,102,204));

		c3.setBounds(510,270,120,30);
		c3.setFont(myFont2);
		c3.setBackground(new Color(204,255,204));
		c3.setForeground(new Color(0,102,204));
		
		c4.setBounds(280,230,260,30);
		c4.setFont(myFont2);
		c4.setBackground(new Color(204,255,204));
		c4.setForeground(new Color(0,102,204));
		
		/*b4.setBounds(610,15,70,40);
		b4.setFont(myFont2);
		b4.setBackground(new Color(204,255,204));
		b4.setForeground(new Color(0,102,204));*/
		
		b6.setBounds(150,760,150,40);
		b6.setBackground(new Color(204,255,204));
		b6.setForeground(new Color(0,102,204));
		b6.setFont(myFont2);
		
		b5.setBounds(350,760,150,40);
		b5.setBackground(new Color(204,225,204));
		b5.setForeground(new Color(0,102,204));
		b5.setFont(myFont2);

		rb1.setBounds(280,625,250,35);
		rb1.setFont(myFont2);

		rb2.setBounds(280,680,250,35);
		rb2.setFont(myFont2);

		rb1.setBackground(new Color(204,255,204));
		rb2.setBackground(new Color(204,255,204));

		f2.add(t1);
		f2.add(t2);
		f2.add(t3);
		f2.add(t4);
		f2.add(t5);
		f2.add(t6);

		f2.add(ta1);

		f2.add(l1);
		f2.add(l2);
		f2.add(l3);
		f2.add(l4);
		f2.add(l5);
		f2.add(l6);
		f2.add(l7);
		f2.add(l8);
		f2.add(l9);
		f2.add(l10);
		f2.add(l11);
		//f2.add(b4);
		f2.add(b5);
		f2.add(b6);

		f2.add(rb1);
		f2.add(rb2);

		f2.add(c1);
		f2.add(c2);
		f2.add(c3);
		f2.add(c4);
		f2.setSize(700,900);
		f2.setLayout(null);
		f2.setVisible(true);

        //b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }

    public static void main(String args[]) {
        registrations1 r = new registrations1();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b6) {
            if (isFieldsEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the details", "Error", JOptionPane.ERROR_MESSAGE);
            }
			else if (!isPasswordMatch()) {
            JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidMobileNumber()) {
            JOptionPane.showMessageDialog(null, "Mobile Number should be numeric and must contain 10digits", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidName(t1.getText()) || !isValidName(t2.getText())) {
            JOptionPane.showMessageDialog(null, "First Name and Last Name should contain only characters", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
                // Perform registration logic here
                if (registerUser()) {
                    JOptionPane.showMessageDialog(null, "Registered successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error registering user", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == b5) {
            f2.dispose();
            // Add code to handle cancel button action
            new bank11();
        }
    }
	
	
    private boolean isFieldsEmpty() {
        return t1.getText().trim().isEmpty() ||
                t2.getText().trim().isEmpty() ||
                t3.getText().trim().isEmpty() ||
                t4.getText().trim().isEmpty() ||
                t5.getText().trim().isEmpty() ||
                t6.getText().trim().isEmpty();
    }
	private boolean isPasswordMatch() {
    return t5.getText().equals(t6.getText());
}

private boolean isValidMobileNumber() {
    String mobileNumber = t3.getText().trim();
    return mobileNumber.matches("\\d+") && mobileNumber.length() == 10;
}

private boolean isValidName(String name) {
    return name.matches("[a-zA-Z]+"); // Check if it contains only alphabets
}

    private boolean registerUser() {
        try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "path of the driver with dbname,port number"; // Change accordingly
                String user = "db username";
                String pass = "db password";
            Connection con = DriverManager.getConnection(url, user, pass);

            String firstName = t1.getText();
            String lastName = t2.getText();
            String gender = c4.getSelectedItem();
            String dob = c1.getSelectedItem() + " " + c2.getSelectedItem() + " " + c3.getSelectedItem();
            String mobileNumber = t3.getText();
            String username = t4.getText();
            String password = t6.getText();
            String address = ta1.getText();

            String query = "INSERT INTO register (firstname, lastname, gender, mobilenum, username, password, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, gender);
                pst.setString(4, mobileNumber);
                pst.setString(5, username);
                pst.setString(6, password);
                pst.setString(7, address);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
class transaction implements ActionListener
{
	JFrame f;
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4;
	JPasswordField t5;
	JLabel l1,l2,l3,l4,l5;
	Font myfont=new Font("DialogInput",Font.BOLD,30);
	transaction()
	{
		f=new JFrame();

		l1=new JLabel("enter your account number");
		l1.setBounds(100,100,800,40);
		l1.setFont(myfont);
		l1.setBackground(new Color(204,255,204));
		l1.setForeground(new Color(0,102,204));
		f.add(l1);

		t1=new JTextField();
		t1.setBounds(100,150,800,40);
		t1.setFont(myfont);
		t1.setBackground(new Color(204,255,204));
		t1.setForeground(new Color(0,102,204));
		f.add(t1);

		l2=new JLabel("enter account number u want to transfer to");
		l2.setBounds(100,200,800,40);
		l2.setFont(myfont);
		l2.setBackground(new Color(204,255,204));
		l2.setForeground(new Color(0,102,204));
		f.add(l2);

		t2=new JTextField();
		t2.setBounds(100,250,800,40);
		t2.setFont(myfont);
		t2.setBackground(new Color(204,255,204));
		t2.setForeground(new Color(0,102,204));
		f.add(t2);
		
		l4=new JLabel("RECIPIENT NAME");
		l4.setBounds(100,300,800,40);
		l4.setFont(myfont);
		l4.setBackground(new Color(204,255,204));
		l4.setForeground(new Color(0,102,204));
		f.add(l4);

		t4=new JTextField();
		t4.setBounds(100,350,800,40);
		t4.setFont(myfont);
		t4.setBackground(new Color(204,255,204));
		t4.setForeground(new Color(0,102,204));
		f.add(t4);

		l3=new JLabel("enter amount you want to transfer");
		l3.setBounds(100,400,800,40);
		l3.setFont(myfont);
		l3.setBackground(new Color(204,255,204));
		l3.setForeground(new Color(0,102,204));
		f.add(l3);

		t3=new JTextField();
		t3.setBounds(100,450,800,40);
		t3.setFont(myfont);
		t3.setBackground(new Color(204,255,204));
		t3.setForeground(new Color(0,102,204));
		f.add(t3);

		l5=new JLabel("enter the pin");
		l5.setBounds(100,500,800,40);
		l5.setFont(myfont);
		l5.setBackground(new Color(204,255,204));
		l5.setForeground(new Color(0,102,204));
		f.add(l5);
		
		t5=new JPasswordField();
		t5.setBounds(100,550,800,40);
		t5.setFont(myfont);
		t5.setEchoChar('*');
		t5.setBackground(new Color(204,255,204));
		t5.setForeground(new Color(0,102,204));
		f.add(t5);

		b1=new JButton("get details");
		b1.setBounds(100,650,300,40);
		b1.setFont(myfont);
		b1.setBackground(new Color(204,255,204));
		b1.setForeground(new Color(0,102,204));
		f.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("pay");
		b2.setBounds(410,650,200,40);
		b2.setFont(myfont);
		b2.setBackground(new Color(204,255,204));
		b2.setForeground(new Color(0,102,204));
		f.add(b2);
		b2.addActionListener(this);

		b3=new JButton("cancel");
		b3.setBounds(620,650,200,40);
		b3.setFont(myfont);
		b3.setBackground(new Color(204,255,204));
		b3.setForeground(new Color(0,102,204));
		f.add(b3);
		b3.addActionListener(this);

		b4=new JButton("pa");
		b4.setBounds(350,600,200,40);
		b4.setFont(myfont);
		b4.setBackground(new Color(204,255,204));
		b4.setForeground(new Color(0,102,204));
		f.add(b4);
		b4.addActionListener(this);

		f.setVisible(true);
		f.setLayout(null);
		f.setSize(1000,1000);
	}
	public static void main(String args[])
	{
		transaction t=new transaction();
	}
	public void actionPerformed(ActionEvent ae) {
        String button = ae.getActionCommand();
        if (button.equals("cancel")) {
            f.dispose();
			new home1();
        } else if (button.equals("get details")) {
            String receiver = t2.getText();
            if (receiver.equals("")) {
                JOptionPane.showMessageDialog(null, "re-enter the account number");
            }

            try {
                String url = "path of the driver with dbname,port number"; // Change accordingly
                String user = "db username";
                String pass = "db password";

                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establish a connection
                Connection connection1 = DriverManager.getConnection(url, user, pass);
                String querySelect1 = "SELECT customername FROM bankdetails WHERE accountnum=?";
                PreparedStatement pstmtSelect1 = connection1.prepareStatement(querySelect1);
                pstmtSelect1.setString(1, receiver);
                ResultSet rs1 = pstmtSelect1.executeQuery();
                if (rs1.next()) {
                    String name = rs1.getString("customername");
                    t4.setText(name);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer name not found for the given Account number");
                }
                rs1.close();
                pstmtSelect1.close();
                connection1.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        } else if (button.equals("pay")) {
            String pin1 = t5.getText();
            if (pin1.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the pin");
            }

            try {
                String url = "path of the driver with dbname,port number"; // Change accordingly
                String user = "db username";
                String pass = "db password";

                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Establish a connection
                Connection connection = DriverManager.getConnection(url, user, pass);

                String sender1 = t1.getText();
                String receiver1 = t2.getText();

                String querySelect = "SELECT pin, balance FROM bankdetails WHERE accountnum=?";
                PreparedStatement pstmtSelect = connection.prepareStatement(querySelect);
                pstmtSelect.setString(1, sender1);
                ResultSet rs = pstmtSelect.executeQuery();
                int sender_pin = 0;
                int sender_balance = 0;
                if (rs.next()) {
                    sender_pin = rs.getInt("pin");
                    sender_balance = rs.getInt("balance");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer name not found for the given Account number");
                }

                String querySelect2 = "SELECT balance FROM bankdetails WHERE accountnum=?";
                PreparedStatement pstmtSelect2 = connection.prepareStatement(querySelect2);
                pstmtSelect2.setString(1, receiver1);
                ResultSet rs2 = pstmtSelect2.executeQuery();
                int receiver_balance = 0;
                if (rs2.next()) {
                    receiver_balance = rs2.getInt("balance");

                    int newpin = Integer.parseInt(pin1);
                    int bal = sender_balance;

                    if (newpin == sender_pin) {
                        String amount = t3.getText();
                        int amountToTransfer = Integer.parseInt(amount);

                        if (amountToTransfer <= bal) {
                            int newBalance = bal - amountToTransfer;

                            String queryUpdateSender = "UPDATE bankdetails SET balance=? WHERE accountnum=?";
                            PreparedStatement pstmtUpdateSender = connection.prepareStatement(queryUpdateSender);
                            pstmtUpdateSender.setInt(1, newBalance);
                            pstmtUpdateSender.setString(2, sender1);
                            pstmtUpdateSender.executeUpdate();

                            String queryUpdateRecipient = "UPDATE bankdetails SET balance=balance+? WHERE accountnum=?";
                            PreparedStatement pstmtUpdateRecipient = connection.prepareStatement(queryUpdateRecipient);
                            pstmtUpdateRecipient.setInt(1, amountToTransfer);
                            pstmtUpdateRecipient.setString(2, receiver1);
                            pstmtUpdateRecipient.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Transaction successful!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong pin");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Receiver account not found");
                }

                rs2.close();
                pstmtSelect2.close();
                rs.close();
                pstmtSelect.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
}
	
}
