/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.desktop.elderbr.utils;

import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author User
 */
public class Langs extends DefaultComboBoxModel<String> {

    private String lang = null;

    // TODOS OS CÓDIGOS DE LANG DISPONIVÉL PARA A VERSÃO 1.17
    private List<String> listLang;
    private final File fileLang = new File(Caminho.fileIndexes, "legacy.json");

    public Langs() {
        String line = null;
        lang = "pt_br";
        listLang = new ArrayList<>();        
        try (BufferedReader reader = Files.newReader(fileLang, Charset.defaultCharset())) {
            while ((line = reader.readLine()) != null) {
                if (line.contains("lang/")) {
                    lang = line.replaceAll("[\"/lang:\\s\\{.]", "");
                    listLang.add(lang);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao buscar todos os langs!!!\nErro: "+ e.getMessage());
        }
        Collections.sort(listLang);
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
