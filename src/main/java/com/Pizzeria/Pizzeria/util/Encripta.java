package com.Pizzeria.Pizzeria.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encripta {

    /* 
     * Método que retorna un hash a partir de un tipo de algoritmo y un texto.
     * @param txt El texto que se va a encriptar.
     * @param hashType El tipo de algoritmo de hash a utilizar (por ejemplo, "MD5", "SHA-1", "SHA-256").
     * @return El hash resultante.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash especificado no está disponible.
     */
    public static String getHash(String txt, String hashType) throws NoSuchAlgorithmException {
        try {
            // Obtener una instancia del algoritmo de hash
            MessageDigest md = MessageDigest.getInstance(hashType);
            
            // Aplicar el algoritmo de hash al array de bytes del texto
            byte[] array = md.digest(txt.getBytes());
            
            // Convertir el array de bytes a una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Lanzar la excepción para que pueda ser manejada en un nivel superior
            throw e;
        }
    }

    /* 
     * Método que retorna un hash MD5 a partir de un texto.
     * @param txt El texto que se va a encriptar.
     * @return El hash MD5 resultante.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash MD5 no está disponible.
     */
    public static String md5(String txt) throws NoSuchAlgorithmException {
        return Encripta.getHash(txt, "MD5");
    }

    /* 
     * Método que retorna un hash SHA-1 a partir de un texto.
     * @param txt El texto que se va a encriptar.
     * @return El hash SHA-1 resultante.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash SHA-1 no está disponible.
     */
    public static String sha1(String txt) throws NoSuchAlgorithmException {
        return Encripta.getHash(txt, "SHA-1");
    }

    /* 
     * Método que retorna un hash SHA-256 a partir de un texto.
     * @param txt El texto que se va a encriptar.
     * @return El hash SHA-256 resultante.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash SHA-256 no está disponible.
     */
    public static String sha256(String txt) throws NoSuchAlgorithmException {
        return Encripta.getHash(txt, "SHA-256");
    }

}
