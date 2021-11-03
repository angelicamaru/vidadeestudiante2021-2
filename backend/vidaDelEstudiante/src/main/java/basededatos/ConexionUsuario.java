package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.entidades.Usuario;
import com.entidades.UsuarioMapper;

public class ConexionUsuario {

	private final String url = "jdbc:mysql://localhost/vidadeEstudiante?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public void conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "Milonga");

			if (con != null) {
				System.out.println("Conexión a base de datos funcionando");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("Algo fallo");// las mostramos en consola
		}

	}

	/**
	 * Conectar BD
	 *
	 * @return conexion
	 */
	public Connection conectado() {
		return con;
	}

	// Desconectar
	/**
	 * Desconectarla por seguridad
	 */
	public void desconectar() {
		con = null;
		System.out.println("La conexion la BD se ha cerrado");
	}

	// Métodos SQL
	/**
	 * Crear Usuario en la BD
	 * 
	 * @param usuario
	 */
	public void usuarioNuevo(Usuario usuario) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuario VALUES (null,'" + usuario.getNombre()
				+ "','" + usuario.getClave() + "','" + usuario.getCorreo() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
	}

	/**
	 * Enviar un usuario
	 *
	 * @param correo
	 * @return Usuario o null si no existe
	 */
	public UsuarioMapper getUsuario(String correo) {
		conexion();
		UsuarioMapper elUsuario = null;
		String sql = "SELECT * FROM Usuario Where Correo='" + correo + "'";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					elUsuario = new UsuarioMapper(rs.getString("Correo"), rs.getString("Clave"));
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return elUsuario;
	}

	/**
	 * Devuelve solo correo y clave
	 *
	 * @param usuario
	 * @return UsuarioMapper
	 */
	public UsuarioMapper getUsuarioMapper(UsuarioMapper usuario) {
		conexion();
		UsuarioMapper elUsuario = null;
		String sql = "SELECT * FROM Usuario WHERE Correo='" + usuario.getCorreo() + "' AND Clave='" + usuario.getClave()
				+ "'";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					elUsuario = new UsuarioMapper(rs.getString("Correo"), rs.getString("Clave"));
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return elUsuario;
	}
}
