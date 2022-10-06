package tv.codely.shared.domain;

public final class InvalidFieldUrl extends DomainError {
    public InvalidFieldUrl(String url) {
        super("invalid_field_url", String.format(String.format("Field url <%s> is not valid",
            url)));
    }
}
