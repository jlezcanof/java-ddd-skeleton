package tv.codely.mooc.students_register.domain;

import tv.codely.shared.domain.IntegerMother;

public final class StudentsRegisterTotalMother {

    public static StudentsRegisterTotal create(Integer value) {
        return new StudentsRegisterTotal(value);
    }

    public static StudentsRegisterTotal random() {
        return create(IntegerMother.random());
    }

    public static StudentsRegisterTotal one() {
        return create(1);
    }
}
