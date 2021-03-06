/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.MaterialDAO;
import com.softserve.museum.domain.Material;

/**
 * 
 * DAO class for Material entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 19.10.2016
 *
 */
@Repository
@Transactional
public class MaterialDAOimpl extends AbstractDAO<Material, Integer> implements MaterialDAO {

    public MaterialDAOimpl() {
        super(Material.class);
    }

    /**
     * Finds materials by given name
     * @param material material's name
     * @return list of materials
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Material> findMaterialByName(String material) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Material.class);
        criteria.add(Restrictions.eq("description", material));
        return criteria.list();
    }

}
