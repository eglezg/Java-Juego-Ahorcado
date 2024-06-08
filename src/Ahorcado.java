import java.util.Scanner;

public class Ahorcado {

    static int vidas = 6;
    static String palabra = "JOTO";
    static char letrasAdivinadas[] = new char[palabra.length()];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        inicializarPalabra();

        while (true) {
            System.out.println("Vidas: " + vidas);
            imprimirPalabra();
            System.out.println("\nIngresa una letra");
            char letra = sc.next().toLowerCase().charAt(0);

            comprobarLetra(letra);
            if (comprobarVidas())
                break;
            if (comprobarGanar())
                break;
        }
        sc.close();
    }

    static void inicializarPalabra() {
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            if (palabra.charAt(i) == ' ') {
                letrasAdivinadas[i] = ' ';
            } else {
                letrasAdivinadas[i] = '_';
            }
        }
    }

    static void imprimirPalabra() {
        for (char x : letrasAdivinadas) {
            System.out.print(x + " ");
        }
    }

    static void comprobarLetra(char letra) {
        boolean encontrada = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.toLowerCase().charAt(i) == letra) {
                letrasAdivinadas[i] = letra;
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No encontrada: " + letra);
            vidas--;
        } else
            System.out.println("Encontrada: " + letra);

    }

    static boolean comprobarVidas() {
        if (vidas == 0) {
            System.out.println("Perdiste, la palabra era: " + palabra);
            return true;
        }
        return false;
    }

    static boolean comprobarGanar() {
        if (String.valueOf(letrasAdivinadas).equals(palabra.toLowerCase())) {
            imprimirPalabra();
            System.out.println("\nGanaste");
            return true;
        }
        return false;
    }

}