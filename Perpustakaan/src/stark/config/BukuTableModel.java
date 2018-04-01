package stark.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import stark.model.Buku;

public class BukuTableModel extends AbstractTableModel{

    private List<Buku> daftarBuku = new ArrayList<>();
    private final String HEADER[] = {"ISBN", "Judul", "Penulis", "Penerbit","Tahun","Harga"};
    
    public BukuTableModel(List<Buku> daftarBuku){
        this.daftarBuku = daftarBuku;
    }
    
    @Override
    public int getRowCount() {
        return daftarBuku.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buku buku = daftarBuku.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return buku.getIsbn();
            case 1: return buku.getJudul();
            case 2: return buku.getPenulis();
            case 3: return buku.getPenerbit();
            case 4: return buku.getTahun();
            case 5: return buku.getHarga();
            default: return null;
        }
    }
    
}
