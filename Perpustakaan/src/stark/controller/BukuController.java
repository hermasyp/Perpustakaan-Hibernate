/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stark.controller;

import java.util.List;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import stark.config.BukuTableModel;
import stark.config.HibernateUtil;
import stark.dao.BukuDao;
import stark.model.Buku;
import stark.view.BukuView;

/**
 *
 * @author yuda14305
 */
public class BukuController {
    private final BukuView bukuView;
    private BukuTableModel bukuTableModel;
    private List<Buku> daftarBuku;
    private final BukuDao bukuDao = HibernateUtil.getBukuDao();

    public BukuController(BukuView bukuView) {
        this.bukuView = bukuView;
    }
    public void showData(){
        daftarBuku = bukuDao.getDaftarBuku();
        bukuTableModel = new BukuTableModel((daftarBuku));
        this.bukuView.getTbBuku().setModel(bukuTableModel);                                                                          
    }
    public void clearField(){
        this.bukuView.getTxtISBN().setText("");
        this.bukuView.getTxtJudul().setText("");
        this.bukuView.getTxtPenerbit().setText("");
        this.bukuView.getTxtPenulis().setText("");
        this.bukuView.getTxtHarga().setText("");
        this.bukuView.getTxtTahun().setText("");
    }
    public void saveBuku(){
        Buku buku = new Buku();
        buku.setIsbn(this.bukuView.getTxtISBN().getText());
        buku.setJudul(this.bukuView.getTxtJudul().getText());
        buku.setPenerbit(this.bukuView.getTxtPenerbit().getText());
        buku.setPenulis(this.bukuView.getTxtPenulis().getText());
        buku.setTahun(Integer.parseInt(this.bukuView.getTxtTahun().getText()));
        buku.setHarga(Integer.parseInt(this.bukuView.getTxtHarga().getText()));
        
        bukuDao.saveBuku(buku);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        clearField();
        showData();
    }
    
    
}
