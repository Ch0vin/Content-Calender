package com.contentCalender.Content.Calender.Repository;

import com.contentCalender.Content.Calender.Model.Content;
import com.contentCalender.Content.Calender.Model.Status;
import com.contentCalender.Content.Calender.Model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList=new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        for (Content content : contentList) {
            if (content.Id().equals(id)) {
                return Optional.of(content);
            }
        }
        return Optional.empty();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.Id().equals(content.Id()));
        contentList.add(content);
    }
    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);

    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c ->c.Id().equals(id)).count()==1;
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.Id().equals(id));
    }
}
