public class DemoCelulares {
    public static void main(String[] args) {
        CelularBasico c1 = new CelularBasico("Nokia", "1100");
        Smartphone c2 = new Smartphone("Samsung", "Galaxy S23");

        c1.llamar("3105551234");
        c1.enviarSMS("Hola, ¿cómo estás?");

        c2.llamar("3109998888");
        c2.tomarFoto();
        c2.navegarInternet();
    }
}
