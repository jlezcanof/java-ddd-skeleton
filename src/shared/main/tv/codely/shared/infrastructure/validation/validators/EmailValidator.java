package tv.codely.shared.infrastructure.validation.validators;

import java.io.Serializable;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class EmailValidator implements FieldValidator {

    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        Pattern emailPattern = Pattern.compile("^(.+)@(\\S+)$");

        return emailPattern.matcher((String) fields.get(fieldName)).matches();
    }

    @Override
    public String errorMessage(String fieldName) {
        return String.format("The field <%s> should be of type email", fieldName);
    }
}
