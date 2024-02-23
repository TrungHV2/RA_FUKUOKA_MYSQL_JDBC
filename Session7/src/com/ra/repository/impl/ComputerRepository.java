package com.ra.repository.impl;

import com.ra.entity.Computer;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

public class ComputerRepository extends RepositoryImpl<Computer> {
    public void test() throws Exception {
       List<Computer>computers = findAll(Computer.class);
        CallableStatement cs = null;
        cs.registerOutParameter(1, Types.INTEGER);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.executeQuery();
        cs.getInt(1);
        cs.getInt(2);
        cs.getInt(3);
    }
}
