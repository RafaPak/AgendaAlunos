package cotuca.unicamp.agendaalunos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class IncluirAluno extends AppCompatActivity {

    EditText txtNome;
    EditText txtTelefone;
    EditText txtEmail;
    Button btnSalvar;
    ArrayList<Aluno> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_aluno);

        lista = new ArrayList<Aluno>();

        txtNome = (EditText)findViewById(R.id.edNome);
        txtTelefone = (EditText)findViewById(R.id.edTelefone);
        txtEmail = (EditText)findViewById(R.id.edEmail);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Aluno al = new Aluno(txtNome.getText().toString(), txtTelefone.getText().toString(), txtEmail.getText().toString());
                    Intent i = new Intent(IncluirAluno.this, MainActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("ALUNO", al);
                    i.putExtras(b);
                    setResult(RESULT_OK, i);
                    finish();
                }
                catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Erro na inserção de dados", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}