package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Medicine;

public interface MedicineDao {
	public boolean insertMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateMedicine(int sNo, Medicine renewMedicine) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Medicine> displayAllMedicines() throws ClassNotFoundException, SQLException, IOException;
	boolean deleteMedicine(int sNo, int patientId) throws ClassNotFoundException, SQLException, IOException;
	Medicine displayMedicine(int sNo, int patientId) throws ClassNotFoundException, SQLException, IOException;
}
