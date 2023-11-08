

import java.sql.*;
import java.util.Scanner;


class ClienteDePruebas extends Cliente {
    public ClienteDePruebas(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
    }

    private static Scanner scanner = new Scanner(System.in); // Declarar scanner como una variable estática

    public static void main(String[] args) {
        boolean salir = true;

        //Preguntamos si quiere conectarse a la tabla clientes o a la tabla articulos
        System.out.println("¿A qué tabla desea conectarse?");
        System.out.println("Pulsa 1 para conectarte a clientes");
        System.out.println("Pulsa 2 para conectarte a articulos");
        System.out.println("Pulsa 3 para conectarte a facturas:");
        System.out.println("Pulsa 4 para conectarte a detalles_factura:");
        System.out.print("Selecciona una opción: ");
        String tabla = scanner.nextLine();


        //si tabla es igual a 1, se conecta a la tabla clientes

        if (tabla.equals("1")) {

            while (salir) {


                mostrarMenu1();
                int opcion = obtenerOpcion();

                switch (opcion) {
                    case 1:
                        verTodosLosClientes();
                        break;
                    case 2:
                        crearNuevoCliente();
                        break;
                    case 3:
                        eliminarCliente();
                        break;
                    case 4:
                        actualizarCampoCliente();
                        break;
                    case 5:
                        salir = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }


            }
        } else if (tabla.equals("2")) {
            while (salir) {


                mostrarMenu2();
                int opcion = obtenerOpcion();

                switch (opcion) {
                    case 1:
                        verTodosLosArticulos();
                        break;
                    case 2:
                        crearNuevoArticulo();
                        break;
                    case 3:
                        eliminarArticulo();
                        break;
                    case 4:
                        actualizarCampoArticulo();
                        break;
                    case 5:
                        salir = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }
            }

        } else if (tabla.equals("3")) {
            while (salir) {

                mostrarMenu3();
                int opcion = obtenerOpcion();

                switch (opcion) {
                    case 1:
                        verTodasLasFacturas();
                        break;

                    case 2:
                        crearNuevaFactura();
                        break;

                    case 3:
                        eliminarFactura();
                        break;
                    case 4:
                        actualizarCampoFactura();
                        break;

                    case 5:
                        salir = false;
                        break;

                    default:

                        System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }


            }
        } else if (tabla.equals("4")) {
            while (salir) {

                mostrarMenu4();
                int opcion = obtenerOpcion();

                switch (opcion) {
                    case 1:
                        verTodosLosDetallesFactura();
                        break;

                    case 2:
                        crearNuevoDetalleFactura();
                        break;

                    case 3:
                        eliminarDetalleFactura();
                        break;
                    case 4:
                        actualizarCampoDetalleFactura();
                        break;

                    case 5:
                        salir = false;
                        break;

                    default:

                        System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }


            }
        }

        System.out.println("***Se ha salido de la aplicación con éxito***");
        scanner.close();
    }

    private static void mostrarMenu1() {
        System.out.println("----------------------------------------- TABLA CLIENTES --------------------------------------------");
        System.out.println("");
        System.out.println("1. Ver todos los clientes");
        System.out.println("2. Crear un nuevo cliente");
        System.out.println("3. Eliminar un cliente por ID");
        System.out.println("4. Actualizar un campo de un cliente por ID");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
    }
    private static void mostrarMenu2() {
        System.out.println("----------------------------------------- TABLA ARTÍCULOS --------------------------------------------");
        System.out.println("");
        System.out.println("1. Ver todos los articulos");
        System.out.println("2. Crear un nuevo articulo");
        System.out.println("3. Eliminar un articulo por ID");
        System.out.println("4. Actualizar un campo de un articulo por ID");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
    }

    private static void mostrarMenu3 () {
        System.out.println("----------------------------------------- TABLA FACTURAS --------------------------------------------");
        System.out.println("");
        System.out.println("1. Ver todas las facturas");
        System.out.println("2. Crear una nueva factura");
        System.out.println("3. Eliminar una factura por ID");
        System.out.println("4. Actualizar un campo de una factura por ID");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
    }

    private static void mostrarMenu4 () {
        System.out.println("----------------------------------------- TABLA DETALLES FACTURA --------------------------------------------");
        System.out.println("");
        System.out.println("1. Ver todos los detalles de factura");
        System.out.println("2. Crear un nuevo detalle de factura");
        System.out.println("3. Eliminar un detalle de factura por ID");
        System.out.println("4. Actualizar un campo de un detalle de factura por ID");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Selecciona una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    //para crear un nuevo cliente
    private static void crearNuevoCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, email, telefono);
        nuevoCliente.guardar();
    }
    //para crear un nuevo articulo

    private static void crearNuevoArticulo(){
        System.out.print("Ingrese el nombre del articulo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el id de la categoria: ");
        int id_categoria = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el precio del articulo: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Ingrese el stock del articulo: ");
        int stock = Integer.parseInt(scanner.nextLine());

        Articulo nuevoArticulo = new Articulo(nombre, id_categoria, precio, stock);
        nuevoArticulo.guardar();
    }

    private static void crearNuevaFactura(){


        Facturas nuevaFactura = new Facturas(id_factura, id_cliente, fecha, total);
        nuevaFactura.guardar();
    }

    private static void crearNuevoDetalleFactura(){

        DetallesFactura nuevoDetalleFactura = new DetallesFactura(id_detalle, id_factura, id_articulo, cantidad, precio);
        nuevoDetalleFactura.guardar();
    }



    private static void verTodosLosClientes() {
        System.out.println("----------------------------------------- TABLA CLIENTES -----------------------------------------");
        conecta1();
    }

    private static void verTodosLosArticulos() {
        System.out.println("----------------------------------------- TABLA ARTICULOS -----------------------------------------");
        conecta2();
    }

    private static void verTodasLasFacturas() {
        System.out.println("----------------------------------------- TABLA FACTURAS -----------------------------------------");
        conecta3();
    }

    private static void verTodosLosDetallesFactura() {
        System.out.println("----------------------------------------- TABLA DETALLES FACTURA -----------------------------------------");
        conecta4();
    }


    private static void conecta1() {
        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement();
             ResultSet miResultset = miStatement.executeQuery("SELECT id, nombre, email, telefono, fecha_alta FROM clientes")) {

            System.out.println("ID - Nombre - Email - Teléfono - Fecha");

            while (miResultset.next()) {
                int id = miResultset.getInt("id");
                String nombre = miResultset.getString("nombre");
                String email = miResultset.getString("email");
                String telefono = miResultset.getString("telefono");
                Date fecha_alta = miResultset.getDate("fecha_alta");

                System.out.println(id + " - " + nombre + " - " + email + " - " + telefono + " - " + fecha_alta);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void conecta2() {
        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement();
             ResultSet miResultset = miStatement.executeQuery("SELECT id_articulo, nombre, id_categoria, precio, stock, fecha_ingreso FROM articulos")) {

            System.out.println("ID - Nombre - ID Categoria - Precio - Stock - Fecha");

            while (miResultset.next()) {
                int id = miResultset.getInt("id_articulo");
                String nombre = miResultset.getString("nombre");
                int id_categoria = miResultset.getInt("id_categoria");
                double precio = miResultset.getDouble("precio");
                int stock = miResultset.getInt("stock");
                Date fecha_ingreso = miResultset.getDate("fecha_ingreso");

                System.out.println(id + " - " + nombre + " - " + id_categoria + " - " + precio + " - " + stock + " - " + fecha_ingreso);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void eliminarArticulo() {
        System.out.print("Ingrese el ID del articulo que desea eliminar: ");
        int idEliminar = Integer.parseInt(scanner.nextLine());

        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement()) {
            String eliminarSql = "DELETE FROM articulos WHERE id_articulo = " + idEliminar;
            int filasAfectadas = miStatement.executeUpdate(eliminarSql);

            if (filasAfectadas > 0) {
                System.out.println("Articulo con ID " + idEliminar + " eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún articulo con el ID " + idEliminar + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

    }

    private static void eliminarCliente() {
        System.out.print("Ingrese el ID del cliente que desea eliminar: ");
        int idEliminar = Integer.parseInt(scanner.nextLine());

        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement()) {
            String eliminarSql = "DELETE FROM clientes WHERE id = " + idEliminar;
            int filasAfectadas = miStatement.executeUpdate(eliminarSql);

            if (filasAfectadas > 0) {
                System.out.println("Cliente con ID " + idEliminar + " eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún cliente con el ID " + idEliminar + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void actualizarCampoCliente() {
        System.out.print("Ingrese el ID del cliente que desea actualizar: ");
        int idActualizar = Integer.parseInt(scanner.nextLine());

        System.out.print("Seleccione el campo a actualizar (nombre, email, telefono): ");
        String campo = scanner.nextLine();

        System.out.print("Ingrese el nuevo valor para " + campo + ": ");
        String nuevoValor = scanner.nextLine();

        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement()) {
            String actualizarSql = "UPDATE clientes SET " + campo + " = '" + nuevoValor + "' WHERE id = " + idActualizar;
            int filasAfectadas = miStatement.executeUpdate(actualizarSql);

            if (filasAfectadas > 0) {
                System.out.println("Campo " + campo + " actualizado para el cliente con ID " + idActualizar + ".");
            } else {
                System.out.println("No se encontró ningún cliente con el ID " + idActualizar + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void actualizarCampoArticulo(){
        System.out.print("Ingrese el ID del articulo que desea actualizar: ");
        int idActualizar = Integer.parseInt(scanner.nextLine());

        System.out.print("Seleccione el campo a actualizar (nombre, id_categoria, precio, stock): ");
        String campo = scanner.nextLine();

        System.out.print("Ingrese el nuevo valor para " + campo + ": ");
        String nuevoValor = scanner.nextLine();

        try (Connection miConexion = ConexionDB.obtenerConexion();
             Statement miStatement = miConexion.createStatement()) {
            String actualizarSql = "UPDATE articulos SET " + campo + " = '" + nuevoValor + "' WHERE id_articulo = " + idActualizar;
            int filasAfectadas = miStatement.executeUpdate(actualizarSql);

            if (filasAfectadas > 0) {
                System.out.println("Campo " + campo + " actualizado para el articulo con ID " + idActualizar + ".");
            } else {
                System.out.println("No se encontró ningún articulo con el ID " + idActualizar + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

    }
}
