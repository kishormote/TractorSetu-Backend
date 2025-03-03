package com.tractorental.fullstack_backend.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "*")
public class WorkLogController
{
    @Autowired
    private WorkLogService workLogService;

    @PostMapping("/work-logs")
    public ResponseEntity<WorkLogs> createWorkLog(@RequestBody WorkLogRequest request)
    {
        WorkLogs workLog = workLogService.createWorkLog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(workLog);
    }

    @PutMapping("/work-logs/{id}")
    public ResponseEntity<WorkLogs> updateWorkLog(@PathVariable long id, @RequestBody WorkLogRequest request)
    {
        WorkLogs updatedLog = workLogService.updateWorkLog(id, request);
        return ResponseEntity.ok(updatedLog);
    }

    @GetMapping("/work-logs/farmer/{farmerId}")
    public ResponseEntity<List<WorkLogs>> getWorkLogsByFarmer(@PathVariable long farmerId)
    {
        List<WorkLogs> workLogs = workLogService.getWorkLogsByFarmer(farmerId);
        return ResponseEntity.ok(workLogs);
    }

    @GetMapping("/work-logs/farmer/{farmerId}/owner/{ownerId}")
    public ResponseEntity<List<WorkLogs>> getWorkLogsByFarmerAndOwner(@PathVariable long farmerId, @PathVariable long ownerId)
    {
        List<WorkLogs> workLogs = workLogService.getWorkLogsByFarmerAndOwner(farmerId, ownerId);
        return ResponseEntity.ok(workLogs);
    }

    @GetMapping("/tractor-owner/{ownerId}")
    public ResponseEntity<List<FarmersDueResponse>> getFarmersByTractorOwner(@PathVariable Long ownerId)
    {
        List<FarmersDueResponse> farmers = workLogService.getFarmersByTractorOwner(ownerId);
        return ResponseEntity.ok(farmers);
    }

    @DeleteMapping("/work-logs/{workLogId}")
    public ResponseEntity<String> deleteWorkLog(@PathVariable Long workLogId)
    {
        workLogService.deleteWorkLog(workLogId);
        return ResponseEntity.ok("Work log deleted successfully");
    }

    @GetMapping("/totalDue/{farmerId}/{ownerId}")
    public ResponseEntity<Double> getTotalDueAmount(
            @PathVariable Long farmerId,
            @PathVariable Long ownerId)
    {
        Double totalDue = workLogService.getTotalDueAmount(farmerId, ownerId);
        return ResponseEntity.ok(totalDue);
    }

    @GetMapping("/farmer/search")
    public ResponseEntity<List<Farmers>> searchFarmers(@RequestParam String name)
    {
        List<Farmers> farmers = workLogService.searchFarmers(name);
        return ResponseEntity.ok(farmers);
    }
}
