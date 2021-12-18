package com.example.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.reto3.Modelo.Adaptador;
import com.example.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.R;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class FragmentProductos extends Fragment {

    View v;
    Cursor cursor;
    ListView listaProductos;
    Adaptador adaptador;
    int [] imagen = {R.drawable.chaquetamujer, R.drawable.chaquetas, R.drawable.nino };
    String TAG = "FragmentProductos";

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_productos, container, false);
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(getTablaProductos(), getActivity());

        listaProductos.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }
    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(this.getActivity(),"QuieroMiChaqueta", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();

        Cursor cursor = db_leer.rawQuery("SELECT * FROM productos", null);


        while(cursor.moveToNext()){

            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));

        }

        return listaProductos;
    }

    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.chaquetamujer, "Dama", "encuentra todo lo relacionado con chaquetas para dama"));
        listaItems.add(new Entidad(R.drawable.chaquetas, "Caballero", "encuentra todo lo relaconado co chaquetas para caballero"));
        listaItems.add(new Entidad(R.drawable.nino, "Niño", "encuentra toda clase de cahquetas para niño"));

        return listaItems;
    }
}