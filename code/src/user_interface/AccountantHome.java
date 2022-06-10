package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.Account;
import businesslogic.Player;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class AccountantHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Player playerlist[];
	public Account accounts[];
	public int countaccounts;
	public int countplayers;

	/**
	 * Launch the application.
	 */
	public void displayAccountantHome(Player plist[], Account acc[], int acount, int pcount) {
		playerlist = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = plist;
		accounts = new Account[150];
		for(int i = 0 ; i < 150 ; i++) {
			accounts[i] = new Account();
		}
		accounts = acc;
		countaccounts = acount;
		countplayers = pcount;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountantHome frame = new AccountantHome();
					frame.accountanthome(playerlist, accounts, countaccounts, countplayers);
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
	public void accountanthome(Player plist[], Account acc[], int acount, int pcount) {
		playerlist = new Player[100];
		for(int i = 0 ; i < 100; i++) {
			playerlist[i] = new Player();
		}
		playerlist = plist;
		accounts = new Account[150];
		for(int i = 0 ; i < 150 ; i++) {
			accounts[i] = new Account();
		}
		accounts = acc;
		countaccounts = acount;
		countplayers = pcount;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accountant Home");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel.setBounds(96, 46, 250, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("close");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Accounts");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateAccount updacc = new UpdateAccount();
				updacc.updateaccountmain(playerlist, accounts, countaccounts, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setBounds(141, 101, 147, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Accounts");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAccounts vwacc = new ViewAccounts();
				vwacc.viewaccountsmain(playerlist, accounts, countaccounts, countplayers);
				dispose();
			}
		});
		btnNewButton_2.setBounds(141, 159, 147, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\41b7aadf30cc1e476ef32f2b8096153d.jpg"));
		lblNewLabel_1.setBounds(-136, 0, 631, 261);
		contentPane.add(lblNewLabel_1);
	}
	
	public AccountantHome() {
	}
}
