

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    private Date fecha_alta; // Cambiar a tipo Date

    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_alta = new Date(); // Establecer la fecha de alta como la fecha actual
    }

    public void guardar() {
        try {
            Connection miConexion = ConexionDB.obtenerConexion();
            Statement miStatement = miConexion.createStatement();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Formatear la fecha como una cadena en el formato adecuado
            String fechaAltaStr = dateFormat.format(fecha_alta);

            // Modificar la consulta SQL para incluir fecha_alta
            String instruccionSql = "INSERT INTO clientes (nombre, email, telefono, fecha_alta) VALUES ('" + nombre + "', '" + email + "', '" + telefono + "', '" + fechaAltaStr + "')";
            int filasAfectadas = miStatement.executeUpdate(instruccionSql);

            if (filasAfectadas > 0) {
                System.out.println("Cliente creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el cliente.");
            }

            miStatement.close();
            miConexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
