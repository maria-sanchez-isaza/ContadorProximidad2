
package com.example.usuario.contadorsensorguardar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Guardados extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guardados);
        cargar();
    }

    private void cargar() {

        BasedeDatos basedeDatos = new BasedeDatos(this, "DEMODB", null, 1); //creacion del puntero
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from Tarea", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(1);
                    ;
                    arreglo[i] = linea;
                    i++;
                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
            ListView lista = (ListView) findViewById(R.id.Mostrardatos);
            lista.setAdapter(adapter);
        }
    }
}