package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.ReceptionController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import businesslogic.Coach;
import businesslogic.Packages;
import businesslogic.Player;
import javax.swing.ImageIcon;

class UpdatePlayer extends JFrame  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Age_Field;
	private JTextField Name_Field;
	private JTextField CNIC_Field;
	private JTextField Addr_Field;
	private JTextField Phone_Field;
	private JTextField Gender_Field;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public void UpdatePlayerMain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
		packlist = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		packlist = pklist;
		playerlist = new Player[100];
			for(int i = 0 ; i < 100; i++) {
				playerlist[i] = new Player();
			}
		playerlist = pllist;
		coachlist = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		countplayers = pcount;
		coachcount = ccount;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePlayer frame = new UpdatePlayer();
					frame.updateplayer(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public UpdatePlayer() {
	}
	public void updateplayer(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
		packlist = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		packlist = pklist;
		playerlist = new Player[100];
			for(int i = 0 ; i < 100; i++) {
				playerlist[i] = new Player();
			}
		playerlist = pllist;
		coachlist = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		countplayers = pcount;
		coachcount = ccount;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PLAYER INFORMATION");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(43, 37, 386, 37);
		contentPane.add(lblNewLabel);
		
		Age_Field = new JTextField();
		Age_Field.setBounds(184, 178, 259, 20);
		contentPane.add(Age_Field);
		Age_Field.setColumns(10);
		
		JLabel Name = new JLabel("Enter Name");
		Name.setForeground(new Color(255, 255, 255));
		Name.setBounds(39, 118, 84, 16);
		contentPane.add(Name);
		
		JLabel CNIC = new JLabel("CNIC");
		CNIC.setForeground(new Color(255, 255, 255));
		CNIC.setBounds(39, 153, 55, 16);
		contentPane.add(CNIC);
		
		JLabel Age = new JLabel("Age");
		Age.setForeground(new Color(255, 255, 255));
		Age.setBounds(39, 180, 55, 16);
		contentPane.add(Age);
		
		JLabel Address = new JLabel("Address");
		Address.setForeground(new Color(255, 255, 255));
		Address.setBounds(39, 211, 55, 16);
		contentPane.add(Address);
		
		JLabel PhoneNo = new JLabel("Phone Number");
		PhoneNo.setForeground(new Color(255, 255, 255));
		PhoneNo.setBounds(39, 242, 94, 16);
		contentPane.add(PhoneNo);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setForeground(new Color(255, 255, 255));
		Gender.setBounds(39, 273, 94, 16);
		contentPane.add(Gender);
		
		Name_Field = new JTextField();
		Name_Field.setColumns(10);
		Name_Field.setBounds(184, 116, 259, 20);
		contentPane.add(Name_Field);
		
		CNIC_Field = new JTextField();
		CNIC_Field.setColumns(10);
		CNIC_Field.setBounds(184, 147, 259, 20);
		contentPane.add(CNIC_Field);
		
		Addr_Field = new JTextField();
		Addr_Field.setColumns(10);
		Addr_Field.setBounds(184, 209, 259, 20);
		contentPane.add(Addr_Field);
		
		Phone_Field = new JTextField();
		Phone_Field.setColumns(10);
		Phone_Field.setBounds(184, 240, 259, 20);
		contentPane.add(Phone_Field);
		
		Gender_Field = new JTextField();
		Gender_Field.setColumns(10);
		Gender_Field.setBounds(184, 271, 259, 20);
		contentPane.add(Gender_Field);
	
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				String id = textField.getText();
				String name = Name_Field.getText();
				String age = Age_Field.getText();
				String phone = Phone_Field.getText();
				String addr = Addr_Field.getText();
				String cnic = CNIC_Field.getText();
				String gender = Gender_Field.getText();
				
				ReceptionController rcp = new ReceptionController();
				rcp.UpdatePlayer(id, name, age, cnic, addr, phone, gender, playerlist, countplayers);
				JOptionPane.showMessageDialog(rootPane, "If player id was correct record has been inserted\nNOTE: confirm success from SQL/Search");	
				
			}
		});
		btnNewButton.setBounds(184, 338, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(411, 0, 67, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Close");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1.setBounds(0, 0, 67, 26);
		contentPane.add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setBounds(184, 85, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(39, 93, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\171783-abstract-green-fluid-color-gradient-geometric-shapes-composition-background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 478, 391);
		contentPane.add(lblNewLabel_2);
	}
}

