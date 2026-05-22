package model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.time.format.DateTimeFormatter;

public abstract class Transacao {

    private String descricao;
    private double valor;
    private LocalDateTime dataHora;
    private UUID id;

    public Transacao (String descricao, double valor){

        this.descricao = descricao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public UUID getId(){
        return id;

    }

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    @Override
    public String toString(){

        return "ID da transação: " + id +
                "\nDescrição: " + descricao +
                "\nValor: " + valor +
                "\nData e Hora da transação: " + dataHora.format(formatter);
    }
}
