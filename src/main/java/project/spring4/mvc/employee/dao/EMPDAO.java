package project.spring4.mvc.employee.dao;

import project.spring4.mvc.employee.model.EMPVO;

import java.util.List;

public interface EMPDAO {
    List<EMPVO> selectEmp();
}