package com.contentCalender.Content.Calender.Repository;

import com.contentCalender.Content.Calender.Model.Content;
import com.contentCalender.Content.Calender.Model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content
            WHERE status= :status
            """)
    List<Content> listyStatus (@Param("status") Status status);
}
