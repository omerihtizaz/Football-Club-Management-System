package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import businesslogic.*;
import javax.swing.ImageIcon;


class CreateSeasonReview extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField RunnerUp_Team;
	private JTextField Winning_Team;
	private JTextField Player_of_Season;
	private JTextField RunnerUp_of_Season;
	private JTextField Most_Goals;
	private JTextField Most_Assists;
	private JTextField Honourable_Mentions;
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
	public void CreateSeasonReviewMain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					CreateSeasonReview frame = new CreateSeasonReview();
					frame.createseasonreview(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void createseasonreview(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 494, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(88, 59, 109));
		contentPane.setForeground(new Color(88, 59, 109));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEASON REVIEW");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(134, 28, 210, 20);
		contentPane.add(lblNewLabel);

		JLabel w_team = new JLabel("Winning Team ");
		w_team.setForeground(new Color(240, 255, 240));
		w_team.setBounds(53, 86, 121, 16);
		contentPane.add(w_team);
		
		JLabel r_team = new JLabel("Runner-Up Team");
		r_team.setForeground(new Color(240, 255, 240));
		r_team.setBounds(53, 121, 134, 16);
		contentPane.add(r_team);
		
		JLabel player_of_season = new JLabel("Season's Player");
		player_of_season.setForeground(new Color(240, 255, 240));
		player_of_season.setBounds(53, 156, 148, 16);
		contentPane.add(player_of_season);
		
		JLabel runnerup_of_season = new JLabel("Season's Runner-Up ");
		runnerup_of_season.setForeground(new Color(240, 255, 240));
		runnerup_of_season.setBounds(53, 191, 182, 16);
		contentPane.add(runnerup_of_season);
		
		JLabel goals = new JLabel("Most Goals ");
		goals.setForeground(new Color(240, 255, 240));
		goals.setBounds(53, 226, 121, 16);
		contentPane.add(goals);
		
		JLabel assists = new JLabel("Most Assists ");
		assists.setForeground(new Color(240, 255, 240));
		assists.setBounds(53, 261, 121, 16);
		contentPane.add(assists);
		
		JLabel mentions = new JLabel("Honourable Mentions");
		mentions.setForeground(new Color(240, 255, 240));
		mentions.setBounds(55, 293, 153, 16);
		contentPane.add(mentions);
		
		Winning_Team = new JTextField();
		Winning_Team.setBounds(196, 82, 265, 24);
		contentPane.add(Winning_Team);
		Winning_Team.setColumns(10);
		
		RunnerUp_Team = new JTextField();
		RunnerUp_Team.setColumns(10);
		RunnerUp_Team.setBounds(197, 117, 265, 24);
		contentPane.add(RunnerUp_Team);
		
		RunnerUp_of_Season = new JTextField();
		RunnerUp_of_Season.setColumns(10);
		RunnerUp_of_Season.setBounds(196, 187, 265, 24);
		contentPane.add(RunnerUp_of_Season);
		
		Player_of_Season = new JTextField();
		Player_of_Season.setColumns(10);
		Player_of_Season.setBounds(196, 152, 265, 24);
		contentPane.add(Player_of_Season);
		
		Most_Goals = new JTextField();
		Most_Goals.setColumns(10);
		Most_Goals.setBounds(196, 222, 265, 24);
		contentPane.add(Most_Goals);
		
		Most_Assists = new JTextField();
		Most_Assists.setColumns(10);
		Most_Assists.setBounds(195, 257, 266, 24);
		contentPane.add(Most_Assists);
		
		Honourable_Mentions = new JTextField();
		Honourable_Mentions.setColumns(10);
		Honourable_Mentions.setBounds(196, 292, 265, 42);
		contentPane.add(Honourable_Mentions);
	
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String wteam = Winning_Team.getText();
				String rteam = RunnerUp_Team.getText();
				String pseason = Player_of_Season.getText();
				String rseason = RunnerUp_of_Season.getText();
				String mostg = Most_Goals.getText();
				String mostass =  Most_Assists.getText();
				String honmen =  Honourable_Mentions.getText();
				
				CoachController ccon = new CoachController();
				ccon.createseasonreview(wteam, rteam, pseason, rseason, mostg, mostass, honmen, seasonreview);
				JOptionPane.showMessageDialog(rootPane, "Season Review has been updated. \nNOTE: confirm operation success through SQL/Search");
			}
		});
		btnNewButton.setBounds(179, 378, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CoachHome chome = new CoachHome();
				chome.displaycoachhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(220, 220, 220));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(220, 220, 220));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\FreeVector-Green-Abstract-Background.jpg"));
		lblNewLabel_1.setBounds(0, -92, 478, 534);
		contentPane.add(lblNewLabel_1);
		
	
	}
	public CreateSeasonReview() {
	}
}

