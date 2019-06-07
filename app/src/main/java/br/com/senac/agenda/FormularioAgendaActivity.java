package br.com.senac.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.senac.agenda.dao.AgendaDAO;
import br.com.senac.agenda.modelo.Agenda;

public class FormularioAgendaActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_formularioagenda);

        helper = new FormularioHelper(this);
        Intent intent = getIntent();
        Agenda agenda = (Agenda) intent.getSerializableExtra("agenda");

        if (agenda != null){
            helper.afterform(agenda);
            Toast.makeText(FormularioAgendaActivity.this, "Está tudo certo", Toast.LENGTH_LONG).show();

        }

        Button botaosalvar = (Button) findViewById(R.id.botaosalvar);
        botaosalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agenda agenda = helper.getAgenda();
                AgendaDAO dao = new AgendaDAO(FormularioAgendaActivity.this);

                if (agenda.getId() != null){
                    dao.altera(agenda);
                    Toast.makeText(FormularioAgendaActivity.this, "Remedio " + agenda.getAgenda() + " alterado", Toast.LENGTH_SHORT).show();
                }else {
                    dao.inseriragenda(agenda);
                    Toast.makeText(FormularioAgendaActivity.this, "Remedio " + agenda.getAgenda() + " salvo", Toast.LENGTH_SHORT).show();
                }

                dao.close();

            }
        });

        Button botaolista = (Button) findViewById(R.id.botaolista);
        botaolista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linklista = new Intent(FormularioAgendaActivity.this, ListaAgendaACtivity.class);
                startActivity(linklista);
            }
        });
    }
}
