package tv.codely.mooc.students.application.create;

import tv.codely.shared.domain.bus.command.Command;

public final class CreateStudentCommand implements Command {

    private final String id;

    private final String name;

    private final String surname;

    private final String email;

    public CreateStudentCommand(String id, String name, String surname, String email){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email= email;
    }

    public String id() {return this.id;}

    public String name(){ return this.name;}

    public String surname(){ return this.surname;}

    public String email(){ return this.email;}


}
