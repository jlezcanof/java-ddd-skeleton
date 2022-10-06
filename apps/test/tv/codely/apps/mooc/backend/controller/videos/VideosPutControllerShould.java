package tv.codely.apps.mooc.backend.controller.videos;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

public final class VideosPutControllerShould extends MoocApplicationTestCase {

    @Test
    void create_a_valid_non_existing_video() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/videos/34726603-1cdb-4ab9-b3a5-1d931034ea5a",
            "{\"url\": \"http://java.sun.com/index.html\", \"text\": \"Hablamos sobre como usar "
                + "este patron creacional\" , \"title\": \"Patron criteria specification\"}",
            201
        );
    }

}
