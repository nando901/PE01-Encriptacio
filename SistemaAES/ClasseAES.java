package SistemaAES;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ClasseAES {

    public static String encripta(String missatge, String clau) throws Exception {

        // Convertim la clau a bytes
        byte[] clauBytes = clau.getBytes(StandardCharsets.UTF_8);

        // Creem la clau per AES
        SecretKeySpec secretKey = new SecretKeySpec(clauBytes, "AES");

        // Creem el sistema de xifrat
        Cipher cipher = Cipher.getInstance("AES");

        // Configurem el Cipher per encriptar
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Convertim el missatge a bytes i l'encriptem
        byte[] missatgeXifrat = cipher.doFinal(missatge.getBytes(StandardCharsets.UTF_8));

        // Convertim els bytes xifrats a Base64
        return Base64.getEncoder().encodeToString(missatgeXifrat);
    }

    public static String desencripta(String missatgeXifrat, String clau) throws Exception {

        // Convertim la clau a bytes
        byte[] clauBytes = clau.getBytes(StandardCharsets.UTF_8);

        // Creem la clau per AES
        SecretKeySpec secretKey = new SecretKeySpec(clauBytes, "AES");

        // Creem el sistema de xifrat
        Cipher cipher = Cipher.getInstance("AES");

        // Configurem el Cipher per desencriptar
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Recuperem els bytes del text en Base64
        byte[] dadesXifrades = Base64.getDecoder().decode(missatgeXifrat);

        // Desencriptem
        byte[] missatgeDesxifrat = cipher.doFinal(dadesXifrades);

        // Convertim els bytes novament a text
        return new String(missatgeDesxifrat, StandardCharsets.UTF_8);
    }
}