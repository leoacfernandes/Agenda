package br.com.senac.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.agenda.modelo.Agenda;

public class AgendaDAO extends SQLiteOpenHelper {
    public AgendaDAO(Context context) {
        super(context, "bdagenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbagenda(id INTEGER PRIMARY KEY,agenda TEXT NOT NULL,data TEXT,hora TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS tbagenda";
        db.execSQL(sql);
    }

    public void inseriragenda(Agenda agenda) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("agenda", agenda.getAgenda());
        dados.put("data", agenda.getData());
        dados.put("hora", agenda.getHora());

        writableDatabase.insert("tbagenda",null,dados);
    }

    public List<Agenda> listaagenda() {
        String sql = "Select * From tbagenda;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Agenda>  agenda = new ArrayList<Agenda>();

        while (c.moveToNext()){
            Agenda agenda1 = new Agenda();

            agenda1.setId(c.getLong(c.getColumnIndex("id")));
            agenda1.setAgenda(c.getString(c.getColumnIndex("agenda")));
            agenda1.setData(c.getString(c.getColumnIndex("data")));
            agenda1.setHora(c.getString(c.getColumnIndex("hora")));

            agenda.add(agenda1);
        }
        c.close();
        return agenda;
    }
    /*public void deleta (Remedio remedio){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {remedio.getId().toString()};
        db.delete("tbremedio", "id = ?", params);
    }*/
    public void deleta (Agenda agenda){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {agenda.getId().toString()};
        db.delete("tbagenda", "id = ?", params);
    }

    public void altera(Agenda agenda) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = gtdados(agenda);
        String[] params = {agenda.getId().toString()};
        db.update("tbagenda", dados, "id = ?", params);
    }

    private ContentValues gtdados(Agenda agenda) {
        ContentValues dados = new ContentValues();
        dados.put("agenda", agenda.getAgenda());
        dados.put("data", agenda.getData());
        dados.put("hora", agenda.getHora());
        return dados;
    }
}

