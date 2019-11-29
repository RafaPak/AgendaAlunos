package cotuca.unicamp.agendaalunos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AlunoAdaptador extends ArrayAdapter<Aluno> {

    List<Aluno> listaAluno;
    Context context;

    public AlunoAdaptador(Context c, List<Aluno> lista)
    {
        super(c, 0, lista);
        this.context = c;
        this.listaAluno = lista;
    }

    @Override
    public View getView(int position, View viewAtual, ViewGroup parent) {

        Aluno aluno = listaAluno.get(position);

        if (viewAtual == null) {
            viewAtual = LayoutInflater.from(context).inflate(R.layout.mostra, null);

            TextView txtNome = (TextView) viewAtual.findViewById(R.id.txtNome);
            txtNome.setText(aluno.getNome());
            TextView txtPhone = (TextView) viewAtual.findViewById(R.id.txtTel);
            txtPhone.setText(aluno.getTelefone());
            TextView txtEmail = (TextView) viewAtual.findViewById(R.id.txtEmail);
            txtEmail.setText(aluno.getEmail());
        }
        return viewAtual;
    }
}