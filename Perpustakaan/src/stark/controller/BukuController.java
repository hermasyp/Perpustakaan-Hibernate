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

    public void showData() {
        daftarBuku = bukuDao.getDaftarBuku();
        bukuTableModel = new BukuTableModel((daftarBuku));
        this.bukuView.getTbBuku().setModel(bukuTableModel);
    }

    public void clearField() {
        this.bukuView.getBtnSave().setEnabled(true);
        this.bukuView.getTxtISBN().setText("");
        this.bukuView.getTxtJudul().setText("");
        this.bukuView.getTxtPenerbit().setText("");
        this.bukuView.getTxtPenulis().setText("");
        this.bukuView.getTxtHarga().setText("");
        this.bukuView.getTxtTahun().setText("");
    }

    public void saveBuku() {
        Buku buku = new Buku();
        buku.setIsbn(this.bukuView.getTxtISBN().getText());
        buku.setJudul(this.bukuView.getTxtJudul().getText());
        buku.setPenerbit(this.bukuView.getTxtPenerbit().getText());
        buku.setPenulis(this.bukuView.getTxtPenulis().getText());
        buku.setTahun(Integer.parseInt(this.bukuView.getTxtTahun().getText()));
        buku.setHarga(Float.parseFloat(this.bukuView.getTxtHarga().getText()));

        bukuDao.saveBuku(buku);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        clearField();
        showData();
    }

    public void updateBuku() {
        Buku buku = new Buku();
        buku.setIsbn(this.bukuView.getTxtISBN().getText());
        buku.setJudul(this.bukuView.getTxtJudul().getText());
        buku.setPenerbit(this.bukuView.getTxtPenerbit().getText());
        buku.setPenulis(this.bukuView.getTxtPenulis().getText());
        buku.setTahun(Integer.parseInt(this.bukuView.getTxtTahun().getText()));
        buku.setHarga(Float.parseFloat(this.bukuView.getTxtHarga().getText()));

        bukuDao.updateBuku(buku);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        showData();
        clearField();
    }

    public void getBuku() {
        this.bukuView.getBtnSave().setEnabled(false);
        int idx = this.bukuView.getTbBuku().getSelectedRow();
        this.bukuView.getTxtISBN().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 0)));
        this.bukuView.getTxtJudul().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 1)));
        this.bukuView.getTxtPenulis().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 2)));
        this.bukuView.getTxtPenerbit().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 3)));
        this.bukuView.getTxtTahun().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 4)));
        this.bukuView.getTxtHarga().setText(
                String.valueOf(this.bukuView.getTbBuku()
                        .getValueAt(idx, 5)));
    }

    public void deleteBuku() {
        Buku buku = new Buku();
        buku.setIsbn(this.bukuView.getTxtISBN().getText());

        int confirm = JOptionPane.showConfirmDialog(bukuView, "Apakah anda yakin ingin menghapus data dengan ISBN : " +buku.getIsbn(),
                "Confirm Delete",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            bukuDao.deleteBuku(buku);
            JOptionPane.showMessageDialog(bukuView, "Buku Telah Berhasil Dihapus !","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        clearField();
        showData();

    }
}
