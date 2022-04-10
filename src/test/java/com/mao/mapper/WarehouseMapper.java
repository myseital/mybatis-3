package com.mao.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author myseital
 * @date 2022/4/11 00:03
 */
public interface WarehouseMapper {

  List<Map<String,Object>> selectAll(Map<String,Object> map);
}
