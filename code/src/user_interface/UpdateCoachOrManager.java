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
import businesslogic.ReceptionController;
import businesslogic.Player;
import businesslogic.Coach;
import businesslogic.Packages;
import javax.swing.ImageIcon;

public class UpdateCoachOrManager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField CNIC;
	private JTextField ID;
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
	public void UpdateCoachOrManagerMain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
					UpdateCoachOrManager frame = new UpdateCoachOrManager();
					frame.CreateUpdateCM(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public UpdateCoachOrManager() {
	}
	public void CreateUpdateCM(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
		setBounds(100, 100, 494, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE COACH/MANAGER");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(64, 40, 361, 20);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setForeground(new Color(240, 255, 240));
		name.setBounds(79, 145, 46, 14);
		contentPane.add(name);
		
		Name = new JTextField();
		Name.setBounds(184, 143, 188, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel cnic = new JLabel("CNIC");
		cnic.setFont(new Font("Tahoma", Font.BOLD, 12));
		cnic.setForeground(new Color(240, 255, 240));
		cnic.setBounds(79, 176, 46, 14);
		contentPane.add(cnic);
		
		CNIC = new JTextField();
		CNIC.setBounds(184, 174, 188, 20);
		contentPane.add(CNIC);
		CNIC.setColumns(10);
		
		JLabel id = new JLabel("Enter ID");
		id.setFont(new Font("Tahoma", Font.BOLD, 12));
		id.setForeground(new Color(240, 255, 240));
		id.setBounds(79, 95, 57, 14);
		contentPane.add(id);
		
		ID = new JTextField();
		ID.setBounds(184, 93, 188, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setForeground(new Color(240, 255, 240));
		email.setBounds(79, 207, 46, 14);
		contentPane.add(email);
		
		Email = new JTextField();
		Email.setBounds(184, 205, 188, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JLabel phone= new JLabel("Phone Number");
		phone.setFont(new Font("Tahoma", Font.BOLD, 12));
		phone.setForeground(new Color(240, 255, 240));
		phone.setBounds(79, 239, 95, 14);
		contentPane.add(phone);
		
		Phone = new JTextField();
		Phone.setBounds(184, 236, 188, 20);
		contentPane.add(Phone);
		Phone.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE COACH");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String NAME = Name.getText();
				String EMAIL = Email.getText();
				String ID_1 = ID.getText();
				String Phone_NO = Phone.getText();
				String CNIC_1 = CNIC.getText();
				
				ReceptionController rcpcon = new ReceptionController();
				rcpcon.UpdateCoach(ID_1, NAME, CNIC_1, Phone_NO, EMAIL, coachlist, coachcount);
				JOptionPane.showMessageDialog(rootPane, "If coach id was correct record has been inserted\nNOTE: confirm success from SQL/Search");
				
			}
		});
		btnNewButton.setBounds(79, 333, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE MANAGER");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String NAME = Name.getText();
				String EMAIL = Email.getText();
				String ID_1 = ID.getText();
				String Phone_NO = Phone.getText();
				String CNIC_1 = CNIC.getText();

				ReceptionController rcpcon = new ReceptionController();
				rcpcon.UpdateManager(ID_1, NAME, CNIC_1, Phone_NO, EMAIL);
				JOptionPane.showMessageDialog(rootPane, "If manager id was correct record has been inserted\nNOTE: confirm success from SQL/Search");
			}
		});
		btnNewButton_1.setBounds(268, 333, 143, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_3.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\171783-abstract-green-fluid-color-gradient-geometric-shapes-composition-background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 399);
		contentPane.add(lblNewLabel_1);
		
	}

}
