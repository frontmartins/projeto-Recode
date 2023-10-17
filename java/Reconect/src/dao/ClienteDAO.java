package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;

public class ClienteDAO {
	public void create(Cliente cliente) {

		String sql = "insert into Cliente (nome, endereco, telefone, email, historico_de_viagens) values (?, ?, ?,?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getHistoricoDeViagem());

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
	
	public List<Cliente> read() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from Cliente";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("ClienteID"));
				cliente.setNome(rset.getString("Nome"));
				cliente.setEndereco(rset.getString("Endereco"));
				cliente.setTelefone(rset.getString("Telefone"));
				cliente.setEmail(rset.getString("Email"));
				cliente.setHistoricoDeViagem(rset.getString("Historico_De_Viagens"));
				
				

				clientes.add(cliente);
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

		return clientes;
	}
	
	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET Nome = ?, Endereco = ?, Telefone = ?, Email =?,Historico_de_Viagens=? WHERE ClienteID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getHistoricoDeViagem());
			pstm.setInt(6, cliente.getId());

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
		String sql = "DELETE FROM Cliente WHERE ClienteID = ?";

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
	public Cliente readById(int id) {
		Cliente cliente = new Cliente();
		String sql = "select * from Cliente WHERE ClienteID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setId(rset.getInt("ClienteID"));
			cliente.setNome(rset.getString("Nome"));
			cliente.setEndereco(rset.getString("Endereco"));
			cliente.setTelefone(rset.getString("Telefone"));
			cliente.setEmail(rset.getString("Email"));
			cliente.setHistoricoDeViagem(rset.getString("Historico_De_Viagens"));

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
		return cliente;
	}



}
