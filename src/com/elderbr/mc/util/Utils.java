/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elderbr.mc.util;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author elder
 */
public class Utils {

    public static String getPathRoot() {
        // PEGANDO O DIRETÓRIO PADRÃO DO SISTEMA
        File fileRoot = FileSystemView.getFileSystemView().getRoots()[0];
        return fileRoot.getAbsolutePath().substring(0, fileRoot.getAbsolutePath().lastIndexOf("\\") + 1);
    }

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
