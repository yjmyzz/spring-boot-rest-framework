package spring.boot.rest.demo.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * 领域模型（面向业务）
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
public class UserData {


    private Integer id;


    @NotNull(message = "名称不能为空")
    @Length(min = 2, max = 20, message = "名称长度范围为2-20位字符")
    private String name;


    @NotBlank(message = "性别不能为空")
    private String sex;


    private Date birthday;

    @Range(min = 0, max = 150, message = "年龄只能在0-150岁之间")
    private Byte age;


    @Min(value = 0, message = "工资不能为负数")
    private Integer salary;


    private String tag;

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


    public String getTag() {
        if (birthday != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthday);
            int year = calendar.get(Calendar.YEAR);
            if (year >= 2010) {
                tag = "10后";
            } else if (year >= 2000) {
                tag = "00后";
            } else if (year >= 1990) {
                tag = "90后";
            } else if (year >= 1980) {
                tag = "80后";
            } else if (year >= 1970) {
                tag = "70后";
            } else if (year >= 1960) {
                tag = "60后";
            } else if (year >= 1950) {
                tag = "50后";
            } else if (year >= 1940) {
                tag = "40后";
            } else if (year >= 1930) {
                tag = "30后";
            } else if (year >= 1920) {
                tag = "德高望重";
            }
        }
        return tag;
    }


    /**
     * 强烈建议所有domain model都重写toString,方便调试
     *
     * @return
     */
    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", salary=" + salary +
                ", tag='" + tag + '\'' +
                '}';
    }
}
