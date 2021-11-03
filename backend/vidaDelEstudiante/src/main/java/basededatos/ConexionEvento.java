package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entidades.Evento;

public class ConexionEvento {

	private final String url = "jdbc:mysql://localhost/vidadeestudiante?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public void conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "Milonga");

			if (con != null) {
				//System.out.println("Conexión a base de datos funcionando :)");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("El fallo fue: " + e);
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

	/**
	 * Desconectarla por seguridad
	 */
	public void desconectar() {
		con = null;
		System.out.println("La conexion la BD se cerro");
	}

	// Métodos SQL
	/**
	 * Agregar un evento a la BD
	 * 
	 * @param elEvento
	 */
	public int addEvent(Evento elEvento) {
		conexion();
		int Error = 0;
		String sql = "INSERT INTO Evento (idEvento,fecha,imagen,titulo,descripcion,lugar,promotor,contacto,costo) "
				+ "VALUES (null,'" + elEvento.getFecha() + "','" + elEvento.getImagen() + "','" + elEvento.getTitulo()
				+ "','" + elEvento.getDescripcion() + "','" + elEvento.getLugar() + "','" + elEvento.getPromotor()
				+ "','" + elEvento.getContacto() + "','" + elEvento.getCosto() + "')";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + ", " + sqle.getMessage());
			Error = sqle.getErrorCode();
		}
		return Error;
	}

	/**
	 * Valida que no haya evento con valores iguales (imagen, titulo, promotor)
	 * 
	 * @param Evento
	 * @return true si no existe un evento con esos valores
	 */
	public boolean validaEvento(Evento Evento) {
		this.deleteEvents();
		conexion();
		Evento elEvento = null;
		String sql = "SELECT * FROM Evento Where Imagen='" + Evento.getImagen() + "' AND Titulo='" + Evento.getTitulo()
				+ "' AND Promotor='" + Evento.getPromotor() + "'";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					elEvento = new Evento(rs.getInt("IdEvento"), rs.getString("Fecha"), rs.getString("Imagen"),
							rs.getString("Titulo"), rs.getString("Descripcion"), rs.getString("Lugar"),
							rs.getString("Promotor"), rs.getString("Contacto"), rs.getInt("Costo"));
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		if (elEvento != null) {
			return false;
		}
		return true;
	}

	/**
	 * @return El mayor número según los IdEventos que existen en la BD
	 */
	public int getMaxId() {
		this.deleteEvents();
		conexion();
		// Para saber cuantos eventos hay
		int id = 0;
		String sqlID = "SELECT max(IdEvento) FROM Evento;";
		try (PreparedStatement stmt = con.prepareStatement(sqlID)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return id;
	}

	/**
	 * @return El menor número según los IdEventos que existen en la BD
	 */
	public int getMinId() {
		this.deleteEvents();
		conexion();
		// Para saber desde donde hay eventos (numero mas pequeño de ID)
		int id = 0;
		String sqlID = "SELECT min(IdEvento) FROM Evento;";
		try (PreparedStatement stmt = con.prepareStatement(sqlID)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return id;
	}

	/**
	 * Cuenta cuantos eventos hay en la BD
	 * @return numero de eventos en la BD
	 */
	public int CountEvents() {
		this.deleteEvents();
		conexion();
		int id = 0;
		String sqlID = "SELECT COUNT(*) FROM evento;";
		try (PreparedStatement stmt = con.prepareStatement(sqlID)) {
			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return id;
	}
	
	/**
	 * Elimina eventos cuya fecha no esta vigente.
	 */
	public void deleteEvents() {
		conexion();
		String sql = "DELETE FROM evento WHERE Fecha<NOW()-1000000;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
	}

	/**
	 * @return arreglo con eventos en la BD
	 */
	public Evento[] getEventos() {
		this.deleteEvents();
		conexion();
		Evento[] eventos = new Evento[this.CountEvents()];
		int ubicacion = 0, i = 0;
		String id;

		// Para tener cada IdEvento evitando generar errores
		String sqlId = "SELECT IdEvento FROM Evento ORDER BY Fecha ASC";
		try (PreparedStatement stmt = con.prepareStatement(sqlId)) {
			ResultSet rst = stmt.executeQuery();
			if (rst != null) {
				while (rst.next()) {
					ubicacion = rst.getInt("IdEvento");
					// System.out.println("Evento tal: " + ubicacion + " <3");
					Evento elEvento = null;
					// LLenar array para enviar
					String sql = "SELECT * FROM Evento Where IdEvento='" + ubicacion + "'";
					try (PreparedStatement stmtl = con.prepareStatement(sql)) {
						ResultSet rs = stmtl.executeQuery();
						if (rs != null) {
							while (rs.next()) {
								elEvento = new Evento(rs.getInt("IdEvento"), rs.getString("Fecha"),
										rs.getString("Imagen"), rs.getString("Titulo"), rs.getString("Descripcion"),
										rs.getString("Lugar"), rs.getString("Promotor"), rs.getString("Contacto"),
										rs.getInt("Costo"));
								// System.out.println(elEvento.toString());
								eventos[i]=elEvento;
							}
							//System.out.println(i); verificar comportamiento de i
						}
						i++;
					} catch (SQLException sqle) {
						System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());

					}
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecucion:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
		return eventos;
	}
}
