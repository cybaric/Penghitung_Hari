package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MasaLalu extends AppCompatActivity {
    TextView hrini, tglini, blnini, thnini, hrdulu;
    TextView hasil1, hasil2, hasil3;
    EditText tgldulu, blndulu, thndulu;
    Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_lalu);

        hrini = findViewById(R.id.hariini);
        tglini = findViewById(R.id.tanggalini);
        blnini = findViewById(R.id.blnini);
        thnini = findViewById(R.id.thnini);
        hrdulu = findViewById(R.id.hrdulu);
        tgldulu = findViewById(R.id.tgldulu);
        blndulu = findViewById(R.id.blndulu);
        thndulu = findViewById(R.id.thndulu);
        hasil1 = findViewById(R.id.hasil1);
        hasil2 = findViewById(R.id.hasil2);
        hasil3 = findViewById(R.id.hasil3);

        Calendar ca = Calendar.getInstance(); // --------
        int harini = ca.get(Calendar.DAY_OF_WEEK);
        String dhs = namahari(harini);
        hrini.setText(dhs);
        int tanggalini = ca.get(Calendar.DATE);
        String ou = String.valueOf(tanggalini);
        tglini.setText(ou);
        int bulanini = 1 + ca.get(Calendar.MONTH); // mengambil tanggal dari sistem dan memasukkan
        String oi =  String.valueOf(bulanini);      // ke editeks kolom sekarang
        blnini.setText(oi);
        int Tahunini = ca.get(Calendar.YEAR);
        String iu = String.valueOf(Tahunini);
        thnini.setText(iu);                   // --------

        hitung = findViewById(R.id.hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgldulu.length() == 0 || blndulu.length() == 0 || thndulu.length() == 0) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                } else {
                    String ax = tgldulu.getText().toString();
                    int tgl = Integer.parseInt(ax);
                    String bx = blndulu.getText().toString();
                    int bln = Integer.parseInt(bx);
                    String cx = thndulu.getText().toString();
                    int thn = Integer.parseInt(cx);
                    String ay = tglini.getText().toString();
                    int tgls = Integer.parseInt(ay);
                    String by = blnini.getText().toString();
                    int blns = Integer.parseInt(by);
                    String cy = thnini.getText().toString();
                    int thns = Integer.parseInt(cy);

                    if ( ((tgl == 0) || (bln == 0) || (thn == 0)) ) {
                        Toast.makeText(getApplication(), getString(R.string.toas1), Toast.LENGTH_LONG).show();
                    }
                    int K = Fungsi.fun(bln, thn);
                    if (K < tgl && bln == 2 && tgl == 29) {
                        Toast.makeText(getApplication(), getString(R.string.toas2), Toast.LENGTH_LONG).show();
                    } else if (K < tgl) {
                        Toast.makeText(getApplication(), getString(R.string.toas3), Toast.LENGTH_LONG).show();
                    } else if (thn > thns) {
                        Toast.makeText(getApplication(), getString(R.string.tsml1), Toast.LENGTH_LONG).show();
                    } else if (bln > 12 || bln < 1) {
                        Toast.makeText(getApplication(), getString(R.string.toas5), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln > blns)) {
                        Toast.makeText(getApplication(), getString(R.string.tsml2), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln == blns) && (tgl > tgls)) {
                        Toast.makeText(getApplication(), getString(R.string.tsml3), Toast.LENGTH_LONG).show();
                    } else {
                        int[] x = Fungsi.mult(tgls,blns,thns,tgl,bln,thn);
                        int Ht = x[0];  // hasil hari
                        int Hbl = x[1]; // hasil bln
                        int Htn = x[2]; // hasil tahun
                        String hsila = "   "+ x[2] +" "+ getString(R.string.tahun) +"  "+ x[1] +" "+ getString(R.string.bulan)
                                +"  "+x[0] +" "+ getString(R.string.hari) + "   ";
                        hasil1.setText(hsila);
                        int[] y = Fungsi.total_hari(Ht,Hbl,Htn,bln,thn);
                        String hsilb = "   "+"=" + "  " + y[1] + " " + getString(R.string.minggu) + "  " +y[2] + " "+ getString(R.string.hari)+"   ";
                        hasil2.setText(hsilb);
                        String hsilc = "   "+"=" + "  " + y[0] + " " + getString(R.string.hari)+"   ";
                        hasil3.setText(hsilc);

                        int jhri = y[3]; //hasil konvert ttl bln ke hr
                        String z = st(Ht,jhri);
                        hrdulu.setText(z);
                     }
                }
            }
        });
    }

        public String st (int jj, int jhri){
            Calendar ca = Calendar.getInstance();
            int h = ca.get(Calendar.DAY_OF_WEEK); // mengambil no hari dari sistem
            return b(h,jj+jhri);
        }

    private  String b (int h, int ttl) {
        // mencari nama hari dr ttl (mundur)
        int jml = (h - 1) - (ttl % 7);
        while (jml >= 7) {
            jml = jml % 7;
        }
        if (jml == 0) {
            return getString((R.string.minggu));
        }
        if ((jml == 1) || (jml == -6)) {
            return getString((R.string.senin));
        }
        if ((jml == 2) || (jml == -5)) {
            return getString((R.string.selasa));
        }
        if ((jml == 3) || (jml == -4)) {
            return getString((R.string.rabu));
        }
        if ((jml == 4) || (jml == -3)) {
            return getString((R.string.kamis));
        }
        if ((jml == 5) || (jml == -2)) {
            return getString((R.string.jumat));
        }
        if ((jml == 6) || (jml == -1)) {
            return getString((R.string.sabtu));
        }
        return "error";
    }

    private String namahari(int a){
        if (a == 1){
            return getString(R.string.mingguhr);
        }
        if (a == 2){
            return getString(R.string.senin);
        }
        if (a == 3){
            return getString(R.string.selasa);
        }
        if (a == 4){
            return getString(R.string.rabu);
        }
        if (a == 5){
            return getString(R.string.kamis);
        }
        if (a == 6){
            return getString(R.string.jumat);
        }
        if (a == 7){
            return getString(R.string.sabtu);
        }
        return  "error";
    }

}
