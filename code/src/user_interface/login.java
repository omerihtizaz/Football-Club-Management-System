package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import businesslogic.ContainerClass;
import javax.swing.ImageIcon;

class login extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Password_Field;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public void authorizelogin() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 102, 76));
		contentPane.setForeground(new Color(30, 102, 76));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(184, 61, 89, 20);
		contentPane.add(lblNewLabel);
		
		JLabel Password = new JLabel("Enter Password");
		Password.setFont(new Font("Tahoma", Font.BOLD, 12));
		Password.setForeground(new Color(240, 255, 240));
		Password.setBounds(39, 176, 127, 16);
		contentPane.add(Password);      
		
		JLabel ID = new JLabel("Enter ID");
		ID.setFont(new Font("Tahoma", Font.BOLD, 12));
		ID.setForeground(new Color(240, 255, 240));
		ID.setBounds(39, 123, 127, 16);
		contentPane.add(ID);
		
		Password_Field  = new JPasswordField();   
		Password_Field.setColumns(10);
		Password_Field.setBounds(184, 174, 259, 20);
		contentPane.add(Password_Field);
		Password_Field.setLayout(null);    
		Password_Field.setVisible(true);  
		
		
		textField = new JTextField();
		textField.setBounds(181, 121, 262, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		final JLabel Output = new JLabel("");
		Output.setBounds(76, 388, 296, 16);
		contentPane.add(Output);
	
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String data = Password_Field.getText();
				String storeid = textField.getText();
				ContainerClass passwordcheck = new ContainerClass();
				String getAuthorization = passwordcheck.checkpassword( storeid, data);
				if (getAuthorization == "done") {
					dispose();
				}
				else if(getAuthorization == "incorrect")
					JOptionPane.showMessageDialog(rootPane, "Password is incorrect. \n ACCESS DENIED");
			}
		});
		btnNewButton.setBounds(184, 292, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Program");
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-background-with-halftone-effect-squares_23-2148661430.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 372);
		contentPane.add(lblNewLabel_1);
	}
}
