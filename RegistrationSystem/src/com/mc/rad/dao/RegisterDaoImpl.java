package com.mc.rad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerVO;

@Repository
public class RegisterDaoImpl extends HibernateDaoSupport implements RegisterDao {

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void saveCustomer(Customer customer) {
		getHibernateTemplate().saveOrUpdate(customer);

	}

	@Override
	public CustomerVO getLWDetailsCount() {
		DateTime today = DateTime.now();
		DateTime lastWeekDate = new DateTime(DateTime.now()).minusDays(7);

		Criteria criteria1 = getSession().createCriteria(Customer.class);
		criteria1.add(Restrictions.between("createdOn", lastWeekDate.toDate(),
				today.toDate()));
		criteria1.setProjection(Projections.rowCount());

		Long resultCount = (Long) criteria1.uniqueResult();

		Criteria criteria2 = getSession().createCriteria(Customer.class);
		criteria2.add(Restrictions.between("createdOn", lastWeekDate.toDate(),
				today.toDate()));
		criteria2.setProjection(Projections.distinct(Projections
				.property("state")));

		int statesCount = criteria2.list().size();

		Criteria criteria3 = getSession().createCriteria(Customer.class);
		criteria3.add(Restrictions.between("createdOn", lastWeekDate.toDate(),
				today.toDate()));
		criteria3.setProjection(Projections.distinct(Projections
				.property("country")));

		int countriesCount =  criteria3.list().size();

		CustomerVO customerVO = new CustomerVO();
		customerVO.setTotalCount(resultCount);
		customerVO.setStatesCount(statesCount);
		customerVO.setCountriesCount(countriesCount);
		System.out.println(customerVO);

		return customerVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getLWDetails() {
		DateTime today = DateTime.now();
		DateTime lastWeekDate = new DateTime(DateTime.now()).minusDays(7);
		Criteria criteria3 = getSession().createCriteria(Customer.class);
		criteria3.add(Restrictions.between("createdOn", lastWeekDate.toDate(),
				today.toDate()));
				 
		return criteria3.list();
	}

}
