package Program;

import java.util.ArrayList;
import java.util.Scanner;
import models.Producto;
import models.DetalleVenta;

// ==================== CLASE PRINCIPAL ====================
public class Principal {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        ArrayList<DetalleVenta> detalles = new ArrayList<>();

        System.out.println("REGISTRO DE VENTA:");
        System.out.println("=======================");

        String continuar;

        do {
            // --- Ingresar y buscar código ---
            System.out.print("Ingrese CODIGO: ");
            int codigo = t.nextInt();

            Producto prod = Producto.getBuscarPorCodigo(codigo);

            if (prod == null) {
                System.out.println("Producto no encontrado. Intente nuevamente.\n");
                continuar = "s";          // Vuelve a pedir código
            } else {
                System.out.printf("PRODUCTO: %s - S/. %.2f%n",
                        prod.getDescripcion(), prod.getPrecio());

                System.out.print("CANTIDAD: ");
                int cantidad = t.nextInt();

                // Crear DetalleVenta y agregar al ArrayList
                DetalleVenta detalle = new DetalleVenta(prod, cantidad);
                detalles.add(detalle);

                System.out.print("Continuar [s/n]: ");
                continuar = t.next();
                System.out.println();
            }

        } while (continuar.equalsIgnoreCase("s"));

        // ---- Mostrar detalle de la venta ----
        System.out.println("\nDetalle de la Venta:");
        System.out.println("=========================================");

        double totalVenta = 0;

        for (DetalleVenta d : detalles) {
            System.out.printf("%d - %s - S/. %.2f - %d - S/. %.2f%n",
                    d.getProducto().getCodigo(),
                    d.getProducto().getDescripcion(),
                    d.getProducto().getPrecio(),
                    d.getCantidad(),
                    d.getTotal());
            totalVenta += d.getTotal();
        }

        double igv        = totalVenta * 0.18;
        double totalConIgv = totalVenta + igv;

        System.out.printf("%nTOTAL     S/. %.2f%n", totalVenta);
        System.out.printf("IGV       S/. %.2f%n", igv);
        System.out.printf("TOTAL IGV S/. %.2f%n", totalConIgv);

        t.close();
    }
}