package com.mis.repository;

import com.mis.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,String> {
    public Bus findByBusName(String busName);

    public List<Bus> findAllBySourceAndDestination(String source, String destination);
}
