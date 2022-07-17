package br.com.desktop.elderbr.utils;

import br.com.desktop.elderbr.interfaces.Global;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
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
                    if (Integer.parseInt(files.getName().substring(0, 1)) > 0) {
                        Caminho.ESCREVER_JSON(files);// Sobrescrevendo o arquivos json                        

                        lang = files.getName().replaceAll(".json", "").trim();
                        VALUE = Caminho.Version(lang);                        
                        Caminho.LIST_VERSION.add(lang);
                        
                        try(BufferedReader br = Files.newBufferedReader(new File(lang.concat(".json")).toPath(), StandardCharsets.UTF_8)){
                            String line = null;
                            String lang = null;
                            while((line = br.readLine())!=null){
                                if(line.contains("minecraft/lang/")){
                                    lang = line.substring(line.indexOf("g/")+2, line.indexOf(".json"));
                                    if(!Global.LIST_LANG.contains(lang)){
                                        Global.LIST_LANG.add(lang);
                                    }
                                }
                            }
                        }catch(IOException ebr){
                            
                        }
                        /*
                        try(BufferedWriter wr = Files.newBufferedWriter(new File(lang).toPath(), StandardCharsets.UTF_8)){
                            
                            wr.write(lang);
                        }catch(IOException w){
                            
                        }*/
                        
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            Collections.sort(Caminho.LIST_VERSION);
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
