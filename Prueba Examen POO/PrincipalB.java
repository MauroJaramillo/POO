public class PrincipalB {
    public static void main(String[] args) {
        // Crear producto válido
        Producto p1 = new Producto("A001", "Jarabe para la tos", 10, 5000);

        // Crear producto inválido
        Producto p2 = new Producto("", "", -2, -1000);

        // Pruebas
        p1.aplicarDescuento(10);      // Aplica 10% de descuento
        p1.incrementarCantidad(5);    // Aumenta en 5 unidades

        System.out.println("=== Producto 1 ===");
        System.out.println(p1.toString());

        System.out.println("\n=== Producto 2 ===");
        System.out.println(p2.toString());
    }
}
