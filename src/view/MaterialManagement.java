package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class MaterialManagement {
    public static LinkedList<Material> materialsClient = MaterialManager.materials;

    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("QUẢN LÝ NGUYÊN LIỆU");
            System.out.println("1. Thêm nguyên liệu mới");
            System.out.println("2. Xóa nguyên liệu");
            System.out.println("3. Sửa nguyên liệu");
            System.out.println("4. Hiển thị nguyên liệu");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Material newMaterial = creatNewMaterial();
                    MaterialManager.addNewMaterial(newMaterial);
                    break;
                case 2:
                    deleteMaterial();
                    break;
                case 3:
                    editMaterial();
                    break;
                case 4:
                    System.out.println("Danh sách nguyên liệu");
                    showAllMaterial();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void deleteMaterial() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println("1. Xóa nguyên liệu theo tên");
        System.out.println("2. Xóa nguyên liệu theo mã");
        System.out.println("Nhập lựa chọn: ");
        choice = input.nextInt();
        if (choice == 1) {
            deleteMaterialByName();
        }
        if (choice == 2) {
            deleteMaterialById();
        }
    }

    public static void deleteMaterialByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên nguyên liệu muốn xóa: ");
        String deleteName = input.nextLine();
        int deleteIndex = MaterialManager.findMaterialIndexByName(deleteName);
        MaterialManager.removeMaterialByIndex(deleteIndex);
    }

    public static void deleteMaterialById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã nguyên liệu muốn xóa: ");
        String deleteId = input.nextLine();
        int deleteIndex = MaterialManager.findMaterialIndexById(deleteId);
        MaterialManager.removeMaterialByIndex(deleteIndex);
    }

    public static void editMaterial() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println("1. Sửa nguyên liệu theo tên");
        System.out.println("2. Sửa nguyên liệu theo mã");
        System.out.println("Nhập lựa chọn: ");
        choice = input.nextInt();
        if (choice == 1) {
            editMaterialByName();
        }
        if (choice == 2) {
            editMaterialById();
        }
    }

    public static void editMaterialByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên nguyên liệu muốn sửa: ");
        String editName = input.nextLine();
        String e = input.nextLine();
        Material editedMaterial = creatNewMaterial();
        int editIndex = MaterialManager.findMaterialIndexByName(editName);
        MaterialManager.editMaterialByIndex(editIndex, editedMaterial);
    }
    
    public static void editMaterialById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã nguyên liệu muốn sửa: ");
        String editId = input.nextLine();
        String e = input.nextLine();
        Material editedMaterial = creatNewMaterial();
        int editIndex = MaterialManager.findMaterialIndexById(editId);
        MaterialManager.editMaterialByIndex(editIndex, editedMaterial);
    }
    
    public static Material creatNewMaterial() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        Material newMaterial = null;
        System.out.println("1. Thêm mới/Sửa Bột chiên giòn");
        System.out.println("2. Thêm mới/Sửa Thịt");
        System.out.println("Nhập lựa chọn: ");
        choice = input.nextInt();
        if (choice == 1) {
            newMaterial = creatNewCrispyFour();
        }
        if (choice == 2) {
            newMaterial = creatNewMeat();
        }
        return newMaterial;
    }

    private static Material creatNewMeat() {
        Scanner input = new Scanner(System.in);
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
        return newMeat;
    }

    private static Material creatNewCrispyFour() {
        Scanner input = new Scanner(System.in);
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
        return newCrispyFlour;
    }

    public static void showAllMaterial(){
        for (Material e: materialsClient
        ) {
            System.out.println(e);
        }
    }
}
