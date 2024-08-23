package com.example.mySite.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAll(Pageable pageable);

    @Query("select "
            + "distinct q "
            + "from Post q "
            + "left outer join AppUser u1 on q.writer = u1 "
            + "left outer join Comment a on a.post = q "
            + "left outer join AppUser u2 on q.writer = u2 "
            + "where "
            + "    q.title like %:kw "
            + "    or q.content like %:kw "
            + "    or u1.username like %:kw "
            + "    or a.content like %:kw "
            + "    or u2.username like %:kw ")
    Page<Post> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
