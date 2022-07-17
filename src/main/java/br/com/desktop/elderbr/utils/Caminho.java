package br.com.desktop.elderbr.utils;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author User
 */
public interface Caminho {

    // PEGANDO O DIRETÓRIO PADRÃO DO SISTEMA
    public static String getPathRoot() {
        File fileRoot = FileSystemView.getFileSystemView().getRoots()[0];
        return fileRoot.getAbsolutePath().substring(0, fileRoot.getAbsolutePath().lastIndexOf("\\") + 1);
    }

    // Todas as versões jogadas fica localizada na pasta indexes
    String pathIndexes = getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\indexes\\");
    File fileIndexes = new File(pathIndexes);

    // Todas as traduções ficam localizadas na pasta objects
    String pathObjects = getPathRoot().concat("AppData\\Roaming\\.minecraft\\assets\\objects\\");
    File fileObjects = new File(pathObjects);

    List<String> LIST_VERSION = new ArrayList<>();// LISTA DE NOME DAS VERSOES JOGADAS
    List<File> LIST_FILE = new ArrayList<>();// LISTA DE ARQUIVOS DAS VERSOES JOGADAS

    // Rescrevendo o arquivo json formatando
    public static boolean ESCREVER_JSON(File file) {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        try {
            JSONObject jsonPric = (JSONObject) new JSONParser().parse(new FileReader(file.getAbsoluteFile()));
            try (BufferedWriter writer = Files.newBufferedWriter(new File(file.getName()).toPath(), StandardCharsets.UTF_8)) {
                writer.write(gson.toJson(jsonPric));
                writer.flush();
            } catch (IOException ew) {

            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
