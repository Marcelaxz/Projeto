package br.mack.ps2.entidades;

public class Empregado {
    private long id_empregado;
    private String nome_emp;
    private String cargo;
    private double salario;

    public Empregado(){ }

    public Empregado(long id_empregado, String nome_emp, String cargo, double salario){
        this.id_empregado = id_empregado;
        this.nome_emp = nome_emp;
        this.cargo = cargo;
        this.salario = salario;
    }

    public long getId_empregado() { return id_empregado; }

    public void setId_empregado(long id_empregado) {
        this.id_empregado = id_empregado;
    }

    public String getNome_emp() {
        return nome_emp;
    }

    public void setNome_emp(String nome_emp) {
        this.nome_emp = nome_emp;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregado " +
                "\n\tID do Empregado: " + id_empregado +
                "\n\tNome do Empregado: " + nome_emp +
                "\n\tCargo: " + cargo +
                "\n\tSalário: " + salario;
    }
}
