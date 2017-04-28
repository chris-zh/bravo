package cc.jscode.newbravo.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by qd on 2017/4/28.
 */
@Setter
@Getter
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -3889853704309757082L;

    @JSONField(serialize = false)
    private int resultCode;

    @JSONField(serialize = false)
    private String resultMessage;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
