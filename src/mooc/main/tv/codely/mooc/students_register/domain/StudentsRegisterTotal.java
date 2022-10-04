package tv.codely.mooc.students_register.domain;

import tv.codely.shared.domain.IntValueObject;

public final class StudentsRegisterTotal extends IntValueObject {
    public StudentsRegisterTotal(Integer value) {
        super(value);
    }

    public StudentsRegisterTotal() {
        super(null);
    }

    public static StudentsRegisterTotal initialize() {
        return new StudentsRegisterTotal(0);
    }

    public StudentsRegisterTotal increment() {
        return new StudentsRegisterTotal(value() + 1);
    }
}
