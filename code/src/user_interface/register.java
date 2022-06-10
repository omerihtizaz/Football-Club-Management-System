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
import javax.swing.JRadioButton;
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

class register extends JFrame  {
	
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
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;
	
	/**
	 * Launch the application.
	 */
	public void registerplayermain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
					register frame = new register();
					frame.registerplayer(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public register() {
	}
	public void registerplayer(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
		setBounds(100, 100, 494, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER NEW PLAYER");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(89, 12, 289, 20);
		contentPane.add(lblNewLabel);
		
		Age_Field = new JTextField();
		Age_Field.setBounds(184, 129, 259, 20);
		contentPane.add(Age_Field);
		Age_Field.setColumns(10);
		
		JLabel Name = new JLabel("Enter Name");
		Name.setForeground(new Color(240, 255, 240));
		Name.setBounds(39, 69, 84, 16);
		contentPane.add(Name);
		
		JLabel CNIC = new JLabel("CNIC");
		CNIC.setForeground(new Color(240, 255, 240));
		CNIC.setBounds(39, 104, 55, 16);
		contentPane.add(CNIC);
		
		JLabel Age = new JLabel("Age");
		Age.setForeground(new Color(240, 255, 240));
		Age.setBounds(39, 131, 55, 16);
		contentPane.add(Age);
		
		JLabel Address = new JLabel("Address");
		Address.setForeground(new Color(240, 255, 240));
		Address.setBounds(39, 162, 55, 16);
		contentPane.add(Address);
		
		JLabel PhoneNo = new JLabel("Phone Number");
		PhoneNo.setForeground(new Color(240, 255, 240));
		PhoneNo.setBounds(39, 193, 94, 16);
		contentPane.add(PhoneNo);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setForeground(new Color(240, 255, 240));
		Gender.setBounds(39, 225, 94, 16);
		contentPane.add(Gender);
		
		Name_Field = new JTextField();
		Name_Field.setColumns(10);
		Name_Field.setBounds(184, 67, 259, 20);
		contentPane.add(Name_Field);
		
		CNIC_Field = new JTextField();
		CNIC_Field.setColumns(10);
		CNIC_Field.setBounds(184, 98, 259, 20);
		contentPane.add(CNIC_Field);
		
		Addr_Field = new JTextField();
		Addr_Field.setColumns(10);
		Addr_Field.setBounds(184, 160, 259, 20);
		contentPane.add(Addr_Field);
		
		Phone_Field = new JTextField();
		Phone_Field.setColumns(10);
		Phone_Field.setBounds(184, 191, 259, 20);
		contentPane.add(Phone_Field);
		
		Gender_Field = new JTextField();
		Gender_Field.setColumns(10);
		Gender_Field.setBounds(184, 223, 259, 20);
		contentPane.add(Gender_Field);
		
		rdbtnNewRadioButton = new JRadioButton("Package 1");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.setBounds(39, 311, 121, 24);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Package 2");
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setOpaque(false);
		rdbtnNewRadioButton_1.setBounds(188, 311, 94, 24);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Package 3");
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setOpaque(false);
		rdbtnNewRadioButton_2.setBounds(322, 311, 121, 24);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Choose a training package:");
		lblNewLabel_6.setForeground(new Color(240, 255, 240));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_6.setBounds(41, 287, 211, 16);
		contentPane.add(lblNewLabel_6);
		
		
		final JLabel Output = new JLabel("");
		Output.setBounds(76, 414, 296, 16);
		contentPane.add(Output);
	
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String name = Name_Field.getText();
				String age = Age_Field.getText();
				String phone = Phone_Field.getText();
				String addr = Addr_Field.getText();
				String cnic = CNIC_Field.getText();
				String gender = Gender_Field.getText();
				String pack_id = "0";
				int packid = 0;
				//set package ID based on the chosen choice of receptionist
				if(rdbtnNewRadioButton.isSelected()) {
					pack_id = "1";
					packid = 0;
				}
				if(rdbtnNewRadioButton_1.isSelected()) {
					pack_id = "2";
					packid = 1;
				}
				if(rdbtnNewRadioButton_2.isSelected()) {
					pack_id = "3";
					packid = 2;
				}
				//call the register player function in receptionist
				ReceptionController rcp = new ReceptionController();
				playerlist = rcp.registerplayer(name, age, cnic, addr, phone, gender, pack_id, playerlist, countplayers, packlist);
				countplayers++;

				//Display that new player has been registered
				JOptionPane.showMessageDialog(rootPane,"NEW PLAYER REGISTERED - NAME: " + name );
				String displayinvoice = "NEW PLAYER ID: " + playerlist[countplayers-1].GetPlayer_ID() + " - FEE: " + packlist[packid].getPackagePrice();
				JOptionPane.showMessageDialog(rootPane, displayinvoice );				
			}
		});
		btnNewButton.setBounds(184, 362, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				staffhome.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.GRAY);
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
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(0, 0, 67, 26);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-geometric-wallpaper-background-vector-21931375.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 442);
		contentPane.add(lblNewLabel_1);

		
	}
}

