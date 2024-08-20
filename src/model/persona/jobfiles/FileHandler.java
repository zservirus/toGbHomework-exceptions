package model.persona.jobfiles;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writable {
    private String pathDir = "src/model/data/";
    private String lastNamePerson = "new";

    public List<String> getListSaveFiles(String pathDir){
        List<String> listFiles = new ArrayList<>();
        File dir = new File(pathDir);
        File[] filesList = dir.listFiles();
        for (File file : filesList) {
            if (file.isFile()) {
                listFiles.add(file.getName());

            }
        }
        return listFiles;
    }


    @Override
    public boolean save(String str, String fileName,Boolean append) throws IOException {
        fileName = fileName+".txt";
        try {
            if (append == true){
                Files.writeString(Path.of(pathDir + fileName ), str, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                System.out.println("Дописали в файл:" + fileName);
                }
            else{
                Files.writeString(Path.of(pathDir + fileName ), str, StandardCharsets.UTF_8);
                System.out.println("Создали файл:" + fileName);
                }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            throw e;
        }

    }

    public byte[] read(String pathFile) {
        byte[] bytes = pathFile.getBytes();
        try {
            Files.write(Path.of(pathFile), bytes);
        } catch (IOException ex) {
            // Handle exception
        }
    return bytes;
    }


    @Override
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();

    }

    @Override
    public List<String> readListFile() {

        return getListSaveFiles(pathDir);
    }


}
