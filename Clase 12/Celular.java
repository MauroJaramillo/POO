class Celular {
    protected String marca;
    protected String modelo;

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void llamar(String numero) {
        System.out.println(marca + " " + modelo + " llamando al número " + numero + "...");
    }
}
