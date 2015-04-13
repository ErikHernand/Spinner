package mx.leonel.spinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class principal extends ActionBarActivity {
    // 4.Declarar el spinner y el textView
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //5. Relacionar con el XML
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textview);

        // 6. Se utiliza para usar el array y colocarlo en algun lado
        // Contexto, nombre del array, la forma en que lo vamos a ver
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.meses,android.R.layout.simple_spinner_item);
        // 7. Le decimos al adaptador que funcione de esta forma
        // El recurso que necesitamos usar
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 8. Que se llene
        spinner.setAdapter(adapter);


        // 9. Que fue lo que se selecciono
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // 10. Metodo cuando se selecciona algo
            //Recibe un argumento, una vista
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(parent.getItemAtPosition(position).toString());

            }

            // 11. Metodo cuando no se selecciona algo
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
