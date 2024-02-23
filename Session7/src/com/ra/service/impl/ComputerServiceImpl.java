package com.ra.service.impl;

import com.ra.entity.Computer;
import com.ra.entity.Order;
import com.ra.repository.Repository;
import com.ra.repository.impl.RepositoryImpl;
import com.ra.service.ComputerService;

public class ComputerServiceImpl implements ComputerService {
    private Repository<Computer> computerRepository;
    private Repository<Order> orderRepository;

    public ComputerServiceImpl() {
        this.computerRepository = new RepositoryImpl<>();
        this.orderRepository = new RepositoryImpl<>();
    }

    @Override
    public void start(String pcId) {
        Computer computer = computerRepository.findId(Computer.class, pcId);
    }
}
