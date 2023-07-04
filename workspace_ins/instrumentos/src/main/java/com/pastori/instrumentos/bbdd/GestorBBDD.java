package com.pastori.instrumentos.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.pastori.instrumentos.beans.Admin;
import com.pastori.instrumentos.beans.Cliente;
import com.pastori.instrumentos.beans.Instrumento;
import com.pastori.instrumentos.beans.Tipo;

public class GestorBBDD {
	static final String DB_URL = "jdbc:mysql://localhost:3306/instrumentos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "pacopacopaco";

	public Admin loginAdmin(String nombreLogin, String passLogin) {
		String queryLogin = "SELECT * FROM admin where nombre = '" + nombreLogin + "' and pass = '" + passLogin + "' ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryLogin);

			if (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setNombre(rs.getString("nombre"));
				return admin;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cliente loginCliente(String nombreLogin, String passLogin) {
		String queryCliente = "SELECT * FROM cliente where nombre = '" + nombreLogin + "' and pass = '"
				+ passLogin + "' ";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryCliente);
			System.out.println(nombreLogin + passLogin);

			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				
				return cliente;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public void addInstrumento(String nombreAlta, int idTipo) {
		String queryAlta = "INSERT INTO instrumento (nombre, id_tipo) VALUES " + "('" + nombreAlta + "', '" + idTipo
				+ "')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.prepareStatement(queryAlta);
			stmt.executeUpdate(queryAlta);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCliente(String nombreAlta, String apellidoAlta, String direccionAlta, String mailAlta,
			String passAlta) {
		String QueryCliente = "INSERT INTO CLIENTE (nombre, apellido, direccion, mail, pass) VALUES " + "('"
				+ nombreAlta + "', '" + apellidoAlta + "', '" + direccionAlta + "', '" + mailAlta + "', '" + passAlta
				+ "')";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.prepareStatement(QueryCliente);
			stmt.executeUpdate(QueryCliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Tipo> getListadoTipos() {
		String queryListadoTipos = "SELECT * FROM tipo";

		ArrayList<Tipo> tipos = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryListadoTipos);

			while (rs.next()) {

				int idTipo = rs.getInt("id");
				String nombreTipo = rs.getString("nombre");

				tipos.add(new Tipo(idTipo, nombreTipo));
			}
			return tipos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Instrumento> getListadoInstrumentos() {
		String queryListadoInstrumento = "SELECT * FROM instrumento";

		ArrayList<Instrumento> instrumentos = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryListadoInstrumento);

			while (rs.next()) {

				int idInstrumento = rs.getInt("id");
				String nombreInstrumento = rs.getString("nombre");
				int idTipo = rs.getInt("id_tipo");
				
				System.out.println(idTipo);

				instrumentos.add(new Instrumento(idInstrumento, nombreInstrumento, idTipo));
			}
			return instrumentos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Tipo getTipoById(int idTipo) {
		String queryTipoById = "SELECT * FROM tipo where id = '" + idTipo + "' ";

		Tipo tipo = new Tipo();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryTipoById);

			while (rs.next()) {
				
				String nombreTipo = rs.getString("nombre");
				System.out.println(queryTipoById + "especialidad por id " + nombreTipo );

				tipo = new Tipo(idTipo, nombreTipo);
			}
			return tipo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void borrarInstrumento(int id) {
		String queryBorrar = "DELETE FROM instrumento where id = '" + id + "' ";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.prepareStatement(queryBorrar);
			int contact = stmt.executeUpdate(queryBorrar);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarInstrumento(int idCambio, String nombreCambio, int idTipoCambio) {
		String queryActualizar = "UPDATE instrumento SET nombre = '" + nombreCambio + "', id_tipo = '" + idTipoCambio
				+ "' where id = '" + idCambio + "' ";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryActualizar);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actualizaCliente(int idCambio, String nombreCambio, String apellidoCambio, String direccionCambio,
			String mailCambio, String passCambio) {
		String queryCambio = "UPDATE cliente SET nombre = '" + nombreCambio + "', apellido = '" + apellidoCambio + "', direccion = '" + direccionCambio + "', mail = '"
        + mailCambio + "', pass = '" + passCambio + "' where id = '" + idCambio + "' ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryCambio);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Instrumento buscar(String nombreInstrumento) {
		String queryBuscar = "SELECT * FROM instrumentos where nombre = '" + nombreInstrumento + "' ";
		
		Instrumento ins = new Instrumento();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("queryBuscar");
			System.out.println(queryBuscar);
			
			while (rs.next()) {

				int idInstrumento = rs.getInt("id");
				String nombreBusqueda = rs.getString("nombre");
				int idTipo = rs.getInt("id_tipo");

				ins = new Instrumento(idInstrumento, nombreInstrumento, idTipo);
			}
			return ins;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
