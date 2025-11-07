package br.com.fiap.bo;

import br.com.fiap.dao.CalendarioDAO;
import br.com.fiap.to.CalendarioTO;


import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarioBO {
    private CalendarioDAO calendarioDAO;

    public ArrayList<CalendarioTO> findAll(){
        calendarioDAO = new CalendarioDAO();
        return calendarioDAO.findAll();
    }

    public CalendarioTO save(CalendarioTO calendario){
        calendarioDAO = new CalendarioDAO();
        return calendarioDAO.save(calendario);
    }

    public boolean delete(Long id){
        calendarioDAO = new CalendarioDAO();
        return calendarioDAO.delete(id);
    }

    public CalendarioTO update(CalendarioTO calendario){
        calendarioDAO = new CalendarioDAO();
        return calendarioDAO.update(calendario);
    }
}
