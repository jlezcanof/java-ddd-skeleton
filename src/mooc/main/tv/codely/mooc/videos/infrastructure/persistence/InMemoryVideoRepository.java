package tv.codely.mooc.videos.infrastructure.persistence;

import java.util.HashMap;
import java.util.Optional;
import tv.codely.mooc.videos.domain.Video;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoRepository;

public final class InMemoryVideoRepository implements VideoRepository {
    private HashMap<String, Video> videos = new HashMap<>();

//    @Override
//    public void save(Course course) {
//        courses.put(course.id().value(), course);
//    }

    @Override
    public Optional<Video> search(VideoId id) {
        return Optional.ofNullable(videos.get(id.value()));
    }

    //@Override
//    public List<Course> matching(Criteria criteria) {
//        return null;
//    }
}
