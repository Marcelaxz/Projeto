package br.mack.ps2.entidades;

public class Jogo {
    private long id_jogo;
    private String nm_time_a;
    private String nm_time_b;
    private int pont_time_a;
    private int pont_time_b;

    public Jogo(){ }

    public Jogo(long id_jogo, String nm_time_a, String nm_time_b, int pont_time_a, int pont_time_b){
        this.id_jogo = id_jogo;
        this.nm_time_a = nm_time_a;
        this.nm_time_b = nm_time_b;
        this.pont_time_a = pont_time_a;
        this.pont_time_b = pont_time_b;
    }

    public long getIdJogo() {
        return id_jogo;
    }

    public void setIdJogo(long id) {
        this.id_jogo = id;
    }

    public String getNm_timeA() {
        return nm_time_a;
    }

    public void setNm_timeA(String nm_timeA) {
        this.nm_time_a = nm_timeA;
    }

    public String getNm_timeB() {
        return nm_time_b;
    }

    public void setNm_timeB(String nm_timeB) {
        this.nm_time_b = nm_timeB;
    }

    public int getPont_timeA() {
        return pont_time_a;
    }

    public void setPont_timeA(int pont_timeA) {
        this.pont_time_a = pont_timeA;
    }

    public int getPont_timeB() {
        return pont_time_b;
    }

    public void setPont_timeB(int pont_timeB) {
        this.pont_time_b = pont_timeB;
    }

    @Override
    public String toString() {
        return "Jogo " +
                "\n\tID do jogo: " + id_jogo +
                "\n\tNome do primeiro time: " + nm_time_a +
                "\n\tNome do segundo time: " + nm_time_b +
                "\n\tPontuação do primeiro time: " + pont_time_a +
                "\n\tPontuação do segundo time: " + pont_time_b +
                "\n";
    }

}