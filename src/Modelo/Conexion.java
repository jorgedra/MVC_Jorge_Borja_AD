package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
 
    public static final String HOSTDB = "localhost";
    public static final String NOMBREDB = "empresa";
    public static final String USUARIODB = "root";
    public static final String CLAVEDB = "1234";
    public static final String PUERTOMYSQL = "3306";
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB +":"+PUERTOMYSQL + "/" + NOMBREDB;

    //----------------------------------------------------------....
    public static Connection conectarConBaseDeDatos() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URLMYSQL, USUARIODB, CLAVEDB);
            return conexion;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("no se pudo establecer la conexion con la base de datos");
            return null;
        }

    }
}
