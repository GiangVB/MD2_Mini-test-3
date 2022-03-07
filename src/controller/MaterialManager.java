package controller;

import Storage.IMaterialData;
import Storage.MaterialFromFileBinary;
import model.Material;

import java.io.IOException;
import java.util.LinkedList;

public class MaterialManager {
    public static IMaterialData materialData = new MaterialFromFileBinary();
    public static LinkedList<Material> materials = materialData.readFile();

    public static void addNewMaterial (Material newMaterial) {
        materials.add(newMaterial);
        try {
            materialData.writeFile(materials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeMaterialByIndex (int index) {
        materials.remove(index);
        try {
            materialData.writeFile(materials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editMaterialByIndex(int index, Material newMaterial) {
        materials.set(index, newMaterial);
        try {
            materialData.writeFile(materials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMaterialIndexById(String SearchId) {
        int index = -1;
        for (int i = 0; i < materials.size(); i++) {
            Material currentMaterial = materials.get(i);
            String currentMaterialId = currentMaterial.getId();
            if (currentMaterialId.equals(SearchId)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static int findMaterialIndexByName(String searchName) {
        int index = -1;
        for (int i = 0; i < materials.size(); i++) {
            Material currentMaterial = materials.get(i);
            String currentMaterialName = currentMaterial.getName();
            if (currentMaterialName.equals(searchName)) {
                index = i;
                return index;
            }
        }
        return index;
    }
}
