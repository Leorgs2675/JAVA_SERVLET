package Controller;

import Entity.HoaDon;
import Service.HoaDonRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "heheheh", value = {"/getAll", "/detail", "/search", "/delete"})
public class HoaDonServlet extends HttpServlet {
    private List<HoaDon> list = new ArrayList<>();
    private HoaDonRepository repo = new HoaDonRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String ma = req.getParameter("ma");
        if (uri.contains("getAll")) {
            list = repo.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/view/hien-thi.jsp").forward(req, resp);
        } else if (uri.contains("detail")) {
            HoaDon hd = repo.getOne(ma);
            req.setAttribute("hd", hd);
            req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
        } else if (uri.contains("/delete")) {
            repo.Delete(ma);
            list = repo.getAll();
            resp.sendRedirect("/getAll");
        } else if (uri.contains("/search")) {
            String tim = req.getParameter("tim");
            List<HoaDon> timKiem = repo.tim(tim);
            list = timKiem;
            req.setAttribute("list", list);
            req.getRequestDispatcher("/view/hien-thi.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        list.clear();
        if (action.equals("add")) {
            String ma = req.getParameter("ma");
            String ghiChu = req.getParameter("ghiChu");
            String maGD = req.getParameter("maGD");
            Float tienThua = Float.valueOf(req.getParameter("tienThua"));
            Float tongTien = Float.valueOf(req.getParameter("tongTien"));
            HoaDon hd = new HoaDon(ma, tongTien, tienThua, ghiChu, maGD);
            repo.add(hd);
            list = repo.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/view/hien-thi.jsp").forward(req, resp);
        } else if (action.equals("update")) {
            String ma = req.getParameter("ma");
            String ghiChu = req.getParameter("ghiChu");
            String maGD = req.getParameter("maGD");
            Float tienThua = Float.valueOf(req.getParameter("tienThua"));
            Float tongTien = Float.valueOf(req.getParameter("tongTien"));
            HoaDon hd = repo.update(ma, new HoaDon(ma, tongTien, tienThua, ghiChu, maGD));
            if (hd != null) {
                hd.setMa(ma);
                hd.setTienThua(tienThua);
                hd.setTongTien(tongTien);
                hd.setMaGD(maGD);
                hd.setGhiChu(ghiChu);
            }
            list.clear();
            list = repo.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/view/hien-thi.jsp").forward(req, resp);
            req.setAttribute("hd", hd);
        }
    }
}
