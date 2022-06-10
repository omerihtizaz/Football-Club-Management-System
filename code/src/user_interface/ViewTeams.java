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

import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.ContainerClass;
import businesslogic.TeamPlayer;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ViewTeams extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Update;
	public PlayerProfile profilelist[];
	public TeamPlayer League_Players[];
	public TeamPlayer Tournament_Players[];
	public Schedule schedule[];
	public SeasonReview seasonreview;
	public int countschedule;
	public int countplayers;
	public String returndest;
	

	/**
	 * Launch the application.
	 */
	public void ViewTeamsMain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		returndest = returnd;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeams frame = new ViewTeams();
					frame.viewteams(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
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
	public void viewteams(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		returndest = returnd;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("TEAM DETAILS");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(146, 11, 188, 20);
		contentPane.add(lblNewLabel);
		
		Update = new JTextField();
		Update.setBounds(120, 42, 202, 20);
		contentPane.add(Update);
		Update.setColumns(10);
		
		JLabel team_name = new JLabel("Team Name");
		team_name.setFont(new Font("Tahoma", Font.BOLD, 12));
		team_name.setForeground(new Color(240, 255, 240));
		team_name.setBounds(39, 42, 82, 18);
		contentPane.add(team_name);
		
		final JLabel lblNewLabel_2 = new JLabel("Team Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 88, 433, 47);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 136, 287, 197);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String Update_ID = Update.getText();
				if(Update_ID.contains("LEAGUE") || Update_ID.contains("league") || Update_ID.contains("League")) {
					lblNewLabel_2.setText("LEAGUE PLAYERS");
					ContainerClass con = new ContainerClass();
					String disp = con.ViewTeams(League_Players);
					textArea.setText(disp);
					
				}
				else if(Update_ID.contains("Tournament") || Update_ID.contains("TOURNAMENT") || Update_ID.contains("tournament")) {
					lblNewLabel_2.setText("TOURNAMENT PLAYERS");
					ContainerClass con = new ContainerClass();
					String disp = con.ViewTeams(Tournament_Players);
					textArea.setText(disp);	
				}
			}
		});
		btnNewButton.setBounds(332, 41, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(returndest.equals("coach")) {
					CoachHome chome = new CoachHome();
					chome.displaycoachhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
					dispose();
				}
				if(returndest.equals("manager")) {
					ManagerHome mghome = new ManagerHome();
					mghome.displaymanagerhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
					dispose();
				}
				if(returndest.equals("player")) {
					PlayerHome plhome = new PlayerHome();
					plhome.playerhomemain(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
					dispose();
				}
			
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\SDA_UI\\src\\grunge-football-soccer-background_1048-7979.jpg"));
		lblNewLabel_3.setBounds(-83, 0, 561, 511);
		contentPane.add(lblNewLabel_3);
	
		}
	
	public ViewTeams() {		
	}

}

