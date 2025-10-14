public class Libro {

    // 1. Atributos (Encapsulamiento con 'private')
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;
    private boolean prestado;

    // 2. Constructor
    public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.prestado = false; // Estado inicial
    }

    // 3. Getters (Lectura)
    public String getTitulo() {
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getNumeroPaginas(){
        return numeroPaginas;
    }

    // 3. Setters (Escritura/Modificación)
    public void setAnioPublicacion(int anio) {
        if (anio <= 2025 && anio > 0) {
            this.anioPublicacion = anio;
        } else {
            System.out.println("Error: Año de publicación inválido.");
        }
    }

    // 4. Métodos de Negocio (Comportamiento)
    public boolean prestar() {
        if (!this.prestado) {
            this.prestado = true;
            System.out.println("El libro '" + this.titulo + "' ha sido prestado exitosamente.");
            return true;
        } else {
            System.out.println("El libro '" + this.titulo + "' ya está prestado.");
            return false;
        }
    }

    // 5. Método toString()
    @Override
    public String toString() {
        String estado = this.prestado ? "PRESTADO" : "DISPONIBLE";

        return "Libro [Título: " + titulo +
                ", Autor: " + autor +
                ", Año: " + anioPublicacion +
                ", Páginas: " + numeroPaginas +
                ", Estado: " + estado +
                "]";
    }
}