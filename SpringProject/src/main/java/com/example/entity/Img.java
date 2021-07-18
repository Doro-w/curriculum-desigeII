package com.example.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Img implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String name;

    private String url;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
