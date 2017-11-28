package ppp.ch17;//import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class EmployeeTest {
    @Test
    public void nullObject() throws Exception {
        Employee e = DB.getEmployee("Bob");

        if (e.isTimeToPay(new Date())) {
            fail("NULL.isTimeToPay()는 false만 반환하므로 이 코드가 실행될 수 없다.");
        }

        assertThat(e == Employee.NULL).isTrue();
    }
}