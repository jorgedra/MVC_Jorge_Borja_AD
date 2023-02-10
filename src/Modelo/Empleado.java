package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class Empleado implements Serializable {
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String cargo;
	private String fecha_ingreso;
	private double salario;
	private int idDepartamentos;
	public Empleado(int idEmpleado, String nombre, String apellido, String cargo, String fecha_ingreso, double salario,
			int idDepartamentos) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fecha_ingreso = fecha_ingreso;
		this.salario = salario;
		this.idDepartamentos = idDepartamentos;
	}
	public synchronized int getIdEmpleado() {
		return idEmpleado;
	}
	public synchronized void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public synchronized String getNombre() {
		return nombre;
	}
	public synchronized void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public synchronized String getApellido() {
		return apellido;
	}
	public synchronized void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public synchronized String getCargo() {
		return cargo;
	}
	public synchronized void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public synchronized String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public synchronized void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public synchronized double getSalario() {
		return salario;
	}
	public synchronized void setSalario(double salario) {
		this.salario = salario;
	}
	public synchronized int getIdDepartamentos() {
		return idDepartamentos;
	}
	public synchronized void setIdDepartamentos(int idDepartamentos) {
		this.idDepartamentos = idDepartamentos;
	}
	


	
	
}
