package com.example.rohitmathew.aspirationcalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
            getSupportActionBar().hide();


        Intent intent = getIntent();

        String jobname = intent.getStringExtra("jobname");
        double length = intent.getDoubleExtra("length",0);
        length = new BigDecimal(length)
                .setScale(3, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double breadth = intent.getDoubleExtra("breadth",0);
        breadth = new BigDecimal(breadth)
                .setScale(3, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        int no_sheets = intent.getIntExtra("nosheet",0);
        int quantity = intent.getIntExtra("quantity",0);
        String name_of_paper = intent.getStringExtra("namepaper");
        double length_pap = intent.getDoubleExtra("length_pap",0);
        double breadth_pap = intent.getDoubleExtra("breadth_pap",0);
        double total_cost_paper = intent.getDoubleExtra("costpap",0);
        String text = intent.getStringExtra("printname");
        double lam_gloss = intent.getDoubleExtra("lamgloss",0);
        lam_gloss = new BigDecimal(lam_gloss)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double lam_matte = intent.getDoubleExtra("lammatte",0);
        lam_matte = new BigDecimal(lam_matte)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double dye_punch = intent.getDoubleExtra("dyepunch",0);
        dye_punch = new BigDecimal(dye_punch)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        dye_punch = new BigDecimal(dye_punch)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double dye_making = intent.getDoubleExtra("dyemaking",0);
        double spot_uv = intent.getDoubleExtra("spotuv",0);
        spot_uv = new BigDecimal(spot_uv)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double gold_foil = intent.getDoubleExtra("goldfoil",0);
        gold_foil = new BigDecimal(gold_foil)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double center_pin = intent.getDoubleExtra("center",0);
        center_pin = new BigDecimal(center_pin)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double saddle_stitch = intent.getDoubleExtra("saddle",0);
        saddle_stitch = new BigDecimal(saddle_stitch)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double wiro = intent.getDoubleExtra("wiro",0);
        wiro = new BigDecimal(wiro)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double hard_bind = intent.getDoubleExtra("hardbind",0);
        hard_bind = new BigDecimal(hard_bind)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double embossing = intent.getDoubleExtra("embossing",0);
        embossing = new BigDecimal(embossing)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double engraving = intent.getDoubleExtra("engraving",0);
        engraving = new BigDecimal(engraving)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double collate = intent.getDoubleExtra("collate",0);
        collate = new BigDecimal(collate)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double cutting = intent.getDoubleExtra("cutting",0);
        cutting = new BigDecimal(cutting)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double cost_per_piece = intent.getDoubleExtra("costpiece",0);
        cost_per_piece = new BigDecimal(cost_per_piece)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double transport = intent.getDoubleExtra("transport",0);
        transport = new BigDecimal(transport)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double margin = intent.getDoubleExtra("margin",0);
        margin = new BigDecimal(margin)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double total = intent.getDoubleExtra("total",0);
        total = new BigDecimal(total)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double total_print_cost = intent.getDoubleExtra("totalprint",0);

        Toast.makeText(display.this, "margin="+margin, Toast.LENGTH_LONG).show();
       /* Toast.makeText(display.this, "length="+length, Toast.LENGTH_LONG).show();
        Toast.makeText(display.this, "breadth="+breadth, Toast.LENGTH_LONG).show();
        Toast.makeText(display.this, "no of sheets="+no_sheets, Toast.LENGTH_LONG).show();
        Toast.makeText(display.this, "length pap="+length_pap, Toast.LENGTH_LONG).show();
        Toast.makeText(display.this, "breadth_pap="+breadth_pap, Toast.LENGTH_LONG).show();*/

        TextView textView = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        TextView textView6 = (TextView)findViewById(R.id.textView6);
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        TextView textView9 = (TextView)findViewById(R.id.textView10);
        TextView textView10 = (TextView)findViewById(R.id.textView11);
        TextView textView11 = (TextView)findViewById(R.id.textView12);
        TextView textView12 = (TextView)findViewById(R.id.textView14);
        TextView textView13 = (TextView)findViewById(R.id.textView16);
        TextView textView14 = (TextView)findViewById(R.id.textView18);
        TextView textView15 = (TextView)findViewById(R.id.textView20);
        TextView textView16 = (TextView)findViewById(R.id.textView22);
        TextView textView17 = (TextView)findViewById(R.id.textView24);
        TextView textView18 = (TextView)findViewById(R.id.textView26);
        TextView textView20 = (TextView)findViewById(R.id.textView28);
        TextView textView21 = (TextView)findViewById(R.id.textView30);
        TextView textView22 = (TextView)findViewById(R.id.textView32);
        TextView textView23 = (TextView)findViewById(R.id.textView34);
        TextView textView24 = (TextView)findViewById(R.id.textView36);
        TextView textView25 = (TextView)findViewById(R.id.textView38);
        TextView textView26 = (TextView)findViewById(R.id.textView40);
        TextView textView27 = (TextView)findViewById(R.id.textView42);
        TextView textView28 = (TextView)findViewById(R.id.textView44);
        TextView textView29 = (TextView)findViewById(R.id.textView46);
        TextView textView30 = (TextView)findViewById(R.id.textView48);

        textView.setText(jobname);
        textView2.setText(Double.toString(length));
        textView3.setText(Double.toString(breadth));
        textView4.setText("No. Sheets:"+Integer.toString(no_sheets));
        textView5.setText("Quantity:"+Integer.toString(quantity));
        textView6.setText(name_of_paper);
        textView7.setText(Double.toString(length_pap));
        textView8.setText(Double.toString(breadth_pap));
        textView9.setText(Double.toString(total_cost_paper));
        textView10.setText(text);
        textView12.setText(Double.toString(lam_gloss));
        textView13.setText(Double.toString(lam_matte));
        textView14.setText(Double.toString(dye_punch));
        textView15.setText(Double.toString(dye_making));
        textView16.setText(Double.toString(spot_uv));
        textView17.setText(Double.toString(gold_foil));
        textView18.setText(Double.toString(center_pin));
        textView20.setText(Double.toString(saddle_stitch));
        textView21.setText(Double.toString(wiro));
        textView22.setText(Double.toString(hard_bind));
        textView23.setText(Double.toString(embossing));
        textView24.setText(Double.toString(engraving));
        textView25.setText(Double.toString(collate));
        textView26.setText(Double.toString(cutting));
        textView27.setText(Double.toString(transport));
        textView28.setText(Double.toString(total));
        textView11.setText(Double.toString(total_print_cost));
        textView29.setText(Double.toString(cost_per_piece));
        textView30.setText(Double.toString(margin)+"%");

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

                try {
                    // image naming and path  to include sd card  appending name you choose for file
                    String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

                    // create bitmap screen capture
                    View v1 = getWindow().getDecorView().getRootView();
                    v1.setDrawingCacheEnabled(true);
                    Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                    v1.setDrawingCacheEnabled(false);

                    File imageFile = new File(mPath);

                    FileOutputStream outputStream = new FileOutputStream(imageFile);
                    int quality = 100;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                    outputStream.flush();
                    outputStream.close();

                    openScreenshot(imageFile);
                } catch (Throwable e) {
                    // Several error may come out with file handling or OOM
                    e.printStackTrace();
                }
            }
        });
    }

    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
    }

}
