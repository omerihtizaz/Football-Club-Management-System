package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import businesslogic.PlayerProfile;
import businesslogic.SeasonReview;
import businesslogic.Schedule;
import businesslogic.TeamPlayer;
import businesslogic.CoachController;
import javax.swing.ImageIcon;

class playerprofile extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TeamName_Field;
	private JTextField Agility_Field;
	private JTextField Redcard_Field;
	private JTextField Field_Position;
	private JTextField Comment_Field;
	private JTextField PlayerID_Field;
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
	public void playerprofilemain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					playerprofile frame = new playerprofile();
					frame.CreatePlayerProfile(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void CreatePlayerProfile(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		contentPane.setBackground(new Color(69, 2, 38));
		contentPane.setForeground(new Color(69, 2, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLAYER PROFILE");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(132, 12, 239, 20);
		contentPane.add(lblNewLabel);
		
		Redcard_Field = new JTextField();
		Redcard_Field.setBounds(184, 171, 259, 20);
		contentPane.add(Redcard_Field);
		Redcard_Field.setColumns(10);
		
		JLabel Team_Name = new JLabel("Team Name");
		Team_Name.setForeground(new Color(240, 255, 240));
		Team_Name.setBounds(39, 111, 84, 16);
		contentPane.add(Team_Name);
		
		JLabel Agility = new JLabel("Agility");
		Agility.setForeground(new Color(240, 255, 240));
		Agility.setBounds(39, 142, 55, 16);
		contentPane.add(Agility);
		
		JLabel cards = new JLabel("Red Cards");
		cards.setForeground(new Color(240, 255, 240));
		cards.setBounds(39, 173, 109, 16);
		contentPane.add(cards);
		
		JLabel position = new JLabel("Field Position");
		position.setForeground(new Color(240, 255, 240));
		position.setBounds(39, 207, 127, 16);
		contentPane.add(position);
		
		JLabel comments = new JLabel("Comments");
		comments.setForeground(new Color(240, 255, 240));
		comments.setBounds(39, 234, 94, 16);
		contentPane.add(comments);
		
		JLabel lblNewLabel_1 = new JLabel("Player ID");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setBounds(39, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		TeamName_Field = new JTextField();
		TeamName_Field.setColumns(10);
		TeamName_Field.setBounds(184, 109, 259, 20);
		contentPane.add(TeamName_Field);
		
		Agility_Field = new JTextField();
		Agility_Field.setColumns(10);
		Agility_Field.setBounds(184, 140, 259, 20);
		contentPane.add(Agility_Field);
		
		Field_Position = new JTextField();
		Field_Position.setColumns(10);
		Field_Position.setBounds(184, 202, 259, 20);
		contentPane.add(Field_Position);
		
		Comment_Field = new JTextField();
		Comment_Field.setColumns(10);
		Comment_Field.setBounds(184, 233, 259, 68);
		contentPane.add(Comment_Field);
		
		PlayerID_Field = new JTextField();
		PlayerID_Field.setBounds(184, 67, 72, 20);
		contentPane.add(PlayerID_Field);
		PlayerID_Field.setColumns(10);
	
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(101, 30, 56));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String player_id = PlayerID_Field.getText();
				String teamname = TeamName_Field.getText();
				String agility = Agility_Field.getText();
				String redcard = Redcard_Field.getText();
				String fieldpos = Field_Position.getText();
				String comments = Comment_Field.getText();
				
				//send all data to coachcontroller to perform action
				CoachController ccon = new CoachController();
				ccon.UpdatePlayerProfile(player_id, teamname, agility, redcard, fieldpos, comments, countplayers, profilelist);
				JOptionPane.showMessageDialog(rootPane, "If player id was correct record has been updated\nNOTE: confirm success from SQL/Search");			
			}
		});
		btnNewButton.setBounds(184, 351, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CoachHome chome = new CoachHome();
				chome.displaycoachhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				chome.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(102, 0, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(102, 0, 51));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\FreeVector-Green-Abstract-Background.jpg"));
		lblNewLabel_2.setBounds(0, -71, 478, 513);
		contentPane.add(lblNewLabel_2);
		
	}
	
	public playerprofile() {	
	}
}
