package util;

import java.sql.*;

public class MysqlDataAccess {
    public Connection myConnection = null;

    public void displayError(SQLException ex){
        System.err.println(" Error Message:" + ex.getMessage());
        System.err.println(" SQL State:" + ex.getSQLState());
        System.err.println(" Error Code:" + ex.getErrorCode());
    }

    public void openConnect(){//Mở kết nối cơ sở dữ liệu
        final String url = "jdbc:mysql://localhost:3306/qlsv";
        final String user="root";
        final String password="chien12345678";
        try {
            myConnection = DriverManager.getConnection(url, user,
                    password);
        } catch (SQLException ex) {
            displayError(ex);
        }
    }

    public void closeConnect(){// dong ket noi co so du lieu
        try {
            if(myConnection!=null)
                myConnection.close();
        } catch (SQLException ex) {
            displayError(ex);
        }
    }


    public ResultSet excuteQuery(String sqlScrip){// danh cho cau lenh secect
        ResultSet rs = null;
        try {
            Statement stm = myConnection.createStatement();
            rs = stm.executeQuery(sqlScrip);
        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }

    public int excuteUpDate(String sqlScrip){
        int rs = 0;
        try{
            Statement stm = myConnection.createStatement();
            rs = stm.executeUpdate(sqlScrip);

        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }




}
