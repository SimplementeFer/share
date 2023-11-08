import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Facturas {
    private int id_factura;
    private int id_cliente;
    private String fecha;
    private double total;

    public Facturas(int id_factura, int id_cliente, String fecha, double total) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public void guardar() {
        try {
            Connection miConexion = ConexionDB.obtenerConexion();
            Statement miStatement = miConexion.createStatement();

            //Consulta SQL

            String instruccionSql = "INSERT INTO facturas (id_factura, id_cliente, fecha, total) VALUES ('" + id_factura + "', '" + id_cliente + "', '" + fecha + "', '" + total + "')";
            int filasAfectadas = miStatement.executeUpdate(instruccionSql);

            if (filasAfectadas > 0) {
                System.out.println("Factura creada exitosamente.");
            } else {
                System.out.println("No se pudo crear la factura.");
            }

            miStatement.close();
            miConexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
