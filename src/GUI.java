import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class GUI extends JFrame
{
	public GUI() {
		setSize(900, 600);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 809, 486);
		getContentPane().add(tabbedPane);
		
		
/////////////////		THIS IS THE Wizard SECTION //////////////////////////

		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Wizard", null, panel, null);
		panel.setLayout(null);
		
		wizTxtName = new JTextField();
		wizTxtName.setBounds(82, 29, 122, 28);
		panel.add(wizTxtName);
		wizTxtName.setColumns(10);
		
		wizTxtLev = new JTextField();
		wizTxtLev.setBounds(82, 60, 122, 28);
		panel.add(wizTxtLev);
		wizTxtLev.setColumns(10);
		
		wizTxtSpell = new JTextField();
		wizTxtSpell.setBounds(82, 90, 122, 28);
		panel.add(wizTxtSpell);
		wizTxtSpell.setColumns(10);
		
		wizTxtHeal = new JTextField();
		wizTxtHeal.setBounds(82, 120, 122, 28);
		panel.add(wizTxtHeal);
		wizTxtHeal.setColumns(10);
		
		wizTxtAtk = new JTextField();
		wizTxtAtk.setBounds(82, 150, 122, 28);
		panel.add(wizTxtAtk);
		wizTxtAtk.setColumns(10);
		
		wizTxtDef = new JTextField();
		wizTxtDef.setBounds(82, 180, 122, 28);
		panel.add(wizTxtDef);
		wizTxtDef.setColumns(10);
		
		wizTxtPet = new JTextField();
		wizTxtPet.setBounds(82, 210, 122, 28);
		panel.add(wizTxtPet);
		wizTxtPet.setColumns(10);
		
		wizTxtGuild = new JTextField();
		wizTxtGuild.setBounds(82, 240, 122, 28);
		panel.add(wizTxtGuild);
		wizTxtGuild.setColumns(10);
		
		JLabel lblWizard = new JLabel("Wizard");
		lblWizard.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard.setBounds(16, 30, 67, 16);
		panel.add(lblWizard);
		
		JLabel lblWizard2 = new JLabel("Level");
		lblWizard2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard2.setBounds(16, 60, 67, 16);
		panel.add(lblWizard2);
		
		JLabel lblWizard3 = new JLabel("Spellset");
		lblWizard3.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard3.setBounds(16, 90, 67, 16);
		panel.add(lblWizard3);
		
		JLabel lblWizard4 = new JLabel("**Health");
		lblWizard4.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard4.setBounds(16, 120, 67, 16);
		panel.add(lblWizard4);
		
		JLabel lblWizard5 = new JLabel("**Attack");
		lblWizard5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard5.setBounds(16, 150, 67, 16);
		panel.add(lblWizard5);
		
		JLabel lblWizard6 = new JLabel("**Deffense");
		lblWizard6.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard6.setBounds(16, 180, 67, 16);
		panel.add(lblWizard6);
		
		JLabel lblWizard7 = new JLabel("**Pet");
		lblWizard7.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard7.setBounds(16, 210, 67, 16);
		panel.add(lblWizard7);
		
		JLabel lblWizard8 = new JLabel("**Guild");
		lblWizard8.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard8.setBounds(16, 240, 67, 16);
		panel.add(lblWizard8);
		
		JLabel lblWizard9 = new JLabel("Double asteriks (**) denotes non-searchable attribute.");
		lblWizard9.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard9.setBounds(16, 400, 600, 16);
		panel.add(lblWizard9);
		
		JLabel lblWizard10 = new JLabel("All attributes are required for Adding a Wizard.");
		lblWizard10.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblWizard10.setBounds(16, 420, 600, 16);
		panel.add(lblWizard10);

		Button button = new Button("Search");
		button.setBounds(209, 29, 76, 23);
		panel.add(button);
		
		Button addWiz = new Button("Add");
		addWiz.setBounds(209, 60, 76, 23);
		panel.add(addWiz);
		
		Button clearWiz = new Button("Clear");
		clearWiz.setBounds(209, 90, 76, 23);
		panel.add(clearWiz);
		
		JLabel wizStats = new JLabel("(name, level, spellset, health, attack, defense, pet, guild)");
		wizStats.setFont(new Font("SansSerif", Font.PLAIN, 12));
		wizStats.setBounds(300, 20, 400, 16);
		panel.add(wizStats);		
		
		wizardRes = new JTextArea();
		wizardRes.setEditable(false);
		wizardRes.setColumns(10);
		wizardRes.setBounds(300, 40, 400, 300);
		panel.add(wizardRes);

		queryRes = "Gothmog Doomsman of the Valar, 5, 100, Necromancer, 100, 100, Roofie, 100101";

		//javac GUI.java 
		//java -classpath ".:sqlite-jdbc-3.7.2.jar" GUI


		class searchWIZ implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {

				wQuery = wizTxtName.getText() + ", " + wizTxtLev.getText() + ", " + 
						wizTxtSpell.getText();
				
				//preparedStatement(statm);
				
				wizardRes.setText(queryRes);
			}
		}
		
		ActionListener seaWIZ = new searchWIZ();
		button.addActionListener(seaWIZ);


		class adWIZ implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {

				wQuery = wizTxtName.getText() + ", " + wizTxtLev.getText() + ", " + 
						wizTxtSpell.getText() + ", " + wizTxtHeal.getText()+ ", " + 
						wizTxtAtk.getText()+ ", " + wizTxtDef.getText()+ ", " + 
						wizTxtPet.getText()+ ", " + wizTxtGuild.getText();
				
				//preparedStatement(statm);
				
				wizardRes.setText(queryRes + "\n" + wQuery);
			}
		}
		
		ActionListener addingWIZ = new adWIZ();
		addWiz.addActionListener(addingWIZ);
		
		class cleaWIZ implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {

				wizTxtName.setText("");
				wizTxtLev.setText("");
				wizTxtSpell.setText("");
				wizTxtHeal.setText("");
				wizTxtAtk.setText("");
				wizTxtDef.setText("");
				wizTxtPet.setText("");
				wizTxtGuild.setText("");
				
			}
		}
		
		ActionListener clearingWIZ = new cleaWIZ();
		clearWiz.addActionListener(clearingWIZ);



		
/////////////////		THIS IS THE GUILD SECTION //////////////////////////


		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Guild", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel gldLblNam = new JLabel("Guild Name");
		gldLblNam.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gldLblNam.setBounds(27, 38, 70, 16);
		panel_1.add(gldLblNam);
		
		JLabel gldLblID = new JLabel("Guild ID");
		gldLblID.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gldLblID.setBounds(27, 80, 55, 16);
		panel_1.add(gldLblID);
		
		gldTxtName = new JTextField();
		gldTxtName.setColumns(10);
		gldTxtName.setBounds(100, 34, 122, 28);
		panel_1.add(gldTxtName);
		
		gldTxtId = new JTextField();
		gldTxtId.setColumns(10);
		gldTxtId.setBounds(100, 80, 122, 28);
		panel_1.add(gldTxtId);
		
		button_1 = new Button("Search");
		button_1.setBounds(220, 38, 76, 23);
		panel_1.add(button_1);
		
		Button addGld = new Button("Add");
		addGld.setBounds(220, 80, 76, 23);
		panel_1.add(addGld);
		
		label_5 = new Label("Wins, Losses");
		label_5.setBounds(384, 38, 100, 23);
		panel_1.add(label_5);
		
		gWinLoss = new JTextField();
		gWinLoss.setEditable(false);
		gWinLoss.setColumns(10);
		gWinLoss.setBounds(384, 60, 122, 28);
		panel_1.add(gWinLoss);
		
		
		gTerritories = new JTextArea();
		gTerritories.setEditable(false);
		gTerritories.setColumns(10);
		gTerritories.setBounds(27, 150, 300, 300);
		panel_1.add(gTerritories);
		
		gWizards = new JTextArea();
		gWizards.setEditable(false);
		gWizards.setColumns(10);
		gWizards.setBounds(360, 150, 300, 300);
		panel_1.add(gWizards);
		
		gTerr = new JLabel ("Occupied Territories");
		gTerr.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gTerr.setBounds(27, 130, 200, 16);
		panel_1.add(gTerr);
		
		gWizz = new JLabel("Wizards Enlisted");
		gWizz.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gWizz.setBounds(360, 130, 200, 16);
		panel_1.add(gWizz);
		
		 
		
		
/////////////////		THIS IS THE TERRITORY SECTION //////////////////////////
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Territory", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblTerritory = new JLabel("Territory");
		lblTerritory.setBounds(27, 39, 87, 21);
		lblTerritory.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel_2.add(lblTerritory);
		
		textField_9 = new JTextField();
		textField_9.setBounds(97, 37, 122, 28);
		textField_9.setColumns(10);
		panel_2.add(textField_9);
		
		Button button_2 = new Button("Search");
		button_2.setBounds(225, 39, 76, 23);
		panel_2.add(button_2);
		
		JLabel lblControlledBy = new JLabel("Controlled By");
		lblControlledBy.setBounds(374, 35, 87, 33);
		panel_2.add(lblControlledBy);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(473, 37, 122, 28);
		panel_2.add(textField_10);
		
		
/////////////////		THIS IS THE WAR SECTION //////////////////////////
		

		JPanel warPanel = new JPanel();
		tabbedPane.addTab("War", null, warPanel, null);
		warPanel.setLayout(null);
		
		
		JLabel guildIDlab = new JLabel("Guild ID");
		guildIDlab.setFont(new Font("SansSerif", Font.PLAIN, 12));
		guildIDlab.setBounds(16, 29, 70, 23);
		warPanel.add(guildIDlab);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(80, 29, 150, 23);
		warPanel.add(textField_13);
		
		Button guildIDbut = new Button("Search");
		guildIDbut.setBounds(240, 29, 70, 23);
		warPanel.add(guildIDbut);


		JLabel warDec = new JLabel("Wars Declared (aggressor, defender, winner, loser, location)");
		warDec.setFont(new Font("SansSerif", Font.PLAIN, 12));
		warDec.setBounds(16, 100, 400, 16);
		warPanel.add(warDec);
		
		warRes = new JTextArea();
		warRes.setEditable(false);
		warRes.setColumns(10);
		warRes.setBounds(16, 120, 400, 300);
		warPanel.add(warRes);
		
/////////////////		THIS IS THE BATTLE SECTION //////////////////////////
		
		
		JPanel battlePanel = new JPanel();
		tabbedPane.addTab("Battle", null, battlePanel, null);
		battlePanel.setLayout(null);
		
		JLabel bAgres = new JLabel("Aggressor ID");
		bAgres.setFont(new Font("SansSerif", Font.PLAIN, 12));
		bAgres.setBounds(16, 29, 80, 23);
		battlePanel.add(bAgres);
		
		JLabel bDef = new JLabel("Defender ID");
		bDef.setFont(new Font("SansSerif", Font.PLAIN, 12));
		bDef.setBounds(16, 60, 80, 23);
		battlePanel.add(bDef);
		
		updateLabel = new JLabel("");
		updateLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		updateLabel.setBounds(16, 150, 150, 23);
		battlePanel.add(updateLabel);
		
		bAggID = new JTextField();
		bAggID.setBounds(100, 29, 122, 28);
		battlePanel.add(bAggID);
		bAggID.setColumns(10);
		
		bDefID = new JTextField();
		bDefID.setBounds(100, 60, 122, 28);
		battlePanel.add(bDefID);
		bDefID.setColumns(10);
		
		Button battleButton = new Button("Battle");
		battleButton.setBounds(230, 29, 70, 23);
		battlePanel.add(battleButton);
		
		class addBattle implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				
				updateLabel.setText("*tables updated");
			}
		}
		ActionListener battleListener = new addBattle();
		battleButton.addActionListener(battleListener);
		
		
	}
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private JLabel lblNewLabel;
	private JTextField textField_6;
	private Button button_1;
	private JTextField textField_7;
	private Label label_5;
	private Label label_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private Label label_7;
	private JTextField textField_11;
	private Label label_8;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextArea wizardRes;
	private JTextArea warRes;
	
	private JTextField wizTxtName;
	private JTextField wizTxtLev;	
	private JTextField wizTxtSpell;
	private JTextField wizTxtHeal;
	private JTextField wizTxtAtk;
	private JTextField wizTxtDef;
	private JTextField wizTxtPet;
	private JTextField wizTxtGuild;
	
	private JTextField gldTxtName;
	private JTextField gldTxtId;
	private JTextField gWinLoss;
	private JTextArea gTerritories;
	private JTextArea gWizards;
	private JLabel gTerr;
	private JLabel gWizz;
	private JLabel updateLabel;

	
	private JTextField bAggID;
	private JTextField bDefID;
	
	
	
	private String wName = "";
	private String wLev = "";	
	private String wSpell = "";	
	private String wHealth = "";
	private String wAtk = "";
	private String wDef = "";
	private String wPet = "";
	private String wGuild = "";
	private String wQuery = "";
	
	private String gName = "";
	private String gID = "";
	
	
	
	String queryRes = "";

	
	public static void main(String args[])  {
		JFrame fr = new GUI();
		fr.setTitle("NWA");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	
	}
}