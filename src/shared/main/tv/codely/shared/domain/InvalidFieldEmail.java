package tv.codely.shared.domain;

public final class InvalidFieldEmail extends DomainError {
    public InvalidFieldEmail(String email) {
        super("invalid_field_email", String.format(String.format("Field email <%s> is not valid",
            email)));
    }
}
