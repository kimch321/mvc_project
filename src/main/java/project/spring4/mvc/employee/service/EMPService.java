package project.spring4.mvc.employee.service;

import project.spring4.mvc.employee.model.EMPVO;

import java.util.List;

public interface EMPService {
    boolean newEmp(EMPVO emp);
    List<EMPVO>readEmpList();
    EMPVO readOneEmp(int empno);
    boolean modifyEmp(int empno);
    boolean remoceEmp(int empno);

}
