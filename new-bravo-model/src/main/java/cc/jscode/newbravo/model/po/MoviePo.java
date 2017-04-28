package cc.jscode.newbravo.model.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by qd on 2017/4/28.
 */
@Setter
@Getter
public class MoviePo {
    private int id;
    private String name;
    private int rate;
    private Date createdTime;
    private Date updatedTime;
    private String referrer;
}
