package com.skillhub.ee.listner;

import com.skillhub.ee.model.AttendanceRecord;
import com.skillhub.ee.model.Course;
import com.skillhub.ee.model.Enrolment;
import com.skillhub.ee.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();
        Map<String, User> userMap = new HashMap<>();
        Map<String, Course> courseMap = new HashMap<>();
        Map<String, Enrolment> enrolmentMap = new HashMap<>();
        Map<String, AttendanceRecord> attendanceRecordMap = new HashMap<>();

        userMap.put("Sanuga", new User("Sanuga", "Sanuga", "Kusalwin", "2006", "ADMIN"));
        userMap.put("Nimal", new User("Nimal", "Nimal", "Perera", "2002", "TRAINER"));
        userMap.put("Kasun", new User("Kasun", "Kasun", "Fernando", "1998", "TRAINER"));
        userMap.put("Amal", new User("Amal", "Amal", "Silva", "2000", "TRAINER"));

        userMap.put("Kavindu", new User("Kavindu", "Kavindu", "Jayasinghe", "2004", "USER"));
        userMap.put("Tharusha", new User("Tharusha", "Tharusha", "Peris", "2005", "USER"));
        userMap.put("Dinuka", new User("Dinuka", "Dinuka", "Bandara", "2003", "USER"));

        courseMap.put("C001", new Course("C001", "Computer Science", 20, "Nimal"));
        courseMap.put("C002", new Course("C002", "Software Engineering", 25, "Kasun"));
        courseMap.put("C003", new Course("C003", "Web Development", 15, "Amal"));

        enrolmentMap.put("S001", new Enrolment("S001", "C001", "Kavindu"));
        enrolmentMap.put("S002", new Enrolment("S002", "C002", "Tharusha"));
        enrolmentMap.put("S003", new Enrolment("S003", "C003", "Dinuka"));
        enrolmentMap.put("S004", new Enrolment("S004", "C002", "Kavindu"));
        enrolmentMap.put("S005", new Enrolment("S005", "C003", "Tharusha"));
        enrolmentMap.put("S006", new Enrolment("S006", "C001", "Dinuka"));

        attendanceRecordMap.put("R001", new AttendanceRecord("R001", "Kavindu", "C001", LocalDateTime.of(2026, 9, 10, 9, 0)));
        attendanceRecordMap.put("R002", new AttendanceRecord("R002", "Tharusha", "C002", LocalDateTime.of(2026, 9, 10, 10, 30)));
        attendanceRecordMap.put("R003", new AttendanceRecord("R003", "Dinuka", "C003", LocalDateTime.of(2026, 9, 11, 11, 0)));
        attendanceRecordMap.put("R004", new AttendanceRecord("R004", "Kavindu", "C002", LocalDateTime.of(2026, 9, 12, 10, 30)));
        attendanceRecordMap.put("R005", new AttendanceRecord("R005", "Tharusha", "C003", LocalDateTime.of(2026, 9, 13, 11, 0)));
        attendanceRecordMap.put("R006", new AttendanceRecord("R006", "Dinuka", "C001", LocalDateTime.of(2026, 9, 14, 9, 0)));

        context.setAttribute("users", userMap);
        context.setAttribute("courses", courseMap);
        context.setAttribute("enrolments", enrolmentMap);
        context.setAttribute("attendances", attendanceRecordMap);

        context.setAttribute("activeUsers", 0);
        System.out.println("SkillHub Training Academy Application Deployed...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext Destroyed...");
    }
}
