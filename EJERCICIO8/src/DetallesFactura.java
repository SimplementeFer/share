
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetallesFactura {
    private int id_detalle;
    private int id_factura;
    private int id_articulo;
    private int cantidad;
    private double precio;

    public DetallesFactura(int id_detalle,  int id_factura, int id_articulo, int cantidad, double precio) {
        this.id_detalle = id_detalle;
        this.id_factura = id_factura;
        this.id_articulo = id_articulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void guardar() {
        try {
            Connection miConexion = ConexionDB.obtenerConexion();
            Statement miStatement = miConexion.createStatement();

            //Consulta SQL



            String instruccionSql = "INSERT INTO detalles_factura (id_detalle, id_factura, id_articulo, cantidad, precio) VALUES ('" + id_detalle + "', '" + id_factura + "', '" + id_articulo + "', '" + cantidad + "', '" + precio + "')";
            int filasAfectadas = miStatement.executeUpdate(instruccionSql);

            if (filasAfectadas > 0) {
                System.out.println("Detalle de factura creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el detalle de factura.");
            }

            miStatement.close();
            miConexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
