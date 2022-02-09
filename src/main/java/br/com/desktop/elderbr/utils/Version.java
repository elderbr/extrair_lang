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
     private final String root = Caminho.getPathRoot();
    private File fileVersionList = new File(root.concat("AppData\\Roaming\\.minecraft\\assets\\indexes"));

    private String lang;
    private double version;
    private List<String> listVersion;

    public Version() {
        // Pegando a lista de langs
        if (fileVersionList.exists()) {
            listVersion = new ArrayList<>();
            for (File files : fileVersionList.listFiles()) {
                lang = files.getName().replaceAll(".json", "").trim();
                version = Caminho.Version(lang);
                if(version > 7){
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
