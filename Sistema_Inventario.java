import java.util.Scanner;

public class Sistema_Inventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;
        do {
            System.out.println("\n=== Menú de Inventario ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Mostrar Productos");
            System.out.println("4. Alertar Stock Bajo");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Actualizar Producto");
            System.out.println("7. Ordenar Productos por Precio");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido para la opción.");
                continue;
            }

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Categoría: ");
                        String categoria = scanner.nextLine();
                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(scanner.nextLine());

                        // Ingreso de los datos del proveedor
                        System.out.print("Nombre del proveedor: ");
                        String nombreProveedor = scanner.nextLine();
                        System.out.print("Contacto del proveedor: ");
                        String contactoProveedor = scanner.nextLine();
                        Proveedor proveedor = new Proveedor(nombreProveedor, contactoProveedor);

                        // Agregar el producto con el proveedor ingresado
                        inventario.agregarProducto(new Producto(nombre, categoria, cantidad, precio, proveedor));
                        System.out.println("Producto agregado.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Entrada no válida.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Producto producto = inventario.buscarProducto(nombreBuscar);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Lista de productos:");
                    inventario.mostrarProductos();
                    break;

                case 4:
                    try {
                        System.out.print("Ingresa el límite de stock bajo: ");
                        int limite = Integer.parseInt(scanner.nextLine());
                        inventario.alertarStockBajo(limite);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingresa un número válido.");
                    }
                    break;

                case 5:
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    inventario.eliminarProducto(nombreEliminar);
                    break;

                case 6:
                    System.out.print("Nombre del producto a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = Double.parseDouble(scanner.nextLine());
                    inventario.actualizarProducto(nombreActualizar, nuevaCantidad, nuevoPrecio);
                    break;

                case 7:
                    inventario.ordenarProductosPorPrecio();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}



