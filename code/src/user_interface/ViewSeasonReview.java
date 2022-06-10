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

import businesslogic.ContainerClass;
import businesslogic.PlayerProfile;
import businesslogic.Schedule;
import businesslogic.SeasonReview;
import businesslogic.TeamPlayer;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ViewSeasonReview extends JFrame {

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
	public String returndest;
	/**
	 * Launch the application.
	 */
	public void viewseasonreviewmain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
					ViewSeasonReview frame = new ViewSeasonReview();
					frame.viewseasonreview(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
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
	public void viewseasonreview(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		setBounds(100, 100, 494, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Current Season Review");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(107, 67, 289, 20);
		contentPane.add(lblNewLabel);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(25, 25, 112));
		textArea.setBounds(85, 157, 315, 224);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ContainerClass con = new ContainerClass();
				String store = con.viewSeasonReview(seasonreview);
				textArea.setText(store);
			}
		});
		btnNewButton.setBounds(199, 98, 89, 23);
		contentPane.add(btnNewButton);	
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\soccer-football-stadium-with-spotlights_163782-3550.jpg"));
		lblNewLabel_1.setBounds(-70, 0, 577, 452);
		contentPane.add(lblNewLabel_1);
	}
	public ViewSeasonReview() {
	}
	

}
