/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Guide;

/**
 * 
 * DAO class for Guide entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
@Repository
@Transactional
public class GuideDAOimpl extends AbstractDAO<Guide, Integer> implements GuideDAO {

	protected GuideDAOimpl() {
		super(Guide.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> findGuideByTime(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"FROM Guide WHERE id NOT IN (SELECT guide FROM Excursion AS XS WHERE (XS.start BETWEEN "
						+ ":startDate AND :endDate) OR (XS.end BETWEEN :startDate AND :endDate))");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));

		return result.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"SELECT gd.id, gd.firstName, gd.lastName, gd.position, COUNT(gd) AS cnt FROM Excursion AS XS RIGHT JOIN XS.guide AS gd "
						+ "WHERE (XS.start >= :startDate AND XS.end <= :endDate) " + "GROUP BY gd");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));
		return result.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCountTotalTimePerGuideByPeriod(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"SELECT gd.id, gd.firstName, gd.lastName, gd.position, SEC_TO_TIME(SUM(timestampdiff(SECOND, XS.start, XS.end))) AS totalduration FROM Excursion AS XS RIGHT JOIN XS.guide AS gd "
						+ "WHERE (XS.start >= :startDate AND XS.end <= :endDate) " + "GROUP BY gd");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));
		return result.list();
	}

}
