package com.example.rohitmathew.aspirationcalculator;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinners();
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        data();
    }

    public void spinners() {

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        List<String> categories1 = new ArrayList<String>();
        categories1.add("Select");
        categories1.add("Offset(18X25)");
        categories1.add("Offset(25X36)");
        categories1.add("Offset(20X30)");
        categories1.add("Offset(30X40)");
        categories1.add("Digital(19X13)");
        categories1.add("Large Format");
        categories1.add("Flex Solvent Print");
        categories1.add("Screen Printing");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void data(){

        int up,up1,up2,u1,u2,u3,u4,p1,p2,p3,p4,pup1,pup2,pup,set,pap1,pap2,total_pap;
        double pu1 = 0,pu2 = 0,total_cost_paper = 0, total_print_cost = 0, total_fin=0, total=0;
        double lam_gloss=0,lam_matte=0,dye_punch=0,dye_making=0,spot_uv=0,gold_foil=0,center_pin=0,saddle_stitch=0,wiro=0,hard_bind=0,embossing=0,engraving=0,collate=0,cutting=0;


        EditText editText = (EditText) findViewById(R.id.editText);
        String job_name  = editText.getText().toString();


        EditText editText2 = (EditText) findViewById(R.id.editText2);
        double length = Float.valueOf(editText2.getText().toString());

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        double breadth = Float.valueOf(editText3.getText().toString());

        EditText editText4 = (EditText) findViewById(R.id.editText4);
        int no_sheets = Integer.parseInt( editText4.getText().toString() );


       EditText editText5 = (EditText) findViewById(R.id.editText5);
        String name_of_paper = editText5.getText().toString();


        EditText editText6 = (EditText) findViewById(R.id.editText6);
        double length_pap = Double.valueOf(editText6.getText().toString());


        EditText editText7 = (EditText) findViewById(R.id.editText7);
        double breadth_pap = Double.valueOf(editText7.getText().toString());


        EditText editText8 = (EditText) findViewById(R.id.editText8);
        double cost_pap = Double.valueOf(editText8.getText().toString());

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();

        EditText editText9 = (EditText) findViewById(R.id.editText9);
        int quantity = Integer.parseInt( editText9.getText().toString() );


        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        int selectedId = radioGroup1.getCheckedRadioButtonId();
        RadioButton rad = (RadioButton) findViewById(selectedId);
        if(rad.getId()==R.id.radioButton){
            lam_gloss=0.0055*0.00155*length*breadth*no_sheets*quantity;
            total_fin= total_fin+lam_gloss;
        }


        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.RadioGroup2);
        int selectedId2 = radioGroup2.getCheckedRadioButtonId();
        RadioButton rad2 = (RadioButton) findViewById(selectedId2);
        if(rad2.getId()==R.id.radioButton3){
            lam_matte=0.0055*0.00155*length*breadth*no_sheets*quantity;
            total_fin= total_fin+lam_matte;
        }

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.RadioGroup3);
        int selectedId3 = radioGroup3.getCheckedRadioButtonId();
        RadioButton rad3 = (RadioButton) findViewById(selectedId3);
        if(rad3.getId()==R.id.radioButton5){
            int q=quantity;
            dye_punch=300;
            while(q>1000)
            {
                dye_punch= dye_punch + 300;
                q=q-1000;
            }
            total_fin= total_fin+dye_punch;
        }


        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.RadioGroup4);
        int selectedId4 = radioGroup4.getCheckedRadioButtonId();
        RadioButton rad4 = (RadioButton) findViewById(selectedId4);
        if(rad4.getId()==R.id.radioButton7){
            EditText editText12 = (EditText) findViewById(R.id.editText12);
            dye_making = Float.valueOf(editText12.getText().toString());
            total_fin = total_fin  + dye_making;
        }

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.RadioGroup5);
        int selectedId5 = radioGroup5.getCheckedRadioButtonId();
        RadioButton rad5 = (RadioButton) findViewById(selectedId5);
        if(rad5.getId()==R.id.radioButton9){
            spot_uv=1*0.00155*length*breadth*no_sheets*quantity;
            if(spot_uv<700)
            {
                spot_uv=700;
            }
            total_fin= total_fin+spot_uv;
        }

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.RadioGroup6);
        int selectedId6 = radioGroup6.getCheckedRadioButtonId();
        RadioButton rad6 = (RadioButton) findViewById(selectedId6);
        if(rad6.getId()==R.id.radioButton11){
            gold_foil=1*0.00155*length*breadth*no_sheets*quantity;
            if(gold_foil<300)
            {
                gold_foil=300;
            }
            total_fin= total_fin+gold_foil;
        }

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.RadioGroup7);
        int selectedId7 = radioGroup7.getCheckedRadioButtonId();
        RadioButton rad7 = (RadioButton) findViewById(selectedId7);
        if(rad7.getId()==R.id.radioButton13){
            center_pin=300.0;
            int q=quantity;
            while(q>1000)
            {
                center_pin=center_pin+300;
                q=q-1000;
            }
            total_fin= total_fin+center_pin;
        }

        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.RadioGroup8);
        int selectedId8 = radioGroup8.getCheckedRadioButtonId();
        RadioButton rad8 = (RadioButton) findViewById(selectedId8);
        if(rad8.getId()==R.id.radioButton15){
            saddle_stitch=300.0;
            int q=quantity;
            while(q>1000)
            {
                saddle_stitch=saddle_stitch+300;
                q=q-1000;
            }
            total_fin= total_fin+saddle_stitch;
        }

        RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.RadioGroup9);
        int selectedId9 = radioGroup9.getCheckedRadioButtonId();
        RadioButton rad9 = (RadioButton) findViewById(selectedId9);
        if(rad9.getId()==R.id.radioButton17){
            wiro=quantity*20;
            total_fin=total_fin+wiro;
        }

        RadioGroup radioGroup10 = (RadioGroup) findViewById(R.id.RadioGroup10);
        int selectedId10 = radioGroup10.getCheckedRadioButtonId();
        RadioButton rad10 = (RadioButton) findViewById(selectedId10);
        if(rad10.getId()==R.id.radioButton19){
            hard_bind=quantity*20;
            total_fin=total_fin+hard_bind;
        }

        RadioGroup radioGroup11 = (RadioGroup) findViewById(R.id.RadioGroup11);
        int selectedId11 = radioGroup11.getCheckedRadioButtonId();
        RadioButton rad11 = (RadioButton) findViewById(selectedId11);
        if(rad11.getId()==R.id.radioButton21){
            int q=quantity;
            embossing=300;
            while(q>1000)
            {
                embossing +=  300;
                q=q-1000;
            }
            total_fin= total_fin+embossing;
        }

        RadioGroup radioGroup12 = (RadioGroup) findViewById(R.id.RadioGroup12);
        int selectedId12 = radioGroup12.getCheckedRadioButtonId();
        RadioButton rad12 = (RadioButton) findViewById(selectedId12);
        if(rad12.getId()==R.id.radioButton23){
            engraving=8*0.00155*length*breadth*no_sheets*quantity;
            total_fin= total_fin+engraving;
        }

        RadioGroup radioGroup13 = (RadioGroup) findViewById(R.id.RadioGroup13);
        int selectedId13 = radioGroup13.getCheckedRadioButtonId();
        RadioButton rad13 = (RadioButton) findViewById(selectedId13);
        if(rad13.getId()==R.id.radioButton25){
            collate=250.0;
            int q=quantity;
            while(q>1000)
            {
                collate=collate+250;
                q=q-1000;
            }
            total_fin= total_fin+collate;
        }

        RadioGroup radioGroup14 = (RadioGroup) findViewById(R.id.RadioGroup14);
        int selectedId14 = radioGroup14.getCheckedRadioButtonId();
        RadioButton rad14 = (RadioButton) findViewById(selectedId14);
        if(rad14.getId()==R.id.radioButton27){
            cutting=250.0;
            int q=quantity;
            while(q>1000)
            {
                cutting=cutting+250;
                q=q-1000;
            }
            total_fin= total_fin+cutting ;
        }

        EditText editText10 = (EditText) findViewById(R.id.editText10);
        Double transport = Double.valueOf(editText10.getText().toString());

        EditText editText11 = (EditText) findViewById(R.id.editText11);
        double margin = Double.valueOf(editText11.getText().toString());

        //UP Part

        int l= (int)length_pap/(int)length;
        int b= (int)breadth_pap/(int)breadth;

        int length1 = (int)length * l;
        for(int i=l;i!=0;i--){
            if(i==1){
                length1=length1+12;}
            else{
                length1=length1+6;}
        }

        if(length1>length_pap){
            l=l-1;
            u1=l;
        }
        else{
            u1=l;
        }

        int breadth1 = (int)breadth * b;
        for(int i=b;i!=0;i--){
            if(i==1){
                breadth1=breadth1+12;}
            else{
                breadth1= breadth1+6;}
        }

        if(breadth1 > breadth_pap){
            b=b-1;
            u2=b;
        }
        else{
            u2=b;
        }

        int l2= 0;
        l2 = (int)length_pap/(int)breadth;
        int b2= 0;
        b2 = (int)breadth_pap/(int)length;

        int length2 = (int)breadth * l2;
        for(int i=l2;i!=0;i--){
            if(i==1){
                length2=length2+12;}
            else{
                length2=length2+6;}
        }

        if(length2>length_pap){
            l2=l2-1;
            u3=l2;
        }
        else{
            u3=l2;
        }

        int breadth2 = (int)length * b2;
        for(int i=b2;i!=0;i--){
            if(i==1){
                breadth2 = breadth2 + 12;}
            else{
                breadth2 = breadth2 + 6;}
        }


        if(breadth2 > breadth_pap){
            b2=b2-1;
            u4=b2;
        }
        else{
            u4=b2;
        }

        up1 = u1*u2;

        up2 = u3*u4;

        if(up1>up2)
        {up = up1;}
        else
        {up = up2;}

        //PUP Part

        int l3= (int)pu1/(int)length;
        int b3= (int)pu2/(int)breadth;

        int length3 = (int)length * l3;
        for(int i=l3;i!=0;i--){
            if(i==1){
                length3=length3+12;}
            else{
                length3=length3+6;}
        }


        if(length3>pu1){
            l3=l3-1;
            p1=l;
        }
        else{
            p1=l;
        }



        int breadth3 = (int)breadth * b3;
        for(int i=b3;i!=0;i--){
            if(i==1){
                breadth3=breadth3+12;}
            else{
                breadth3= breadth3+6;}
        }

        if(breadth3 > pu2){
            b3=b3-1;
            p2=b3;
        }
        else{
            p2=b3;
        }


        int l4;
        l4 = (int)length_pap/(int)breadth;
        int b4;
        b4 = (int)breadth_pap/(int)length;

        int length4 = (int)breadth * l4;
        for(int i=l4;i!=0;i--){
            if(i==1){
                length4=length4+12;}
            else{
                length4=length4+6;}
        }

        if(length4>pu1){
            l4=l4-1;
            p3=l4;
        }
        else{
            p3=l4;
        }

        int breadth4 = (int)length * b4;
        for(int i=b4;i!=0;i--){
            if(i==1){
                breadth4 = breadth4 + 12;}
            else{
                breadth4 = breadth4 + 6;}
        }


        if(breadth4 > pu2){
            b4=b4-1;
            p4=b4;
        }
        else{
            p4=b4;
        }
        pup1 = p1*p2;

        pup2 = p3*p4;

        if(pup1>pup2)
        {pup = pup1;}
        else
        {pup = pup2;}

        set = no_sheets / pup;

        pap1 = (no_sheets * quantity)/(up*2);

        pap2 = set * 50;

        total_pap = pap1 + pap2;

        total_cost_paper = total_pap * cost_pap;

        if(text == "Offset(18X25)"){
            pu1 = 18 * 25.4;
            pu2 = 25 * 25.4;
            total_print_cost=3500.00 * set;
            if(quantity>1000)
            {
                int q=quantity-1000;
                while(q>1000)
                {
                    total_print_cost=total_print_cost+800;
                    q=q-1000;
                }
            }
        }
        else if(text == "Offset(25X36)"){
            pu1 = 25 * 25.4;
            pu2 = 36 * 25.4;
            total_print_cost=6000.00 * set;
            if(quantity>1000) {
                int q = quantity - 1000;
                while (q > 1000) {
                    total_print_cost = total_print_cost + 1000;
                    q = q - 1000;
                }
            }
        }
        else if(text == "Offset(20X30)") {
            pu1 = 20 * 25.4;
            pu2 = 30 * 25.4;
            total_print_cost=4250.00 * set;
            if(quantity>1000) {
                int q = quantity - 1000;
                while (q > 1000) {
                    total_print_cost = total_print_cost + 800;
                    q = q - 1000;
                }
            }
        }
        else if(text == "Offset(30X40)"){
            pu1 = 30 * 25.4;
            pu2 = 40 * 25.4;
            total_print_cost=8000.00;
            if(quantity>1000)
            {
                int q=quantity-1000;
                while(q>1000)
                {
                    total_print_cost=total_print_cost+1200.00;
                    q=q-1000;
                }
            }
        }
        else if(text == "Digital(19X13)"){
            pu1 = 19 * 25.4;
            pu2 = 13 * 25.4;
            total_print_cost = 14*quantity;
        }
        else if(text == "Large Format"){
            double total_dim=quantity*length*breadth*0.0000107639*no_sheets;
            total_print_cost=55*total_dim;
        }
        else if(text == "Flex Solvent Print"){
            double total_dim=quantity*length*breadth*0.0000107639*no_sheets;
            total_print_cost=9*total_dim;
        }
        else if(text == "Screen Printing"){
            total_print_cost=quantity*length*breadth*0.00155*0.50*no_sheets;
            if( total_print_cost<250)
            {
                total_print_cost=250;
            }
        }


        total = total_cost_paper + total_print_cost + total_fin + transport;

        double ttl =  total * margin/100;

        total = total + ttl;

        double cost_per_piece=0;
        cost_per_piece=total/quantity;


        Toast.makeText(MainActivity.this, "margin="+margin, Toast.LENGTH_LONG).show();


        Intent intent = new Intent(this, display.class);
        intent.putExtra("jobname",job_name);
        intent.putExtra("length",length);
        intent.putExtra("breadth",breadth);
        intent.putExtra("nosheet",no_sheets);
        intent.putExtra("quantity",quantity);
        intent.putExtra("namepaper",name_of_paper);
        intent.putExtra("length_pap",length_pap);
        intent.putExtra("breadth_pap",breadth_pap);
        intent.putExtra("costpap",total_cost_paper);
        intent.putExtra("printname", text);
        intent.putExtra("lamgloss",lam_gloss);
        intent.putExtra("lammatte",lam_matte);
        intent.putExtra("dyepunch",dye_punch);
        intent.putExtra("dyemaking",dye_making);
        intent.putExtra("spotuv",spot_uv);
        intent.putExtra("goldfoil",gold_foil);
        intent.putExtra("center",center_pin);
        intent.putExtra("saddle",saddle_stitch);
        intent.putExtra("wiro",wiro);
        intent.putExtra("hardbind",hard_bind);
        intent.putExtra("embossing",embossing);
        intent.putExtra("engraving",engraving);
        intent.putExtra("collate",collate);
        intent.putExtra("cutting",cutting);
        intent.putExtra("transport",transport);
        intent.putExtra("total",total);
        intent.putExtra("totalprint",total_print_cost);
        intent.putExtra("margin",margin);
        intent.putExtra("costpiece",cost_per_piece);
        startActivity(intent);

    }


}
