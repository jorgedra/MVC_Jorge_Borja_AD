package Controlador;

import java.util.ArrayList;

import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.BBDD;
import Vista.Interfaz;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Interfaz in = new Interfaz();
		BBDD bd = new BBDD();
		int opc=0;
		do {
			opc = in.menu();
			switch(opc) {
				case 1: 
					Empleado empleado = in.lecturaEmpleado();
					Boolean okEmpleado = bd.insertarEmpleado(empleado);
					if(okEmpleado) 
					{
						in.mensaje("El empleado se ha guardado correctamente");
					}
					else
					{
						in.mensaje("Error al insertar empleado");
					}
					break;
				case 2:
					Departamento departamento = in.lecturaDepartamento();
					Boolean okDepartamento = bd.insertarDepartamento(departamento);
					if(okDepartamento) 
					{
						in.mensaje("El departamento se ha guardado correctamente");
					}
					else
					{
						in.mensaje("Error al insertar departamento");
					}
					break;
				case 3: 
					ArrayList<Empleado> empleados = bd.obtenerEmpelado();
					in.mostrarEmpleado(empleados);
					break;
				case 4:
					ArrayList<Departamento> departamentos = bd.obtenerDepartamento();
					in.mostrarDepartamento(departamentos);
					break;
				case 5:
					Empleado empleadoB = in.borrarEmpleado();
					Boolean okBorrarE = bd.borrarEmpleado(empleadoB);
					if(okBorrarE)
					{
						in.mensaje("Empleado borrado correctamente");
					}
					else
					{
						in.mensaje("Error al borrar el empleado");
					}
					break;
				case 6:
					Departamento departamentoB = in.borrarDepartamento();
					Boolean okBorrarD = bd.borrarDepartamento(departamentoB);
					if(okBorrarD)
					{
						in.mensaje("Departamento borrado correctamente");
					}
					else
					{
						in.mensaje("Error al borrar el departamento");
					}
					break;
				case 7:
					bd.mostrarInformacionBaseDeDatos();
				case 8:
					in.mensaje("Saliendo...");
					in.limpiar(1000);
					break;
				default: in.mensaje("Introduce una opcion correcta");
			}
		} while(opc!=8);
	}

}
