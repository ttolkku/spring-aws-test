package com.jojoldu.book.springawstest.service.posts;

import com.jojoldu.book.springawstest.domain.posts.Posts;
import com.jojoldu.book.springawstest.domain.posts.PostsRepository;
import com.jojoldu.book.springawstest.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springawstest.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없음. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
