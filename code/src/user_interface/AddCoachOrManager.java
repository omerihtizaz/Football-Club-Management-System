package user_interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import businesslogic.*;
import javax.swing.ImageIcon;

public class AddCoachOrManager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField CNIC;
	private JTextField Email;
	private JTextField Phone;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;

	/**
	 * Launch the application.
	 */
	public void addcoachormanagermain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
					AddCoachOrManager frame = new AddCoachOrManager();
					frame.CreateCoachManager(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public AddCoachOrManager() {
	}
	
	public void CreateCoachManager(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD COACH/MANAGER");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(86, 38, 289, 20);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setForeground(new Color(240, 255, 240));
		name.setBounds(79, 97, 46, 14);
		contentPane.add(name);
		
		Name = new JTextField();
		Name.setBounds(194, 95, 181, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel cnic = new JLabel("CNIC");
		cnic.setFont(new Font("Tahoma", Font.BOLD, 12));
		cnic.setForeground(new Color(240, 255, 240));
		cnic.setBounds(79, 131, 46, 14);
		contentPane.add(cnic);
		
		CNIC = new JTextField();
		CNIC.setBounds(194, 129, 181, 20);
		contentPane.add(CNIC);
		CNIC.setColumns(10);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setForeground(new Color(240, 255, 240));
		email.setBounds(79, 169, 46, 14);
		contentPane.add(email);
		
		Email = new JTextField();
		Email.setBounds(194, 167, 181, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel phone= new JLabel("Phone Number");
		phone.setFont(new Font("Tahoma", Font.BOLD, 12));
		phone.setForeground(new Color(240, 255, 240));
		phone.setBounds(79, 205, 95, 14);
		contentPane.add(phone);
		
		Phone = new JTextField();
		Phone.setBounds(194, 203, 181, 20);
		contentPane.add(Phone);
		Phone.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("ADD COACH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = Name.getText();
				String c = CNIC.getText();
				String ph = Phone.getText();
				String em = Email.getText();
				
				ReceptionController rcpcon = new ReceptionController();
				coachlist = rcpcon.AddCoach(n, c, ph, em, coachlist, coachcount);
				int i = 0;
				int checkcoachcount = 0;
				while(coachlist[i].GetCoachID()!= "") {
					i++;
					checkcoachcount++;
				}
				if(checkcoachcount > coachcount) {
					JOptionPane.showMessageDialog(rootPane, "Coach " + coachlist[checkcoachcount-1].GetCoachID() + " has been successfully added");
					coachcount++;
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ERROR: Coach not added");
				}
			}
		});
		btnNewButton.setBounds(79, 329, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD MANAGER");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = Name.getText();
				String c = CNIC.getText();
				String ph = Phone.getText();
				String em = Email.getText();
				ReceptionController rcpcon = new ReceptionController();
				rcpcon.AddManager(n, c, ph, em);
				JOptionPane.showMessageDialog(rootPane, "Manager " + n + " added. Please confirm operation success from SQL");
			}
		});
		btnNewButton_1.setBounds(262, 329, 135, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("Close");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.GRAY);
		btnNewButton_2_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-geometric-wallpaper-background-vector-21931375.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 442);
		contentPane.add(lblNewLabel_1);
		
	
	}
}

