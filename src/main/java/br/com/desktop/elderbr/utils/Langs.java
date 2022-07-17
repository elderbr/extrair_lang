/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.desktop.elderbr.utils;

import br.com.desktop.elderbr.interfaces.Global;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

    public Langs() {
        Collections.sort(Global.LIST_LANG);                
    }

    @Override
    public String getElementAt(int index
    ) {
        lang = Global.LIST_LANG.get(index);
        return lang;
    }

    @Override
    public int getSize() {
        return Global.LIST_LANG.size();
    }

    @Override
    public String toString() {
        return lang;
    }
}
