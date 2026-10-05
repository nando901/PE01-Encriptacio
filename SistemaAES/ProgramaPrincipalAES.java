package SistemaAES;
import java.util.Scanner;
public class ProgramaPrincipalAES {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ProgramaPrincipalAES p = new ProgramaPrincipalAES();
        p.principal();
    }

    public void principal() {
        String clauCorrecta = "1234567890123456";

        System.out.print("Introdueix el missatge: ");
        String missatge = sc.nextLine();

        try {

            String xifrat = ClasseAES.encripta(missatge, clauCorrecta);

            System.out.println("Missatge xifrat: " + xifrat);

            System.out.print("Introdueix la clau per desencriptar: ");
            String clauIntroduida = sc.nextLine();

            String desxifrat = ClasseAES.desencripta(xifrat, clauIntroduida);

            System.out.println("Missatge desxifrat: " + desxifrat);

        } catch (Exception e) {
            System.out.println("No s'ha pogut desencriptar el missatge.");
        }

        sc.close();
    }
}