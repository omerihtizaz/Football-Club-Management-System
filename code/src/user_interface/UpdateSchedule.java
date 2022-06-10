package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;
import businesslogic.AdminController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class UpdateSchedule extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField oldtime;
	private JTextField olddate;
	private JTextField oldvenue;
	private JTextField newtime;
	private JTextField newdate;
	private JTextField newvenue;
	private JTextField coach;
	public PlayerProfile profilelist[];
	public TeamPlayer League_Players[];
	public TeamPlayer Tournament_Players[];
	public Schedule schedule[];
	public SeasonReview seasonreview;
	public int countschedule;
	public int countplayers;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void updateschedulemain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
		profilelist = new PlayerProfile[100];
		for(int i = 0 ; i < 100 ; i++) {
			profilelist[i] = new PlayerProfile();
		}
		profilelist = pro;
		League_Players = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			League_Players[i] = new TeamPlayer();
		}
		League_Players = leag;
		Tournament_Players = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			Tournament_Players[i] = new TeamPlayer();
		}
		Tournament_Players = tour;
		schedule = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		seasonreview = new SeasonReview();
		seasonreview = ssnrvw;
		countplayers = cp;
		countschedule = cs;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSchedule frame = new UpdateSchedule();
					frame.updateschedule(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void updateschedule(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
		profilelist = new PlayerProfile[100];
		for(int i = 0 ; i < 100 ; i++) {
			profilelist[i] = new PlayerProfile();
		}
		profilelist = pro;
		League_Players = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			League_Players[i] = new TeamPlayer();
		}
		League_Players = leag;
		Tournament_Players = new TeamPlayer[11];
		for(int i = 0 ; i < 11 ; i++) {
			Tournament_Players[i] = new TeamPlayer();
		}
		Tournament_Players = tour;
		schedule = new Schedule[50];
		for(int i = 0 ; i < 50 ; i++) {
			schedule[i] = new Schedule();
		}
		schedule = sch;
		seasonreview = new SeasonReview();
		seasonreview = ssnrvw;
		countplayers = cp;
		countschedule = cs;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(312, 233, 89, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Details");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(240, 233, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel = new JLabel("Update Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(123, 27, 226, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton =new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminHome adhome = new AdminHome();
				adhome.displayAdminHome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(362, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Old Time");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(38, 101, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Old Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(38, 138, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Old Venue");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(38, 174, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		oldtime= new JTextField();
		oldtime.setBounds(123, 98, 86, 20);
		contentPane.add(oldtime);
		oldtime.setColumns(10);
		
		olddate = new JTextField();
		olddate.setBounds(123, 135, 86, 20);
		contentPane.add(olddate);
		olddate.setColumns(10);
		
		oldvenue = new JTextField();
		oldvenue.setBounds(123, 171, 86, 20);
		contentPane.add(oldvenue);
		oldvenue.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New Time");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(240, 101, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(240, 138, 55, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New Venue");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(240, 174, 65, 14);
		contentPane.add(lblNewLabel_6);
		
		newtime = new JTextField();
		newtime.setBounds(315, 98, 86, 20);
		contentPane.add(newtime);
		newtime.setColumns(10);
		
		newdate = new JTextField();
		newdate.setBounds(315, 135, 86, 20);
		contentPane.add(newdate);
		newdate.setColumns(10);
		
		newvenue = new JTextField();
		newvenue.setBounds(315, 171, 86, 20);
		contentPane.add(newvenue);
		newvenue.setColumns(10);
		
		coach = new JTextField();
		coach.setBounds(315, 202, 86, 20);
		contentPane.add(coach);
		coach.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Coach");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(240, 205, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ot = oldtime.getText();
				String od = olddate.getText();
				String ov = oldvenue.getText();
				String nt = newtime.getText();
				String nd = newdate.getText();
				String nv = newvenue.getText();
				String det = textField.getText();
				String c = coach.getText();
				
				AdminController adcon = new AdminController();
				schedule = adcon.UpdateSchedule(ot, od, ov, nd, nt, nv, c,det, schedule, countschedule);
				JOptionPane.showMessageDialog(rootPane, "Schedule Updated\nNOTE: Confirm operation success through search/SQL");
			}
		});
		btnNewButton_2.setBounds(167, 298, 100, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-shapes-green-background_23-2148358212.jpg"));
		lblNewLabel_8.setBounds(0, 0, 466, 332);
		contentPane.add(lblNewLabel_8);
	
	}
	public UpdateSchedule() {

	}
	

}
