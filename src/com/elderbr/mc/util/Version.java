/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elderbr.mc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author elder
 */
public class Version extends DefaultComboBoxModel<String> {

    private final String root = Utils.getPathRoot();
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
                version = Utils.Version(lang);
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
