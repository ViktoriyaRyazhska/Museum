/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service;

import java.sql.Time;
import java.util.List;

import com.softserve.museum.domain.Guide;

/**
 * 
 * Excursion service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
public interface GuideService {
    
    public abstract Integer save(Guide guide);
    
    public abstract Guide update(Guide guide);
    
    public abstract void delete(Guide guiden);

    public abstract List<Guide> listGuides();
    
    public abstract List<Guide> findGuideByTime(Time start, Time end);
    
    public abstract List<Guide> getCountGuidesByPeriod(Time start, Time end);
    
    public abstract List<Guide> getCountTotalTimePerGuideByPeriod(Time start, Time end);

    public abstract List<Guide> findByPosition(String position);
}
