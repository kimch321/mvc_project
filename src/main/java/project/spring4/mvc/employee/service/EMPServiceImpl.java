package project.spring4.mvc.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring4.mvc.employee.dao.EMPDAO;
import project.spring4.mvc.employee.model.EMPVO;

import java.util.List;

// @Service: 비즈니스 로직을 담당하는 클래스를 나타내는 어노테이션입니다.
// 적용된 클래스는 스프링 컨테이너에 빈으로 등록됩니다.
@Service("empsrv")
public class EMPServiceImpl implements EMPService{
    private EMPDAO empdao = null;

    // 이 경우는 이름으로 등록되었다. EMPDAO는 인터페이스이고 등록되지 않았기 때문이다.
    @Autowired
    public EMPServiceImpl(EMPDAO empdao) {
        this.empdao = empdao;
    }

    @Override
    public int newEmp(EMPVO emp) {
        return 0;
    }

    @Override
    public List<EMPVO> readEmpList() {
        return empdao.selectEmp();
    }

    @Override
    public EMPVO readOneEmp(int empno) {
        return null;
    }

    @Override
    public int modifyEmp(int empno) {
        return 0;
    }

    @Override
    public int remoceEmp(int empno) {
        return 0;
    }

}
