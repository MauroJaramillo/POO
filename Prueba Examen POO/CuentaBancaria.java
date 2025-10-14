public class CuentaBancaria {
    // Atributos privados
    private String titular;
    private String numeroCuenta;
    private double saldo;

    // Constructor por defecto
    public CuentaBancaria() {
        this.titular = "Sin nombre";
        this.numeroCuenta = "000000";
        this.saldo = 0.0;
    }

    // Constructor parametrizado con validaciones
    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            this.titular = "Desconocido";
        }

        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        } else {
            this.numeroCuenta = "000000";
        }

        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0.0;
        }
    }

    // Getters y Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= -50) { // permite sobregiro máximo de -50
            this.saldo = saldo;
        }
    }

    // Método depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    // Método retirar con sobregiro máximo de -50
    public void retirar(double monto) {
        if (monto > 0 && saldo - monto >= -50) {
            saldo -= monto;
        } else {
            System.out.println("No se puede retirar: excede el sobregiro permitido (-50).");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Titular: " + titular +
               "\nCuenta: " + numeroCuenta +
               "\nSaldo actual: $" + saldo;
    }
}
