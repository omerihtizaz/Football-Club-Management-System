package user_interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businesslogic.Account;
import businesslogic.Player;
import businesslogic.AccountantController;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewAccounts extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField player_ID;
	public Player playerlist[];
	public Account accounts[];
	public int countaccounts;
	public int countplayers;

	/**
	 * Launch the application.
	 */
	public void viewaccountsmain(Player plist[], Account acc[], int acount, int pcount) {
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
					ViewAccounts frame = new ViewAccounts();
					frame.viewaccounts(playerlist, accounts, countaccounts, countplayers);
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
	public void viewaccounts(Player plist[], Account acc[], int acount, int pcount) {
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
		setBounds(100, 100, 494, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 168, 278, 236);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton_3 = new JButton("Search all unpaid");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				AccountantController accon = new AccountantController();
				String display = accon.ViewUnpaidAccounts(accounts, countaccounts);
				textArea.setText(display);
			}
		});
		btnNewButton_3.setBounds(166, 125, 140, 23);
		contentPane.add(btnNewButton_3);
	
		JLabel lblNewLabel = new JLabel("ACCOUNT DETAILS");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(131, 33, 289, 20);
		contentPane.add(lblNewLabel);
		
		player_ID = new JTextField();
		player_ID.setBounds(144, 81, 177, 20);
		contentPane.add(player_ID);
		player_ID.setColumns(10);
		
		JLabel account = new JLabel("ID/DATE");
		account.setFont(new Font("Tahoma", Font.BOLD, 12));
		account.setForeground(new Color(240, 255, 240));
		account.setBounds(63, 81, 82, 18);
		contentPane.add(account);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String playerID = player_ID.getText();
				AccountantController accon = new AccountantController();
				String display = accon.ViewAccount(accounts, countaccounts, playerID);
				textArea.setText(display);
			}
		});
		btnNewButton.setBounds(342, 80, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AccountantHome acchome = new AccountantHome();
				acchome.displayAccountantHome(playerlist, accounts, countaccounts, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-geometric-wallpaper-background-vector-21931375.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 442);
		contentPane.add(lblNewLabel_1);
	}
	public ViewAccounts() {
	}
}
