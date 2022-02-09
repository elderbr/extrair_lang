/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.desktop.elderbr.utils;

import br.com.desktop.elderbr.interfaces.VGlobal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author User
 */
public class Langs extends DefaultComboBoxModel<String> {

    private String lang = null;

    // TODOS OS CÓDIGOS DE LANG DISPONIVÉL PARA A VERSÃO 1.17
    private List<String>listLang;
    private File fileVersion;

    public Langs() {
        try {
            listLang = new ArrayList<>();
            fileVersion = new File(VGlobal.LANG_INDEX, "1.18.json");
            try (BufferedReader br = new BufferedReader(new FileReader(fileVersion.getAbsoluteFile()))) {
                while ((lang = br.readLine()) != null) {
                    if (lang.contains("realms/lang/")) {
                        listLang.add(lang.replaceAll("\"realms/lang/", "").replaceAll("[\":{]", "").replace(".json", "").trim());
                    }
                }
            } catch (Exception ex) {
                System.out.println("Erro ao ler a languagem: \nErro: " + ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler a languagem: \nErro: " + e.getMessage());
        }        
    }

    @Override
    public String getElementAt(int index) {
        lang = listLang.get(index);
        return lang;
    }

    @Override
    public int getSize() {
        return listLang.size();
    }

    @Override
    public String toString() {
        return lang;
    }
}
