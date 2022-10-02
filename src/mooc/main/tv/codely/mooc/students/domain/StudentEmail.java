package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.EmailValueObject;

public final class StudentEmail extends EmailValueObject {

    public StudentEmail(String value) {
        super(value);
    }

    private StudentEmail() {
        super("email@valid.es");
    }
}
