package com.tractorental.fullstack_backend.expense;

import com.tractorental.fullstack_backend.infra.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkLogService
{
    @Autowired
    private WorkLogRepository workLogRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private TractorOwnerTaskRepository tractorOwnerTaskRepository;

    public WorkLogs createWorkLog(WorkLogRequest request)
    {
        Farmers farmer;

        if (request.getFarmerId() != null)
        {
            farmer = farmerRepository.findById(request.getFarmerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Farmer not found for id: " + request.getFarmerId()));
        } else
        {
            if (request.getFarmerName() == null || request.getFarmerName().isEmpty())
            {
                throw new IllegalArgumentException("Farmer name is required when farmer ID is not provided.");
            }
            farmer = new Farmers();
            farmer.setName(request.getFarmerName());
            farmer = farmerRepository.save(farmer);
        }

        TractorOwnerTask task = tractorOwnerTaskRepository.findById(request.getTractorOwnerTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for id: " + request.getTractorOwnerTaskId()));

        WorkLogs workLog = new WorkLogs();
        workLog.setFarmer(farmer);
        workLog.setTractorOwnerTask(task);
        workLog.setTaskDate(request.getTaskDate());
        workLog.setArea(request.getArea());
        workLog.setAmountPaid(request.getAmountPaid());

        return workLogRepository.save(workLog);
    }


    public WorkLogs updateWorkLog(Long id, WorkLogRequest request)
    {
        WorkLogs workLog = workLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work Log not found"));

        workLog.setTaskDate(request.getTaskDate());
        workLog.setArea(request.getArea());
        workLog.setAmountPaid(request.getAmountPaid());

        return workLogRepository.save(workLog);
    }

    public List<WorkLogs> getWorkLogsByFarmer(Long farmerId)
    {
        return workLogRepository.findByFarmer_Id(farmerId);
    }

    public List<WorkLogs> getWorkLogsByFarmerAndOwner(Long farmerId, Long ownerId)
    {
        return workLogRepository.findByFarmer_IdAndTractorOwnerTask_TractorOwner_Id(farmerId, ownerId);
    }

    public List<Farmers> getFarmersByTractorOwner(Long ownerId)
    {
        return farmerRepository.findFarmersByTractorOwner(ownerId);
    }

    public void deleteWorkLog(Long workLogId)
    {
        WorkLogs workLog = workLogRepository.findById(workLogId)
                .orElseThrow(() -> new ResourceNotFoundException("Work Log not found with id: " + workLogId));

        workLogRepository.delete(workLog);
    }

    public Double getTotalDueAmount(Long farmerId, Long ownerId)
    {
        List<WorkLogs> workLogs = workLogRepository.findByFarmer_IdAndTractorOwnerTask_TractorOwner_Id(farmerId, ownerId);

        double totalCost = 0.0;
        double totalPaid = 0.0;

        for (WorkLogs log : workLogs)
        {
            double area = log.getArea();
            double price = log.getTractorOwnerTask().getPrice();
            totalCost += (area * price);
            totalPaid += log.getAmountPaid();
        }

        return totalCost - totalPaid;
    }

    public List<Farmers> searchFarmers(String name)
    {
        Specification<Farmers> spec = FarmerSpecification.searchByName(name);
        return farmerRepository.findAll(spec);
    }
}
