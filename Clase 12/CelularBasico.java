class CelularBasico extends Celular {
    public CelularBasico(String marca, String modelo) {
        super(marca, modelo);
    }

    public void enviarSMS(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}

class Smartphone extends Celular {
    public Smartphone(String marca, String modelo) {
        super(marca, modelo);
    }

    public void tomarFoto() {
        System.out.println(marca + " " + modelo + " tomó una foto con su cámara HD 📸");
    }

    public void navegarInternet() {
        System.out.println(marca + " " + modelo + " está navegando por Internet 🌐");
    }
}
