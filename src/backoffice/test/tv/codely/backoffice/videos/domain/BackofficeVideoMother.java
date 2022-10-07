package tv.codely.backoffice.videos.domain;

import tv.codely.shared.domain.UrlMother;
import tv.codely.shared.domain.UuidMother;
import tv.codely.shared.domain.WordMother;

public final class BackofficeVideoMother {
    public static BackofficeVideo create(String id, String text, String title, String url) {
        return new BackofficeVideo(id,text,title,url);
    }

//    public static BackofficeVideo create( String text, String title, String url) {
//        return new BackofficeVideo(UuidMother.random(), text, title, url);
//    }

    public static BackofficeVideo random() {
        return create(UuidMother.random(), WordMother.random(), WordMother.random(),
            UrlMother.random());
    }
}
