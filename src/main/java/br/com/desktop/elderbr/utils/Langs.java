/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.desktop.elderbr.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import jdk.security.jarsigner.JarSigner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author User
 */
public class Langs extends DefaultComboBoxModel<String> {

    private String lang = null;

    // TODOS OS CÓDIGOS DE LANG DISPONIVÉL PARA A VERSÃO 1.17
    private List<String> listLang;
    private final File FILE_LANG = new File(getClass().getResource("/langs/langs.txt").getPath());

    public Langs() {

        listLang = new ArrayList<>();
        String line = null;

        File fileV19 = new File(Caminho.pathIndexes, "1.19.json");
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();        
        
        try {
            JSONObject jsonPric = (JSONObject) new JSONParser().parse(new FileReader(fileV19.getAbsoluteFile()));
            
            try(BufferedWriter writer = Files.newBufferedWriter(new File("lang_txt.json").toPath(), StandardCharsets.UTF_8)){
                writer.write(gson.toJson(jsonPric));
                writer.flush();
            }catch(IOException ew){
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       
        //System.exit(0);

        lang = "pt_br";
        try (BufferedReader reader = Files.newBufferedReader(FILE_LANG.toPath(), StandardCharsets.UTF_8)) {
            while ((line = reader.readLine()) != null) {
                listLang.add(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao buscar todos os langs!!!\nErro: " + e.getMessage());
        }
        Collections.sort(listLang);
    }

    @Override
    public String getElementAt(int index
    ) {
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
