package user_interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.Coach;
import businesslogic.Packages;
import businesslogic.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import businesslogic.*;
import javax.swing.ImageIcon;


public class DeleteUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Delete_ID;
	public Packages packlist[];
	public Player playerlist[];
	public Coach coachlist[];
	public int countplayers;
	public int coachcount;

	/**
	 * Launch the application.
	 */
	public void deleteusermain(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
					DeleteUser frame = new DeleteUser();
					frame.CreateDeleteUser(packlist, playerlist, coachlist, countplayers, coachcount);
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
	public DeleteUser() {
	}
	public void CreateDeleteUser(Packages pklist[], Player pllist[], Coach clist[], int pcount, int ccount) {
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
		setBounds(100, 100, 494, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete User");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		lblNewLabel.setBounds(160, 34, 156, 20);
		contentPane.add(lblNewLabel);
		
		JLabel delete_ID = new JLabel("Enter ID");
		delete_ID.setFont(new Font("Tahoma", Font.BOLD, 12));
		delete_ID.setForeground(new Color(240, 255, 240));
		delete_ID.setBounds(58, 107, 82, 18);
		contentPane.add(delete_ID);
		
		Delete_ID = new JTextField();
		Delete_ID.setBounds(179, 107, 241, 20);
		contentPane.add(Delete_ID);
		Delete_ID.setColumns(10);
	
		JButton btnNewButton_1 = new JButton("Delete Coach");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = Delete_ID.getText();
				ReceptionController rcpcontrol = new ReceptionController();
				coachlist = rcpcontrol.DeleteCoach(id, coachlist, coachcount);
				int checkcoachcount = 0; 
				int i = 0;
				while(coachlist[i].GetCoachID() != "") {
					i++;
					checkcoachcount++;
				}
				if(checkcoachcount < coachcount) {
					JOptionPane.showMessageDialog(rootPane, "Coach " + id + " has been deleted");
					coachcount--;
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ERROR - coach not deleted");
				}
			}
		});
		btnNewButton_1.setBounds(186, 178, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Manager");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = Delete_ID.getText();
				ReceptionController rcpcontrol = new ReceptionController();
				rcpcontrol.DeleteManager(id);
				JOptionPane.showMessageDialog(rootPane, "Manager has been attempted to be deleted, please check SQL to confirm deletion");
			}
		});
		btnNewButton_2.setBounds(329, 178, 121, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete Player");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = Delete_ID.getText();
				ReceptionController rcpcontrol = new ReceptionController();
				playerlist = rcpcontrol.DeletePlayer(id, playerlist, countplayers);
				int checkplayercount = 0; 
				int i = 0;
				while(playerlist[i].GetPlayer_ID() != "") {
					i++;
					checkplayercount++;
				}
				if(checkplayercount < countplayers) {
					JOptionPane.showMessageDialog(rootPane, "Player " + id + " has been deleted");
					countplayers--;
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "ERROR - player not deleted");
				}
			}
		});
		btnNewButton.setBounds(48, 178, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReceptionHome staffhome = new ReceptionHome();
				staffhome.displayReceptionHome(packlist, playerlist, coachlist, countplayers, coachcount);
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(389, 0, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Exit Application");
				dispose();
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\SDA_UI\\src\\FreeVector-Green-Abstract-Background.jpg"));
		lblNewLabel_1.setBounds(0, -290, 478, 548);
		contentPane.add(lblNewLabel_1);
		
		
	}

}
