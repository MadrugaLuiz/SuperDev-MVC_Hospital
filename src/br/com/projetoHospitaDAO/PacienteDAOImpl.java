package br.com.projetoHospitaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoMVC.model.Medico;
import br.com.projetoMVC.model.Paciente;
import br.com.projetoMVC.util.ConnectionFactory;

public class PacienteDAOImpl implements GenericDAO {

	private Connection conn;

	// Construtor vazio da classe ProdutoDAOImpl, iniciando a conexão com o banco
	// de dados atráves da classe ConnectionFactory

	public PacienteDAOImpl() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Object> listarTodos() {
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Paciente ";

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setIsInternado(rs.getBoolean("isInternado"));
				lista.add(paciente);
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Medico" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão!" + e.getMessage());
			}
		}

		return lista;
	}

	public Object listarPorId(int id) {

		Paciente paciente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select * FROM paciente WHERE id = ? ";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setIsInternado(rs.getBoolean("isInternado"));
			}

		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Paciente por id " + ex.getMessage());
			ex.printStackTrace();

		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar  conexão " + e.getMessage());
				e.printStackTrace();

			}
		}

		return paciente;
	}

	public boolean cadastrar(Object object) {

		Paciente paciente = (Paciente) object;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO paciente (nome,cpf,idade,isInternado) VALUES (?,?,?,?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setInt(3, paciente.getIdade());
			stmt.setBoolean(4, paciente.getIsInternado());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao cadastrar Paciente" + ex.getMessage());
			ex.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão!" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public boolean alterar(Object object) {

		return false;
	}

	public void excluir(int id) {

	}

}
