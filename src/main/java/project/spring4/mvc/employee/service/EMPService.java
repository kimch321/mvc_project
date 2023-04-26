package project.spring4.mvc.employee.service;

import project.spring4.mvc.employee.model.EMPVO;

import java.util.List;

public interface EMPService {
    int newEmp(EMPVO emp);
    List<EMPVO>readEmpList();
    EMPVO readOneEmp(int empno);
    int modifyEmp(int empno);
    int remoceEmp(int empno);

}
