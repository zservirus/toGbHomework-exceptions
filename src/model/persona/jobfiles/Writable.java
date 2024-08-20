package model.persona.jobfiles;

import java.util.List;

public interface Writable  {
    boolean save (String str, String fileName,Boolean append);
    boolean deleteFile (String fileName);

    List<String> readListFile();
}
