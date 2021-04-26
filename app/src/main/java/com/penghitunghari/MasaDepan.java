package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import java.util.Calendar;

public class MasaDepan extends AppCompatActivity {
    TextView hrini,tglini,blnini,thnini,hrdpan;
    TextView hasil1, hasil2, hasil3;
    EditText tgldpan, blndpan, thndpan;
    Button hitung;
    InterstitialAd in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_depan);

        in = new InterstitialAd(MasaDepan.this);
        in.setAdUnitId("ca-app-pub-9560479013051071/2009576314");
        AdRequest minta = new AdRequest.Builder().build();
        in.loadAd(minta);
        in.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded(){
                displayInterstitial();
            }
        });

        hrini = findViewById(R.id.hariini);
        tglini = findViewById(R.id.tanggalini);
        blnini = findViewById(R.id.blnini);
        thnini = findViewById(R.id.thnini);
        hrdpan = findViewById(R.id.hrdpan);
        tgldpan = findViewById(R.id.tgldpan);
        blndpan = findViewById(R.id.blndpan);
        thndpan = findViewById(R.id.thndpan);
        hasil1 = findViewById(R.id.hasila);
        hasil2 = findViewById(R.id.hasilb);
        hasil3 = findViewById(R.id.hasilc);
        hitung = findViewById(R.id.itung);

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

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgldpan.length() == 0 || blndpan.length() == 0 || thndpan.length() == 0) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                } else {
                    String ax = tglini.getText().toString(); // sekarang (diisi sistem)
                    int tgl = Integer.parseInt(ax);
                    String bx = blnini.getText().toString();
                    int bln = Integer.parseInt(bx);
                    String cx = thnini.getText().toString();
                    int thn = Integer.parseInt(cx);
                    String ay = tgldpan.getText().toString();
                    int tgls = Integer.parseInt(ay);
                    String by = blndpan.getText().toString();
                    int blns = Integer.parseInt(by);
                    String cy = thndpan.getText().toString();
                    int thns = Integer.parseInt(cy);

                    if (((tgls == 0) || (blns == 0) || (thns == 0))) {
                        Toast.makeText(getApplication(), getString(R.string.toas1), Toast.LENGTH_LONG).show();
                    }
                    int K = Fungsi.fun(blns, thns);
                    if (K < tgls && blns == 2 && tgls == 29) {
                        Toast.makeText(getApplication(), getString(R.string.toas2), Toast.LENGTH_LONG).show();
                    } else if (K < tgls) {
                        Toast.makeText(getApplication(), getString(R.string.toas3), Toast.LENGTH_LONG).show();
                    } else if (thn > thns) {
                        Toast.makeText(getApplication(), getString(R.string.toas4), Toast.LENGTH_LONG).show();
                    } else if (blns > 12 || blns < 1) {
                        Toast.makeText(getApplication(), getString(R.string.toas5), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln > blns)) {
                        Toast.makeText(getApplication(), getString(R.string.toas6), Toast.LENGTH_LONG).show();
                    } else if ((thn == thns) && (bln == blns) && (tgl > tgls)) {
                        Toast.makeText(getApplication(), getString(R.string.toas7), Toast.LENGTH_LONG).show();
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
                        hrdpan.setText(z);
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

    private String b (int h, int ttl) {
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

    public void  displayInterstitial(){
        if (in.isLoaded()){
            in.show();
        }
    }

}