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
import businesslogic.TeamPlayer;
import javax.swing.SwingConstants;
import businesslogic.ManagerController;
import javax.swing.ImageIcon;

public class UpdateTeam extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Player_ID;
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
	public void updateteammain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					UpdateTeam frame = new UpdateTeam();
					frame.updateteam(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);					
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
	public void updateteam(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
	
	}
	public UpdateTeam() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("EDIT TEAM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 32, 468, 26);
		contentPane.add(lblNewLabel);
		
		Player_ID = new JTextField();
		Player_ID.setBounds(168, 129, 225, 20);
		contentPane.add(Player_ID);
		Player_ID.setColumns(10);
		
		JLabel player = new JLabel("Player ID");
		player.setFont(new Font("Tahoma", Font.BOLD, 12));
		player.setForeground(new Color(240, 255, 240));
		player.setBounds(76, 129, 82, 18);
		contentPane.add(player);
	
		textField = new JTextField();
		textField.setBounds(168, 177, 225, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD TO LEAGUE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String player = Player_ID.getText();
				String name = textField.getText();
				
				ManagerController mancon = new ManagerController();
				League_Players = mancon.AddToTeamLeague(player, name, League_Players);
				JOptionPane.showMessageDialog(rootPane, "PLAYER HAS BEEN ADDED\nNOTE: confirm operation success through search/SQL");
				
			}
		});
		btnNewButton.setBounds(41, 257, 184, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE FROME LEAGUE");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String player = Player_ID.getText();
				String name = textField.getText();
				
				ManagerController mancon = new ManagerController();
				mancon.DeletefromLeague(player, name, League_Players);
				JOptionPane.showMessageDialog(rootPane, "PLAYER HAS BEEN DELETED\nNOTE: confirm operation success through search/SQL");
				
			}
		});
		btnNewButton_1.setBounds(261, 257, 184, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerHome mghome = new ManagerHome();
				mghome.displaymanagerhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.setBounds(411, 0, 67, 26);
		contentPane.add(btnNewButton_3);
		
		
		JLabel lblNewLabel_1 = new JLabel("Player Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(76, 180, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setBounds(0, 2, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("ADD TO TOURNAMENT");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String player = Player_ID.getText();
				String name = textField.getText();
				
				ManagerController mancon = new ManagerController();
				Tournament_Players = mancon.AddToTeamTournament(player, name, Tournament_Players);
				JOptionPane.showMessageDialog(rootPane, "PLAYER HAS BEEN ADDED\nNOTE: confirm operation success through search/SQL");
			}
		});
		btnNewButton_4.setBounds(41, 308, 184, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("DELETE FROM TOURNAMENT");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String player = Player_ID.getText();
				String name = textField.getText();
				
				ManagerController mancon = new ManagerController();
				mancon.DeletefromTournament(player, name, Tournament_Players);
				JOptionPane.showMessageDialog(rootPane, "PLAYER HAS BEEN DELETED\nNOTE: confirm operation success through search/SQL");
				
			}
		});
		btnNewButton_5.setBounds(261, 308, 184, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-geometric-wallpaper-background-vector-21931375.jpg"));
		lblNewLabel_2.setBounds(0, -180, 478, 551);
		contentPane.add(lblNewLabel_2);
	}
	

}
