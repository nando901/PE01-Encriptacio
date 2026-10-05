package Xifrat_Propi;
public class ClasseCriptografica {

    private final String ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encripta(String missatge, String clau) {
        String fase1 = desplacament(missatge, clau);
        String fase2 = transposicio(fase1);
        String fase3 = substitucio(fase2);

        return fase3;
    }

    public String desencripta(String missatge, String clau) {
        String fase3 = desferSubstitucio(missatge);
        String fase2 = desferTransposicio(fase3);
        String fase1 = desferDesplacament(fase2, clau);

        return fase1;
    }

    private String desplacament(String missatge, String clau) {
        String resultat = "";
        missatge = missatge.toUpperCase();
        clau = clau.toUpperCase();

        for (int i = 0; i < missatge.length(); i++) {
            char caracterMissatge = missatge.charAt(i);
            int valorMissatge = ALFABET.indexOf(caracterMissatge);

            if (valorMissatge == -1) {
                resultat += caracterMissatge;

            } else {
                char caracterClau = clau.charAt(i % clau.length());
                int valorClau = ALFABET.indexOf(caracterClau);

                int novaPosicio = (valorMissatge + valorClau + i) % ALFABET.length();

                resultat += ALFABET.charAt(novaPosicio);
            }
        }
        return resultat;
    }

    private String transposicio(String missatge) {
        String resultat = "";

        for (int i = 0; i < missatge.length(); i += 4) {
            int finalBloc = Math.min(i + 4, missatge.length());
            String bloc = missatge.substring(i, finalBloc);

            if (bloc.length() == 4) {
                resultat += bloc.substring(2, 4);
                resultat += bloc.substring(0, 2);
            } else {
                resultat += bloc;
            }
        }
        return resultat;
    }

    private String substitucio(String missatge) {
        String resultat = "";

        for (int i = 0; i < missatge.length(); i++) {
            char caracter = missatge.charAt(i);
            int posicio = ALFABET.indexOf(caracter);

            if (posicio == -1) {
                resultat += caracter;

            } else {
                int posicioInvertida = ALFABET.length() - 1 - posicio;

                resultat += ALFABET.charAt(posicioInvertida);
            }
        }

        return resultat;
    }

    private String desferSubstitucio(String missatge) {
        return substitucio(missatge);
    }

    private String desferTransposicio(String missatge) {
        return transposicio(missatge);
    }

    private String desferDesplacament(String missatge, String clau) {
        String resultat = "";
        missatge = missatge.toUpperCase();
        clau = clau.toUpperCase();

        for (int i = 0; i < missatge.length(); i++) {
            char caracterMissatge = missatge.charAt(i);
            int valorMissatge = ALFABET.indexOf(caracterMissatge);

            if (valorMissatge == -1) {
                resultat += caracterMissatge;

            } else {
                char caracterClau = clau.charAt(i % clau.length());
                int valorClau = ALFABET.indexOf(caracterClau);
                int novaPosicio = (valorMissatge - valorClau - i) % ALFABET.length();

                if (novaPosicio < 0) {
                    novaPosicio += ALFABET.length();
                }

                resultat += ALFABET.charAt(novaPosicio);
            }
        }

        return resultat;
    }
}