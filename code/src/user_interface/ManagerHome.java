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
import javax.swing.border.EmptyBorder;

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;
import javax.swing.ImageIcon;

public class ManagerHome extends JFrame {

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
	public void displaymanagerhome(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					ManagerHome frame = new ManagerHome();
					frame.managerhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void managerhome(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 450, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGER HOME PAGE");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(97, 34, 260, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("View Player Profile");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "manager";
				ViewPlayerProfile vwpl = new ViewPlayerProfile();
				vwpl.viewplayerprofilemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_2.setBounds(132, 81, 166, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Teams");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "manager";
				ViewTeams vwtm = new ViewTeams();
				vwtm.ViewTeamsMain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_3.setBounds(132, 126, 166, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Season Reviews");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "manager";
				ViewSeasonReview vwssn = new ViewSeasonReview();
				vwssn.viewseasonreviewmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_4.setBounds(132, 170, 166, 23);
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
		
		JButton btnNewButton = new JButton("Update Team");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTeam uptm = new UpdateTeam();
				uptm.updateteammain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton.setBounds(132, 214, 166, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Schedule");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "manager";
				ViewSchedule vwsch = new ViewSchedule();
				vwsch.viewschedulemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_1.setBounds(132, 258, 166, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("View Feedback");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String returnd = "manager";
				ViewFeedback vwfb = new ViewFeedback();
				vwfb.viewfeedbackmain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returnd);
				dispose();
			}
		});
		btnNewButton_6.setBounds(132, 297, 166, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\resize.png"));
		lblNewLabel_1.setBounds(0, -23, 451, 433);
		contentPane.add(lblNewLabel_1);
	}
	public ManagerHome() {
		
	}

}


