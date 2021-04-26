package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Interval extends AppCompatActivity {
    TextView hasilsatu, hasildua, harim, ket1, ket2;
    EditText tanggalm, bulanm, tahunm, ihr, img, ibln, ithn;
    Button ngitung1, ngitung2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval);

        hasilsatu = findViewById(R.id.hasilsatu);
        hasildua = findViewById(R.id.hasildua);
        harim = findViewById(R.id.harim);
        tanggalm = findViewById(R.id.tanggalm);
        bulanm = findViewById(R.id.bulanm);
        tahunm = findViewById(R.id.tahunm);
        ihr = findViewById(R.id.ihr);
        img = findViewById(R.id.img);
        ibln = findViewById(R.id.ibln);
        ithn = findViewById(R.id.ithn);
        ngitung1 = findViewById(R.id.ngitung1);
        ngitung2 = findViewById(R.id.ngitung2);
        ket1 = findViewById(R.id.ket1);
        ket2 = findViewById(R.id.ket2);

        ngitung1.setOnClickListener(new View.OnClickListener() { // mundur
            @Override
            public void onClick(View v) {
                if (tanggalm.length() == 0 || bulanm.length() == 0 || tahunm.length() == 0) {
                    Toast.makeText(getApplication(), getText(R.string.isi), Toast.LENGTH_LONG).show();
                } else {
                    String ax = tanggalm.getText().toString();
                    String bx = bulanm.getText().toString();
                    String cx = tahunm.getText().toString();
                    int tgl = Integer.parseInt(ax);
                    int bln = Integer.parseInt(bx);
                    int thn = Integer.parseInt(cx);
                    String ay = ihr.getText().toString();
                    String by = img.getText().toString();
                    String cy = ibln.getText().toString();
                    String dy = ithn.getText().toString();
                    int hari = ceknol(ay);
                    int minggu = ceknol(by);
                    int bulan = ceknol(cy);
                    int tahun = ceknol(dy);

                    if(tahun > 10000){
                        Toast.makeText(getApplication(), getText(R.string.batas), Toast.LENGTH_LONG).show();
                    }else {
                        int d = tgl - 1, selisihbln = bln - 1, selisihthn = thn - 1;
                        int jbln = selisihbln + 12 * selisihthn; // mengubah tahun dan bulan, ke jml bulan
                        int jhri = Fungsi.ubah(1, jbln, 1); // mengubah jml bulan ke hari maju
                        String string = b(2, d + jhri); // mencari nama hari mulai maju dt thn 1
                        harim.setText(string);

                        int ttl = hari + (7 * minggu);
                        int jbl = bulan + 12 * tahun; // mengubah tahun dan bulan, ke jml bulan
                        int jhr = Fungsi.ubih(bln, jbl, thn); // mengubah jml bulan ke hari mundur
                        int h = Fungsi.f(string);
                        String hmdr = a(h, ttl + jhr); // mencari nama hari mundur

                        int j = ttl + jhr;
                        while (j > 0) {
                            while (bln < 2) {
                                bln = bln + 12;
                                thn--;
                            }
                            while (tgl < 2) {
                                tgl = tgl + Fungsi.fun(bln - 1, thn);
                                bln--;
                            }
                            tgl--;
                            j--;
                        }
                        while (bln > 12) {
                            bln = bln - 12;
                            thn++;
                        }

                        String p = String.valueOf(tgl);
                        String q = nmbln(bln);
                        String r = String.valueOf(thn);
                        String s = "   " + hari + "  " + getString(R.string.hari) + "  " + minggu + "  " + getString(R.string.minggu) + "  " + bulan +
                                "  " + getString(R.string.bulan) + "  " + tahun + "  " + getString(R.string.tahun) + "  " + getString(R.string.mundur) + "   ";
                        ket1.setText(s);
                        String hasyl = "   " + "=" + "  " + hmdr + " " + p + " " + q + " " + r + "   ";
                        hasilsatu.setText(hasyl);
                    }
                }
            }
        });

        ngitung2.setOnClickListener(new View.OnClickListener() { // maju
            @Override
            public void onClick(View v) {
                if (tanggalm.length() == 0 || bulanm.length() == 0 || tahunm.length() == 0) {
                    Toast.makeText(getApplication(), getText(R.string.isi), Toast.LENGTH_LONG).show();
                } else {
                    String ax = tanggalm.getText().toString();
                    String bx = bulanm.getText().toString();
                    String cx = tahunm.getText().toString();
                    int tgl = Integer.parseInt(ax);
                    int bln = Integer.parseInt(bx);
                    int thn = Integer.parseInt(cx);
                    String ay = ihr.getText().toString();
                    String by = img.getText().toString();
                    String cy = ibln.getText().toString();
                    String dy = ithn.getText().toString();
                    int hari = ceknol(ay);
                    int minggu = ceknol(by);
                    int bulan = ceknol(cy);
                    int tahun = ceknol(dy);

                    if(tahun > 10000){
                        Toast.makeText(getApplication(), getText(R.string.batas), Toast.LENGTH_LONG).show();
                    }else {
                        int d = tgl - 1, selisihbln = bln - 1, selisihthn = thn - 1;
                        int jbln = selisihbln + 12 * selisihthn; // mengubah tahun dan bulan, ke jml bulan
                        int jhri = Fungsi.ubah(1, jbln, 1); // mengubah jml bulan ke hari maju
                        String string = b(2, d + jhri); // mencari nama hari mulai maju dt thn 1
                        harim.setText(string);

                        int ttl = hari + (7 * minggu) + tgl;
                        int jbl = bulan + 12 * tahun; // mengubah tahun dan bulan, ke jml bulan
                        int jhr = Fungsi.ubah(bln, jbl, thn); // mengubah jml bulan ke hari maju
                        int h = Fungsi.f(string);
                        String hmdr = b(h, ttl + jhr - tgl); // mencari nama hari maju

                        thn = tahun + thn;
                        bln = bln + bulan;
                        while (bln > 12) { // menghitung hasil tahun
                            bln = bln - 12;
                            thn = thn + 1;
                        }
                        while (ttl > Fungsi.fun(bln, thn)) {
                            ttl = ttl - Fungsi.fun(bln, thn);
                            bln++;
                            while (bln > 12) {
                                bln = bln - 12;
                                thn = thn + 1;
                            }
                        }
                        String p = String.valueOf(ttl);
                        String q = nmbln(bln);
                        String r = String.valueOf(thn);
                        String s = "   " + hari + "  " + getString(R.string.hari) + "  " + minggu + "  " + getString(R.string.minggu) + "  " + bulan +
                                "  " + getString(R.string.bulan) + "  " + tahun + "  " + getString(R.string.tahun) + "  " + getString(R.string.maju) + "   ";
                        ket2.setText(s);
                        String hasyl = "   " + "=" + "  " + hmdr + " " + p + " " + q + " " + r + "   ";
                        hasildua.setText(hasyl);
                    }
                }
            }
        });
    }

    public String a(int h, int ttl){
        //mundur
        int jml = (h - 1) - (ttl % 7);
        if (jml == 0){
            return getString(R.string.mingguhr);
        }
        if ((jml == 1) || (jml == -6)){
            return getString(R.string.senin);
        }
        if ((jml == 2) || (jml == -5)){
            return getString(R.string.selasa);
        }
        if ((jml == 3) || (jml == -4)){
            return getString(R.string.rabu);
        }
        if ((jml == 4) || (jml == -3)){
            return getString(R.string.kamis);
        }
        if ((jml == 5) || (jml == -2)){
            return getString(R.string.jumat);
        }
        if ((jml == 6) || (jml == -1)){
            return getString(R.string.sabtu);
        }
        return  "error";
    }

    public String b(int h, int ttl) {
        // mencari nama hari dr ttl (maju)
        int jml = (h - 1) + (ttl % 7);
        while (jml >= 7) {
            jml = jml % 7;
        }
        if (jml == 0) {
            return getString(R.string.mingguhr);
        }
        if ((jml == 1) || (jml == -6)) {
            return getString(R.string.senin);
        }
        if ((jml == 2) || (jml == -5)) {
            return getString(R.string.selasa);
        }
        if ((jml == 3) || (jml == -4)) {
            return getString(R.string.rabu);
        }
        if ((jml == 4) || (jml == -3)) {
            return getString(R.string.kamis);
        }
        if ((jml == 5) || (jml == -2)) {
            return getString(R.string.jumat);
        }
        if ((jml == 6) || (jml == -1)) {
            return getString(R.string.sabtu);
        }
        return "error";
    }

    public int ceknol (String ss){
        if(ss.length() == 0) {
            return 0;
        }
        return Integer.parseInt(ss);
    }

    private String nmbln(int a){
        if (a==1){
            return getString(R.string.jan) ;
        }
        if (a==2){
            return getString(R.string.feb) ;
        }
        if (a==3){
            return getString(R.string.mar) ;
        }
        if (a==4){
            return getString(R.string.apr) ;
        }
        if (a==5){
            return getString(R.string.mei) ;
        }
        if (a==6){
            return  getString(R.string.jun) ;
        }
        if (a==7){
            return getString(R.string.jul) ;
        }
        if (a==8){
            return getString(R.string.agu) ;
        }
        if (a==9){
            return getString(R.string.sep) ;
        }
        if (a==10){
            return getString(R.string.okt) ;
        }
        if (a==11){
            return getString(R.string.nov) ;
        }
        if (a==12){
            return getString(R.string.des) ;
        }
        return "Error";
    }






}
