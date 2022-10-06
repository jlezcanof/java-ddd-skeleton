package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.StringValueObject;

public final class VideoName extends StringValueObject {
    public VideoName(String value) {
        super(value);
    }

    public VideoName() {
        super("");
    }
}
