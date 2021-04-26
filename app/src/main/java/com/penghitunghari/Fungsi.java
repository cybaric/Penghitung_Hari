package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;

public class Fungsi extends AppCompatActivity {

    public static int[] mult(int tgls, int blns, int thns, int tgl, int bln, int thn) {
        int[] hasil = new int[3];
        if (tgls < tgl) {
            int J = fun(blns - 1, thns);
            int Ht = tgls + J - tgl;
            blns = blns - 1;
            if (blns < bln) {
                thns = thns - 1;
                int Hbl = 12 + blns - bln;
                int Htn = thns - thn;
                hasil[0] = Ht;
                hasil[1] = Hbl;
                hasil[2] = Htn;
                return hasil;
            }
            int Hbl = blns - bln;
            int Htn = thns - thn;
            hasil[0] = Ht;
            hasil[1] = Hbl;
            hasil[2] = Htn;
            return hasil;
        }
        int Ht = tgls - tgl;
        if (blns < bln) {
            thns = thns - 1;
            int Hbl = 12 + blns - bln;
            int Htn = thns - thn;
            hasil[0] = Ht;
            hasil[1] = Hbl;
            hasil[2] = Htn;
            return hasil;
        }
        int Hbl = blns - bln;
        int Htn = thns - thn;
        hasil[0] = Ht;
        hasil[1] = Hbl;
        hasil[2] = Htn;
        return hasil;
    }



    public static int[] total_hari(int Ht, int Hbl, int Htn, int bln, int thn) {
        int[] result = new int[4];
        int jbln = Hbl + 12 * Htn; // mengubah tahun dan bulan, ke jml bulan
        int jhri = Fungsi.ubah(bln, jbln, thn); // mengubah jml bulan ke hari maju
        int s1 = (Ht + jhri); // jumlah hari total
        int mngu = (Ht + jhri) / 7;
        int sisa = (Ht + jhri) % 7;
        result[0] = s1;
        result[1] = mngu;
        result[2] = sisa;
        result[3] = jhri;
        return result;
    }

    public static int ubah(int blns, int j, int thns) {
        // mengubah bulan ke hari (maju)
        int hr = 0;
        while (j > 0) {
            hr = hr + fun(blns, thns);
            blns++;
            j--;
            while (blns > 12) {
                blns = blns - 12;
                thns++;
            }
        }
        return hr;
    }

    public static int ubih (int blns, int j, int thns) {
        // mengubah bulan ke hari mundur
        int hr = 0;
        while (j > 0) {
            hr = hr + fun(blns-1, thns);
            blns--;
            j--;
            while (blns <= 0) {
                blns = blns + 12;
                thns--;
            }
        }
        return hr;
    }

    public static int f(String a) {
        if (a.equals("Sunday") || a.equals("Minggu")) {
            return 1;
        }
        if (a.equals("Monday") || a.equals("Senin")) {
            return 2;
        }
        if (a.equals("Tuesday") || a.equals("Selasa")) {
            return 3;
        }
        if (a.equals("Wednesday") || a.equals("Rabu")) {
            return 4;
        }
        if (a.equals("Thursday") || a.equals("Kamis")) {
            return 5;
        }
        if (a.equals("Friday") || a.equals("Jumat")) {
            return 6;
        }
        if (a.equals("Saturday") || a.equals("Sabtu")) {
            return 7;
        }
        return 0;
    }

    public static int fun ( int a, int b){ // ---------------------
        if (a == 0) {
            return 31;
        }
        if (a == 1) {
            return 31;
        }
        if (a == 2) {
            if (b % 100 == 0) {
                if (b % 400 == 0) {
                    return 29;
                }
                return 28;
            }
            if (b % 4 == 0) {
                return 29;
            }
            return 28;
        }
        if (a == 3) {
            return 31;
        }
        if (a == 4) {
            return 30;
        }
        if (a == 5) {
            return 31;
        }
        if (a == 6) {
            return 30;
        }
        if (a == 7) {
            return 31;
        }
        if (a == 8) {
            return 31;
        }
        if (a == 9) {
            return 30;
        }
        if (a == 10) {
            return 31;
        }
        if (a == 11) {
            return 30;
        }
        if (a == 12) {
            return 31;
        }
        return 0;
    }

}
