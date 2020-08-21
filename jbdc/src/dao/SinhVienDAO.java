package dao;

import dto.SinhVien;
import util.MysqlDataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SinhVienDAO {
    public static ArrayList<SinhVien> getALLSinhVien() {
        ArrayList<SinhVien> arr = new ArrayList<>();
        MysqlDataAccess mysqlDataAccess = new MysqlDataAccess();
        String sqlScrip = "select * from sinhvien";
        mysqlDataAccess.openConnect();
        try {

            ResultSet rs = mysqlDataAccess.excuteQuery(sqlScrip);

            while (rs.next()){
                SinhVien sv = new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("tenSV"),
                        rs.getBoolean("gioiTinh"),
                        rs.getString("maLop")
                );
                arr.add(sv);
            }
        }
        catch (SQLException ex){
            mysqlDataAccess.displayError(ex);
        }
        finally {
            mysqlDataAccess.closeConnect();
        }
        return arr;
    }

    public static int insertSinhVien(SinhVien sv){
        MysqlDataAccess mysqlDataAccess = new MysqlDataAccess();
        mysqlDataAccess.openConnect();
        String sql = String.format(
                "INSERT INTO sinhvien(maSV,tenSV,gioiTinh,maLop)" +
                " VALUES ('%s',N'%s',%b,'%s')",
                sv.getMaSV(),sv.getTenSV(),sv.getGioiTinh(),sv.getMaLop()
                );

        int rs = mysqlDataAccess.excuteUpDate(sql);

        mysqlDataAccess.closeConnect();

        return rs;
    }

    public static int deleteSinhVien(String maSV){
        MysqlDataAccess mysqlDataAccess = new MysqlDataAccess();
        String sqlScrip = String.format("delete from qlsv.sinhvien where maSV= '%s'",maSV);
        mysqlDataAccess.openConnect();
        int rs = mysqlDataAccess.excuteUpDate(sqlScrip);
        return rs;
    }

    public static int upDateSinhVien(SinhVien sv){
        MysqlDataAccess mysqlDataAccess = new MysqlDataAccess();
        mysqlDataAccess.openConnect();
        String sqlScrip = String.format("update SinhVien SET tenSV=N'%s',gioiTinh=%b,maLop='%s' where maSV='%s'"
                ,sv.getTenSV(),sv.getGioiTinh(),sv.getMaLop(),sv.getMaSV());
        int rs = mysqlDataAccess.excuteUpDate(sqlScrip);
        mysqlDataAccess.closeConnect();
        return rs;
    }

    


}
