package com.example.uguesas2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FacturaActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factura_layout);
        Bundle param=getIntent().getExtras();
        TextView e=(TextView) findViewById(R.id.textView1);
        e.setText(param.getString("reporte"));
    }
	  public void retornar(View vista)
	   {
		   finish();
	   }
	

}
