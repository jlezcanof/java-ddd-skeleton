package tv.codely.mooc.students.domain;

public final class StudentCreateMother {


    public static Student create(
        StudentId id,
        StudentName name,
        StudentSurname surname,
        StudentEmail email
    ) {
        return new Student(id, name, surname, email);
    }

    public static Student random() {

        return create(
           StudentIdMother.random(), StudentNameMother.random(),
            StudentSurnameMother.random(), StudentEmailMother.random()
                     );
    }
}
