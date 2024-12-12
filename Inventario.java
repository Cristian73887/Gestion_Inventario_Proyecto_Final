import java.util.ArrayList;
import java.util.Comparator;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null; // Si no se encuentra
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public void alertarStockBajo(int limite) {
        System.out.println("Productos con stock bajo:");
        for (Producto producto : productos) {
            if (producto.getCantidad() < limite) {
                System.out.println(producto);
            }
        }
    }

    public void eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarProducto(String nombre, int nuevaCantidad, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            producto.setPrecio(nuevoPrecio);
            System.out.println("Producto actualizado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void ordenarProductosPorPrecio() {
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Productos ordenados por precio.");
    }
}

