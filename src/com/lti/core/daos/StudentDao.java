package com.lti.core.daos;

import java.util.List;

import com.lti.core.entities.*;
import com.lti.core.exceptions.*;

public interface StudentDao {

	public int insertNewStudent0(Student student );
	public int setPassForStudent0(String studentAadharNo, String studentPassword );
	public Student studentLogin0(String studentAadharNo);
	public int editProfileForStudent0(Student student);
	
	public List<Course> viewCourseByStudent0();
	public Course returnCourseOnId(String courseId);
	public int applyForCourse0(String studentCourseId, String studentAadharNo, String studentCourseName);
    public int addCompletedCourse0(Completedcourse completedcourse);
    public Completedcourse CheckStudentapplyingSameCourse(String compCourseId, Student studentid);

    public List<Job> searchJobByStudent0();
    public List<Jobapply> returnStudentStatusOfApplyjob0(Student studentjid);
    public int rejJobByStudent(String appJobId, Student studentjid);
    public int accJobByStudentA(Student studentjid);
    public int accJobByStudentB(String studentAadharNo, String jobId);
    public int accJobByStudent0(Student studentjid, String appJobId);

}
