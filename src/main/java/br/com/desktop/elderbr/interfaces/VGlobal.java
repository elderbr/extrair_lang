/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.desktop.elderbr.interfaces;

import br.com.desktop.elderbr.utils.Caminho;
import java.io.File;

/**
 *
 * @author User
 */
public interface VGlobal {
    File LANG_INDEX = new File(Caminho.getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\indexes\\"));
}
