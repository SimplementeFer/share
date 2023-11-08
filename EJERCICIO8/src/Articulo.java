

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

class Articulo {
    private String nombre;
    private int id_categoria;
    private double precio;
    private int stock;
    private Date fecha_ingreso;

    public Articulo(String nombre, int id_categoria, double precio, int stock) {
        this.nombre = nombre;
        this.id_categoria = id_categoria;
        this.precio = precio;
        this.stock = stock;

        // Establecer la fecha_ingreso como la fecha actual
        this.fecha_ingreso = new Date();
    }

    public void guardar() {
        try {
            Connection miConexion = ConexionDB.obtenerConexion();
            Statement miStatement = miConexion.createStatement();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Formatear la fecha como una cadena en el formato adecuado
            String fechaAltaStr = dateFormat.format(fecha_ingreso);

            //Consulta SQL

            String instruccionSql = "INSERT INTO articulos (nombre, id_categoria, precio, stock, fecha_ingreso) VALUES ('" + nombre + "', '" + id_categoria + "', '" + precio + "', '" + stock + "', '" + fechaAltaStr + "')";
            int filasAfectadas = miStatement.executeUpdate(instruccionSql);



            if (filasAfectadas > 0) {
                System.out.println("Articulo creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el articulo.");
            }

            miStatement.close();
            miConexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
