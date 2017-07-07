package inventur;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import com.onbarcode.barcode.Code128;

public class Backend extends Thread{
	
	private boolean checkDBConnect;
	private Oberfläche controlOberfläche;
	private DBConnect DBConnection;
	private String lastId;
	
	public Backend(){
		checkDBConnect = true;
	}
	
	public void run(){
		while(true){
			
		}
	}
	
	public int eintragen(String bid, String name, String standort, String geräteart){
		this.lastId = bid;
		String query;
		ResultSet result = null;
		int check = 0; //0:bereits vorhanden 1:nicht vorhanden
		
		query = "select * from data where bid = '"+bid+"'";
		try {
			result = DBConnection.getStatement().executeQuery(query);
            result.next();
            result.getInt("bid"); 
		} catch (SQLException e) {
			check=1;
		}
		
		if(check == 1){
			query = "insert into data "
				+ " (bid, name, standort, geräteart)"
				+ "values ('"+bid+"','"+name+"','"+standort+"','"+geräteart+"')";
			if(bid.length() > 0 && name.length() > 0 && standort.length() > 0 && geräteart.length() > 0){
				try {
					DBConnection.getStatement().executeUpdate(query);
				} catch (SQLException e) {
					return 2; //DB Fehler
				}
				return 0; //alles ok
			}else{
				return 1; //Felder sind leer
			}
		}else{
			return 3; //id schon vorhanden
		}
	}
	
	public void printLabelForLast(){
		Code128 barcode = new Code128();
		JLabel output3 = controlOberfläche.getOutput3();
		try {
			barcode.setData(lastId);
			barcode.drawBarcode("D://barcode-code128.jpg");
			barcode.drawBarcode("D://barcode-code128.jpg");
			output3.setText("PrintVorgang erfolgreich");
		} catch (Exception e) {
			output3.setText("PrintVorgang fehlgeschlagen");
		}
	}
	
	public void makeDBConnection(){
		DBConnection = new DBConnect(this);
		JLabel output1 = controlOberfläche.getOutput1();
		if(!checkDBConnect){
			output1.setText("Datenbankverbindung fehlgeschlagen !");
		}else{
			output1.setText("Datenbankverbindung hergestellt");
		}	
	}
	
	public void setCheckDBConnect(boolean checkDBConnect) {
		this.checkDBConnect = checkDBConnect;
	}
	
	public void setControlOberfläche(Oberfläche controlOberfläche){
		this.controlOberfläche = controlOberfläche;
	}
}
