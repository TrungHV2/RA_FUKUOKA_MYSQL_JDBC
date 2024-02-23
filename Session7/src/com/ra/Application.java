package com.ra;

import com.ra.entity.Computer;
import com.ra.entity.Order;
import com.ra.repository.Repository;
import com.ra.repository.impl.RepositoryImpl;

import java.util.Date;
import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        Repository<Computer> computerRepository = new RepositoryImpl<>();
        Repository<Order> orderRepository = new RepositoryImpl<>();
        Computer computer = new Computer("PC01", "01", 10000, true);
        //computerRepository.add(computer);
        //computerRepository.remove(Computer.class, "PC01");
        Computer update = computerRepository.findId(Computer.class, "PC01");
        update.setName("Máy 01");
        //computerRepository.edit(update);
        for (Computer pc : computerRepository.findAll(Computer.class)) {
            System.out.println(pc.getId() + ":" + pc.getName());
        }
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setComputerId("PC01");
        order.setStartTime(new Date());
        order.setTotalTime(Float.valueOf(5));
        order.setPricePerHours(Float.valueOf(10000));
        order.setCreated(new Date());
        order.setStatus(true);

        //orderRepository.add(order);
        System.out.println("Danh sách đơn hàng");
        for (Order o : orderRepository.findAll(Order.class)) {
            System.out.println(o.getId() + ": " + o.getStartTime());
        }
    }
}
