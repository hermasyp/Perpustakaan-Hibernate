/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stark.services;

import java.util.List;
import stark.model.Buku;

/**
 *
 * @author yuda14305
 */
public interface BukuServices {

    public void saveBuku(Buku buku);

    public void updateBuku(Buku buku);

    public void deleteBuku(Buku buku);

    public List<Buku> getDaftarBuku();
}
