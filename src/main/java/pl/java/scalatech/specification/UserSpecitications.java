package pl.java.scalatech.specification;

import java.math.BigDecimal;

import pl.java.scalatech.domain.QUser;

import com.mysema.query.types.Predicate;

public class UserSpecitications {
    public static Predicate findByLogin(final String login) {
        QUser user = QUser.user;
        return user.login.eq(login);
    }

    public static Predicate getUsersWhoEarMoreThan(final BigDecimal salary) {
        QUser user = QUser.user;
        return user.salary.gt(salary);
    }

}
