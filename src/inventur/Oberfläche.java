package inventur;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Oberfl�che extends JFrame {

	private JPanel contentPane;
	private JTextField txtBid;
	private JTextField txtName;
	private JTextField txtStandort;
	private JTextField txtGer�teart;
	private JLabel lblGerteId;
	private JLabel lblName;
	private JLabel lblStandort;
	private JLabel lblGerteart;
	private JLabel best�tigung;
	private JLabel Output1;
	private JLabel Output2;
	private JLabel Output3;

	/**
	 * Create the frame.
	 */
	public Oberfl�che(Backend ControlSqlQuery){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		best�tigung = new JLabel("");
		best�tigung.setBounds(10, 123, 381, 19);
		contentPane.add(best�tigung);
		
		txtBid = new JTextField();
		txtBid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				best�tigung.setText("");
			}
		});
		txtBid.setBounds(10, 85, 120, 20);
		contentPane.add(txtBid);
		txtBid.setColumns(10);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				best�tigung.setText("");
			}
		});
		txtName.setColumns(10);
		txtName.setBounds(141, 85, 120, 20);
		contentPane.add(txtName);
		
		txtStandort = new JTextField();
		txtStandort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				best�tigung.setText("");
			}
		});
		txtStandort.setColumns(10);
		txtStandort.setBounds(271, 85, 120, 20);
		contentPane.add(txtStandort);
		
		txtGer�teart = new JTextField();
		txtGer�teart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				best�tigung.setText("");
			}
		});
		txtGer�teart.setColumns(10);
		txtGer�teart.setBounds(401, 85, 120, 20);
		contentPane.add(txtGer�teart);
		
		JButton sendToSqlButton = new JButton("Absenden");
		sendToSqlButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(Output1.getText() != "Datenbankverbindung hergestellt"){
					sendToSqlButton.setEnabled(false);
				}
			}
		});
		sendToSqlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid = txtBid.getText();
				String name = txtName.getText();
				String standort = txtStandort.getText();
				String ger�teart = txtGer�teart.getText();
				int check = ControlSqlQuery.eintragen(bid, name, standort, ger�teart);
				if(check == 0){
					best�tigung.setText("Eintrag erfolgreich vorgenommen");
					txtBid.setText("");
					txtName.setText("");
					txtStandort.setText("");
					txtGer�teart.setText("");
				}else if(check == 1){
					best�tigung.setText("Felder m�ssen f�r den Eintrag gef�llt sein");
				}else if(check == 2){
					best�tigung.setText("Die Datenbank hat f�r diese Eingabe einen Fehler wiedergegeben");
				}else if(check == 3){
					best�tigung.setText("Eintrag mit dieser id schon vorhanden");
				}
				
			}
		});
		sendToSqlButton.setToolTipText("sendToSql");
		sendToSqlButton.setBounds(411, 119, 110, 23);
		contentPane.add(sendToSqlButton);
		
		JLabel lblGertZurDatenbank = new JLabel("Ger\u00E4t zur Datenbank hinzuf\u00FCgen");
		lblGertZurDatenbank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGertZurDatenbank.setBounds(10, 28, 272, 14);
		contentPane.add(lblGertZurDatenbank);
		
		lblGerteId = new JLabel("Ger\u00E4te id");
		lblGerteId.setBounds(10, 60, 67, 14);
		contentPane.add(lblGerteId);
		
		lblName = new JLabel("Name");
		lblName.setBounds(141, 60, 46, 14);
		contentPane.add(lblName);
		
		lblStandort = new JLabel("Standort");
		lblStandort.setBounds(271, 60, 67, 14);
		contentPane.add(lblStandort);
		
		lblGerteart = new JLabel("Ger\u00E4teart");
		lblGerteart.setBounds(401, 60, 62, 14);
		contentPane.add(lblGerteart);
	
		
		JLabel lblProgrammstatus = new JLabel("Programmstatus");
		lblProgrammstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProgrammstatus.setBounds(10, 442, 177, 19);
		contentPane.add(lblProgrammstatus);
		
		Output1 = new JLabel("");
		Output1.setBounds(10, 462, 514, 14);
		contentPane.add(Output1);
		
		Output2 = new JLabel("");
		Output2.setBounds(10, 474, 514, 14);
		contentPane.add(Output2);
		

		
		JButton btnDrucken = new JButton("Barcode drucken");
		btnDrucken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlSqlQuery.printLabelForLast();
			}
		});
		btnDrucken.setBounds(384, 153, 137, 19);
		contentPane.add(btnDrucken);
		
		Output3 = new JLabel("");
		Output3.setBounds(384, 174, 150, 14);
		contentPane.add(Output3);
		
	}
	
	public JLabel getOutput1(){
		return this.Output1; 
	}
	
	public JLabel getOutput2(){
		return this.Output2;
	}
	
	public JLabel getOutput3(){
		return this.Output3;
	}
}
