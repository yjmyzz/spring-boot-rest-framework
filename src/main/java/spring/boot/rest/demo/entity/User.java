package spring.boot.rest.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * db实体（面向数据库）
 */
@Table(name = "T_User")
public class User {
    /**
     * 流水号
     */
    @Id
    @Column(name = "D_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "D_NAME")
    private String name;

    /**
     * 性别(-1女，0保密，1男)
     */
    @Column(name = "D_SEX")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "D_Birthday")
    private Date birthday;

    /**
     * 年龄
     */
    @Column(name = "D_Age")
    private Byte age;

    /**
     * 工资
     */
    @Column(name = "D_Salary")
    private Integer salary;

    /**
     * 获取流水号
     *
     * @return D_ID - 流水号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置流水号
     *
     * @param id 流水号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return D_NAME - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别(-1女，0保密，1男)
     *
     * @return D_SEX - 性别(-1女，0保密，1男)
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别(-1女，0保密，1男)
     *
     * @param sex 性别(-1女，0保密，1男)
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return D_Birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取年龄
     *
     * @return D_Age - 年龄
     */
    public Byte getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * 获取工资
     *
     * @return D_Salary - 工资
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置工资
     *
     * @param salary 工资
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}