package br.com.schumaker.hsfiles;

import java.io.File;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsFiles {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private final String rootDirWin = "C:/Hstudio";
    private final String rootDirUnix = "/Hstudio";
    private final String rootDirOsX = "/Applications/Hstudio";
    private final String mercado = "mercado";
    private final String usuario = "usuario";

    public boolean criarDirMercado(String nome) {
        if (isWindows()) {
            File f = new File(rootDirWin + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else if (isUnix()) {
            File f = new File(rootDirUnix + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else if (isMac()) {
            File f = new File(rootDirOsX + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else {
            return false;
        }
    }

    public boolean criarDirUsuario(String nome) {
        if (isWindows()) {
            File f = new File(rootDirWin + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else if (isUnix()) {
            File f = new File(rootDirUnix + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else if (isMac()) {
            File f = new File(rootDirOsX + "/" + mercado + "/" + nome);
            return f.mkdir();
        } else {
            return false;
        }
    }

    public boolean criarRaizDirSistema() {
        if (isWindows()) {
            File f = new File(rootDirWin);
            return f.mkdir();
        } else if (isUnix()) {
            File f = new File(rootDirUnix);
            return f.mkdir();
        } else if (isMac()) {
            File f = new File(rootDirOsX);
            return f.mkdir();
        } else {
            return false;
        }
    }

    public boolean criarDirRaizMercado() {
        if (isWindows()) {
            File f = new File(rootDirWin + "/" + mercado);
            return f.mkdir();
        } else if (isUnix()) {
            File f = new File(rootDirUnix + "/" + mercado);
            return f.mkdir();
        } else if (isMac()) {
            File f = new File(rootDirOsX + "/" + mercado);
            return f.mkdir();
        } else {
            return false;
        }
    }

    public boolean criarDirRaizUsuarios() {
        if (isWindows()) {
            File f = new File(rootDirWin + "/" + usuario);
            return f.mkdir();
        } else if (isUnix()) {
            File f = new File(rootDirUnix + "/" + usuario);
            return f.mkdir();
        } else if (isMac()) {
            File f = new File(rootDirOsX + "/" + usuario);
            return f.mkdir();
        } else {
            return false;
        }
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }
}