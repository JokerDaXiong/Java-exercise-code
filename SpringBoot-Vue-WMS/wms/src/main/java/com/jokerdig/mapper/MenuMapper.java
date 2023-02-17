package com.jokerdig.mapper;

import com.jokerdig.common.Result;
import com.jokerdig.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jokerdig.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王省雄
 * @since 2023-01-13
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
