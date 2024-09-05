package desafio4;

public class ejercicio49 {
    static final double SIGMA = 5.67e-8; // Constante de Stefan-Boltzmann en W/m^2 K^4

    public static void main(String[] args) {
        // Variables del problema
        double A = 0.15;    // Área en m^2
        double e = 0.90;    // Emisividad adimensional
        double T = 650;     // Temperatura en K
        double deltaT1 = 20; // Incertidumbre en T (caso 1)
        double deltaT2 = 40; // Incertidumbre en T (caso 2)
        
        // Calcular H para T = 650
        double H = stefanBoltzmann(A, e, T);
        System.out.println("H para T = 650 K: " + H + " W");

        // Calcular la incertidumbre de H con deltaT = 20
        double deltaH1 = errorPropagation(A, e, T, deltaT1);
        System.out.println("Incertidumbre en H para deltaT = 20: " + deltaH1 + " W");

        // Calcular la incertidumbre de H con deltaT = 40
        double deltaH2 = errorPropagation(A, e, T, deltaT2);
        System.out.println("Incertidumbre en H para deltaT = 40: " + deltaH2 + " W");

        // Comparar con el error exacto recalculando H para T ± deltaT
        double H_upper1 = stefanBoltzmann(A, e, T + deltaT1);
        double H_lower1 = stefanBoltzmann(A, e, T - deltaT1);
        System.out.println("H para T + 20: " + H_upper1 + " W");
        System.out.println("H para T - 20: " + H_lower1 + " W");
        System.out.println("Error exacto con deltaT = 20: " + Math.abs(H_upper1 - H) + " W");

        double H_upper2 = stefanBoltzmann(A, e, T + deltaT2);
        double H_lower2 = stefanBoltzmann(A, e, T - deltaT2);
        System.out.println("H para T + 40: " + H_upper2 + " W");
        System.out.println("H para T - 40: " + H_lower2 + " W");
        System.out.println("Error exacto con deltaT = 40: " + Math.abs(H_upper2 - H) + " W");
    }

    // Función para calcular H según la ley de Stefan-Boltzmann
    public static double stefanBoltzmann(double A, double e, double T) {
        return A * e * SIGMA * Math.pow(T, 4);
    }

    // Función para propagar el error en H
    public static double errorPropagation(double A, double e, double T, double deltaT) {
        return 4 * A * e * SIGMA * Math.pow(T, 3) * deltaT;
    }
}
