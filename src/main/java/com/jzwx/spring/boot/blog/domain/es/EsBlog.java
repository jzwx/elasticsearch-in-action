package com.jzwx.spring.boot.blog.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * EsBlog 类 Blog文档
 *
 * @author jzwx
 * @version $ Id: EsBlog, v 0.1 2018/2/1 16:47 jzwx Exp $
 */
@Document(indexName = "blog", type = "blog") //文档类
public class EsBlog implements Serializable {
    private static final long serialVersionUID = 7121512017969174834L;

    /**
     * 编号
     */
    @Id //主键
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 内容
     */
    private String content;

    protected EsBlog() { //JPA规范要求;防止直接使用

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("EsBlog[id='%s',title='%s',summary='%s',content='%s']", id, title, summary, content);
    }
}
