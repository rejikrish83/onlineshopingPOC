package com.atb.application.scheduling;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class SyncAssetValueAndCostCenterJob
    extends QuartzJobBean
    implements Job
{
    private static final Log           LOG      = LogFactory.getLog(SyncAssetValueAndCostCenterJob.class);

    Map<String, Object>                services = new HashMap<String, Object>();

   // private AssetService assetService;

    @Override
    protected void executeInternal(JobExecutionContext context)
        throws JobExecutionException
    {
        long start = System.currentTimeMillis();
        try
        {   
            LOG.info("SyncAssetValueAndCostCenterJob : Entering into SyncAssetValueAndCostCenterJob executeInternal method");
      

            SchedulerContext schedulerContext = context.getScheduler().getContext();
            services = getRequiredServices(schedulerContext);

           /* assetService =
                (AssetService) services.get(SpringBatchJobConstants.ASSET_SERVICE);
            try{
            assetService.updateCostCenterReportFromFile();
            LOG.info("SyncAssetValueAndCostCenterJob : updateCostCenterReportFromFile..Cost center report updated successfully from file...");
            assetService.updateCostCenterFromReportTable();
            LOG.info("SyncAssetValueAndCostCenterJob : updateCostCenterFromReportTable.. cost center updates completed......");
            }
            catch(Exception e){
                LOG.error("Exception occured in updateCostCenterReport :" + e.getMessage());
            }
            try
            {
                assetService.updateAssetReportFromFile();
            }
            catch (Exception e)
            {
                LOG.error("SyncAssetValueAndCostCenterJob : Exception occured in updateAssetReportFromFile :" + e.getMessage());
            }
            LOG.info("SyncAssetValueAndCostCenterJob : updateAssetReportFromFile..Asset value report updated successfully from file...");
            assetService.updateAssetFromAssetReportTable();*/
            LOG.info("SyncAssetValueAndCostCenterJob : updateAssetFromAssetReportTable..Asset updates completed ...........");
            
        }
        catch (SchedulerException e)
        {
            LOG.error("SchedulerException occured in SyncAssetValueAndCostCenterJob :" , e);
        }
        catch (Exception e) {
            LOG.error("Exception occured in SyncAssetValueAndCostCenterJob :" , e);
        }
        finally
        {
            long end = System.currentTimeMillis();
            LOG.info("Completed the processing of SyncAssetValueAndCostCenterJob in " + (end - start) + "ms.");            
        }

    }

    /**
     * This method loads the services required during the Job execution from the SchedulerContext
     * 
     * @param schedulerContext
     * @return Map<String, Object>
     */

    private Map<String, Object> getRequiredServices(SchedulerContext schedulerContext)
    {
        Map<String, Object> services = new HashMap<String, Object>();
        /*services.put(SpringBatchJobConstants.PROPERTY_SERVICE,
            (PropertyService) schedulerContext.get(SpringBatchJobConstants.PROPERTY_SERVICE));
        services.put(SpringBatchJobConstants.WORK_ORDER_SERVICE,
            (WorkOrderService) schedulerContext.get(SpringBatchJobConstants.WORK_ORDER_SERVICE));
        services.put(SpringBatchJobConstants.ASSET_SERVICE,
            (AssetService) schedulerContext.get(SpringBatchJobConstants.ASSET_SERVICE));*/

        return services;
    }
}
