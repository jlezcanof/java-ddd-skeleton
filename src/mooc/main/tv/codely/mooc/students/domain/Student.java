package tv.codely.mooc.students.domain;

public final class Student {
    private final StudentId id;
    private final StudentName       name;
    private final StudentSurname    surname;
    private final StudentEmail      email;

    public Student(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        this.id      = id;
        this.name    = name;
        this.surname = surname;
        this.email   = email;
    }

    public StudentId id() {
        return id;
    }

    public StudentName name() {
        return name;
    }

    public StudentSurname surname() {
        return surname;
    }

    public StudentEmail email() {
        return email;
    }
}
