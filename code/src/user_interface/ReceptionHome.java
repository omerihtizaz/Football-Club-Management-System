package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import businesslogic.Coach;
import businesslogic.Packages;
import businesslogic.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ReceptionHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;
	
	/**
	 * Launch the application.
	 */
	public void displayReceptionHome(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
					ReceptionHome frame = new ReceptionHome();
					frame.CreateReceptionHome(packlist, playerlist, coachlist,countplayers, coachcount);
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
	public ReceptionHome() {	

	}
	public void CreateReceptionHome(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECEPTION HOME");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 24, 200, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose what you want to do");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(118, 68, 183, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton register = new JButton("Register New Player");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register registernewplayer = new register();
				registernewplayer.registerplayermain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		register.setBounds(122, 140, 179, 23);
		contentPane.add(register);
		
		JButton AddCoachManager = new JButton("Add Coach/Manager");
		AddCoachManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCoachOrManager addCorM = new AddCoachOrManager();
				addCorM.addcoachormanagermain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		AddCoachManager.setBounds(122, 208, 179, 23);
		contentPane.add(AddCoachManager);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchStaff search = new searchStaff();
				search.searchstaffmain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton.setBounds(122, 106, 179, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUser deluser = new DeleteUser();
				deluser.deleteusermain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_1.setBounds(122, 174, 179, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Player Information");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdatePlayer uplayer = new UpdatePlayer();
				uplayer.UpdatePlayerMain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_3.setBounds(122, 242, 179, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Coach/Manager Information");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateCoachOrManager ucm = new UpdateCoachOrManager();
				ucm.UpdateCoachOrManagerMain(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_4.setBounds(122, 276, 179, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\41b7aadf30cc1e476ef32f2b8096153d.jpg"));
		lblNewLabel_2.setBounds(-64, -35, 526, 467);
		contentPane.add(lblNewLabel_2);
		
	
	}
}
