/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Model.ChuDe;
import Model.NhaXuatBan;
import Model.TacGia;
import javax.swing.JComboBox;

/**
 *
 * @author Nganp
 */
public class CBOHelper {
    public static <T> T getSelectedItem(JComboBox<T> comboBox) {
       return (T) comboBox.getSelectedItem();
    }

    // Lấy ra ID (giống như ValueMember)
    public static <T> int getSelectedId(JComboBox<T> comboBox) {
        T item = (T) comboBox.getSelectedItem();
        if (item == null) return -1;

        if (item instanceof TacGia) return ((TacGia) item).MaTacgia;
        if (item instanceof ChuDe) return ((ChuDe) item).MaChuDe;
        if (item instanceof NhaXuatBan) return ((NhaXuatBan) item).MaNXB;

        return -1;
    }

    // Chọn lại combo theo ID (giống SelectedValue)
    public static <T> void setSelectedById(JComboBox<T> comboBox, int id) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            T item = comboBox.getItemAt(i);
            if (item instanceof TacGia && ((TacGia) item).MaTacgia == id) {
                comboBox.setSelectedIndex(i); return;
            }
            if (item instanceof ChuDe && ((ChuDe) item).MaChuDe == id) {
                comboBox.setSelectedIndex(i); return;
            }
            if (item instanceof NhaXuatBan && ((NhaXuatBan) item).MaNXB == id) {
                comboBox.setSelectedIndex(i); return;
            }
        }
    }
}
