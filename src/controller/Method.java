package controller;

import model.Material;

import java.util.LinkedList;

public class Method {
    public static LinkedList<Material> addNewMaterial (LinkedList<Material> materials, Material newMaterial) {
        materials.add(newMaterial);
        return materials;
    }

    public static LinkedList<Material> removeMaterial (LinkedList<Material> materials, int index) {
        materials.remove(index);
        return materials;
    }

    public static LinkedList<Material> replaceMaterial (LinkedList<Material> materials, int index, Material newMaterial) {
        materials.set(index, newMaterial);
        return materials;
    }

}
