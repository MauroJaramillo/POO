public class PrincipalA {
    public static void main(String[] args) {
        // Crear cuenta válida
        CuentaBancaria cuenta1 = new CuentaBancaria("Mauro Jaramillo", "123456", 100000);

        // Crear cuenta inválida (valores corregidos por validación)
        CuentaBancaria cuenta2 = new CuentaBancaria("", "123", -50);

        // Pruebas
        cuenta1.depositar(50000);
        cuenta1.retirar(30000);
        System.out.println("=== Cuenta 1 ===");
        System.out.println(cuenta1.toString());

        cuenta2.depositar(-1000); // intento de depósito inválido
        cuenta2.retirar(40);      // prueba de retiro
        System.out.println("\n=== Cuenta 2 ===");
        System.out.println(cuenta2.toString());
    }
}
