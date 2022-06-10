package user_interface;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businesslogic.Coach;
import businesslogic.Packages;
import businesslogic.Player;
import businesslogic.ReceptionController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;


public class searchStaff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Search_ID;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;
	
	/**
	 * Launch the application.
	 */
	public void searchstaffmain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
		packlist = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		packlist = pklist;
		playerlist = new Player[100];
			for(int i = 0 ; i < 100; i++) {
				playerlist[i] = new Player();
			}
		playerlist = pllist;
		coachlist = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		countplayers = pcount;
		coachcount = ccount;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchStaff frame = new searchStaff();
					frame.CreateSearchForm(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public searchStaff() {
	}
	

	public void CreateSearchForm(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
		packlist = new Packages[4];
		for(int i = 0 ; i < 4 ; i++) {
			packlist[i] = new Packages();
		}
		packlist = pklist;
		playerlist = new Player[100];
			for(int i = 0 ; i < 100; i++) {
				playerlist[i] = new Player();
			}
		playerlist = pllist;
		coachlist = new Coach[10];
		for(int i = 0 ; i < 10 ; i++) {
			coachlist[i] = new Coach();
		}
		coachlist = clist;
		countplayers = pcount;
		coachcount = ccount;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(189, 34, 100, 20);
		contentPane.add(lblNewLabel);
		
		Search_ID = new JTextField();
		Search_ID.setBounds(168, 87, 260, 20);
		contentPane.add(Search_ID);
		Search_ID.setColumns(10);
		
		JLabel Search = new JLabel("Search ID/Name");
		Search.setFont(new Font("Tahoma", Font.BOLD, 12));
		Search.setForeground(new Color(240, 255, 240));
		Search.setBounds(38, 87, 109, 18);
		contentPane.add(Search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(38, 183, 407, 113);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(0, 153, 51));
		scrollPane.setViewportView(textArea);
		JButton btnNewButton_1 = new JButton("Manager");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String id = Search_ID.getText();
				String tempstore = "";
				ReceptionController rcpcon = new ReceptionController();
				tempstore = rcpcon.getManagerList(id);
				textArea.append(tempstore);
			}
		});
		btnNewButton_1.setBounds(200, 134, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Coach");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String id = Search_ID.getText();
				ReceptionController rcpcon = new ReceptionController();
				String display = rcpcon.SearchCoach(id, coachlist, coachcount);
				textArea.setText(display);
			}
		});
		btnNewButton_2.setBounds(322, 134, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.setBounds(385, 0, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_4.setBackground(new Color(128, 128, 128));
		btnNewButton_4.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Player");
		btnNewButton.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String id = Search_ID.getText();
				ReceptionController rcpcon = new ReceptionController();
				String display = rcpcon.SearchPlayer(id, playerlist, countplayers);
				textArea.setText(display);
			}
		});
		btnNewButton.setBounds(69, 134, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\green-shapes-green-background_23-2148358212.jpg"));
		lblNewLabel_1.setBounds(0, 0, 474, 328);
		contentPane.add(lblNewLabel_1);
	}
	
}
