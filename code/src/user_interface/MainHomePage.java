package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainHomePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public void displayMainHome() {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHomePage frame = new MainHomePage();
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
	public MainHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("OMEGA FOOTBALL CLUB");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Stencil", Font.BOLD, 33));
		lblNewLabel_3.setBounds(0, 85, 434, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 44, 434, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reception");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton.setBounds(54, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Player");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton_1.setBounds(54, 192, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton_2.setBounds(187, 158, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Accountant");
	
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton_3.setBounds(187, 192, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Coach");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton_4.setBounds(314, 158, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Manager");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login lg = new login();
				lg.authorizelogin();
				dispose();
			}
		});
		btnNewButton_5.setBounds(314, 192, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your designation");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(133, 122, 212, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("Close");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_6.setForeground(new Color(192, 192, 192));
		btnNewButton_6.setBackground(new Color(47, 79, 79));
		btnNewButton_6.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\soccer-stadium-vector-illustration_44392-203.jpg"));
		lblNewLabel_2.setBounds(-91, -85, 525, 355);
		contentPane.add(lblNewLabel_2);
		
	}
}
