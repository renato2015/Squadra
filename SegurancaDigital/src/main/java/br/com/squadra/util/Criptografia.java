package br.com.squadra.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00 17/10/2016
 */
public class Criptografia {

    private static Criptografia instance;

    public static Criptografia getInstance() {
        if (instance == null) {
            instance = new Criptografia();
        }
        return instance;
    }
    /**
     * Metodo que criptografa a senha
     * @param senha
     * @return senha criptografada
     */
    @SuppressWarnings("null")
    public static String criptografiaSenha(String senha) {
        MessageDigest algorithm = null;
        try {
            algorithm = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            Mensagem.getInstance().erro("Erro ao criptografar senha");
        }
        byte[] messageDigest = null;
        try {
            messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Mensagem.getInstance().erro("Erro ao criptografar senha");
        }

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();
        return senhaCriptografada;
    }

    public static void main(String[] args) {
        String senha = criptografiaSenha("12345");
        System.out.println("Senha: " + senha);
    }
}
