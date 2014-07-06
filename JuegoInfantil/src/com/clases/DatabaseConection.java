package com.clases;



/*		CLASE ASYNCTASK
 * 
 * usaremos esta para poder mostrar el dialogo de progreso mientras enviamos y obtenemos los datos
 * podria hacerse lo mismo sin usar esto pero si el tiempo de respuesta es demasiado lo que podria ocurrir    
 * si la conexion es lenta o el servidor tarda en responder la aplicacion sera inestable.
 * ademas observariamos el mensaje de que la app no responde.     
 */
  /*  
class asynclogin extends AsyncTask< String, String, String > {
	 
	String user,pass;
	private ProgressDialog pDialog;
	String URL_connect="http://hogardinamico.com/acces.php";//ruta en donde estan nuestros archivos	
	Httppostaux post;
	
    protected void onPreExecute() {
    	
    	post=new Httppostaux();
    	
    	//para el progress dialog
        //pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Autenticando....");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();        
    }
 
	protected String doInBackground(String... params) {
		//obtnemos usr y pass
		user=params[0];
		pass=params[1];
	    
		//enviamos y recibimos y analizamos los datos en segundo plano.
		if (loginstatus(user,pass)==true){    		    		
			return "ok"; //login valido
		}else{    		
			return "err"; //login invalido     	          	  
		}        	
	}
	
    protected void onPostExecute(String result) {

       pDialog.dismiss();//ocultamos progess dialog.
       Log.e("onPostExecute=",""+result);           
       if (result.equals("ok")){
    	   Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario Correcto", Toast.LENGTH_SHORT);
    	   toast1.show();    	
        }else{
        	err_login();            
        }
    }
}
    
    //Valida el estado del logueo solamente necesita como parametros el usuario y passw
    public boolean loginstatus(String username ,String password) {
    	
    	int logstatus=-1;
    	 
    	ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();
    	postparameters2send.add(new BasicNameValuePair("usuario",username));
    	postparameters2send.add(new BasicNameValuePair("password",password));
    	
    	//realizamos una peticion y como respuesta obtenes un array JSON
    	JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);
    	
	    SystemClock.sleep(950);

	    //si lo que obtuvimos no es null
	    if (jdata!=null && jdata.length() > 0){

    		JSONObject json_data; //creamos un objeto JSON
			try {
				json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
				 logstatus=json_data.getInt("logstatus");//accedemos al valor 
				 Log.e("loginstatus","logstatus= "+logstatus);//muestro por log que obtuvimos
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		            

			//validamos el valor obtenido
    		 if (logstatus==0){// [{"logstatus":"0"}] 
    			 Log.e("loginstatus ", "invalido");
    			 return false;
    		 }
    		 else{// [{"logstatus":"1"}]
    			 Log.e("loginstatus ", "valido");
    			 return true;
    		 }
	    }
	    else{	
	    	//json obtenido invalido verificar parte WEB.
	    	Log.e("JSON  ", "ERROR");
	    	return false;	    
	    }    	
    }*/