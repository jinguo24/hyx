package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ObtainEmployment;

public interface ObtainEmploymentMapper extends CommonMapper<ObtainEmployment, String> {

	List<ObtainEmployment> findList(ObtainEmployment obtainEmployment);
	
	

	
	
	
}
