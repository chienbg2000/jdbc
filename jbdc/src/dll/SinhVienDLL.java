package dll;

import dao.SinhVienDAO;
import dto.SinhVien;
import java.util.ArrayList;

public class SinhVienDLL {
    public static ArrayList<SinhVien> getAllSinhVien() {
        ArrayList<SinhVien> arr = SinhVienDAO.getALLSinhVien();
        return arr;
    }

    public static int insertSinhVien(SinhVien sv){
        int b = SinhVienDAO.insertSinhVien(sv);
        return b;
    }

    public static int deleteSinhVien(String maSV){
        int b = SinhVienDAO.deleteSinhVien(maSV);
        return b;
    }

    public static int upDateSinhVien(SinhVien sv){
        return SinhVienDAO.upDateSinhVien(sv);
    }


}
