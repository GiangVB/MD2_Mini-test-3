package Storage;

import model.Material;

import java.io.IOException;
import java.util.LinkedList;

public interface IMaterialData {
    LinkedList<Material> readFile();
    void writeFile(LinkedList<Material> materials) throws IOException;
}
