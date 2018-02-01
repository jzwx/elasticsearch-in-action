package com.jzwx.spring.boot.blog.repository.es;

import com.jzwx.spring.boot.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlogRepository 接口  Es资源库接口
 *
 * @author jzwx
 * @version $ Id: EsBlogRepository, v 0.1 2018/2/1 17:04 jzwx Exp $
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String>{

    /**
     * 分页查询博客（去重）
     * @param title
     * @param summary
     * @param content
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
