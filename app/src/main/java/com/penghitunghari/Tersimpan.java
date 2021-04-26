package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class Tersimpan extends AppCompatActivity {
    EditText Tgl1, Bln1, Thn1, Tgl2, Bln2, Thn2, Tgl3, Bln3, Thn3;
    TextView Tex1, Hapus1, Simpan1, Judul1, Tex2, Hapus2, Simpan2, Judul2, Tex3, Hapus3, Simpan3, Judul3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tersimpan);

        Judul1 = findViewById(R.id.judul1);
        Tgl1 = findViewById(R.id.tgl1);
        Bln1 = findViewById(R.id.bln1);
        Thn1 = findViewById(R.id.thn1);
        Tex1 = findViewById(R.id.tex1);
        Hapus1 = findViewById(R.id.hapus1);
        Simpan1 = findViewById(R.id.simpan1);

        Judul2 = findViewById(R.id.judul2);
        Tgl2 = findViewById(R.id.tgl2);
        Bln2 = findViewById(R.id.bln2);
        Thn2 = findViewById(R.id.thn2);
        Tex2 = findViewById(R.id.tex2);
        Hapus2 = findViewById(R.id.hapus2);
        Simpan2 = findViewById(R.id.simpan2);

        Judul3 = findViewById(R.id.judul3);
        Tgl3 = findViewById(R.id.tgl3);
        Bln3 = findViewById(R.id.bln3);
        Thn3 = findViewById(R.id.thn3);
        Tex3 = findViewById(R.id.tex3);
        Hapus3 = findViewById(R.id.hapus3);
        Simpan3 = findViewById(R.id.simpan3);

        final SharedPreferences pref = getSharedPreferences("user", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        String judul1 = pref.getString("judul1", ""); // menampilkan
        Judul1.setText(judul1);
        editor.apply();
        String tgl1 = pref.getString("tgl1", "");
        Tgl1.setText(tgl1);
        editor.apply();
        String bln1 = pref.getString("bln1", "");
        Bln1.setText(bln1);
        editor.apply();
        String thn1 = pref.getString("thn1", "");
        Thn1.setText(thn1);
        editor.apply();

        String judul2 = pref.getString("judul2", ""); // menampilkan
        Judul2.setText(judul2);
        editor.apply();
        String tgl2 = pref.getString("tgl2", "");
        Tgl2.setText(tgl2);
        editor.apply();
        String bln2 = pref.getString("bln2", "");
        Bln2.setText(bln2);
        editor.apply();
        String thn2 = pref.getString("thn2", "");
        Thn2.setText(thn2);
        editor.apply();

        String judul3 = pref.getString("judul3", ""); // menampilkan
        Judul3.setText(judul3);
        editor.apply();
        String tgl3 = pref.getString("tgl3", "");
        Tgl3.setText(tgl3);
        editor.apply();
        String bln3 = pref.getString("bln3", "");
        Bln3.setText(bln3);
        editor.apply();
        String thn3 = pref.getString("thn3", "");
        Thn3.setText(thn3);
        editor.apply();

        Calendar ca = Calendar.getInstance();
        final int tgl = ca.get(Calendar.DATE);
        final int bln = 1 + ca.get(Calendar.MONTH); // mengambil tanggal dari sistem
        final int thn = ca.get(Calendar.YEAR);

        if ((judul1.length()==0) && (judul2.length()==0) && (judul3.length()==0) ) {
            Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
        }
        else {
            if (Tgl1.length()>0) {
                tgl1 = Tgl1.getText().toString();
                int Tgl1 = ceknol(tgl1);
                bln1 = Bln1.getText().toString();
                int Bln1 = ceknol(bln1);
                thn1 = Thn1.getText().toString();
                int Thn1 = ceknol(thn1);
                if((Thn1<=thn)&&(Bln1<=bln)&&(Tgl1<tgl)){
                    Tex1.setText(R.string.lewat);
                }
                int K = Fungsi.fun(Bln1, Thn1);
                if (K < Tgl1 && Bln1 == 2 && Tgl1 == 29) {
                    Tex1.setText(R.string.toas2);
                } else if (K < Tgl1) {
                    Tex1.setText(R.string.toas3);
                } else if (thn > Thn1) {
                    Tex1.setText(R.string.toas4);
                } else if (Bln1 > 12 || Bln1 <= 0 || (Tgl1<=0)) {
                    Tex1.setText(R.string.toas5);
                } else if ((thn == Thn1) && (bln > Bln1)) {
                    Tex1.setText(R.string.toas6);
                } else if ((thn == Thn1) && (bln == Bln1) && (tgl > Tgl1)) {
                    Tex1.setText(R.string.toas7);
                }
                else {
                    int[] x1 = Fungsi.mult(Tgl1, Bln1, Thn1, tgl, bln, thn);
                    int Ht1 = x1[0];  // hasil hari
                    int Hbl1 = x1[1]; // hasil bln
                    int Htn1 = x1[2]; // hasil tahun
                    int[] y1 = Fungsi.total_hari(Ht1, Hbl1, Htn1, bln, thn);
                    String hsilc1 = "   " + "=" + "  " + y1[0] + " " + getString(R.string.hari) + "   ";
                    Tex1.setText(hsilc1);
                    Hapus1.setText(R.string.hapus);
                }
            }
            if (Tgl2.length()>0) {
                tgl2 = Tgl2.getText().toString();
                int Tgl2 = ceknol(tgl2);
                bln2 = Bln2.getText().toString();
                int Bln2 = ceknol(bln2);
                thn2 = Thn2.getText().toString();
                int Thn2 = ceknol(thn2);
                if((Thn2<=thn)&&(Bln2<=bln)&&(Tgl2<tgl)){
                    Tex2.setText(R.string.lewat);
                }
                int K = Fungsi.fun(Bln2, Thn2);
                if (K < Tgl2 && Bln2 == 2 && Tgl2 == 29) {
                    Tex2.setText(R.string.toas2);
                } else if (K < Tgl2) {
                    Tex2.setText(R.string.toas3);
                } else if (thn > Thn2) {
                    Tex2.setText(R.string.toas4);
                } else if (Bln2 > 12 || Bln2 <= 0 || (Tgl2<=0)) {
                    Tex2.setText(R.string.toas5);
                } else if ((thn == Thn2) && (bln > Bln2)) {
                    Tex2.setText(R.string.toas6);
                } else if ((thn == Thn2) && (bln == Bln2) && (tgl > Tgl2)) {
                    Tex2.setText(R.string.toas7);
                }
                else {
                    int[] x2 = Fungsi.mult(Tgl2, Bln2, Thn2, tgl, bln, thn);
                    int Ht2 = x2[0];  // hasil hari
                    int Hbl2 = x2[1]; // hasil bln
                    int Htn2 = x2[2]; // hasil tahun
                    int[] y2 = Fungsi.total_hari(Ht2, Hbl2, Htn2, bln, thn);
                    String hsilc2 = "   " + "=" + "  " + y2[0] + " " + getString(R.string.hari) + "   ";
                    Tex2.setText(hsilc2);
                    Hapus2.setText(R.string.hapus);
                }
            }
            if (Tgl3.length()>0) {
                tgl3 = Tgl3.getText().toString();
                int Tgl3 = ceknol(tgl3);
                bln3 = Bln3.getText().toString();
                int Bln3 = ceknol(bln3);
                thn3 = Thn3.getText().toString();
                int Thn3 = ceknol(thn3);
                if((Thn3<=thn)&&(Bln3<=bln)&&(Tgl3<tgl)){
                    Tex3.setText(R.string.lewat);
                }
                int K = Fungsi.fun(Bln3, Thn3);
                if (K < Tgl3 && Bln3 == 2 && Tgl3 == 29) {
                    Tex3.setText(R.string.toas2);
                } else if (K < Tgl3) {
                    Tex3.setText(R.string.toas3);
                } else if (thn > Thn3) {
                    Tex3.setText(R.string.toas4);
                } else if (Bln3 > 12 || Bln3 <= 0 || (Tgl3<=0)) {
                    Tex3.setText(R.string.toas5);
                } else if ((thn == Thn3) && (bln > Bln3)) {
                    Tex3.setText(R.string.toas6);
                } else if ((thn == Thn3) && (bln == Bln3) && (tgl > Tgl3)) {
                    Tex3.setText(R.string.toas7);
                }
                else {
                    int[] x3 = Fungsi.mult(Tgl3, Bln3, Thn3, tgl, bln, thn);
                    int Ht3 = x3[0];  // hasil hari
                    int Hbl3 = x3[1]; // hasil bln
                    int Htn3 = x3[2]; // hasil tahun
                    int[] y3 = Fungsi.total_hari(Ht3, Hbl3, Htn3, bln, thn);
                    String hsilc3 = "   " + "=" + "  " + y3[0] + " " + getString(R.string.hari) + "   ";
                    Tex3.setText(hsilc3);
                    Hapus3.setText(R.string.hapus);
                }
            }
        }

        Simpan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Judul1.length()==0) || (Tgl1.length()==0) || (Bln1.length()==0) || (Thn1.length()==0)) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                }
                else {
                    String judul1 = String.valueOf(Judul1.getText()); // menyimpan
                    editor.putString("judul1", judul1);
                    editor.apply();
                    String tgl1 = String.valueOf(Tgl1.getText());
                    editor.putString("tgl1", tgl1);
                    editor.apply();
                    String bln1 = String.valueOf(Bln1.getText());
                    editor.putString("bln1", bln1);
                    editor.apply();
                    String thn1 = String.valueOf(Thn1.getText());
                    editor.putString("thn1", thn1);
                    editor.apply();

                    judul1 = pref.getString("judul1", ""); // menampilkan
                    Judul1.setText(judul1);
                    editor.apply();
                    tgl1 = pref.getString("tgl1", "");
                    Tgl1.setText(tgl1);
                    editor.apply();
                    bln1 = pref.getString("bln1", "");
                    Bln1.setText(bln1);
                    editor.apply();
                    thn1 = pref.getString("thn1", "");
                    Thn1.setText(thn1);
                    editor.apply();

                    tgl1 = Tgl1.getText().toString();
                    int Tgl1 = ceknol(tgl1);
                    bln1 = Bln1.getText().toString();
                    int Bln1 = ceknol(bln1);
                    thn1 = Thn1.getText().toString();
                    int Thn1 = ceknol(thn1);
                    if((Thn1<=thn)&&(Bln1<=bln)&&(Tgl1<tgl)){
                        Tex1.setText(R.string.lewat);
                    }
                    int K = Fungsi.fun(Bln1, Thn1);
                    if (K < Tgl1 && Bln1 == 2 && Tgl1 == 29) {
                        Tex1.setText(R.string.toas2);
                    } else if (K < Tgl1) {
                        Tex1.setText(R.string.toas3);
                    } else if (thn > Thn1) {
                        Tex1.setText(R.string.toas4);
                    } else if (Bln1 > 12 || Bln1 <= 0 || (Tgl1<=0)) {
                        Tex1.setText(R.string.toas5);
                    } else if ((thn == Thn1) && (bln > Bln1)) {
                        Tex1.setText(R.string.toas6);
                    } else if ((thn == Thn1) && (bln == Bln1) && (tgl > Tgl1)) {
                        Tex1.setText(R.string.toas7);
                    }
                    else {
                        int[] x1 = Fungsi.mult(Tgl1, Bln1, Thn1, tgl, bln, thn);
                        int Ht1 = x1[0];  // hasil hari
                        int Hbl1 = x1[1]; // hasil bln
                        int Htn1 = x1[2]; // hasil tahun
                        int[] y1 = Fungsi.total_hari(Ht1, Hbl1, Htn1, bln, thn);
                        String hsilc1 = "   " + "=" + "  " + y1[0] + " " + getString(R.string.hari) + "   ";
                        Tex1.setText(hsilc1);
                        Hapus1.setText(R.string.hapus);
                        Toast.makeText(getApplication(), getText(R.string.tersimpan), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Simpan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Judul2.length()==0) || (Tgl2.length()==0) || (Bln2.length()==0) || (Thn2.length()==0)) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                }
                else {
                    String judul2 = String.valueOf(Judul2.getText()); // menyimpan
                    editor.putString("judul2", judul2);
                    editor.apply();
                    String tgl2 = String.valueOf(Tgl2.getText());
                    editor.putString("tgl2", tgl2);
                    editor.apply();
                    String bln2 = String.valueOf(Bln2.getText());
                    editor.putString("bln2", bln2);
                    editor.apply();
                    String thn2 = String.valueOf(Thn2.getText());
                    editor.putString("thn2", thn2);
                    editor.apply();

                    judul2 = pref.getString("judul2", ""); // menampilkan
                    Judul2.setText(judul2);
                    editor.apply();
                    tgl2 = pref.getString("tgl2", "");
                    Tgl2.setText(tgl2);
                    editor.apply();
                    bln2 = pref.getString("bln2", "");
                    Bln2.setText(bln2);
                    editor.apply();
                    thn2 = pref.getString("thn2", "");
                    Thn2.setText(thn2);
                    editor.apply();

                    tgl2 = Tgl2.getText().toString();
                    int Tgl2 = ceknol(tgl2);
                    bln2 = Bln2.getText().toString();
                    int Bln2 = ceknol(bln2);
                    thn2 = Thn2.getText().toString();
                    int Thn2 = ceknol(thn2);
                    if((Thn2<=thn)&&(Bln2<=bln)&&(Tgl2<tgl)) {
                        Tex2.setText(R.string.lewat);
                    }
                        int K = Fungsi.fun(Bln2, Thn2);
                        if (K < Tgl2 && Bln2 == 2 && Tgl2 == 29) {
                            Tex2.setText(R.string.toas2);
                        } else if (K < Tgl2) {
                            Tex2.setText(R.string.toas3);
                        } else if (thn > Thn2) {
                            Tex2.setText(R.string.toas4);
                        } else if (Bln2 > 12 || Bln2 <= 0 || (Tgl2<=0)) {
                            Tex2.setText(R.string.toas5);
                        } else if ((thn == Thn2) && (bln > Bln2)) {
                            Tex2.setText(R.string.toas6);
                        } else if ((thn == Thn2) && (bln == Bln2) && (tgl > Tgl2)) {
                            Tex2.setText(R.string.toas7);
                        }
                    else {
                        int[] x2 = Fungsi.mult(Tgl2, Bln2, Thn2, tgl, bln, thn);
                        int Ht2 = x2[0];  // hasil hari
                        int Hbl2 = x2[1]; // hasil bln
                        int Htn2 = x2[2]; // hasil tahun
                        int[] y2 = Fungsi.total_hari(Ht2, Hbl2, Htn2, bln, thn);
                        String hsilc2 = "   " + "=" + "  " + y2[0] + " " + getString(R.string.hari) + "   ";
                        Tex2.setText(hsilc2);
                        Hapus2.setText(R.string.hapus);
                        Toast.makeText(getApplication(), getText(R.string.tersimpan), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Simpan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Judul3.length()==0) || (Tgl3.length()==0) || (Bln3.length()==0) || (Thn3.length()==0)) {
                    Toast.makeText(getApplication(), getText(R.string.isikosong), Toast.LENGTH_LONG).show();
                }
                else {
                    String judul3 = String.valueOf(Judul3.getText()); // menyimpan
                    editor.putString("judul3", judul3);
                    editor.apply();
                    String tgl3 = String.valueOf(Tgl3.getText());
                    editor.putString("tgl3", tgl3);
                    editor.apply();
                    String bln3 = String.valueOf(Bln3.getText());
                    editor.putString("bln3", bln3);
                    editor.apply();
                    String thn3 = String.valueOf(Thn3.getText());
                    editor.putString("thn3", thn3);
                    editor.apply();

                    judul3 = pref.getString("judul3", ""); // menampilkan
                    Judul3.setText(judul3);
                    editor.apply();
                    tgl3 = pref.getString("tgl3", "");
                    Tgl3.setText(tgl3);
                    editor.apply();
                    bln3 = pref.getString("bln3", "");
                    Bln3.setText(bln3);
                    editor.apply();
                    thn3 = pref.getString("thn3", "");
                    Thn3.setText(thn3);
                    editor.apply();

                    tgl3 = Tgl3.getText().toString();
                    int Tgl3 = ceknol(tgl3);
                    bln3 = Bln3.getText().toString();
                    int Bln3 = ceknol(bln3);
                    thn3 = Thn3.getText().toString();
                    int Thn3 = ceknol(thn3);
                    if((Thn3<=thn)&&(Bln3<=bln)&&(Tgl3<tgl)){
                        Tex3.setText(R.string.lewat);
                    }
                    int K = Fungsi.fun(Bln3, Thn3);
                    if (K < Tgl3 && Bln3 == 2 && Tgl3 == 29) {
                        Tex3.setText(R.string.toas2);
                    } else if (K < Tgl3) {
                        Tex3.setText(R.string.toas3);
                    } else if (thn > Thn3) {
                        Tex3.setText(R.string.toas4);
                    } else if (Bln3 > 12 || Bln3 <= 0 || (Tgl3<=0)) {
                        Tex3.setText(R.string.toas5);
                    } else if ((thn == Thn3) && (bln > Bln3)) {
                        Tex3.setText(R.string.toas6);
                    } else if ((thn == Thn3) && (bln == Bln3) && (tgl > Tgl3)) {
                        Tex3.setText(R.string.toas7);
                    }
                    else {
                        int[] x3 = Fungsi.mult(Tgl3, Bln3, Thn3, tgl, bln, thn);
                        int Ht3 = x3[0];  // hasil hari
                        int Hbl3 = x3[1]; // hasil bln
                        int Htn3 = x3[2]; // hasil tahun
                        int[] y3 = Fungsi.total_hari(Ht3, Hbl3, Htn3, bln, thn);
                        String hsilc3 = "   " + "=" + "  " + y3[0] + " " + getString(R.string.hari) + "   ";
                        Tex3.setText(hsilc3);
                        Hapus3.setText(R.string.hapus);
                        Toast.makeText(getApplication(), getText(R.string.tersimpan), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Hapus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("judul1");
                Judul1.setText("");
                editor.apply();
                editor.remove("tgl1");
                Tgl1.setText("");
                editor.apply();
                editor.remove("bln1");
                Bln1.setText("");
                editor.apply();
                editor.remove("thn1");
                Thn1.setText("");
                editor.apply();
                Tex1.setText("");
                Hapus1.setText("");
                Toast.makeText(getApplication(), getText(R.string.dihapus), Toast.LENGTH_LONG).show();
            }
        });

        Hapus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("judul2");
                Judul2.setText("");
                editor.apply();
                editor.remove("tgl2");
                Tgl2.setText("");
                editor.apply();
                editor.remove("bln2");
                Bln2.setText("");
                editor.apply();
                editor.remove("thn2");
                Thn2.setText("");
                editor.apply();
                Tex2.setText("");
                Hapus2.setText("");
                Toast.makeText(getApplication(), getText(R.string.dihapus), Toast.LENGTH_LONG).show();
            }
        });

        Hapus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("judul3");
                Judul3.setText("");
                editor.apply();
                editor.remove("tgl3");
                Tgl3.setText("");
                editor.apply();
                editor.remove("bln3");
                Bln3.setText("");
                editor.apply();
                editor.remove("thn3");
                Thn3.setText("");
                editor.apply();
                Tex3.setText("");
                Hapus3.setText("");
                Toast.makeText(getApplication(), getText(R.string.dihapus), Toast.LENGTH_LONG).show();
            }
        });
    }

    public int ceknol (String ss){
        if(ss.length() == 0) {
            return 0;
        }
        return Integer.parseInt(ss);
    }
}