package project.spring4.mvc.employee.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.spring4.mvc.employee.model.EMPVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// @Repository: DAO(Date Access Object)클래스에 적용되는 어노테이션입니다.
// 해당 클래스가 데이터베이스와의 연동을 담당하는 클래스임을 명시하는 역할을 합니다.
// ("empdao")은 해당 빈의 이름을 지정해주는 것입니다. 지정해주지 않으면 클래스 이름으로 정해집니다.
@Repository("empdao")
class EMPDAOImpl implements EMPDAO {
    private static final Logger logger = LogManager.getLogger(EMPDAOImpl.class);
    // 얘는 뭐하는 애더라....
    private JdbcTemplate jdbcTemplate;

    // @value: 주입되는 값을 설정하는데 사용됩니다. 여기서는 selectEmpSQL에 값을 주입하고 있습니다.
    // ("#{jdbc['selectEmpSQL']}"): Spring의 표현 언어(SpEL)을 사용하여 "jdbc"라는 ID를 가진 util:properties 빈의 "selectEmpSQL" 속성 값을 참조하는 것을 의미합니다.
    // jdbc.properties에 정의한 SQL 가져오기
    @Value("#{jdbc['insertEmpSQL']}") private String insertEmpSQL;
    @Value("#{jdbc['selectEmpSQL']}") private String selectEmpSQL;
    @Value("#{jdbc['selectOneEmpSQL']}") private String selectOneEmpSQL;
    @Value("#{jdbc['updateEmpSQL']}") private String updateEmpSQL;
    @Value("#{jdbc['deleteEmpSQL']}") private String deleteEmpSQL;

    // 객체를 자동으로 주입해주는 역할을 합니다.
    // 자동으로 주입하기 위해서는 Bean으로 등록되어야 합니다. Type, 혹은 Name을 기준으로 주입합니다.
    // Autowired가 뭐지..
    @Autowired
    public EMPDAOImpl (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int insertEmp(EMPVO emp) {
        int cnt = -1;

        try{
            Object[] params = new Object[] {
                    emp.getEmpno(), emp.getFname(),emp.getLname(), emp.getEmail(), emp.getPhone(), emp.getHdate(),
                    emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptno()
            };

            cnt = jdbcTemplate.update(insertEmpSQL,params);

        } catch (Exception ex) {
            logger.error("insertEMP 에러!");
            ex.printStackTrace();
        }

        return cnt;
    }

    @Override
    public List<EMPVO> selectEmp() {
        RowMapper<EMPVO> mapper = new EMPMapper();

        return jdbcTemplate.query(selectEmpSQL, mapper);
    }

    @Override
    public EMPVO selectOneEmp(int empno) {
        Object[] param = new Object[] { empno };
        RowMapper<EMPVO> mapper = new EMPOneMapper();
        EMPVO emp = jdbcTemplate.queryForObject(selectOneEmpSQL, mapper, param);

        return emp;
    }

    @Override
    public int updateEmp(EMPVO emp) {
        return 0;
    }

    @Override
    public int deleteEmp(int empno) {
        return 0;
    }

    class EMPMapper implements RowMapper<EMPVO> {
        @Override
        public EMPVO mapRow(ResultSet rs, int num) throws SQLException {
            EMPVO emp = new EMPVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));

            return emp;
        }
    }

    class EMPOneMapper implements RowMapper<EMPVO> {
        @Override
        public EMPVO mapRow(ResultSet rs, int i) throws SQLException {
            EMPVO emp = new EMPVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getDouble(9),
                    rs.getInt(10),rs.getInt(11));

            return emp;
        }
    }

}

