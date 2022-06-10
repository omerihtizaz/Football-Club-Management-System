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
import businesslogic.AdminController;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


public class ScheduleTrainingOrTournament extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Date;
	private JTextField Time;
	private JTextField Venue;
	private JTextField Coach;
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
	public void ScheduleTrainingSessionOrTournamentMain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
					ScheduleTrainingOrTournament frame = new ScheduleTrainingOrTournament();
					frame.scheduletrainingortournament(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
	public void scheduletrainingortournament(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp) {
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
		setBounds(100, 100, 494, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(69, 2, 38));
		contentPane.setForeground(new Color(69, 2, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Details");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(57, 236, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(198, 233, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SCHEDULE TRAINING/TOURNAMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 32, 478, 20);
		contentPane.add(lblNewLabel);
		
		Time = new JTextField();
		Time.setBounds(198, 171, 188, 20);
		contentPane.add(Time);
		Time.setColumns(10);
		
		JLabel date = new JLabel("Date (dd/mm/yy)");
		date.setFont(new Font("Tahoma", Font.BOLD, 11));
		date.setForeground(new Color(240, 255, 240));
		date.setBounds(57, 111, 109, 16);
		contentPane.add(date);
		
		JLabel venue = new JLabel("Venue");
		venue.setFont(new Font("Tahoma", Font.BOLD, 11));
		venue.setForeground(new Color(240, 255, 240));
		venue.setBounds(57, 138, 55, 16);
		contentPane.add(venue);
		
		JLabel time = new JLabel(" Time (24 HR)");
		time.setFont(new Font("Tahoma", Font.BOLD, 11));
		time.setForeground(new Color(240, 255, 240));
		time.setBounds(53, 173, 135, 16);
		contentPane.add(time);
		
		JLabel coach = new JLabel("Coach");
		coach.setFont(new Font("Tahoma", Font.BOLD, 11));
		coach.setForeground(new Color(240, 255, 240));
		coach.setBounds(57, 204, 127, 16);
		contentPane.add(coach);
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(198, 109, 188, 20);
		contentPane.add(Date);
		
		Venue = new JTextField();
		Venue.setColumns(10);
		Venue.setBounds(198, 140, 188, 20);
		contentPane.add(Venue);
		
		Coach = new JTextField();
		Coach.setColumns(10);
		Coach.setBounds(198, 202, 188, 20);
		contentPane.add(Coach);
	
		JButton btnNewButton = new JButton("ADD TRAINING");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String date = Date.getText();
				String venue = Venue.getText();
				String coach = Coach.getText();
				String time = Time.getText();
				String details = textField.getText();
				String type = "training";
				
				AdminController adcon = new AdminController();
				schedule = adcon.CreateSchedule(type, date, time, venue, coach, details, schedule, countschedule);
				
				int checkadd = 0;
				while(schedule[checkadd].getType() != "") {
					checkadd++;
				}
				if(checkadd>countschedule) {
					JOptionPane.showMessageDialog(rootPane, "Schedule has been added successfully");
					countschedule++;
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ERROR: Schedule not added");
				}
			}
		});
		btnNewButton.setBounds(79, 307, 121, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("ADD TOURNAMENTS");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String date = Date.getText();
				String venue = Venue.getText();
				String coach = Coach.getText();
				String time = Time.getText();
				String details = textField.getText();
				String type = "tournament";
				
				AdminController adcon = new AdminController();
				schedule = adcon.CreateSchedule(type, date, time, venue, coach,details,  schedule, countschedule);
				
				int checkadd = 0;
				while(schedule[checkadd].getType() != "") {
					checkadd++;
				}
				if(checkadd>countschedule) {
					JOptionPane.showMessageDialog(rootPane, "Schedule has been added successfully");
					countschedule++;
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ERROR: Schedule not added");
				}

			}
		});
		btnNewButton_2.setBounds(280, 307, 131, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_3.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminHome adhome = new AdminHome();
				adhome.displayAdminHome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
				dispose();
			}
		});
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\171783-abstract-green-fluid-color-gradient-geometric-shapes-composition-background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 478, 442);
		contentPane.add(lblNewLabel_1);
	
		
	}
	
	public ScheduleTrainingOrTournament() {
	}
}
