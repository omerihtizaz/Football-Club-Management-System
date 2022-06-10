package user_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.ContainerClass;
import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ViewPlayerProfile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	public void viewplayerprofilemain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
					ViewPlayerProfile frame = new ViewPlayerProfile();
					frame.viewplayerprofile(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
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
	public void viewplayerprofile(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Player Profile");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(85, 34, 274, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(345, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(144, 78, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID/Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(44, 80, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(95, 128, 315, 200);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(0, 100, 0));
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String id_name = textField.getText();
				ContainerClass ccon = new ContainerClass();
				String storestring = ccon.viewPlayerProfile(id_name, countplayers, profilelist);
				textArea.append(storestring);				
			}
		});
		btnNewButton_2.setBounds(313, 78, 76, 20);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\SDA_UI\\src\\3d-rendering-soccer-ball-with-line-soccer-field_41667-273.jpg"));
		lblNewLabel_2.setBounds(-47, -26, 481, 442);
		contentPane.add(lblNewLabel_2);
		
	}

	public ViewPlayerProfile() {
	}
}
