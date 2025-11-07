package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarioTO {
    private Long id;
    @FutureOrPresent
    @NotNull
    private LocalDate data_consulta;
    @NotNull
    private String hora_consulta;
    @NotNull
    private String especialidade;
    @NotNull
    private String local;

    public CalendarioTO() {

    }

    public CalendarioTO(Long id, LocalDate data_consulta, String hora_consulta, String especialidade, String local) {
        this.id = id;
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.especialidade = especialidade;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDate data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getHora_consulta() {
        return hora_consulta;
    }

        public void setHora_consulta(String hora_consulta) {
        this.hora_consulta = hora_consulta;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}




