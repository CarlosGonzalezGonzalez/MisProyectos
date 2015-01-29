package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class PracticaAssets extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_assets);

        TextView texto = (TextView)findViewById(R.id.texto);

        AssetManager assetManager = getAssets();
        InputStream inputStream = null;

        try{
            inputStream = assetManager.open("canciones/la lola.txt");
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

            byte[] bytes = new byte[4096];
            int len = 0;
            while((len = inputStream.read(bytes)) > 0){
                byteStream.write(bytes,0,len);

                String text = new String(byteStream.toByteArray(),"UTF8");
                texto.setText(text);
            }
        } catch (IOException e) {
            texto.setText("No se puede cargar el archivo");
        }finally{
            if(inputStream != null){
                try{
                    inputStream.close();
                } catch (IOException e) {
                    texto.setText("No se puede cargar el archivo");
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practica_assets, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
