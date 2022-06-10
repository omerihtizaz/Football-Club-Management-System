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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ViewFeedback extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PFD_ID;
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
	public void viewfeedbackmain(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
					ViewFeedback frame = new ViewFeedback();
					frame.viewfeedback(seasonreview, profilelist, League_Players, Tournament_Players, schedule, countschedule, countplayers, returndest);
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
	public void viewfeedback(SeasonReview ssnrvw, PlayerProfile pro[], TeamPlayer leag[], TeamPlayer tour[], Schedule sch[], int cs, int cp, String returnd) {
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
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("VIEW FEEDBACK");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 11, 478, 46);
		contentPane.add(lblNewLabel);
		
		PFD_ID = new JTextField();
		PFD_ID.setBounds(148, 94, 212, 20);
		contentPane.add(PFD_ID);
		PFD_ID.setColumns(10);
		
		JLabel label = new JLabel("ENTER COACH ID");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setForeground(new Color(240, 255, 240));
		label.setBounds(33, 94, 113, 18);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 136, 353, 251);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(0, 100, 0));
		textArea.setForeground(new Color(240, 255, 240));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String coachid = PFD_ID.getText();
				ContainerClass con = new ContainerClass();
				String display = con.ViewFeedback(coachid);
				textArea.setText(display);
			}
		});
		btnNewButton.setBounds(370, 93, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
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
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.setBounds(411, 0, 67, 26);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(0, 2, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\3d-rendering-soccer-ball-with-line-soccer-field_41667-273.jpg"));
		lblNewLabel_1.setBounds(-37, 0, 532, 490);
		contentPane.add(lblNewLabel_1);
		
		
	}
	
	public ViewFeedback() {
	}

}
