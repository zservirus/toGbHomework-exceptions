package model.persona.jobfiles;

import java.io.IOException;
import java.util.List;

public interface Writable  {
    boolean save (String str, String fileName,Boolean append) throws IOException;
    boolean deleteFile (String fileName);

    List<String> readListFile();
}
