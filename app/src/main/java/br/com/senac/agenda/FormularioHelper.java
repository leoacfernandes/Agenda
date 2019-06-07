package br.com.senac.agenda;

import android.widget.EditText;

import br.com.senac.agenda.modelo.Agenda;

public class FormularioHelper {
    private final EditText campoagenda;
    private final EditText campodata;
    private final EditText campohora;
    private Agenda agenda;
// classe auxiliar

    public FormularioHelper(FormularioAgendaActivity Activity) {

        campoagenda = Activity.findViewById(R.id.nome);
        campodata = Activity.findViewById(R.id.data);
        campohora = Activity.findViewById(R.id.hora);
        agenda = new Agenda();

    }

    public Agenda getAgenda(){

        agenda.setAgenda(campoagenda.getText().toString());
        agenda.setData(campodata.getText().toString());
        agenda.setHora(campohora.getText().toString());

        return agenda;
    }

    public void afterform(Agenda agenda){

        campoagenda.setText(agenda.getAgenda());
        campodata.setText(agenda.getData());
        campohora.setText(agenda.getHora());
        this.agenda = agenda;
    }
}
