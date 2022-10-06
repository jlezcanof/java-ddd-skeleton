package tv.codely.mooc.videos.domain;

import java.util.Optional;

public interface VideoRepository {
    Optional<Video> search(VideoId id);
    //void save(Course course);

    //List<Course> matching(Criteria criteria);
}
