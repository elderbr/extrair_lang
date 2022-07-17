package br.com.desktop.elderbr.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ElderBR
 */
public class Version extends DefaultComboBoxModel<String> {

    private final File fileVersionList = Caminho.fileIndexes;

    private String lang;
    public static double VALUE;
    private List<String> listVersion;

    public Version() {
        // Pegando a lista de langs
        if (fileVersionList.exists()) {
            listVersion = new ArrayList<>();
            for (File files : fileVersionList.listFiles()) {
                lang = files.getName().replaceAll(".json", "").trim();
                VALUE = Caminho.Version(lang);
                if(VALUE > 12){
                    listVersion.add(lang);
                }
            }
        }
    }

    @Override
    public String getElementAt(int index) {   
        return listVersion.get(index);
    }

    @Override
    public int getSize() {
        return listVersion.size();
    }

}
