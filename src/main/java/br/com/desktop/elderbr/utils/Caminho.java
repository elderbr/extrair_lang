package br.com.desktop.elderbr.utils;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author User
 */
public interface Caminho {
    // PEGANDO O DIRETÓRIO PADRÃO DO SISTEMA
    public static String getPathRoot() {        
        File fileRoot = FileSystemView.getFileSystemView().getRoots()[0];
        return fileRoot.getAbsolutePath().substring(0, fileRoot.getAbsolutePath().lastIndexOf("\\") + 1);
    }
    
    // Todas as versões jogadas fica localizada na pasta indexes
    String pathIndexes = getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\indexes\\");
    File fileIndexes = new File(pathIndexes);
    
    // Todas as traduções ficam localizadas na pasta objects
    String pathObjects = getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\objects\\");
    File fileObjects = new File(pathObjects);
    
    public static int Version(String version) {
        String versionReturn = "0";
        if (version.contains(".")) {
            char[] vA = version.split("\\.")[1].toCharArray();            
            for (char v : vA) {
                if (Character.getType(v) == 9) {
                    versionReturn += v;
                }
            }
        }
        return Integer.parseInt(versionReturn);
    }
}
