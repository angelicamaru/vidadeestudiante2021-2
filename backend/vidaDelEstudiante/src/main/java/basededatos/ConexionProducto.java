package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.entidades.Producto;
import com.entidades.Productos;
import java.util.ArrayList;

public class ConexionProducto {
        private ArrayList<Productos> productos = new ArrayList<Productos>();
	private final String url = "jdbc:mysql://localhost/vidadeestudiante?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public void conexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "Milonga");

			if (con != null) {
				System.out.println("Conexión a base de datos funcionando");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			System.out.println(" Algo fallo");// las mostramos en consola
		}

	}

	// Conectar
	public Connection conectado() {
		return con;
	}

	// Desconectar
	public void desconectar() {
		con = null;
		System.out.println("La conexion la BD se ha cerrado");
	}

	// Métodos sql

	// Añadir producto nuevo
	public void productoNuevo(Producto producto) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Producto VALUES (null,'" + producto.getNombre() + "','" + producto.getDescripcion() + "',"
						+ producto.getPrecio() + ",'" + producto.getImagen() +"','" + producto.getNumeroDisponible() + "')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
	}
	
	// Traer producto 
		public Producto traerProducto(String id) {
			conexion();
	Producto productoS = new Producto();
	try (PreparedStatement stmt = con.prepareStatement(
			"SELECT * FROM Producto WHERE idProducto= "+id)){
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			productoS = new Producto (rs.getFloat("Precio"),rs.getInt("IdProducto"),rs.getString("Imagen"),rs.getString("Nombre"), rs.getString("Descripcion"),
					  rs.getInt("NumeroDisponible"));
		}
		}catch (SQLException sqle) {
            System.out.println("Error en la ejecuciÃ³n:"+ sqle.getErrorCode() + " " + sqle.getMessage());     
	}
	System.out.println(productoS);
	return productoS;
		}
	//Traer Productos
		public ArrayList<Productos> traerProducto() {
		Productos elProducto;
        String sql = "SELECT * FROM Producto";
        conexion();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               
                elProducto = new Productos( rs.getInt("IdProducto") , rs.getString("Nombre"), rs.getString("Descripcion"),rs.getFloat("Precio"), rs.getString("Imagen"));
                this.productos.add( elProducto);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return productos;
    }

}
