package tv.codely.shared.domain;

public final class InvalidFieldEmail extends RuntimeException {
    public InvalidFieldEmail(String email) {
        super(String.format(String.format("Field email %s is not valid", email)));
    }
}
