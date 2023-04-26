package project.spring4.mvc.employee.dao;

import project.spring4.mvc.employee.model.EMPVO;

import java.util.List;

public interface EMPDAO {
    int insertEmp(EMPVO emp);
    List<EMPVO> selectEmp();
    EMPVO selectOneEmp(int empno);
    int updateEmp(EMPVO emp);
    int deleteEmp(int empno);
}