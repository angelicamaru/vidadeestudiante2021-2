package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entidades.Blog;
import com.entidades.BlogMapper;


public class ConexionBlog {
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

	// Añadir Blog nuevo
	public void BlogNuevo(Blog blog) {
		conexion();
		try (PreparedStatement stmt = con.prepareStatement(

				"INSERT INTO Blog VALUES (null,'" + blog.getFecha() + "','" + blog.getImagen()
				+ "','" + blog.getTitulo()+ "','" + blog.getDescripcion()+ "','" + blog.getAutor()+ "','" 
				+ blog.getEtiquetaUno()+ "','" + blog.getEtiquetaDos()+"')")) {
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error en la ejecuciÃ³n:" + sqle.getErrorCode() + " " + sqle.getMessage());
		}
	}
    
	
            
	//Traer Blog 
	public Blog traerBlog(String titulo) {
		conexion ();
		
		Blog blogS = new Blog();
		
		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT * FROM Blog WHERE Titulo= "+titulo)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				blogS = new Blog (rs.getInt("IdBlog"),rs.getString("Titulo"), rs.getString("Imagen"),
						rs.getString("Descripcion"), rs.getString("Autor"), rs.getString("Fecha"), 
						rs.getString("EtiquetaUno"),rs.getString("EtiquetaDos")); 
			}
			}catch (SQLException sqle) {
                System.out.println("Error en la ejecuciÃ³n:"+ sqle.getErrorCode() + " " + sqle.getMessage());     
		}
		System.out.println(blogS);
		return blogS;
		
	}
	
	
	//Traer Blog 
		public ArrayList<BlogMapper> traerBlogs() {
			conexion ();
			
			ArrayList<BlogMapper> blogs = new ArrayList<BlogMapper>();
			
			try (PreparedStatement stmt = con.prepareStatement(
					"SELECT IdBlog, Titulo, Imagen FROM Blog ")){
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					BlogMapper blog = new BlogMapper(rs.getInt("IdBlog"),rs.getString("Titulo"), rs.getString("Imagen"));						 
				blogs.add(blog);
				}
				}catch (SQLException sqle) {
	                System.out.println("Error en la ejecuciÃ³n:"+ sqle.getErrorCode() + " " + sqle.getMessage());     
			}
			System.out.println(blogs);
			return blogs;
			
		}
	
	

}
