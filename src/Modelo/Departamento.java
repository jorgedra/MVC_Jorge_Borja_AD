package Modelo;

import java.io.Serializable;

public class Departamento implements Serializable{

	private int idDepartamento;
	private String nombreDepartamento;
	private String localizacion;
	
	public Departamento(int idDepartamento, String nombreDepartamento, String localizacion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.localizacion = localizacion;
	}

	public synchronized int getIdDepartamento() {
		return idDepartamento;
	}

	public synchronized void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public synchronized String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public synchronized void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public synchronized String getLocalizacion() {
		return localizacion;
	}

	public synchronized void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	
	
}
