package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class MaterialManagement {
    public static LinkedList<Material> materials;

    /* public static void main(String[] args) {
        materials = new LinkedList<>();
        materials.add(new CrispyFlour("CF1","Bột chiên phồng", LocalDate.now(), 1000, 100));
        materials.add(new CrispyFlour("CF2", "Bột chiên xù", LocalDate.now(), 950, 150));
        materials.add(new Meat("M1", "Thịt bò Úc", LocalDate.now(), 1500, 50));
        materials.add(new Meat("M2", "Thịt bò Kobe", LocalDate.now(), 2000, 20));
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("QUẢN LÝ NGUYÊN LIỆU");
            System.out.println("1. Thêm nguyên liệu mới");
            System.out.println("2. Xóa nguyên liệu");
            System.out.println("3. Sửa nguyên liệu");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Material newMaterial = creatNewMaterial();
                    materials = MaterialManager.addNewMaterial(materials,newMaterial);
                    break;
                case 2:
                    System.out.println("Nhập mã nguyên liệu muốn xóa: ");
                    String deleteID = input.nextLine();
                    int deleteIndex = findMaterialIndexByID(deleteID);
                    MaterialManager.removeMaterial(materials, deleteIndex);
                    break;
                case 3:
                    System.out.println("Nhập mã nguyên liệu muốn sửa: ");
                    String editID = input.nextLine();
                    String e = input.nextLine();
                    Material editedMaterial = creatNewMaterial();
                    int editIndex = findMaterialIndexByID(editID);
                    MaterialManager.replaceMaterial(materials, editIndex, editedMaterial);
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }*/

    /*public static Material creatNewMaterial() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        Material newMaterial = null;
        System.out.println("1. Bột chiên giòn");
        System.out.println("2. Thịt");
        System.out.println("Nhập lựa chọn: ");
        choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Nhập mã Bột chiên giòn: ");
            String crispyFlourID = input.nextLine();
            String enter = input.nextLine();
            System.out.println("Nhập tên Bột chiên giòn: ");
            String crispyFlourName = input.nextLine();
            System.out.println("Nhập ngày sản xuất: ");
            int crispyFlourManufacturingDay = input.nextInt();
            System.out.println("Nhập tháng sản xuất: ");
            int crispyFlourManufacturingMonth = input.nextInt();
            System.out.println("Nhập năm sản xuất: ");
            int crispyFlourManufacturingYear = input.nextInt();
            LocalDate crispyFlourManufacturingDate = LocalDate.of(crispyFlourManufacturingYear, crispyFlourManufacturingMonth, crispyFlourManufacturingDay);
            System.out.println("Nhập giá thành Bột chiên giòn: ");
            int crispyFlourCost = input.nextInt();
            System.out.println("Nhập số lượng: ");
            int crispyFlourQuantity = input.nextInt();
            Material newCrispyFlour = new CrispyFlour(crispyFlourID, crispyFlourName, crispyFlourManufacturingDate, crispyFlourCost, crispyFlourQuantity);
            newMaterial = newCrispyFlour;
        }
        if (choice == 2) {
                System.out.println("Nhập mã Thịt: ");
                String meatID = input.nextLine();
                String space = input.nextLine();
                System.out.println("Nhập tên Thịt: ");
                String meatName = input.nextLine();
                System.out.println("Nhập ngày sản xuất: ");
                int meatManufacturingDay = input.nextInt();
                System.out.println("Nhập tháng sản xuất: ");
                int meatManufacturingMonth = input.nextInt();
                System.out.println("Nhập năm sản xuất: ");
                int meatManufacturingYear = input.nextInt();
                LocalDate meatManufacturingDate = LocalDate.of(meatManufacturingYear, meatManufacturingMonth, meatManufacturingDay);
                System.out.println("Nhập giá thành Thịt: ");
                int meatCost = input.nextInt();
                System.out.println("Nhập khối lượng: ");
                double meatWeight = input.nextDouble();
                Material newMeat = new Meat(meatID, meatName, meatManufacturingDate, meatCost, meatWeight);
                newMaterial = newMeat;
        }
        return newMaterial;
    }*/

    /*public static int findMaterialIndexByID(String SearchID) {
        int index = -1;
        for (int i = 0; i < materials.size(); i++) {
            Material currentMaterial = materials.get(i);
            String currentMaterialID = currentMaterial.getId();
            if (currentMaterialID.equals(SearchID)) {
                index = i;
                break;
            }
        }
        return index;
    }*/
}
