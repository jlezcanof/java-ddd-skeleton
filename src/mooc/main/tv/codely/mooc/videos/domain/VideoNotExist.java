package tv.codely.mooc.videos.domain;

import tv.codely.shared.domain.DomainError;

public final class VideoNotExist extends DomainError {
    public VideoNotExist(VideoId id) {
        super("video_not_exist", String.format("The video <%s> doesn't exist", id.value()));
    }
}
