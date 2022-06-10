package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;
import javax.swing.ImageIcon;

public class AdminHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public PlayerProfile profilelist[];
	public TeamPlayer League_Players[];
	public TeamPlayer Tournament_Players[];
	public Schedule schedule[];
	public SeasonReview seasonreview;
	public int countschedule;
	public int countplayers;

	/**
	 * Launch the application.
	 */
	public void displayAdminHome(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					AdminHome frame = new AdminHome();
					frame.adminhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void adminhome(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN HOME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel.setBounds(124, 48, 186, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("close");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Schedule");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateSchedule upd = new UpdateSchedule();
				upd.updateschedulemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setBounds(110, 151, 214, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Schedule");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "admin";
				ViewSchedule vwsch = new ViewSchedule();
				vwsch.viewschedulemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_2.setBounds(110, 185, 214, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Training Session/Tournament");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ScheduleTrainingOrTournament sch = new ScheduleTrainingOrTournament();
				sch.ScheduleTrainingSessionOrTournamentMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_3.setBounds(110, 117, 214, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete Schedule");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSchedule delsch = new DeleteSchedule();
				delsch.DeleteScheduleMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_4.setBounds(110, 219, 214, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\41b7aadf30cc1e476ef32f2b8096153d.jpg"));
		lblNewLabel_1.setBounds(-113, 0, 547, 380);
		contentPane.add(lblNewLabel_1);
	
			
	}
	public AdminHome() {
	
	}
}
