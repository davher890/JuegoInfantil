package com.juegoinfantil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.juegoinfantil.R;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.clases.StringImagenes;

public class MainActivity extends Activity{
	
	private static final int NUMERO_IMAGENES = 3;
	int id = 0;
	MainActivity context = null;
	String solucion = "";
	String palabra = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		context = this;
		CreaJuego(id);		
	}

	private void CreaJuego(int i) {
		final LinearLayout layoutBotones = (LinearLayout) findViewById(R.id.botonesLateral);
		ImageView im = (ImageView) findViewById(R.id.imageView1);		
		String[] sArray = getResources().getStringArray(R.array.listaImgs);
			
		palabra = sArray[i];
		im.setImageResource(stringXImg(palabra));
		
		String palShuffle = shuffle(sArray[i]);
		for (int j=0; j<palShuffle.length(); j++){
		
			final char letra = palShuffle.charAt(j);
			ImageButton b1 = new ImageButton(this);
			b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			b1.setImageResource(letraXimg(letra));
			b1.setBackgroundColor(Color.parseColor("#00000000"));
			b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final LinearLayout layoutinferior = (LinearLayout) findViewById(R.id.botonesInferior);
					
					final ImageButton b2 = new ImageButton(context);
					LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
					b2.setLayoutParams(params);
					b2.setImageResource(letraXimg(letra));
					b2.setBackgroundColor(Color.parseColor("#00000000"));
					b2.setTag(String.valueOf(letra));
					//layoutBotones.removeView(b1);//Invisible
					solucion = solucion + letra;
					
					b2.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							layoutinferior.removeView(b2);
							String letra = (String) b2.getTag();
							solucion = solucion.replace(letra, "");							
						}
					});
					layoutinferior.addView(b2);
					if (solucion.equals(palabra)){
						final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
	            		alertDialog.setTitle("Enhorabuena, la palabra es correcta");
	            		alertDialog.setButton(RESULT_OK, "Aceptar", new DialogInterface.OnClickListener() {    				
		    				@Override
		    				public void onClick(DialogInterface dialog, int which) {
		    					// TODO Auto-generated method stub		
		    					alertDialog.cancel();
		    					layoutinferior.removeAllViews();
		    					layoutBotones.removeAllViews();
		    					solucion = "";
		    					id = (id+1)%NUMERO_IMAGENES;
		    					CreaJuego(id);
		    				}
	            		});
	            		alertDialog.show();						
					}
				}
			});
			layoutBotones.addView(b1);
		}
	}
	
	private static String shuffle(String str) {
		 
	    List<String> letters = Arrays.asList(str.split(""));
	    Collections.shuffle(letters);
	 
	    String salida = "";
	    for (String s : letters)
	        salida += s;
	    
	    if (salida.equals(str)){
	    	return shuffle(salida);
	    }
	    return salida;
	 
	}
	
	//Devuelve la imagen correspondiente a la letra pasada como parametro
	private int letraXimg(char letra){
		
		switch (letra) {
		case 'a':
			return R.drawable.letraa;
		case 'b':
			return R.drawable.letrab;
		case 'c':
			return R.drawable.letrac;
		case 'd':
			return R.drawable.letrad;
		case 'e':
			return R.drawable.letrae;
		case 'f':
			return R.drawable.letraf;
		case 'g':
			return R.drawable.letrag;
		case 'h':
			return R.drawable.letrah;
		case 'i':
			return R.drawable.letrai;
		case 'j':
			return R.drawable.letraj;
		case 'k':
			return R.drawable.letrak;
		case 'l':
			return R.drawable.letral;
		case 'm':
			return R.drawable.letram;
		case 'n':
			return R.drawable.letran;			
		case 'o':
			return R.drawable.letrao;
		case 'p':
			return R.drawable.letrap;
		case 'q':
			return R.drawable.letraq;
		case 'r':
			return R.drawable.letrar;
		case 's':
			return R.drawable.letras;
		case 't':
			return R.drawable.letrat;
		case 'u':
			return R.drawable.letrau;
		case 'v':
			return R.drawable.letrav;
		case 'w':
			return R.drawable.letraw;
		case 'x':
			return R.drawable.letrax;
		case 'y':
			return R.drawable.letray;
		case 'z':
			return R.drawable.letraz;
		default:
			return 0;
		}		
	}
	
	//Devuelve la imagen correspondiente al string pasado como parametro
	private int stringXImg(String palabra){
				
		StringImagenes img = StringImagenes.valueOf(palabra);
		
		switch (img) {
		case perro:
			return R.drawable.perro;
		case casa:
			return R.drawable.casa;
		case gato:
			return R.drawable.gato;
		default:
			return 0;
		}		
	}
}
