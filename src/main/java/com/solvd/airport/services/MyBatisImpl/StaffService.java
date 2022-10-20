package com.solvd.airport.services.MyBatisImpl;

import com.solvd.airport.DAO.IStaffDAO;
import com.solvd.airport.models.Staff;
import com.solvd.airport.services.IStaffService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class StaffService implements IStaffService {
    private static final Logger LOGGER = Logger.getLogger(StaffService.class.getName());
    private final SqlSessionFactory sessionFactory = MyBatisFactory.getSessionFactory();

    @Override
    public Staff getStaffByID(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            Staff staff = staffDAO.getObjectByID(id);
            if (staff == null) {
                LOGGER.error("User with id " + id + " wasn't found!");
            }
            return staff;
        }
    }

    @Override
    public void createStaff(Staff s) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.create(s);
                session.commit();
                LOGGER.info("inserted Successfully");
            } catch (Exception e) {
                LOGGER.error("Inserting wasn't successful", e);
                session.rollback();
            }
        }
    }

    @Override
    public void updateStaff(Staff s) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.update(s);
                session.commit();
                LOGGER.info("updated Successfully");
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                session.rollback();
            }
        }
    }

    @Override
    public void deleteStaff(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.delete(id);
                session.commit();
                LOGGER.info("Staff was removed");
            } catch (Exception e) {
                LOGGER.error("Removing id " + id, e);
                session.rollback();
            }
        }
    }
}
