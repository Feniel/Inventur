package inventur;

public class main {
	
	public static void main(String[] args) {
		Backend ControlSqlQuery = new Backend();
		try {
			Oberfläche frame = new Oberfläche(ControlSqlQuery);
			frame.setVisible(true);
			ControlSqlQuery.setControlOberfläche(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ControlSqlQuery.makeDBConnection();
		ControlSqlQuery.run();
	}

}
