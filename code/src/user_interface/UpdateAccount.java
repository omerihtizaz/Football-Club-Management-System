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
import javax.swing.SwingConstants;

import businesslogic.AccountantController;
import businesslogic.Account;
import businesslogic.Player;
import javax.swing.ImageIcon;

public class UpdateAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Player_ID;
	private JTextField duedate;
	private JTextField Discount;
	private JTextField Paid;
	private JTextField Payment_Date;
	public Player playerlist[];
	public Account accounts[];
	public int countaccounts;
	public int countplayers;
	
	/**
	 * Launch the application.
	 */
	public void updateaccountmain(Player plist[], Account acc[], int acount, int pcount ) {
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
					UpdateAccount frame = new UpdateAccount();
					frame.updateaccount(playerlist, accounts, countaccounts, countplayers);
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
	public void updateaccount(Player plist[], Account acc[], int acount, int pcount) {
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
		
		JLabel lblNewLabel = new JLabel("UPDATE ACCOUNT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 35, 458, 20);
		contentPane.add(lblNewLabel);
		
		JLabel p_id = new JLabel("Player ID");
		p_id.setFont(new Font("Tahoma", Font.BOLD, 12));
		p_id.setForeground(new Color(240, 255, 240));
		p_id.setBounds(79, 97, 62, 14);
		contentPane.add(p_id);
		
		Player_ID = new JTextField();
		Player_ID.setBounds(184, 94, 148, 20);
		contentPane.add(Player_ID);
		Player_ID.setColumns(10);
		
		JLabel pack = new JLabel("Due Date");
		pack.setFont(new Font("Tahoma", Font.BOLD, 12));
		pack.setForeground(new Color(240, 255, 240));
		pack.setBounds(79, 132, 80, 14);
		contentPane.add(pack);
		
		duedate = new JTextField();
		duedate.setBounds(184, 129, 148, 20);
		contentPane.add(duedate);
		duedate.setColumns(10);
		
		JLabel fee = new JLabel("Discount");
		fee.setFont(new Font("Tahoma", Font.BOLD, 12));
		fee.setForeground(new Color(240, 255, 240));
		fee.setBounds(79, 163, 80, 14);
		contentPane.add(fee);
		
		Discount = new JTextField();
		Discount.setBounds(184, 160, 148, 20);
		contentPane.add(Discount);
		Discount.setColumns(10);
		
		JLabel paid = new JLabel("Paid");
		paid.setFont(new Font("Tahoma", Font.BOLD, 12));
		paid.setForeground(new Color(240, 255, 240));
		paid.setBounds(79, 200, 46, 14);
		contentPane.add(paid);
		
		Paid = new JTextField();
		Paid.setBounds(184, 197, 148, 20);
		contentPane.add(Paid);
		Paid.setColumns(10);
		
		JLabel payment= new JLabel("Payment Date");
		payment.setFont(new Font("Tahoma", Font.BOLD, 12));
		payment.setForeground(new Color(240, 255, 240));
		payment.setBounds(79, 239, 95, 14);
		contentPane.add(payment);
		
		Payment_Date = new JTextField();
		Payment_Date.setBounds(184, 236, 148, 20);
		contentPane.add(Payment_Date);
		Payment_Date.setColumns(10);

		
		JButton btnNewButton = new JButton("UPDATE ACCOUNT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = Player_ID.getText();
				String ddate = duedate.getText();
				String dis = Discount.getText();
				String is_paid = Paid.getText();
				String pay_date = Payment_Date.getText();
				
				AccountantController accon = new AccountantController();
				String checksuccess = accon.UpdateAccount(playerlist, accounts, countplayers, countaccounts, id, ddate, dis, is_paid, pay_date);
				if(checksuccess.equals("player found")) {
					JOptionPane.showMessageDialog(rootPane, "SUCCESS: PLAYER " + id + " ACCOUNT HAS BEEN UPDATED\nNOTE: confirm from SQL/Search");
				}
				else if(checksuccess.equals("player not found")) {
					JOptionPane.showMessageDialog(rootPane, "ERROR : PLAYER " + id + " NOT FOUND");
				}
				
			}
		});
		btnNewButton.setBounds(184, 331, 127, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountantHome acchome = new AccountantHome();
				acchome.displayAccountantHome(playerlist, accounts, countaccounts, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\FreeVector-Green-Abstract-Background.jpg"));
		lblNewLabel_1.setBounds(0, -70, 478, 512);
		contentPane.add(lblNewLabel_1);
	}
	public UpdateAccount() {
		
	}
}
