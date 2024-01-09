
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

//Using Singleton Pattern to optimize this class
public class MysqlConnector {
    private static MysqlConnector instance = null;
    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/qlchungcu";
    private final String userName = "root";
    private final String password = "";

    private MysqlConnector() {
        // Private constructor to prevent external instantiation.
    }

    public static MysqlConnector getInstance() {
        if (instance == null) {
            instance = new MysqlConnector();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }

    public void closeDB() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
    
    //User data
    public String getPwData(String username) {
        String pw = null;
        try {
            String query = "SELECT Password FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pw = rs.getString("Password");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pw;
    }
    
    public void changePwData(String username, String newPw){
        try {
            String query = "UPDATE user SET Password = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newPw);
            ps.setString(2, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String getHoTenData(String username) {
        String hoTen = null;
        try {
            String query = "SELECT HoTen FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hoTen = rs.getString("HoTen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoTen;
    }

    public String getEmailData(String username) {
        String email = null;
        try {
            String query = "SELECT Email FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                email = rs.getString("Email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public String getSoDTData(String username) {
        String soDT = null;
        try {
            String query = "SELECT SoDT FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soDT = rs.getString("SoDT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soDT;
    }

    public String getDiaChiData(String username) {
        String diaChi = null;
        try {
            String query = "SELECT DiaChi FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                diaChi = rs.getString("DiaChi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diaChi;
    }

    public int getTuoiData(String username) {
        int tuoi = -1; // Giả sử tuổi không bao giờ là giá trị âm
        try {
            String query = "SELECT Tuoi FROM user WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tuoi = rs.getInt("Tuoi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tuoi;
    }

    public void changeHoTenData(String username, String newHoTen) {
        try {
            String query = "UPDATE user SET HoTen = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newHoTen);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeEmailData(String username, String newEmail) {
        try {
            String query = "UPDATE user SET Email = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeSoDTData(String username, String newSoDT) {
        try {
            String query = "UPDATE user SET SoDT = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newSoDT);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeDiaChiData(String username, String newDiaChi) {
        try {
            String query = "UPDATE user SET DiaChi = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newDiaChi);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeTuoiData(String username, int newTuoi) {
        try {
            String query = "UPDATE user SET Tuoi = ? WHERE Username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, newTuoi);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //Nhân khẩu data
    
    public ObservableList<NhanKhauModel> getNhanKhauData(){
        ObservableList<NhanKhauModel> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from NhanKhau");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new NhanKhauModel(
                        rs.getString("MaHoKhau"), 
                        rs.getString("HoTen"), 
                        Integer.parseInt(rs.getString("Tuoi")), 
                        rs.getString("GioiTinh"), 
                        rs.getString("SoCMND_CCCD"), 
                        rs.getString("SoDT"), 
                        rs.getString("QuanHe"),
                        Integer.parseInt(rs.getString("TamVang")) == 1,
                        Integer.parseInt(rs.getString("TamTru")) == 1
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public void addNhanKhauData(NhanKhauModel nhanKhau) {
        try {
            String query = "INSERT INTO NhanKhau (MaHoKhau, HoTen, Tuoi, GioiTinh, SoCMND_CCCD, SoDT, QuanHe, TamVang, TamTru) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nhanKhau.getMaHoKhau());
            ps.setString(2, nhanKhau.getHoTen());
            ps.setInt(3, nhanKhau.getTuoi());
            ps.setString(4, nhanKhau.getGioiTinh());
            ps.setString(5, nhanKhau.getCCCD());
            ps.setString(6, nhanKhau.getSoDT());
            ps.setString(7, nhanKhau.getQuanHe());
            ps.setInt(8, 0);
            ps.setInt(9, 0);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateNhanKhauData(NhanKhauModel updatedNhanKhau) {
        try {
            String query = "UPDATE NhanKhau SET MaHoKhau = ?, HoTen = ?, Tuoi = ?, GioiTinh = ?, SoDT = ?, QuanHe = ?, TamVang = ?, TamTru = ? WHERE SoCMND_CCCD = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, updatedNhanKhau.getMaHoKhau());
            ps.setString(2, updatedNhanKhau.getHoTen());
            ps.setInt(3, updatedNhanKhau.getTuoi());
            ps.setString(4, updatedNhanKhau.getGioiTinh());
            ps.setString(5, updatedNhanKhau.getSoDT());
            ps.setString(6, updatedNhanKhau.getQuanHe());
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setString(9, updatedNhanKhau.getCCCD());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteNhanKhauData(String soCCCD) {
        try {
            String query = "DELETE FROM NhanKhau WHERE SoCMND_CCCD = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, soCCCD);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<TamTruModel> getTamTruData() {
        ObservableList<TamTruModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM TamTru");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TamTruModel(
                        rs.getString("MaTamTru"),
                        rs.getString("SoCMND_CCCD"),
                        rs.getString("LyDo"),
                        rs.getObject("TuNgay", LocalDate.class),
                        rs.getObject("DenNgay", LocalDate.class)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ObservableList<TamVangModel> getTamVangData() {
        ObservableList<TamVangModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM TamVang");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TamVangModel(
                        rs.getString("MaTamVang"),
                        rs.getString("SoCMND_CCCD"),
                        rs.getString("NoiTamTru"),
                        rs.getObject("TuNgay", LocalDate.class),
                        rs.getObject("DenNgay", LocalDate.class)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addTamTruData(TamTruModel tamTru) {
        try {
            String query = "INSERT INTO TamTru (MaTamTru, SoCMND_CCCD, LyDo, TuNgay, DenNgay) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tamTru.getMaTamTru());
            ps.setString(2, tamTru.getSoCCCD());
            ps.setString(3, tamTru.getLyDo());
            ps.setObject(4, tamTru.getTuNgay());
            ps.setObject(5, tamTru.getDenNgay());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTamVangData(TamVangModel tamVang) {
        try {
            String query = "INSERT INTO TamVang (MaTamVang, SoCMND_CCCD, NoiTamTru, TuNgay, DenNgay) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tamVang.getMaTamVang());
            ps.setString(2, tamVang.getSoCCCD());
            ps.setString(3, tamVang.getNoiTamTru());
            ps.setObject(4, tamVang.getTuNgay());
            ps.setObject(5, tamVang.getDenNgay());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTamTruData(String maTamTru) {
        try {
            String query = "DELETE FROM TamTru WHERE MaTamTru = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maTamTru);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTamVangData(String maTamVang) {
        try {
            String query = "DELETE FROM TamVang WHERE MaTamVang = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maTamVang);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Hộ khẩu data
    public ObservableList<HoKhauModel> getHoKhauData() {
        ObservableList<HoKhauModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM HoKhau");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoKhauModel(
                        rs.getString("MaHoKhau"),
                        rs.getString("DiaChi"),
                        rs.getObject("NgayLap", LocalDate.class),
                        rs.getObject("NgayChuyenDi", LocalDate.class),
                        rs.getString("LyDoChuyen")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addHoKhauData(HoKhauModel newHoKhau) {  //Có trigger để thêm dữ liệu các bảng khác rồi
        try {
            String query = "INSERT INTO HoKhau (MaHoKhau, DiaChi, NgayLap, NgayChuyenDi, LyDoChuyen) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, newHoKhau.getMaHoKhau());
            ps.setString(2, newHoKhau.getDiaChi());
            ps.setObject(3, newHoKhau.getNgayLap());
            ps.setObject(4, newHoKhau.getNgayChuyenDi());
            ps.setString(5, newHoKhau.getLyDoChuyen());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateHoKhauData(HoKhauModel updatedHoKhau) {
        try {
            String query = "UPDATE HoKhau SET DiaChi = ?, NgayLap = ?, NgayChuyenDi = ?, LyDoChuyen = ? WHERE MaHoKhau = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, updatedHoKhau.getDiaChi());
            ps.setObject(2, updatedHoKhau.getNgayLap());
            ps.setObject(3, updatedHoKhau.getNgayChuyenDi());
            ps.setString(4, updatedHoKhau.getLyDoChuyen());
            ps.setString(5, updatedHoKhau.getMaHoKhau());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteHoKhauData(String maHoKhau) {    //Có trigger để xóa dữ liệu các bảng khác rồi
        try {
            String query = "DELETE FROM HoKhau WHERE MaHoKhau = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maHoKhau);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<PhiCoDinhModel> getFeeData(String tenPhi, int nam) {
        ObservableList<PhiCoDinhModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + tenPhi + " WHERE Nam = ?");
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhiCoDinhModel(
                        rs.getString("MaHoKhau"),
                        rs.getFloat("TienNopMoiThang"),
                        rs.getFloat("Thang1"),
                        rs.getFloat("Thang2"),
                        rs.getFloat("Thang3"),
                        rs.getFloat("Thang4"),
                        rs.getFloat("Thang5"),
                        rs.getFloat("Thang6"),
                        rs.getFloat("Thang7"),
                        rs.getFloat("Thang8"),
                        rs.getFloat("Thang9"),
                        rs.getFloat("Thang10"),
                        rs.getFloat("Thang11"),
                        rs.getFloat("Thang12")                    
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public float getGiaPhiData(String tenPhi, int nam) {
        float giaPhi = 0.0f;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT GiaPhi FROM " + tenPhi + " WHERE Nam = ?");
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                giaPhi = rs.getFloat("GiaPhi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaPhi;
    }
    
    public void changeFeeData(String tenPhi, float newFee, int nam) {
        try {
            float oldFee = 0.0f, oldMonthlyFee = 0.0f;
            PreparedStatement psSelect = connection.prepareStatement("SELECT GiaPhi, TienNopMoiThang FROM " + tenPhi + " WHERE Nam = ?");
            psSelect.setInt(1, nam);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                oldFee = rs.getFloat("GiaPhi");
                oldMonthlyFee = rs.getFloat("TienNopMoiThang");
            }

            PreparedStatement psUpdate = connection.prepareStatement("UPDATE " + tenPhi + " SET GiaPhi = ?, TienNopMoiThang = ? WHERE Nam >= ?");
            psUpdate.setFloat(1, newFee);
            psUpdate.setFloat(2, oldMonthlyFee / oldFee * newFee);
            psUpdate.setInt(3, nam);
            psUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<HoKhauModel> getDienTichHoData() {
        ObservableList<HoKhauModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT MaHoKhau, dienTichHo FROM Hokhau");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoKhauModel(
                        rs.getString("MaHoKhau"),
                        rs.getFloat("dienTichHo")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void changeDienTichHoData(String maHoKhau, float newDienTich, int nam){
        try {
            float giaPhiDichVu = 0.0f;
            PreparedStatement ps = connection.prepareStatement("SELECT GiaPhi FROM PhiDichVu WHERE MaHoKhau = ?");
            ps.setString(1, maHoKhau);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                giaPhiDichVu = rs.getFloat("GiaPhi");
            }
            
            float giaPhiQuanLy = 0.0f;
            ps = connection.prepareStatement("SELECT GiaPhi FROM PhiQuanLy WHERE MaHoKhau = ?");
            ps.setString(1, maHoKhau);
            rs = ps.executeQuery();
            if(rs.next()){
                giaPhiQuanLy = rs.getFloat("GiaPhi");
            }
            
            ps = connection.prepareStatement("UPDATE Hokhau SET dienTichHo = ? WHERE MaHoKhau = ?");
            ps.setFloat(1, newDienTich);
            ps.setString(2, maHoKhau);
            ps.executeUpdate();
    
            
            ps = connection.prepareStatement("UPDATE PhiDichVu SET TienNopMoiThang = ? WHERE MaHoKhau = ? and Nam >= ?");
            ps.setFloat(1, giaPhiDichVu * newDienTich);
            ps.setString(2, maHoKhau);
            ps.setInt(3, nam);
            ps.executeUpdate();
            
            
            ps = connection.prepareStatement("UPDATE PhiQuanLy SET TienNopMoiThang = ? WHERE MaHoKhau = ? and Nam >= ?");
            ps.setFloat(1, giaPhiQuanLy * newDienTich);
            ps.setString(2, maHoKhau);
            ps.setInt(3, nam);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<HoKhauModel> getVehicleData() {
        ObservableList<HoKhauModel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT MaHoKhau, SoXeMay, SoOTo, SoXeDap FROM Hokhau");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoKhauModel(
                        rs.getString("MaHoKhau"),
                        rs.getInt("SoXeMay"),
                        rs.getInt("SoOTo"),
                        rs.getInt("SoXeDap")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public float getFeePerVehicleData(String feeName, int nam) {
        float fee = 0.0f;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT " + feeName +" FROM PhiGuiXe WHERE Nam = ?");
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fee = rs.getFloat(feeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fee;
    }
    
    public void changeVehicleData(String maHoKhau, int soXeMay, int soOTo, int soXeDap, int nam){
        float fee1 = getFeePerVehicleData("GiaXeMay", nam);
        float fee2 = getFeePerVehicleData("GiaOTo", nam);
        float fee3 = getFeePerVehicleData("GiaXeDap", nam);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE HoKhau SET SoXeMay = ?, SoOTo = ?, SoXeDap = ? WHERE MaHoKhau = ?");
            ps.setInt(1, soXeMay);
            ps.setInt(2, soOTo);
            ps.setInt(3, soXeDap);
            ps.setString(4, maHoKhau);
            ps.executeUpdate();
            
            ps = connection.prepareStatement("UPDATE PhiGuiXe SET TienNopMoiThang = ? WHERE MaHoKhau = ? and Nam >= ?");
            ps.setFloat(1, fee1 * soXeMay + fee2 * soOTo + fee3 * soXeDap);
            ps.setString(2, maHoKhau);
            ps.setInt(3, nam);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void changeFeePerVehicleData(float giaXeMay, float giaOTo, float giaXeDap, int nam){
        ObservableList<HoKhauModel> list = getVehicleData();
        for(HoKhauModel hoKhau : list){
            String maHoKhau = hoKhau.getMaHoKhau();
            int soXeMay = hoKhau.getSoXeMay();
            int soXeDap = hoKhau.getSoXeDap();
            int soOTo = hoKhau.getSoOTo();
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE PhiGuiXe SET GiaXeMay = ?, GiaOTo = ?, GiaXeDap = ?, TienNopMoiThang = ? WHERE MaHoKhau = ? and nam >= ?");
                ps.setFloat(1, giaXeMay);
                ps.setFloat(2, giaOTo);
                ps.setFloat(3, giaXeDap);
                ps.setFloat(4, giaXeMay * soXeMay + giaXeDap * soXeDap + giaOTo * soOTo);
                ps.setString(5, maHoKhau);
                ps.setInt(6, nam);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}