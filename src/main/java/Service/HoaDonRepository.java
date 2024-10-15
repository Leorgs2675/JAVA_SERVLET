package Service;

import Entity.HoaDon;
import Utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    private List<HoaDon> hdlist = new ArrayList<>();
public List<HoaDon> getAll() {
    String sql = "SELECT    idHoaDon, tongTienHang, tienThua, ghiChu, maGiaoDich\n" +
            "FROM         dbo.HoaDon";
    try(Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            HoaDon hd = new HoaDon();
            hd.setMa(rs.getString(1));
            hd.setTongTien(rs.getFloat(2));
            hd.setTienThua(rs.getFloat(3));
            hd.setGhiChu(rs.getString(4));
            hd.setMaGD(rs.getString(5));
            hdlist.add(hd);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return hdlist;
}
public ArrayList<HoaDon> tim(String ma) {
    ArrayList<HoaDon> listHd = new ArrayList<>();
    String sql = "SELECT    idHoaDon, tongTienHang, tienThua, ghiChu, maGiaoDich FROM         dbo.HoaDon WHERE idHoaDon like ?";
    try(Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setObject(1,'%'+ma+'%');
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String maHD,ghiChu,maGD;
            Float tienThua,tongTien;
            maHD = rs.getString(1);
            maGD = rs.getString(5);
            ghiChu = rs.getString(4);
            tongTien = rs.getFloat(2);
            tienThua = rs.getFloat(3);
            listHd.add(new HoaDon(maHD,tongTien,tienThua,ghiChu,maGD));

        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return listHd;
}

        public HoaDon getOne(String ma){
            String sql = "SELECT    idHoaDon, tongTienHang, tienThua, ghiChu, maGiaoDich FROM         dbo.HoaDon WHERE idHoaDon = ?";
            try(Connection conn = DBConnect.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1,ma);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    HoaDon hd = new HoaDon();
                    hd.setMa(rs.getString(1));
                    hd.setTongTien(rs.getFloat(2));
                    hd.setTienThua(rs.getFloat(3));
                    hd.setGhiChu(rs.getString(4));
                    hd.setMaGD(rs.getString(5));
                    return hd;

                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    public void Delete(String ma){
        String sql = "DELETE FROM dbo.HoaDon WHERE idHoaDon = ?";
        try(Connection conn = DBConnect.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,ma);
            ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        public HoaDon update(String ma,HoaDon hd){
            String sql = "UPDATE dbo.HoaDon SET tongTienHang=?,tienThua=?,ghiChu=?,maGiaoDich=? WHERE idHoaDon =?";
            try(Connection conn = DBConnect.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setFloat(1,hd.getTongTien());
                ps.setFloat(2,hd.getTienThua());
                ps.setString(3,hd.getGhiChu());
                ps.setString(4,hd.getMaGD());
                ps.setString(5,ma);
                ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }
            return hd;
        }
        public void add(HoaDon hd){
            String sql = "INSERT INTO HoaDon(tongTienHang,tienThua,ghiChu,maGiaoDich) VALUES (?,?,?,?)";
            try(Connection conn = DBConnect.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
//                ps.setString(1,hd.getMa());
                ps.setFloat(1,hd.getTongTien());
                ps.setFloat(2,hd.getTienThua());
                ps.setString(3,hd.getGhiChu());
                ps.setString(4,hd.getMaGD());
                ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

}
