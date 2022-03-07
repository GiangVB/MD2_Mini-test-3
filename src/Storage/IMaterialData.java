package Storage;

import model.Material;

import java.io.IOException;
import java.util.LinkedList;

public interface IMaterialData {
    LinkedList<Material> readFile();
    void writFile (LinkedList<Material> materials) throws IOException;
}
