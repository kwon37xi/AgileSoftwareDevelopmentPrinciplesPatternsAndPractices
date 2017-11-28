package ppp.ch17;

import java.util.Date;

/**
 * EmployeeTest 코드를 보시오.
 */
public interface Employee {
    boolean isTimeToPay(Date payDate);
    void pay();

    /** Null Object */
    Employee NULL = new Employee() {
        @Override
        public boolean isTimeToPay(Date payDate) {
            return false;
        }

        @Override
        public void pay() {
            // do nothing
        }
    };
}
