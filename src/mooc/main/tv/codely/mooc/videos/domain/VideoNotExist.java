package tv.codely.mooc.videos.domain;

import tv.codely.mooc.steps.domain.StepId;
import tv.codely.shared.domain.DomainError;

public final class VideoNotExist extends DomainError {
    public VideoNotExist(StepId videoId) {
        super("video_not_exist", String.format("The video <%s> doesn't exist", videoId.value()));
    }
}
