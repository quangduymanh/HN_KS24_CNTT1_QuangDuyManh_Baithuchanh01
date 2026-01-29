package Session05;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ThucHanh01 {
    static String[] mssvList = new String[100];
    static int count = 0;
    static final String MSSV_REGEX = "^B\\d{7}$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            System.out.print("Chọn chức năng:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addMSSV(scanner);
                    break;
                case 3:
                    updateMSSV(scanner);
                    break;
                case 4:
                    deleteMSSV(scanner);
                    break;
                case 5:
                    seachMSSV(scanner);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
        scanner.close();
    }
    // Hiển thị menu
    static void showMenu() {
        System.out.println("\n===MENU QUẢN LÝ MSSV===");
        System.out.println("1. Hiển thị danh sách MSSV");
        System.out.println("2. Thêm mới MSSV");
        System.out.println("3. Cập nhật MSSV theo index");
        System.out.println("4. Xóa MSSV");
        System.out.println("5. Tìm kiếm MSSV");
        System.out.println("0. Thoát");
    }
    // Hiển thị danh sách MSSV
    static void showList() {
        if (count == 0) {
            System.out.println("Danh sách MSSV đang rỗng!");
            return;
        }
        System.out.println("Danh sách MSSV:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }
    // Thêm mới MSSV
    static void addMSSV(Scanner scanner) {
        if (count >= 100) {
            System.out.println("Mảng đã đầy, không thể thêm!");
            return;
        }
        String mssv;
        while (true) {
            System.out.print("Nhập MSSV mới: ");
            mssv = scanner.nextLine();
            if (Pattern.matches(MSSV_REGEX, mssv)) {
                break;
            }
            System.out.println("Sai định dạng! MSSV phải dạng Bxxxxxxx");
        }
        mssvList[count] = mssv;
        count++;
        System.out.println("Thêm MSSV thành công!");
    }
    // Cập nhật MSSV theo index
    static void updateMSSV(Scanner scanner) {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.print("Nhập index cần sửa (0 - " + (count - 1) + "): ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        String newMSSV;
        while (true) {
            System.out.print("Nhập MSSV mới: ");
            newMSSV = scanner.nextLine();
            if (Pattern.matches(MSSV_REGEX, newMSSV)) {
                break;
            }
            System.out.println("Sai định dạng MSSV!");
        }
        mssvList[index] = newMSSV;
        System.out.println("Cập nhật thành công!");
    }
    // Xóa MSSV
    static void deleteMSSV(Scanner scanner) {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.print("Nhập MSSV cần xóa: ");
        String target = scanner.nextLine();
        int deleteIndex = -1;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(target)) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex == -1) {
            System.out.println("Không tìm thấy MSSV!");
            return;
        }
        for (int i = deleteIndex; i < count - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        mssvList[count - 1] = null;
        count--;
        System.out.println("Xóa MSSV thành công!");
    }
    // Tìm kiếm MSSV
    static void seachMSSV(Scanner scanner){
        if (count == 0){
            System .out .println("Danh sách rỗng!");
            return;
        }
        System.out.println("Nhap ma sinh vien can tim kiem:");
    }
}
