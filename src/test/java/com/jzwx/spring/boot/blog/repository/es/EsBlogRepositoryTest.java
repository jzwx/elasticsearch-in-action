package com.jzwx.spring.boot.blog.repository.es;

import com.jzwx.spring.boot.blog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * EsBlogRepositoryTest 类
 *
 * @author jzwx
 * @version $ Id: EsBlogRepositoryTest, v 0.1 2018/2/1 17:18 jzwx Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRRepositoryData() {
        //清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("登鹤雀楼", "王之涣的登鹤雀楼", "白日依山尽，黄河入水流。欲穷千里目，更上一层楼。"));

        esBlogRepository.save(new EsBlog("相思", "王维的相思", "红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));

        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思", "床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page=esBlogRepository
            .findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);
        System.out.println("--------------start1.");
        for (EsBlog esBlog : page.getContent()){
            System.out.println(esBlog.toString());
        }
        System.out.println("--------------end1.");

        title = "相思";
        page=esBlogRepository
                .findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);
        System.out.println("--------------start2.");
        for (EsBlog esBlog : page.getContent()){
            System.out.println(esBlog.toString());
        }
        System.out.println("--------------end2.");
    }
}
