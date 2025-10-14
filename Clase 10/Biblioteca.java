public class Biblioteca {

    public static void main(String[] args) {

        // Creación del primer objeto (Instancia)
        System.out.println("--- Añadiendo 'Cien Años de Soledad' ---");
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, 496);

        // Uso del toString() y un getter
        System.out.println("Datos iniciales: " + libro1.toString());
        System.out.println("Autor: " + libro1.getAutor());

        // Uso de un setter y un método de negocio
        libro1.setAnioPublicacion(1970);
        libro1.prestar();

        // Verificar estado con toString()
        System.out.println("Estado final: " + libro1);

        // Creación de un segundo objeto
        System.out.println("\n--- Añadiendo 'El Señor de los Anillos' ---");
        Libro libro2 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, 1216);

        // To String y Getter de libro2
        System.out.println("Datos Iniciales: " + libro2);
        System.out.println("Autor: " + libro2.getAutor());
        System.out.println("Paginas: " + libro2.getNumeroPaginas());

        // Negocio
        libro2.setAnioPublicacion(1954);
        libro2.getNumeroPaginas();
        libro2.prestar();

        // Estado Nuevamente:
        System.out.println("Estado Final" + libro2);
    }
}