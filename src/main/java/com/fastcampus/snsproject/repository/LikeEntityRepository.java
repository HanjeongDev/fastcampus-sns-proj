package com.fastcampus.snsproject.repository;

import com.fastcampus.snsproject.model.entity.LikeEntity;
import com.fastcampus.snsproject.model.entity.PostEntity;
import com.fastcampus.snsproject.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.OptBoolean;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity userEntity, PostEntity postEntity);

    @Query(value = "SELECT COUNT(*) FROM LikeEntity entity WHERE entity.post = :post")
    Integer countByPost(@Param("post") PostEntity post);

    List<LikeEntity> findAllByPost(PostEntity postEntity);
}
