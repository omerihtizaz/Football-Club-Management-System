package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PlayerHome extends JFrame {

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
	public void playerhomemain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					PlayerHome frame = new PlayerHome();
					frame.playerhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void playerhome(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("close");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("PLAYER HOME PAGE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 34, 414, 34);
		contentPane.add(lblNewLabel);
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("View Team");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewTeams vwteam = new ViewTeams();
				String returnd = "player";
				vwteam.ViewTeamsMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_3.setBounds(132, 128, 166, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Schedule");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewSchedule vwsch = new ViewSchedule();
				String returnd = "player";
				vwsch.viewschedulemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_4.setBounds(132, 162, 166, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Give Feedback");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GiveFeedback gfb = new GiveFeedback();
				gfb.givefeedbackmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_6.setBounds(132, 232, 166, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("View Player Profiles");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewPlayerProfile vplprofile = new ViewPlayerProfile();
				String returndest = "player";
				vplprofile.viewplayerprofilemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
				dispose();
			}
		});
		btnNewButton_1.setBounds(132, 94, 166, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("View Season Review");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewSeasonReview viewssnrvw = new ViewSeasonReview();
				String returnd = "player";
				viewssnrvw.viewseasonreviewmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton.setBounds(132, 198, 166, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\abstract-colorful-flow-shapes-background_23-2148220472.jpg"));
		lblNewLabel_1.setBounds(0, -30, 529, 407);
		contentPane.add(lblNewLabel_1);
	}
	public PlayerHome() {
	}
}

