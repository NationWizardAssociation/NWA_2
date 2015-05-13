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
		
		textField = new JTextField();
		textField.setBounds(82, 29, 122, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblWizard = new JLabel("Wizard");
		lblWizard.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblWizard.setBounds(16, 33, 67, 16);
		panel.add(lblWizard);
		
/*		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(419, 29, 122, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(419, 69, 122, 28);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(419, 109, 122, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(419, 149, 122, 28);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(419, 189, 122, 28);
		panel.add(textField_5);
		
		Label label = new Label("Level");
		label.setBounds(344, 29, 69, 23);
		panel.add(label);
*/		
		Button button = new Button("Search");
		button.setBounds(209, 29, 76, 23);
		panel.add(button);
		
		wizardRes = new JTextArea();
		wizardRes.setEditable(false);
		wizardRes.setColumns(10);
		wizardRes.setBounds(350, 25, 300, 400);
		panel.add(wizardRes);
		String wName = "";
		String queryRes = "Gothmog Doomsman of the Valar, 5, 100, Necromancer, 100, 100, Roofie, 100101";

/*		class searchWIZ implements ActionListener {
			
			public void actionPerformed(ActionEvent arg0) {
				wName=textField.getText();
				
				
				wizardRes.setText(queryRes + "\n" + wName);
			
			}
		
		}

*/

		
/*		
		Label label_1 = new Label("Attack");
		label_1.setBounds(344, 69, 69, 23);
		panel.add(label_1);
		
		label_2 = new Label("Defense");
		label_2.setBounds(344, 109, 69, 23);
		panel.add(label_2);
		
		label_3 = new Label("SpellSet");
		label_3.setBounds(344, 149, 69, 23);
		panel.add(label_3);
		
		label_4 = new Label("Guild ");
		label_4.setBounds(344, 189, 69, 23);
		panel.add(label_4);
		
		label_7 = new Label("Pet Name");
		label_7.setBounds(344, 231, 69, 23);
		panel.add(label_7);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(419, 231, 122, 28);
		panel.add(textField_11);
*/		

		
		
		
/////////////////		THIS IS THE GUILD SECTION //////////////////////////


		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Guild", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Guild");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(27, 38, 55, 16);
		panel_1.add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(80, 34, 122, 28);
		panel_1.add(textField_6);
		
		button_1 = new Button("Search");
		button_1.setBounds(208, 38, 76, 23);
		panel_1.add(button_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(459, 38, 122, 28);
		panel_1.add(textField_7);
		
		label_5 = new Label("Wins");
		label_5.setBounds(384, 38, 69, 23);
		panel_1.add(label_5);
		
		label_6 = new Label("Losses");
		label_6.setBounds(384, 78, 69, 23);
		panel_1.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(459, 78, 122, 28);
		panel_1.add(textField_8);
		
		
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
		button_2.setBounds(225, 39, 53, 23);
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
		
		JLabel lblWar = new JLabel("War");
		lblWar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblWar.setBounds(16, 33, 67, 16);
		warPanel.add(lblWar);

		Button MVWbutton = new Button("Most Valuable Wizard (by war aggressor)");
		MVWbutton.setBounds(100, 29, 300, 23);
		warPanel.add(MVWbutton);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(473, 37, 122, 28);
		warPanel.add(textField_10);
		

		
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
	
	public static void main(String args[]) {
		JFrame fr = new GUI();
		fr.setTitle("NWA");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	
	}
}