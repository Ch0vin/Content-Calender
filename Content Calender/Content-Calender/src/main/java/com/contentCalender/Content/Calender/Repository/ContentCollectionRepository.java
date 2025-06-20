package com.contentCalender.Content.Calender.Repository;

import com.contentCalender.Content.Calender.Model.Content;
import org.springframework.stereotype.Repository;

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
        contentList.add(content);
    }
}
