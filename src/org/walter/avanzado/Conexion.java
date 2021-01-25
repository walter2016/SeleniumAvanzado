package org.walter.avanzado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection con;
    private static void conectar() {
        /*
         * Si la conexión ya se ha realizado, solo devolverá la conexión
         * Si no se ha realizado, realizará la conexión y la devolverá
         */
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regisro","root","");
        } catch (SQLException | ClassNotFoundException
                | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexion(){
        if(con == null){
            conectar();
        }
        return con;
    }


}
