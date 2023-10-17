package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.PacoteDeViagem;

public class PacoteDeViagemDAO {
	public void create(PacoteDeViagem pacote) {

		String sql = "insert into Pacote_De_Viagem  (Destino, Itinerario, Preco, Datas_Disponiveis, Descricao) values (?, ?, ?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getDestino());
			pstm.setString(2, pacote.getItinerario());
			pstm.setFloat(3, pacote.getPreco());
			pstm.setString(4, pacote.getDatasDisponiveis());
			pstm.setString(5, pacote.getDescricao());
			

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
	
	public List<PacoteDeViagem> read() {
		List<PacoteDeViagem> pacotes = new ArrayList<PacoteDeViagem>();
		String sql = "select * from Pacote_De_Viagem";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				PacoteDeViagem pacote = new PacoteDeViagem();

				pacote.setId(rset.getInt("PacoteID"));
				pacote.setDestino(rset.getString("Destino"));
				pacote.setItinerario(rset.getString("Itinerario"));
				pacote.setPreco(rset.getFloat("Preco"));
				pacote.setDatasDisponiveis(rset.getString("Datas_disponiveis"));
				pacote.setDescricao(rset.getString("descricao"));
				
				

				pacotes.add(pacote);
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

		return pacotes;
	}
	
	public void update(PacoteDeViagem pacote) {
		String sql = "UPDATE Pacote_De_Viagem SET Destino = ?, Itinerario = ?, Preco = ?, Datas_Disponiveis =?, Descricao =? WHERE PacoteID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getDestino());
			pstm.setString(2, pacote.getItinerario());
			pstm.setFloat(3, pacote.getPreco());
			pstm.setString(4, pacote.getDatasDisponiveis());
			pstm.setString(5, pacote.getDescricao());
			pstm.setInt(6, pacote.getId());

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
		String sql = "DELETE FROM Pacote_De_Viagem WHERE PacoteID = ?";

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
	
	public PacoteDeViagem readById(int id) {
		PacoteDeViagem pacote = new PacoteDeViagem();
		String sql = "select * from Pacote_De_Viagem WHERE PacoteID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			pacote.setId(rset.getInt("PacoteID"));
			pacote.setDestino(rset.getString("Destino"));
			pacote.setItinerario(rset.getString("Itinerario"));
			pacote.setPreco(rset.getFloat("Preco"));
			pacote.setDatasDisponiveis(rset.getString("Datas_disponiveis"));
			pacote.setDescricao(rset.getString("descricao"));
			

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
		return pacote;
	}
	
}
