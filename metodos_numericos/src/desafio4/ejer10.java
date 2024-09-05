package desafio4;

public class ejer10 {

	public static void main(String[] args) {
        // Constantes
        double sigma = 5.67e-8; // Constante de Stefan-Boltzmann en W/m²K⁴
        double pi = Math.PI;
        
        // Variables con incertidumbre
        double r = 0.15;        // Radio de la esfera en metros
        double delta_r = 0.01;  // Incertidumbre en el radio en metros
        double e = 0.90;        // Emisividad
        double delta_e = 0.05;  // Incertidumbre en la emisividad
        double T = 550;         // Temperatura en Kelvin
        double delta_T = 20;    // Incertidumbre en la temperatura en Kelvin

        // Cálculo del área de la esfera
        double A = 4 * pi * Math.pow(r, 2);

        // Cálculo de la tasa de radiación H
        double H = A * e * sigma * Math.pow(T, 4);
        System.out.println("Tasa de radiación H: " + H + " W");

        // Cálculo del error de H por propagación de errores
        // Derivadas parciales
        double dH_dr = 8 * pi * r * e * sigma * Math.pow(T, 4);
        double dH_de = A * sigma * Math.pow(T, 4);
        double dH_dT = 4 * A * e * sigma * Math.pow(T, 3);

        // Propagación de errores
        double delta_H_r = Math.pow(dH_dr * delta_r, 2);
        double delta_H_e = Math.pow(dH_de * delta_e, 2);
        double delta_H_T = Math.pow(dH_dT * delta_T, 2);

        double delta_H = Math.sqrt(delta_H_r + delta_H_e + delta_H_T);

        System.out.println("Incertidumbre en la tasa de radiación ΔH: " + delta_H + " W");
    }
}
