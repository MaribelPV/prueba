package com.example.uguesas2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	int img[]={R.drawable.hconfideitos,R.drawable.hconhuevo,R.drawable.hdoble,
			   R.drawable.hgemelas,R.drawable.hmariajuana,R.drawable.hmediokilo,
			   R.drawable.hnormal,R.drawable.hpollo,R.drawable.hvegetal};
	String tit[]={"HcFideitos","HcHuevo","Hdoble","Hgemelas","HMariaJuana",
			       "H1/2kilo","Hnormal","Hpollo","Hvegetal"};
	int pr[]={15,13,18,21,25,18,12,12,15};
	int pedido[]={0,0,0,0,0,0,0,0,0};
	int tpedido=0;
	int tpagar=0;
	int Indice=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void anterior(View vista){
	TextView ptit=(TextView) findViewById(R.id.textView1);
	ImageView pg=(ImageView) findViewById(R.id.imageView1);
	Indice=Indice-1;
	if (Indice<0)Indice=8;
	ptit.setText(tit[Indice]+" "+pr[Indice]+" "+"Bs.");
	pg.setImageResource(img[Indice]);
	TextView pt=(TextView) findViewById(R.id.textView3);
	pt.setText(pedido[Indice]+"");
	
}
public void siguiente(View vista){
	TextView ptit=(TextView) findViewById(R.id.textView1);
	ImageView pg=(ImageView) findViewById(R.id.imageView1);
	Indice=Indice+1;
	if (Indice>8) Indice=0;
	ptit.setText(tit[Indice]+" "+pr[Indice]+" "+"Bs.");
	pg.setImageResource(img[Indice]);
	TextView pt=(TextView) findViewById(R.id.textView3);
	pt.setText(pedido[Indice]+"");
}
public void comprar(View vista){
	pedido[Indice]=pedido[Indice]+1;
	tpagar=tpagar+pr[Indice];
	tpedido=tpedido+1;
	TextView pt=(TextView) findViewById(R.id.textView3);
	TextView ptp=(TextView) findViewById(R.id.textView7);//total a pagar
	TextView ptped=(TextView) findViewById(R.id.textView5);//numero de pedidos
    pt.setText(pedido[Indice]+"");
    ptp.setText(tpagar+"");
    ptped.setText(tpedido+"");
}
public void devolver(View vista){
	if(pedido[Indice]==0){
		Toast.makeText(this,"No puede devolver", 1).show();
	}
	else{
		pedido[Indice]=pedido[Indice]-1;
		tpagar=tpagar-pr[Indice];
		tpedido=tpedido-1;
		TextView pt=(TextView) findViewById(R.id.textView3);
		TextView ptp=(TextView) findViewById(R.id.textView7);//total a pagar
		TextView ptped=(TextView) findViewById(R.id.textView5);//numero de pedidos
	    pt.setText(pedido[Indice]+"");
	    ptp.setText(tpagar+"");
	    ptped.setText(tpedido+"");
	}
}
public void factura(View vista){
	String fac="DETALLE DE FACTURA";
	for (int i = 0; i < pedido.length; i++) {
		if(pedido[i]!=0){
			int cuanto=pedido[i]*pr[i];
			fac=fac+"\n "+pedido[i]+"==> " +tit[i]+"  Bs."+cuanto;
		}
	}
	fac=fac+"\n "+" TOTAL A PAGAR"+tpagar ;
	Intent detalle=new Intent(this,FacturaActivity.class);
	detalle.putExtra("reporte", fac);
	startActivity(detalle);
	//Toast.makeText(this,fac+"\n"+"TOTAL A PAGAR : "+tpagar, 1).show();
	
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
