package gui;

import InPut.InPut;
import dll.SinhVienDLL;
import dto.SinhVien;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiDiemSV {

    private static void loadAllSV()  {
        ArrayList<SinhVien> arr = SinhVienDLL.getAllSinhVien();
        for (SinhVien sv: arr) {
            System.out.println(sv);
        }
    }

    private static void insertSV(){

        System.out.println("Nhập mã sinh viên:");
        String maSV = InPut.nextLine();
        System.out.println("Nhập tên sinh viên:");
        String tenSV = InPut.nextLine();
        System.out.println("Nhập giới tính:");
        Boolean gioiTinh = InPut.nextBool();
        System.out.println("Nhập mã lớp:");
        String maLop = InPut.nextLine();

        SinhVien sv = new SinhVien(maSV,tenSV,gioiTinh,maLop);

        if(SinhVienDLL.insertSinhVien(sv)!=0){
            System.out.println("Thêm thành công");
        }else {
            System.out.println("Thêm thất bại");
        };

    }

    private static void deteleSV(){
        System.out.println("Nhập mã sinh viên muốn xóa:");
        String maSV = InPut.nextLine();
        if(SinhVienDLL.deleteSinhVien(maSV) != 0){
            System.out.println("Xóa thành công!");
        }else {
            System.out.println("Xóa thất bại!");
        };



    }

    private static void upDateSV(){
        System.out.println("Nhập mã sinh viên:");
        String maSV = InPut.nextLine();
        System.out.println("Nhập tên sinh viên:");
        String tenSV = InPut.nextLine();
        System.out.println("Nhập giới tính:");
        Boolean gioiTinh = InPut.nextBool();
        System.out.println("Nhập mã lớp:");
        String maLop = InPut.nextLine();
        SinhVien sv = new SinhVien(maSV,tenSV,gioiTinh,maLop);

        if(SinhVienDLL.upDateSinhVien(sv)!=0){
            System.out.println("Thành công");
        }else {
            System.out.println("Thất bại");
        };
    }

    private static void menu(){
        int chon;
        do {
            System.out.println("===QLDSV===");
            System.out.println("1.Sinh vien");
            System.out.println("2.Lop");
            System.out.println("3.Diem");
            System.out.println("4.Mon hoc");
            System.out.println("0.Exit");
            chon = InPut.nextInt();
            switch (chon){
                case 1:subMenuSV();break;
                case 2:break;
                case 3:break;
                case 4:break;
                case 0:break;
                default:
                    System.out.println("Lựa chọn không hợp hệ!");
            }
            System.out.println("Enter để tiếp tục!");
            if(chon != 0){
                System.out.println("Enter để tiếp tục!");
                new Scanner(System.in).nextLine();
            }
        }while (chon != 0);
    }

    public static void subMenuSV() {
        int chon;
        do {
            System.out.println("===Sinh_Vien===");
            System.out.println("1.Hiện danh sách sinh viên");
            System.out.println("2.Thêm sinh viên");
            System.out.println("3.Xóa sinh viên");
            System.out.println("4.Chỉnh sửa thông tin sinh viên");
            System.out.println("0.Exit");

            chon = InPut.nextInt();
            switch (chon){
                case 1:loadAllSV();
                break;
                case 2:insertSV();
                break;
                case 3:deteleSV();
                break;
                case 4:upDateSV();
                break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            if(chon != 0){
                System.out.println("Enter để tiếp tục!");
                new Scanner(System.in).nextLine();
            }

        }while (chon !=0);
    }

    public static void main(String[] args) {
        menu();



    }
}
