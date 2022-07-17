package br.com.desktop.elderbr.utils;

import java.io.File;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ElderBR
 */
public class Version extends DefaultComboBoxModel<String> {

    private final File fileVersionList = Caminho.fileIndexes;

    private String lang;
    public static double VALUE;

    public Version() {
        // Pegando a lista de langs
        if (fileVersionList.exists()) {
           for (File files : fileVersionList.listFiles()) {
                try {
                    if (Integer.parseInt(files.getName().substring(0,1)) > 0) {
                        Caminho.ESCREVER_JSON(files);

                        lang = files.getName().replaceAll(".json", "").trim();
                        VALUE = Caminho.Version(lang);
                        if (VALUE > 12) {
                            Caminho.LIST_VERSION.add(lang);
                        }
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
    }

    @Override
    public String getElementAt(int index) {
        return Caminho.LIST_VERSION.get(index);
    }

    @Override
    public int getSize() {
        return Caminho.LIST_VERSION.size();
    }

}
