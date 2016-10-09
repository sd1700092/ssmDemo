package cn.gxufe.ssm.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 燕赤侠 2016-09-26
 */
@Table(name = "airlines")
public class Airlines {

    @Column
    private String name;

    @Id
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


}
