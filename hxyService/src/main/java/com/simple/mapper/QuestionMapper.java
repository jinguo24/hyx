package com.simple.mapper;

import java.util.*;
import com.simple.common.crud.CommonMapper;
import org.apache.ibatis.annotations.Param;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Question;

public interface QuestionMapper extends CommonMapper<Question, String> {

	List<Question> findList(Question question);
	
	

	
	
	
}
