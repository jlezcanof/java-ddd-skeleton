package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;
import tv.codely.shared.domain.InvalidFieldEmail;

public final class StudentsPutControllerShould extends MoocApplicationTestCase {

    @Test
    void register_a_valid_non_existing_student() throws Exception{

        assertRequestWithBody(
            "PUT",
            "/students/469ba883-f471-4290-b389-3b1b1e12790c",
            "{\"name\": \"guzman\", \"surname\": \"el bueno\", \"email\": \"a@a.es\"}",
            201
                             );
    }

        @Test
        @Disabled
        void student_with_invalid_email() {
            Assertions.assertThrows(InvalidFieldEmail.class,
                () ->
                    assertRequestWithBody(
                        "PUT",
                        "/students/8974825f-2ed3-42c8-a134-c393618961f5",
                        "{\"name\": \"guzman\", \"surname\": \"el bueno\", \"email\": \"invalidemail\"}",
                        400)
            );


    }
}
