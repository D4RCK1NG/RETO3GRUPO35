package com.example.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.reto3.Modelo.Adaptador;
import com.example.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.R;

import java.util.ArrayList;

public class FragmentFavoritos extends Fragment {


    View v;
    String TAG = "FragmentFavoritos";
    ListView listaFavoritos;
    Adaptador adaptador;
    int [] imagen = {R.drawable.domicilio, R.drawable.fav, R.drawable.arreglos,R.drawable.nino,R.drawable.chaquetas,R.drawable.chaquetamujer };

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_favoritos, container, false);

        listaFavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(getTablaFavoritos(), getContext());
        listaFavoritos.setAdapter(adaptador);

        return v;
    }
    private ArrayList<Entidad> getTablaFavoritos(){
        ArrayList<Entidad> listaFavoritos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"QuieroMiChaqueta", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos", null);


        while(cursor.moveToNext()){

            listaFavoritos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));

        }


        return listaFavoritos;
    }
}