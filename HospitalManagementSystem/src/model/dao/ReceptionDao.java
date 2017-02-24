package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Reception;

public interface ReceptionDao {
	public boolean insertReception(Reception newReception) throws ClassNotFoundException,SQLException, IOException;
	public boolean deleteReception(int receptionId) throws ClassNotFoundException,SQLException, IOException;
	public boolean updateReception(int receptionId, Reception renewReception) throws ClassNotFoundException,SQLException, IOException;
	public Reception displayReception(int receptionId) throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<Reception> displayAllReceptions() throws ClassNotFoundException,SQLException, IOException;
}
