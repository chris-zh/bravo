package cc.jscode.newbravo.dao.mapper;

import cc.jscode.newbravo.model.po.MoviePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qd on 2017/4/28.
 */
@Mapper
public interface MovieDao {
    MoviePo queryById(@Param("id") int id);

    List<MoviePo> queryAll();

    int insert(@Param("record") MoviePo movie);
}
