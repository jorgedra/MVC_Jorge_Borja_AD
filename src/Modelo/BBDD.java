package Modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Conexion;
import Modelo.Departamento;
import Modelo.Empleado;

public class BBDD {
	
	public static ArrayList<Empleado> obtenerEmpelado() {
        Connection conexion = Conexion.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM empleados";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                int idEmpleado = resultado.getInt("idEmpleado");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String cargo = resultado.getString("cargo");
                String fecha_ingreso = resultado.getString("fecha_ingreso");
                double salario = resultado.getDouble("salario");
                int departamento = resultado.getInt("idDepartamento");
                Empleado e = new Empleado(idEmpleado, nombre,apellido, cargo,fecha_ingreso, salario,departamento); 
                empleados.add(e);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return empleados;
        } catch (SQLException e) {
            return empleados;
        }
    }
	
	public static ArrayList<Departamento> obtenerDepartamento() {
        Connection conexion = Conexion.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM departamentos";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                int idDepartamento = resultado.getInt("idDepartamento");
                String d_nombre = resultado.getString("d_nombre");
                String d_localizacion = resultado.getString("d_localizacion");
                Departamento d = new Departamento(idDepartamento, d_nombre,d_localizacion);           
                departamentos.add(d);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return departamentos;
        } catch (SQLException e) {
            return departamentos;
        }
    }

   

    public static boolean borrarEmpleado(Empleado empleado1) {
        Connection conexion = Conexion.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
        	int id = empleado1.getIdEmpleado();
            String ordensql = "DELETE FROM empleados WHERE (idEmpleado = ?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setInt(1, id);
            int filasafectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean borrarDepartamento(Departamento departamento1) {
        Connection conexion = Conexion.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
        	int id = departamento1.getIdDepartamento();
            String ordensql = "DELETE FROM departamentos WHERE (idDepartamento = ?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setInt(1, id);
            int filasafectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean insertarEmpleado(Empleado e) {
        Connection conexion = Conexion.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "INSERT INTO empleados (idEmpleado, nombre, apellido, cargo, fecha_ingreso, salario, idDepartamento) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setInt(1, e.getIdEmpleado());
	        sentencia.setString(2, e.getNombre());
	        sentencia.setString(3,e.getApellido());
	        sentencia.setString(4,e.getCargo());
	        sentencia.setString(5, e.getFecha_ingreso());
	        sentencia.setDouble(6, e.getSalario());
	        sentencia.setInt(7, e.getIdDepartamentos());
            int filasafectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e1) {
            return false;
        }
    }
    
    public static boolean insertarDepartamento(Departamento d) {
	    Connection conexion = Conexion.conectarConBaseDeDatos();
	    if(conexion == null)
	    {
	        return false;
	    }
	    try {
	        String ordensql = "INSERT INTO departamentos (idDepartamento, d_nombre, d_localizacion) VALUES (?, ?, ?);";
	        PreparedStatement sentencia = conexion.prepareStatement(ordensql);
	        sentencia.setInt(1, d.getIdDepartamento());
	        sentencia.setString(2, d.getNombreDepartamento());
	        sentencia.setString(3, d.getLocalizacion());
	        
	        int filasafectadas = sentencia.executeUpdate();
	        sentencia.close();
	        conexion.close();
	        if(filasafectadas > 0)
	        {
	            return true;
	        }
	        else {
	            return false;
	        }
	    } catch (SQLException e1) {
	        return false;
	    }
	}
    
public static void mostrarInformacionBaseDeDatos(){
		
		try {
			Connection c = Conexion.conectarConBaseDeDatos();
			DatabaseMetaData dbmd = c.getMetaData(); 
			String nombreDB = c.getCatalog();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			//----------------------------------------------
			System.out.println("-------------------------------------------");
			System.out.println("nombre de la base de datos: " + nombreDB);
			System.out.println("driver: " + driver);
			System.out.println("url: " + url);
			System.out.println("usuario: " + usuario);
			System.out.println("----------------------TABLAS---------------");

			//----------------------------------------------
			ResultSet result = dbmd.getTables(nombreDB,null, null, null);
			while(result.next())
			{
				
				String tabla = result.getString(3);
	
				System.out.println("----------tabla "  + tabla +": ---------------");
				ResultSet resultabla = dbmd.getColumns(null, null, tabla, null);
				int nColumnas = 0;
				while(resultabla.next())
				{
					String nombrecol = resultabla.getString("COLUMN_NAME");
					String tipocol = resultabla.getString("TYPE_NAME");
					String tamcol = resultabla.getString("COLUMN_SIZE");
					String nulo = resultabla.getString("IS_NULLABLE");
					System.out.println("columna->" + nombrecol + " , tipo:" + tipocol + " , tam:" + tamcol + " , nulo:" + nulo );	
					nColumnas ++;
				}
				System.out.println("Numero de columnas de la tabla " + tabla + " : " +  nColumnas);
			}			System.out.println("-------------------------------------------");			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
