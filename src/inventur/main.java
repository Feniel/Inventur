package inventur;

public class main {
	
	public static void main(String[] args) {
		Backend ControlSqlQuery = new Backend();
		try {
			Oberfl�che frame = new Oberfl�che(ControlSqlQuery);
			frame.setVisible(true);
			ControlSqlQuery.setControlOberfl�che(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ControlSqlQuery.makeDBConnection();
		ControlSqlQuery.run();
	}

}
