package br.com.desktop.elderbr.interfaces;

import br.com.desktop.elderbr.utils.Caminho;
import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author User
 */
public interface VGlobal {
    // CAMINHO COM CÓDIGO DO LANG
    File LANG_INDEX = new File(Caminho.getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\indexes\\"));    
}
