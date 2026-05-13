package models;

// ==================== CLASE DetalleVenta ====================
public class DetalleVenta {
    private Producto producto;
    private int      cantidad;
    private double   total;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total    = producto.getPrecio() * cantidad;
    }

    // Getters
    public Producto getProducto() { return producto; }
    public int      getCantidad() { return cantidad; }
    public double   getTotal()    { return total; }
}
