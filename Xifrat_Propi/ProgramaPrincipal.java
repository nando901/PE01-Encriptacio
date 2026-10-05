package Xifrat_Propi;
import java.util.Scanner;

public class ProgramaPrincipal {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ProgramaPrincipal p = new ProgramaPrincipal();
        p.principal();
    }

    public void principal() {
        ClasseCriptografica cripto = new ClasseCriptografica();

        String clauCorrecta = "CLAVE";

        System.out.print("Introdueix el missatge: ");
        String missatge = sc.nextLine();

        String xifrat = cripto.encripta(missatge, clauCorrecta);

        System.out.println("Missatge xifrat: " + xifrat);

        System.out.print("Introdueix la clau per desencriptar: ");
        String clauIntroduida = sc.nextLine();

        String desxifrat = cripto.desencripta(xifrat, clauIntroduida);

        System.out.println("Missatge desxifrat: " + desxifrat);

        sc.close();
    }
}