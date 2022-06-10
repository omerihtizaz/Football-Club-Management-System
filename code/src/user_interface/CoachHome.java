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
import businesslogic.*;
import javax.swing.ImageIcon;

public class CoachHome extends JFrame {

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
	public void displaycoachhome( SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {		
		
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
					CoachHome frame = new CoachHome();
					frame.CreateCoachHome( seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void CreateCoachHome( SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COACH HOME PAGE");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(82, 25, 270, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update Player Profile");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerprofile profile = new playerprofile();
				profile.playerprofilemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton.setBounds(34, 108, 167, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Write Season Review");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateSeasonReview ssnrvw = new CreateSeasonReview();
				ssnrvw.CreateSeasonReviewMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setBounds(34, 174, 167, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Player Profile");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewPlayerProfile vplprofile = new ViewPlayerProfile();
				String returndest = "coach";
				vplprofile.viewplayerprofilemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
				dispose();
			}
		});
		btnNewButton_2.setBounds(254, 85, 138, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Teams");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewTeams vwteam = new ViewTeams();
				String returnd = "coach";
				vwteam.ViewTeamsMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_3.setBounds(254, 119, 138, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Season Review");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewSeasonReview viewssnrvw = new ViewSeasonReview();
				String returnd = "coach";
				viewssnrvw.viewseasonreviewmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_4.setBounds(254, 153, 138, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("close");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View Schedule");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewSchedule vwsch = new ViewSchedule();
				String returnd = "coach";
				vwsch.viewschedulemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_6.setBounds(254, 185, 138, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("View Feedback");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "coach";
				ViewFeedback vwfb = new ViewFeedback();
				vwfb.viewfeedbackmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_7.setBounds(254, 219, 138, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\resize.png"));
		lblNewLabel_1.setBounds(-18, 0, 452, 450);
		contentPane.add(lblNewLabel_1);
	}
	public CoachHome() {	
		
	}
}
