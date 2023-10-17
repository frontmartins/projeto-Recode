package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.PacoteDeViagem;
import model.Reserva;

public class ReservaDAO {

	public void create(Reserva reserva) {

		String sql = "insert into Reserva  (ClienteID, PacoteID, Data_Reserva, Status_Reserva) values (?, ?, ?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getPacote().getId());
			pstm.setDate(3,new Date( reserva.getDataReserva().getTime()));
			pstm.setString(4, reserva.getStatusReserva());
			

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Reserva> read() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "select * from Reserva";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();

				reserva.setId(rset.getInt("ReservaID"));
				int clienteid=rset.getInt("ClienteID");
				ClienteDAO clientedao=new ClienteDAO();
				Cliente cliente=clientedao.readById(clienteid);
				reserva.setCliente(cliente);
				int pacoteid=rset.getInt("PacoteID");
				PacoteDeViagemDAO pacotedao=new PacoteDeViagemDAO();
				PacoteDeViagem pacote=pacotedao.readById(pacoteid);
				reserva.setPacote(pacote);
				reserva.setDataReserva(rset.getDate("Data_Reserva"));
				reserva.setStatusReserva(rset.getString("Status_Reserva"));
				
				
				

				reservas.add(reserva);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return reservas;
	}
	
	public void update(Reserva reserva) {
		String sql = "UPDATE Reserva SET  ClienteID = ?, PacoteID = ?, Data_Reserva =?, Status_Reserva =? WHERE ReservaID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getPacote().getId());
			pstm.setDate(3,new Date( reserva.getDataReserva().getTime()));
			pstm.setString(4, reserva.getStatusReserva());
			pstm.setInt(5, reserva.getId());
			
			

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void delete(int id) {
		String sql = "DELETE FROM Reserva WHERE ReservaID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "select * from Reserva WHERE ReservaID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			reserva.setId(rset.getInt("ReservaID"));
			int clienteid=rset.getInt("ClienteID");
			ClienteDAO clientedao=new ClienteDAO();
			Cliente cliente=clientedao.readById(clienteid);
			reserva.setCliente(cliente);
			int pacoteid=rset.getInt("PacoteID");
			PacoteDeViagemDAO pacotedao=new PacoteDeViagemDAO();
			PacoteDeViagem pacote=pacotedao.readById(pacoteid);
			reserva.setPacote(pacote);
			reserva.setDataReserva(rset.getDate("Data_Reserva"));
			reserva.setStatusReserva(rset.getString("Status_Reserva"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reserva;
	}
}
