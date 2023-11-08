import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    public static Connection obtenerConexion() {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

