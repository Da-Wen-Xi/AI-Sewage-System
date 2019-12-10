package com.sewage.springboot.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sewage.springboot.entity.po.Job;

/**
 * 工单业务接口
 * 
 * @author sc
 * @date 2019年9月10日
 *
 */
public interface JobService {
	
	public static final int PAGE_INDEX = 1; 
	public static final int PAGE_SIZE  = 20;
	
	
	/** 查询用户自己创建的工单  
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryJobsCreatedBySelf(String user, Integer pageIndex, Integer pageSize);
	
	/** 查询用户处理中的工单 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryJobsProcessing(String user,Integer pageIndex, Integer pageSize);
	
	/** 查询用户处理完成的工单（待审核确认） 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryJobsProcessed(String user, Integer pageIndex, Integer pageSize);
	
	/** 查询用户处理完成的工单（处理结果审核通过） 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryJobsProcessedSuccessful(String user,Integer pageIndex, Integer pageSize);
	
	/** 查询用户处理完成的工单（处理结果审核未通过） 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryJobsProcessedFailed(String user, Integer pageIndex, Integer pageSize);
	
	/** 查询所有已创建，待领取/分配的工单 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryAllJobsWaitingForHandle(Integer pageIndex, Integer pageSize);
	
	/** 查询所有已处理，待审核的工单 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryAllJobsWaitingForCheck(Integer pageIndex, Integer pageSize);
	
	/** 查询所有已审核通过的工单（确认处理完毕） 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryAllJobsCheckSuccessful(Integer pageIndex, Integer pageSize);
	
	/** 查询所有已审核未通过的工单（确认处理失败） 
	 * @param pageIndex 查询当前页，默认为{@link JobService#PAGE_INDEX}
	 * @param pageSize 数据条数，默认{@link JobService#PAGE_SIZE}
	 */
	public JSONObject queryAllJobsCheckFailed(Integer pageIndex, Integer pageSize);
	
	
	/** 创建一个工单 */
	public JSONObject createJob(JSONObject form);
	
	public JSONObject deleteJob(int jobId);
	
	public JSONObject updateJob(Job job);

	/** 查询所有工单列表  */
	public JSONObject selectJobList(Integer pageIndex, Integer pageSize);
	
	/** 抢单（领取工单） */
	public JSONObject grabJobs(String user, List<Integer> jobsIds);
	
	/**
	 *  转发工单
	 *  @param owner 工单所属人
	 */
	public JSONObject forwardJobs(String owner,JSONObject json);

	/**
	 * 完成工单
	 *
	 * @author：sc
	 * @data： 2019年9月25日
	 */
	public JSONObject doneJob(String processor,JSONObject json);

	/**
	 * 审核工单
	 * @author：sc
	 * @data： 2019年9月25日
	 */
	public JSONObject inspect(String inspector, JSONObject json);
	
	/**
	 * 查询某工单的所有进程
	 */
	public JSONObject queryJobProcessListByJobId(int jobId);
	
	/**
	 * 模糊查询
	 * @param username 与username有关的工单
	 * @param keyword  模糊查询关键字 
	 * @return
	 */
	public JSONObject queryJobsAboutMeByCondition(String username, String keyword, Integer pageIndex, Integer pageSize);

	/**
	 * 查询可接单的用户列表
	 * <br><br>
	 * 当前要求：1.普通用户  2.正常用户
	 */
	public JSONObject queryUserListAvailableForReceivingJob();

	public JSONObject queryJobsCount(String username, String type);

	public JSONObject queryById(Integer jobId);


}