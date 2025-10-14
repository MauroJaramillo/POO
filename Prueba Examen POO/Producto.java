public class Producto {
    // Atributos privados
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    // Constructor por defecto
    public Producto() {
        this.codigo = "0000";
        this.descripcion = "Sin descripción";
        this.cantidad = 1;
        this.precioUnitario = 0.0;
    }

    // Constructor parametrizado
    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        this.codigo = (codigo != null && !codigo.isEmpty()) ? codigo : "0000";
        this.descripcion = (descripcion != null && !descripcion.isEmpty()) ? descripcion : "Desconocido";
        this.cantidad = (cantidad >= 1) ? cantidad : 1;
        this.precioUnitario = (precioUnitario >= 0) ? precioUnitario : 0.0;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty()) this.codigo = codigo;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty()) this.descripcion = descripcion;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad >= 1) this.cantidad = cantidad;
    }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0) this.precioUnitario = precioUnitario;
    }

    // Método para calcular subtotal
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    // Método para aplicar descuento (0–50%)
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 50) {
            double descuento = calcularSubtotal() * (porcentaje / 100);
            precioUnitario -= (precioUnitario * (porcentaje / 100));
            System.out.println("Descuento aplicado: " + porcentaje + "%");
        } else {
            System.out.println("Porcentaje inválido. Debe estar entre 0 y 50%");
        }
    }

    // Método para incrementar cantidad
    public void incrementarCantidad(int valor) {
        if (valor > 0) {
            cantidad += valor;
        } else {
            System.out.println("Valor inválido para incrementar cantidad.");
        }
    }

    // Método para calcular total con impuesto del 8%
    public double calcularTotalConImpuesto() {
        double subtotal = calcularSubtotal();
        double impuesto = subtotal * 0.08;
        return subtotal + impuesto;
    }

    // Método toString
    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nDescripción: " + descripcion +
               "\nCantidad: " + cantidad +
               "\nPrecio unitario: $" + precioUnitario +
               "\nSubtotal: $" + calcularSubtotal() +
               "\nTotal con impuesto (8%): $" + calcularTotalConImpuesto();
    }
}