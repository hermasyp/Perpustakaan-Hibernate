/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stark.dao;

import java.util.List;
import stark.model.Buku;

public interface BukuDao {

    public void saveBuku(Buku buku);

    public List<Buku> getDaftarBuku();

    public void updateBuku(Buku buku);

    public void deleteBuku(Buku buku);
}
