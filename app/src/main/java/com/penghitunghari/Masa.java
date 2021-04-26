package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Masa extends AppCompatActivity {
    TextView hrm, hrf, hasilx, hasily, hasilz;
    EditText tglm, blnm, thnm, tglf, blnf, thnf;
    Button itun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);

        hrm = findViewById(R.id.hrm);
        tglm = findViewById(R.id.tglm);
        blnm = findViewById(R.id.blnm);
        thnm = findViewById(R.id.thnm);
        hrf = findViewById(R.id.hrf);
        tglf = findViewById(R.id.tglf);
        blnf = findViewById(R.id.blnf);
        thnf = findViewById(R.id.thnf);
        itun = findViewById(R.id.itun);
        hasilx = findViewById(R.id.hasilx);
        hasily = findViewById(R.id.hasily);
        hasilz = findViewById(R.id.hasilz);

        itun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tglm.length() == 0 || blnm.length() == 0 || thnm.length() == 0 || tglf.length() == 0 || blnf.length() == 0 || thnf.length() == 0) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                } else {
                    String ax = tglm.getText().toString();
                    String bx = blnm.getText().toString();
                    String cx = thnm.getText().toString();
                    int tgl = Integer.parseInt(ax);
                    int bln = Integer.parseInt(bx);
                    int thn = Integer.parseInt(cx);
                    String ay = tglf.getText().toString();
                    String by = blnf.getText().toString();
                    String cy = thnf.getText().toString();
                    int tgls = Integer.parseInt(ay);
                    int blns = Integer.parseInt(by);
                    int thns = Integer.parseInt(cy);
                    int K = Fungsi.fun(bln, thn);
                    int L = Fungsi.fun(blns, thns);

                    if (((tgl == 0) || (bln == 0) || (thn == 0)) || ((tgls == 0) || (blns == 0) || (thns == 0))) {
                        Toast.makeText(getApplication(), getString(R.string.toas1), Toast.LENGTH_LONG).show();
                    }
                    if (K < tgl && bln == 2 && tgl == 29) {
                        Toast.makeText(getApplication(), getString(R.string.toas2) + " "+ "(" + cx + ")", Toast.LENGTH_LONG).show();
                    } else if (L < tgls && blns == 2 && tgls == 29) {
                        Toast.makeText(getApplication(), getString(R.string.toas2) + " "+ "(" + cy + ")", Toast.LENGTH_LONG).show();
                    } else if (K < tgl || L < tgls) {
                        Toast.makeText(getApplication(), getString(R.string.toas3), Toast.LENGTH_LONG).show();
                    } else if (thn > thns) {
                        Toast.makeText(getApplication(), getString(R.string.tsmasa1), Toast.LENGTH_LONG).show();
                    } else if ((tgl == 0 || tgls == 0) || (thn == 0 || thns == 0) || (bln == 0 || blns == 0)) {
                        Toast.makeText(getApplication(), getString(R.string.tsmasa2), Toast.LENGTH_LONG).show();
                    } else if ((bln > 12 || bln < 1) || (blns > 12 || blns < 1)) {
                        Toast.makeText(getApplication(), getString(R.string.toas5), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln > blns)) {
                        Toast.makeText(getApplication(), getString(R.string.tsmasa3), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln == blns) && (tgl > tgls)) {
                        Toast.makeText(getApplication(), getString(R.string.tsmasa4), Toast.LENGTH_LONG).show();
                    } else {
                        int[] x = Fungsi.mult(tgls, blns, thns, tgl, bln, thn);
                        int Ht = x[0];  // hasil hari
                        int Hbl = x[1]; // hasil bln
                        int Htn = x[2]; // hasil tahun
                        String hsila = "   " + x[2] + " " + getString(R.string.tahun) + "  " + x[1] + " " + getString(R.string.bulan)
                                + "  " + x[0] + " " + getString(R.string.hari) + "   ";
                        hasilx.setText(hsila);
                        int[] y = Fungsi.total_hari(Ht, Hbl, Htn, bln, thn);
                        String hsilb = "   " + "=" + "  " + y[1] + " " + getString(R.string.minggu) + "  " + y[2] + " " + getString(R.string.hari) + "   ";
                        hasily.setText(hsilb);
                        String hsilc = "   " + "=" + "  " + y[0] + " " + getString(R.string.hari) + "   ";
                        hasilz.setText(hsilc);

                        int d = tgl - 1, selisihbln = bln - 1, selisihthn = thn - 1;
                        int jbln = selisihbln + 12 * selisihthn; // mengubah tahun dan bulan, ke jml bulan
                        int jhri = Fungsi.ubah(1, jbln, 1); // mengubah jml bulan ke hari maju
                        String string = b(2, d + jhri); // mencari nama hari mulai maju dt thn 1
                        hrm.setText(string);

                        int hhr = Fungsi.f(string);
                        int jj = x[0];
                        int jk = x[1];
                        int jl = x[2];
                        int jbln2 = jk + 12 * jl; // mengubah tahun dan bulan, ke jml bulan
                        int jhri2 = Fungsi.ubah(bln, jbln2, thn); // mengubah jml bulan ke hari maju
                        String sting = b(hhr, jj + jhri2); // mencari nama hari akhir maju
                        hrf.setText(sting);
                    }
                }
            }
        });
    }

    public String b(int h, int ttl) {
        // mencari nama hari dr ttl (maju)
        int jml = (h - 1) + (ttl % 7);
        System.out.println(jml);
        while (jml >= 7) {
            jml = jml % 7;
        }
        if (jml == 0) {
            return getString(R.string.minggu);
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

}
