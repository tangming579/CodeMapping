package com.tm.codemapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.codemapping.mapper.BasicSettingMapper;

@Service
public class BasicSettingService {

	@Autowired BasicSettingMapper basicSettingMapper;
}
