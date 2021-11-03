package com.entidades;

public class Evento {
	
	private int IdEvento;
	private String Fecha;
	private String Imagen;
	private String Titulo;
	private String Descripcion;
    private String Lugar;
    private String Promotor;
    private String Contacto;
	private int Costo;
	
	public Evento() {
		IdEvento = 0;
		Fecha = "";
		Imagen = "";
		Titulo = "";
		Descripcion = "";
        Lugar = "";
        Promotor = "";
        Contacto = "";
        Costo =0;
	}

    public Evento(int idEvento, String fecha, String imagen, String titulo, String descripcion, String lugar,
			String promotor, String contacto, int costo) {
		super();
		IdEvento = idEvento;
		Fecha = fecha;
		Imagen = imagen;
		Titulo = titulo;
		Descripcion = descripcion;
		Lugar = lugar;
		Promotor = promotor;
		Contacto = contacto;
		Costo = costo;
	}

	public int getCosto() {
		return Costo;
	}

	public void setCosto(int costo) {
		Costo = costo;
	}

	public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getPromotor() {
        return Promotor;
    }

    public void setPromotor(String Promotor) {
        this.Promotor = Promotor;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

	public int getIdEvento() {
		return IdEvento;
	}

	public void setIdEvento(int idEvento) {
		IdEvento = idEvento;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Evento [IdEvento=" + IdEvento + ", Fecha=" + Fecha + ", Imagen=" + Imagen + ", Titulo=" + Titulo
				+ ", Descripcion=" + Descripcion + ", Lugar=" + Lugar + ", Promotor=" + Promotor + ", Contacto="
				+ Contacto + ", Costo=" + Costo + "]";
	}
}
