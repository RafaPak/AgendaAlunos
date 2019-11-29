package cotuca.unicamp.agendaalunos;

import java.io.Serializable;

public class Aluno implements Serializable {

    String nome;
    String telefone;
    String email;

    public Aluno (String n, String t, String e) throws Exception
    {
        this.setNome(n);
        this.setEmail(e);
        this.setTelefone(t);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.equals(null) || nome.equals(""))
            throw new Exception("Nome Inválido!");

        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String tel) throws Exception {
        if (tel.equals(null) || tel.equals("") || !tel.matches("[0-9]+"))
            throw new Exception("Telefone Inválido!");

        this.telefone = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.equals(null) || email.equals("") || !email.contains("@") || !email.contains("."))
            throw new Exception("E-mail Inválido!");

        this.email = email;
    }

    @Override
    public String toString() {
        return "" + this.nome + " | " + this.telefone + " | " + this.email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
