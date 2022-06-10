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
import businesslogic.ContainerClass;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class ViewSchedule extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Schedule_ID;
	private JTextField textField;
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
	public void viewschedulemain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
					ViewSchedule frame = new ViewSchedule();
					frame.viewschedule(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
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
	public void viewschedule(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		setBounds(100, 100, 494, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SEARCH SCHEDULE");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(126, 11, 240, 20);
		contentPane.add(lblNewLabel);
		
		Schedule_ID = new JTextField();
		Schedule_ID.setBounds(171, 101, 226, 20);
		contentPane.add(Schedule_ID);
		Schedule_ID.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(171, 132, 226, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel val = new JLabel("ENTER VALUE");
		val.setFont(new Font("Tahoma", Font.BOLD, 12));
		val.setForeground(new Color(240, 255, 240));
		val.setBounds(66, 105, 95, 18);
		contentPane.add(val);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(returndest.equals("coach")) {
					CoachHome chome = new CoachHome();
					chome.displaycoachhome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
					dispose();
				}
				if(returndest.equals("admin")) {
					AdminHome adhome = new AdminHome();
					adhome.displayAdminHome(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers);
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
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.setBounds(411, 0, 67, 26);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(128, 128, 128));
		btnNewButton_4.setBounds(0, 2, 89, 23);
		contentPane.add(btnNewButton_4);
		
		
		JLabel lblNewLabel_1 = new JLabel("ENTER TYPE");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(66, 134, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(38, 207, 412, 184);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(0, 100, 0));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Search schedule by venue, date or coach");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(116, 76, 259, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String srchthrough = Schedule_ID.getText();
				String type = textField.getText();
				ContainerClass con = new ContainerClass();
				String disp = con.viewSchedule(schedule, countschedule, type, srchthrough);
				textArea.setText(disp);
			}
		});
		btnNewButton.setBounds(197, 163, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\SDA_UI\\src\\3d-rendering-soccer-ball-with-line-soccer-field_41667-273.jpg"));
		lblNewLabel_3.setBounds(-143, -27, 635, 529);
		contentPane.add(lblNewLabel_3);

	}

	public ViewSchedule() {	
	}
}
