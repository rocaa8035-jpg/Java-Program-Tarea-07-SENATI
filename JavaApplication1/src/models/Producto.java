package models;

// ==================== CLASE Producto ====================
public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    // Array estático con los 5 productos predefinidos
    private static Producto[] catalogo = {
        new Producto(100, "TELEVISOR",     1500),
        new Producto(300, "LICUADORA",      300),
        new Producto(500, "LAVADORA",       800),
        new Producto(700, "REFRIGERADORA", 2500),
        new Producto(900, "EQUIPO",         750)
    };

    // Constructor
    public Producto(int codigo, String descripcion, double precio) {
        this.codigo      = codigo;
        this.descripcion = descripcion;
        this.precio      = precio;
    }

    // Getters
    public int    getCodigo()      { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio()      { return precio; }

    // Método estático que busca en el arreglo y retorna el Producto encontrado
    public static Producto getBuscarPorCodigo(int codigo) {
        for (Producto p : catalogo) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // No encontrado
    }
}