package cotuca.unicamp.agendaalunos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fltBtn;
    ListView lstAluno;
    ArrayList<Aluno> lista;
    AlunoAdaptador alAdaptador;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK){
                Bundle b = data.getExtras();
                Aluno resultado = (Aluno)b.get("ALUNO");
                lista.add(resultado);
                alAdaptador.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fltBtn = (FloatingActionButton)findViewById(R.id.fltAB);
        lstAluno = (ListView)findViewById(R.id.lstAlunos);

        lista = new ArrayList<Aluno>();
        alAdaptador = new AlunoAdaptador(this, lista);
        lstAluno.setAdapter(alAdaptador);

        fltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IncluirAluno.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}