//Caso 1
public class CalculadoraTransporte {
    public static void main(String[] args) {
        //Datos base de viaje
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double precioLitro = 1.35, masaCargaKg = 1200;
        double largo = 2.0, ancho = 1.2, alto = 1.1;
        double p1 = 2.5, p2 = 3.0, p3 = 2.0;
        double deprecPorKm = 0.08, volCamionM3 = 10.0;
        double fCO2 = 2.68, galPorLitro = 0.264172;
        double vmin = 30, vmax = 90;
        double va = 40, vb = 80, ca = 0.05, cb = 0.09;
        double a = -0.0008, b = 0.08, c = 4.0;
        //Velocidades y rendimiento
        double v1 = d1 / t1;
        double v2 = d2 / t2;
        double v3 = d3 / t3;
        double vprom = (d1*v1 + d2*v2 + d3*v3) / (d1+d2+d3);

        double kml1 = d1 / l1;
        double kml2 = d2 / l2;
        double kml3 = d3 / l3;
        double kmltotal = (d1+d2+d3) / (l1+l2+l3);
        //Costos directos
        double comb = l1+l2+l3;
        double costoComb = comb * precioLitro;
        double deprec = (d1+d2+d3) * deprecPorKm;
        double peajes = p1+p2+p3;
        double costoDirecto = costoComb + deprec + peajes;
        double costoPorKm = costoDirecto / (d1+d2+d3);
        //Volumen densidad y ocupación
        double volumenM3 = largo*ancho*alto;
        double densidad = masaCargaKg / volumenM3;
        double ocupacion = volumenM3 / volCamionM3;
        //Emisiones CO2
        double COTotal = comb * fCO2;
        double COporKm = COTotal / (d1+d2+d3);
        //Conversiones y normalización
        double vprom_ms = vprom * 1000 / 3600;
        double galTot = comb * galPorLitro;
        double vnorm = (vprom - vmin) / (vmax - vmin);
        //Promedios y dispersion
        double vmedia = (v1+v2+v3) / 3;
        double sigma = (Math.pow(v1-vmedia,2) + Math.pow(v2-vmedia,2) + Math.pow(v3-vmedia,2)) / 3;
        double vpond_t = (t1*v1 + t2*v2 + t3*v3) / (t1+t2+t3);
        //Interpolacion lineal (mantenimiento)
        double c_vprom = ca + (cb - ca) * (vprom - va) / (vb - va);
        double costoMant = c_vprom * (d1+d2+d3);
        //Modelo polinomico
        double kmlModelo = a*Math.pow(vprom,2) + b*vprom + c;
        double litrosModelo = (d1+d2+d3) / kmlModelo;
        //Indice de eficiencia (score)
        double w1 = 0.25, w2 = 0.25, w3 = 0.25, w4 = 0.25; // supuestos
        double score = w1*(1/costoPorKm) + w2*kmltotal + w3*(1/COporKm) + w4*(1/(1+sigma));
        // Mostrar resultados
        System.out.printf("Velocidades: v1=%.2f v2=%.2f v3=%.2f%n Km/h", v1, v2, v3);
        System.out.printf("Velocidad promedio = %.2f km/h = %.2f m/s%n", vprom, vprom_ms);
        System.out.printf("Rendimientos: %.2f %.2f %.2f total=%.2f%n", kml1, kml2, kml3, kmltotal);
        System.out.printf("Costos: Comb=%.2f Dep=%.2f Peajes=%.2f%n", costoComb, deprec, peajes);
        System.out.printf("Costo Directo=%.2f Costo/km=%.2f%n", costoDirecto, costoPorKm);
        System.out.printf("Volumen=%.2f Densidad=%.2f Ocupacion=%.2f%n", volumenM3, densidad, ocupacion);
        System.out.printf("CO2 Total=%.2f CO2/km=%.2f gal=%.2f%n", COTotal, COporKm, galTot);
        System.out.printf("Promedios: vmedia=%.2f vpond_t=%.2f sigma=%.2f%n", vmedia, vpond_t, sigma);
        System.out.printf("Interpolacion: c(vprom)=%.5f CostoMant=%.2f%n", c_vprom, costoMant);
        System.out.printf("Modelo polinomico: kmlModelo=%.3f litrosModelo=%.3f%n", kmlModelo, litrosModelo);
        System.out.printf("Score final=%.4f%n", score);
    }
}