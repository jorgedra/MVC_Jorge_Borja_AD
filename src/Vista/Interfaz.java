package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Departamento;
import Modelo.Empleado;

public class Interfaz {

	public int menu() {
		int opc = 0;
		mensaje("======[MENU]======");
		mensaje("1. Insertar empleado");
		mensaje("2. Insertar departamento");
		mensaje("3. Mostrar empleados");
		mensaje("4. Mostrar departamentos");
		mensaje("5. Borrar empleado");
		mensaje("6. Borrar departamento");
		mensaje("7. Mostrar datos de la BBDD");
		mensaje("8. Salir del programa");
		mensaje("======[Elige una opcion]======");
		opc = new Scanner(System.in).nextInt();
		return opc;
	}

	public Empleado lecturaEmpleado() {
		Scanner sc = new Scanner(System.in);
		mensaje("Introduce el id del empleado");
		int idEmpleado = sc.nextInt();
		sc.nextLine();
		mensaje("Introduce el nombre del empleado");
		String nombre = sc.next();
		mensaje("Introduce el apellido del empleado");
		String apellido = sc.next();
		mensaje("Introduce el cargo del empleado");
		String cargo = sc.next();
		mensaje("Introduce la fecha del ingreso del empleado");
		String fecha = sc.next();
		mensaje("Introduce el salario del empleado");
		double salario = sc.nextDouble();
		sc.nextLine();
		mensaje("Introduce el id del departamento del empleado");
		int idDepartamento = sc.nextInt();
		sc.nextLine();
		return new Empleado(idEmpleado, nombre, apellido, cargo, fecha, salario, idDepartamento);
	}

	public Departamento lecturaDepartamento() {
		Scanner sc = new Scanner(System.in);
		mensaje("Introduce el id del departamento");
		int idDepartamento = sc.nextInt();
		sc.nextLine();
		mensaje("Introduce el nombre del departamento");
		String nombre = sc.next();
		mensaje("Introduce la localizacion del departamento");
		String localizacion = sc.next();
		return new Departamento(idDepartamento, nombre, localizacion);
	}

	public void mostrarEmpleado(ArrayList<Empleado> empleados) {
		for (Empleado e : empleados) {
			mensaje("Id empleado: " + e.getIdEmpleado());
			mensaje("Nombre empleado: " + e.getNombre());
			mensaje("Apellido empleado: " + e.getApellido());
			mensaje("Cargo empleado: " + e.getCargo());
			mensaje("Fecha ingreso empleado: " + e.getFecha_ingreso());
			mensaje("Salario empleado: " + e.getSalario());
			mensaje("Departamento empleado: " + e.getIdDepartamentos());
			mensaje("=====================================================");
		}
	}

	public void mostrarDepartamento(ArrayList<Departamento> departamentos) {
		for (Departamento d : departamentos) {
			mensaje("Id departamento: " + d.getIdDepartamento());
			mensaje("Nombre departamento: " + d.getNombreDepartamento());
			mensaje("Localizacion empleado: " + d.getLocalizacion());
			mensaje("=====================================================");
		}
	}

	public Empleado borrarEmpleado() {
		Scanner sc = new Scanner(System.in);
		mensaje("Introduce el id del empleado a borrar");
		int idEBorrar = sc.nextInt();
		return new Empleado(idEBorrar, null, null, null, null, 0.0, 0);
	}

	public Departamento borrarDepartamento() {
		Scanner sc = new Scanner(System.in);
		mensaje("Introduce el id del departamento a borrar");
		int idDBorrar = sc.nextInt();
		return new Departamento(idDBorrar, null, null);
	}

	public void mensaje(String texto) {
		System.out.println(texto);
	}

	public void limpiar(int lineas)

	{

		for (int i = 0; i < lineas; i++)

		{

			System.out.println();

		}
	}
}
