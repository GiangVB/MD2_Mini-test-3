package Storage;

import model.Material;

import java.io.*;
import java.util.LinkedList;

public class MaterialFromFileBinary implements IMaterialData{
    @Override
    public LinkedList<Material> readFile() {
        File file = new File("list.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object output = ois.readObject();
            LinkedList<Material> materials = (LinkedList<Material>) output;
            ois.close();
            fis.close();
            return materials;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    @Override
    public void writFile(LinkedList<Material> materials) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("list.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(materials);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            fos.close();
        }
    }
}
