package com.adarsh.crimerecord.Police;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.crimerecord.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FirActivity extends AppCompatActivity {
    private ImageView imgview;
    private TextView fir;
    private TextView section;
    private TextView districtTitle;
    private TextView districtTxtview;
    private TextView pstitle;
    private TextView pstextview;
    private TextView firnotitle;
    private TextView firnotextview;
    private TextView yeartitle;
    private TextView dateandtime;
    private TextView firdatetextview;
    private TextView firTimeEdt;
    private TextView yeartextview;
    private TableLayout table;
    private TextView actstextview;
    private TextView sectionstextview;
    private TextView occurence;
    private TextView day;
    private TextView dayEdt;
    private TextView datefrom;
    private TextView dateFromEdt;
    private TextView dateto;
    private TextView dateToEdt;
    private TextView timefrom;
    private TextView timeFromEdt;
    private TextView timeto;
    private TextView timeToEdt;
    private TextView gdr;
    private TextView diaryNumber;
    private TextView diaryNumberEdt;
    private TextView diaryTime;
    private TextView diaryTimeEdt;
    private TextView typeofinfo;
    private TextView typeofinfoEdit;
    private TextView placeofoccurence;
    private TextView distance;
    private TextView distanceEdt;
    private TextView beat;
    private TextView beatEdt;
    private TextView address;
    private TextView addressEdt;
    private RelativeLayout relativeLayout;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir);
        initView();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("firpref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

   //     sharedPreferences.getString("complaintdetails",null);

        SharedPreferences sp=getApplicationContext().getSharedPreferences("police",MODE_PRIVATE);
//        sp.getInt("policestation_id",0);
//
//        sp.getString("email",null);
//        sp.getString("password",null);
//        sp.getString("code",null);

        districtTxtview.setText(sp.getString("district",null));
        pstextview.setText(sp.getString("name",null));
        firnotextview.setText(sharedPreferences.getString("firno",null));
        yeartextview.setText("2020");
        firdatetextview.setText(sharedPreferences.getString("firdate",null));
        firTimeEdt.setText(sharedPreferences.getString("firtime",null));
        actstextview.setText(sharedPreferences.getString("ipcAct",null));
        sectionstextview.setText(sharedPreferences.getString("ipcsession",null));
        dayEdt.setText(sharedPreferences.getString("day",null));
        dateFromEdt.setText(sharedPreferences.getString("datefrom",null));
        dateToEdt.setText(sharedPreferences.getString("dateto",null));
        timeFromEdt.setText(sharedPreferences.getString("timefrom",null));
        timeToEdt.setText(sharedPreferences.getString("timeto",null));
        diaryNumberEdt.setText(sharedPreferences.getString("diaryentry",null));
        diaryTimeEdt.setText( sharedPreferences.getString("diaryentrytime",null));
        typeofinfoEdit.setText(sharedPreferences.getString("type",null));
        distanceEdt.setText(sharedPreferences.getString("distance",null));
        beatEdt.setText(sharedPreferences.getString("beatno",null));
        addressEdt.setText(sharedPreferences.getString("address",null));

    }

    private void initView() {
        relativeLayout=findViewById(R.id.relative);
        imgview = findViewById(R.id.imgview);
        fir = findViewById(R.id.fir);
        section = findViewById(R.id.section);
        districtTitle = findViewById(R.id.district_title);
        districtTxtview = findViewById(R.id.district_txtview);
        pstitle = findViewById(R.id.pstitle);
        pstextview = findViewById(R.id.pstextview);
        firnotitle = findViewById(R.id.firnotitle);
        firnotextview = findViewById(R.id.firnotextview);
        yeartitle = findViewById(R.id.yeartitle);
        dateandtime = findViewById(R.id.dateandtime);
        firdatetextview = findViewById(R.id.firdatetextview);
        firTimeEdt = findViewById(R.id.fir_time_edt);
        yeartextview = findViewById(R.id.yeartextview);
        table = findViewById(R.id.table);
        actstextview = findViewById(R.id.actstextview);
        sectionstextview = findViewById(R.id.sectionstextview);
        occurence = findViewById(R.id.occurence);
        day = findViewById(R.id.day);
        dayEdt = findViewById(R.id.day_edt);
        datefrom = findViewById(R.id.datefrom);
        dateFromEdt = findViewById(R.id.date_from_edt);
        dateto = findViewById(R.id.dateto);
        dateToEdt = findViewById(R.id.date_to_edt);
        timefrom = findViewById(R.id.timefrom);
        timeFromEdt = findViewById(R.id.time_from_edt);
        timeto = findViewById(R.id.timeto);
        timeToEdt = findViewById(R.id.time_to_edt);
        gdr = findViewById(R.id.gdr);
        diaryNumber = findViewById(R.id.diary_number);
        diaryNumberEdt = findViewById(R.id.diary_number_edt);
        diaryTime = findViewById(R.id.diary_time);
        diaryTimeEdt = findViewById(R.id.diary_time_edt);
        typeofinfo = findViewById(R.id.typeofinfo);
        typeofinfoEdit = findViewById(R.id.typeofinfo_edit);
        placeofoccurence = findViewById(R.id.placeofoccurence);
        distance = findViewById(R.id.distance);
        distanceEdt = findViewById(R.id.distance_edt);
        beat = findViewById(R.id.beat);
        beatEdt = findViewById(R.id.beat_edt);
        address = findViewById(R.id.address);
        addressEdt = findViewById(R.id.address_edt);
    }

    public void savePdf(View view) {
        bitmap = loadBitmapFromView(relativeLayout, relativeLayout.getWidth(), relativeLayout.getHeight());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            createPdf();
        }
    }
    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);

        return b;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPdf() {

        try {


            android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument();
            android.graphics.pdf.PdfDocument.PageInfo pageInfo = new android.graphics.pdf.PdfDocument.PageInfo.Builder(relativeLayout.getWidth(), relativeLayout.getHeight(),1).create();
            android.graphics.pdf.PdfDocument.Page page = document.startPage(pageInfo);

            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();
            canvas.drawPaint(paint);
            relativeLayout.draw(canvas);
            document.finishPage(page);
            String targetPdf = "/sdcard/pdffromlayout.pdf";
            File filePath;
            filePath = new File(targetPdf);
            try {
                document.writeTo(new FileOutputStream(filePath));

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
            }

            // close the document
            document.close();
            Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show();
            openGeneratedPDF();


        }catch (Exception e){

            // Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    private void openGeneratedPDF() {
        File file = new File("/sdcard/pdffromlayout.pdf");
        if (file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(FirActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
            }
        }
    }
}
