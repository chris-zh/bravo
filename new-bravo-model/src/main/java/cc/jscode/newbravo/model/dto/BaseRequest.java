package cc.jscode.newbravo.model.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by qd on 2017/4/28.
 */
public abstract class BaseRequest implements Serializable {
    private static final long serialVersionUID = 7555889205167704090L;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
