package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;

public interface StudentService {
	
	
	public boolean insertNewStudent1(Student student);
	public boolean setPassForStudent1(String studentAadharNo, String studentPasswordCrypt);
	public Student studentLogin1(String studentAadharNo);
    public boolean editProfileForStudent1(Student student);

    public List<Course> viewCourseByStudent1();
    public Course returnCourseOnId1(String courseId);
    public int applyForCourse1(String studentCourseId, String studentAadharNo, String studentCourseName);

    public int addCompletedCourse0(Completedcourse completedcourse);
    public Completedcourse CheckStudentapplyingSameCourse1(String compCourseId, Student studentid);
    
    public List<Job> searchJobByStudent1();
    public List<Jobapply> returnStudentStatusOfApplyjob1(Student studentjid);
    public int rejJobByStudent1(String appJobId, Student studentjid);
    public int accJobByStudentA1(Student studentjid);
    public int accJobByStudentB1(String studentAadharNo, String jobId);
    public int accJobByStudent1(Student studentjid, String appJobId);

}
